package com.jobintech.springapp.Model;

import com.jobintech.springapp.Model.Enum.RoleUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleUser role;
    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private String profilePictureUrl;

    @OneToMany(mappedBy = "expert")
    private List<Course> ListCourses;


}
