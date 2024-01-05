package com.kurtlar.konseyi.freelancerclone.library.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x.requestMatchers("/auth/login").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/auth/register").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/auth/**").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/users/validate").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/jobs/accept").permitAll())
//                .authorizeHttpRequests(x -> x.requestMatchers("/auth/register").permitAll())
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.DELETE, "/comments/**").authenticated())
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.POST, "/comments/**").authenticated())
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.PUT, "/comments/**").authenticated())
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.GET, "/comments/**").hasAnyRole("ADMIN", "SUPER_ADMIN"))
//
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.PUT, "/privates/**").hasAnyRole("ADMIN", "SUPER_ADMIN"))
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.POST, "/privates/**").hasRole("SUPER_ADMIN"))
//                .authorizeHttpRequests(x -> x.requestMatchers(HttpMethod.DELETE, "/privates/**").hasRole("SUPER_ADMIN"))
//                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }


}
