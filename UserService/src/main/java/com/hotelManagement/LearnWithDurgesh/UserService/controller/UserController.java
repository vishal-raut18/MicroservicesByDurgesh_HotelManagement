package com.hotelManagement.LearnWithDurgesh.UserService.controller;


import com.hotelManagement.LearnWithDurgesh.UserService.entity.User;
import com.hotelManagement.LearnWithDurgesh.UserService.services.UserServices;
import com.hotelManagement.LearnWithDurgesh.UserService.services.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    // add
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get all  user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    // get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user1 = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }
}
