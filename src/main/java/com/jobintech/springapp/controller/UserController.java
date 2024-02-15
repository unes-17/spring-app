package com.jobintech.springapp.controller;

import com.jobintech.springapp.entities.User;
import com.jobintech.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User userSave(@RequestBody User user){

        return userService.create(user);
    }

    @GetMapping("/users")
    public List<User> allUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User allUsers(@PathVariable long id){
        return userService.getUserById(id);
    }

    /*@GetMapping("/users/{id}")
    public User allUsers(@PathVariable long id){
        return userService.getUserById(id);
    }*/

}
