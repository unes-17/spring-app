package com.jobintech.springapp.mapper;

import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    @Autowired
    ModelMapper modelMapper;
       public UserDto userToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User userDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
    public void updateUserFromDto(UserDto userDto, User user) {

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setProfilePictureUrl(userDto.getProfilePictureUrl());
    }

}
