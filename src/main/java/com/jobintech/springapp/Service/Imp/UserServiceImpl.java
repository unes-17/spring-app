package com.jobintech.springapp.Service.Imp;

import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.User;
import com.jobintech.springapp.Repository.UserRepository;
import com.jobintech.springapp.Service.UserService;
import com.jobintech.springapp.exceptions.NoSuchElementFoundException;
import com.jobintech.springapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User update(Long id, User userNew) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("User not found with id : " + id));
        user.setUsername(userNew.getUsername());
        user.setEmail(userNew.getEmail());
        user.setPassword(userNew.getPassword());
        user.setRole(userNew.getRole());
        user.setAddress(userNew.getAddress());
        user.setDateOfBirth(userNew.getDateOfBirth());
        user.setProfilePictureUrl(userNew.getProfilePictureUrl());
        user.setPhoneNumber(userNew.getPhoneNumber());

        return userRepository.save(user);
    }



    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    ////DTO
    public UserDto createDto(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        user = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }
    @Override
    public List<UserDto> getAllUsersDto() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateDto(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("User not found with id : " + id));

        userMapper.updateUserFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }
}
