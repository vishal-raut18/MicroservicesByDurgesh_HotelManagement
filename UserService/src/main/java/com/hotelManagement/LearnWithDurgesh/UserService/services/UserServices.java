package com.hotelManagement.LearnWithDurgesh.UserService.services;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);

    //get All User
    List<User> getAllUser();

    //get User By UserId
    User getUser(String userId);

    //Delete

    //Update -homework
}
