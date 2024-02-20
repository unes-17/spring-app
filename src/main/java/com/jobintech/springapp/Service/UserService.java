package com.jobintech.springapp.Service;

import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    List<User> getAllUsers();
    User update(Long id, User user);
    void delete(Long id);
//DTO
    UserDto createDto(UserDto userDto);
    List<UserDto> getAllUsersDto();
    UserDto updateDto(Long id, UserDto userDto);


}
