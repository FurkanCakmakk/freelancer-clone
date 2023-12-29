package com.kurtlar.konseyi.freelancerclone.library.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expirationMs}")
    private long jwtExpirationDate;

    // Generate JWT token
    public String generateJwtToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

       String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key())
                .compact();


        return token;

    }

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    // Get username from JWT token
    // Yukarıda JWT tokenı oluştururken setSubject() içerisine username'i atamıştık. Şimdi de onu çıkartıcaz!
    public String getUsernameFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        return username;
    }


    // Validate JWT token
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        }catch (MalformedJwtException ex) {
            throw new RuntimeException("Invalid JWT token");
        }catch (ExpiredJwtException ex) {
            throw new RuntimeException("Expired JWT token");
        }catch (UnsupportedJwtException ex) {
            throw new RuntimeException("Unsupported JWT token");
        }catch (IllegalArgumentException ex) {
            throw new RuntimeException("JWT claims string is empty.");
        }
    }


}
