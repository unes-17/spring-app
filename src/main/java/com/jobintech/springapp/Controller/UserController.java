package com.jobintech.springapp.Controller;

import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.Enum.RoleUser;
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
    @PostMapping("/post")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.update(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    ///// dto


    @PostMapping("/v1/post")
    public ResponseEntity<UserDto> createDto(@RequestBody UserDto userDto) {
        UserDto createdUserDto = userService.createDto(userDto);
        return ResponseEntity.ok(createdUserDto);
    }

    @PostMapping("/expert")
    public ResponseEntity<UserDto> createExpert(@RequestBody UserDto userDto) {
        userDto.setRole(RoleUser.EXPERT);
        UserDto createdUserDto = userService.createDto(userDto);
        return ResponseEntity.ok(createdUserDto);
    }
    @PostMapping("/APPRENTICE")
    public ResponseEntity<UserDto> createAPPRENTICE(@RequestBody UserDto userDto) {
        userDto.setRole(RoleUser.APPRENTICE);
        UserDto createdUserDto = userService.createDto(userDto);
        return ResponseEntity.ok(createdUserDto);
    }

    @PostMapping("/MANAGER")
    public ResponseEntity<UserDto> createMANAGER(@RequestBody UserDto userDto) {
        userDto.setRole(RoleUser.ADMIN);
        UserDto createdUserDto = userService.createDto(userDto);
        return ResponseEntity.ok(createdUserDto);
    }

    @GetMapping("/v1/get")
    public ResponseEntity<List<UserDto>> getAllUsersDto() {
        List<UserDto> usersDto = userService.getAllUsersDto();
        return ResponseEntity.ok(usersDto);
    }
    @PutMapping("/v1/delete/{id}")
    public ResponseEntity<UserDto> updateDto(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUserDto = userService.updateDto(id, userDto);
        return ResponseEntity.ok(updatedUserDto);
    }

}



