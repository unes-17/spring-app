package com.jobintech.springapp.service;

import com.jobintech.springapp.dto.UserDTO;
import com.jobintech.springapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    User update(User user);

    List<User> getAllUsers();

    List<UserDTO> getAllUsersDTO();

    User getUserById(long id);

    void deleteById(Long id);

    UserDTO getUserDTO(long id);
}

