package com.jobintech.springapp.service;

import com.jobintech.springapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    User update(User user);

    List<User> getAllUsers();

    User getUserById(long id);
}

