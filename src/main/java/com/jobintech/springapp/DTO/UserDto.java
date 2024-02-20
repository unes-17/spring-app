package com.jobintech.springapp.DTO;

import com.jobintech.springapp.Model.Enum.RoleUser;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private RoleUser role;
    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private String profilePictureUrl;

}
