package com.jobintech.springapp.controller;

import com.jobintech.springapp.dto.UserDTO;
import com.jobintech.springapp.entities.User;
import com.jobintech.springapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/save")
    public User userSave(@RequestBody User user) {

        return userService.create(user);
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/userbydto")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsersDTO();
    }

    @GetMapping("/users/{id}")
    public User allUsers(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/userbydto/{id}")
    public UserDTO getUserByDTO(@PathVariable long id) {
        return userService.getUserDTO(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody User user) {
        User currentUser = userService.getUserById(id);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhoneNum(user.getPhoneNum());
        currentUser.setCreatedAt(user.getCreatedAt());
        currentUser.setEnabled(user.isEnabled());
        currentUser.setCountry(user.getCountry());
        currentUser.setCity(user.getCity());
        currentUser.setUsername(user.getUsername());
        currentUser.setUpdatedAt(new Date());
        currentUser.setAddress(user.getAddress());
        currentUser.setRoles(user.getRoles());
        currentUser.setDateOfBirth(user.getDateOfBirth());
        currentUser.setGender(user.getGender());
        currentUser.setPostalCode(user.getPostalCode());
        currentUser.setPassword(user.getPassword());
        currentUser.setProfilePicture(user.getProfilePicture());
        currentUser.setResetPasswordToken(user.getResetPasswordToken());
        currentUser.setVerificationToken(user.getVerificationToken());

        currentUser = userService.update(currentUser);

        return ResponseEntity.ok(currentUser);
    }

/*
    @PutMapping("2/{id}")
    public ResponseEntity updateClient2(@PathVariable Long id, @RequestBody User user) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        User currentUser = userService.getUserById(id);

        user = modelMapper.map(user, User.class);
        currentUser = userService.update(currentUser);

        return ResponseEntity.ok(currentUser);
    }
*/
}
