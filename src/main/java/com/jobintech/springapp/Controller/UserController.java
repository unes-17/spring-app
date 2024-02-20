package com.jobintech.springapp.Controller;

import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.User;
import com.jobintech.springapp.Service.UserService;
import com.jobintech.springapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @PostMapping("/save")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.update(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    ///// dto


    @PostMapping("/saveDto")
    public ResponseEntity<UserDto> createDto(@RequestBody UserDto userDto) {
        UserDto createdUserDto = userService.createDto(userDto);
        return ResponseEntity.ok(createdUserDto);
    }

    @GetMapping("/usersDto")
    public ResponseEntity<List<UserDto>> getAllUsersDto() {
        List<UserDto> usersDto = userService.getAllUsersDto();
        return ResponseEntity.ok(usersDto);
    }
    @PutMapping("/Dto/{id}")
    public ResponseEntity<UserDto> updateDto(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUserDto = userService.updateDto(id, userDto);
        return ResponseEntity.ok(updatedUserDto);
    }

}



