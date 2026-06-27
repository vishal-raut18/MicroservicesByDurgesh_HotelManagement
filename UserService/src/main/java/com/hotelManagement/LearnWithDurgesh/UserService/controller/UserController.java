package com.hotelManagement.LearnWithDurgesh.UserService.controller;


import com.hotelManagement.LearnWithDurgesh.UserService.entity.User;
import com.hotelManagement.LearnWithDurgesh.UserService.services.UserServices;
import com.hotelManagement.LearnWithDurgesh.UserService.services.imp.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);
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
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user1 = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

        logger.info("Fallback is executed becouse service is down : " + ex.getMessage());

        User  user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy becouse some service is down")
                .userId("11111111")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
