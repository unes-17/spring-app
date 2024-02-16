package com.jobintech.springapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String gender;

    private String phoneNum;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String profilePicture;

    @Column(nullable = false)
    private Date createdAt;

    private Date updatedAt;

    private Date lastLogin;

    private boolean isEnabled;

    /*@ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> roles;
*/

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))*/
    @Enumerated(EnumType.STRING)
    private Role roles;

    private String verificationToken;

    private String resetPasswordToken;
}
