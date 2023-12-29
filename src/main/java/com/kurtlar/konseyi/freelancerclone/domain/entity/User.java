package com.kurtlar.konseyi.freelancerclone.domain.entity;

import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@Table(name = User.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity {
    public static final String TABLE = "users";
    private static final String COL_NAME = "name";
    private static final String COL_USERNAME = "username";
    private static final String COL_SURNAME = "surname";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";
    private static final String COL_ROLES = "roles";

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_USERNAME)
    private String username;

    @Column(name = COL_SURNAME)
    private String surname;

    @Column(name = COL_EMAIL)
    private String email;

    @Column(name = COL_PASSWORD)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

}
