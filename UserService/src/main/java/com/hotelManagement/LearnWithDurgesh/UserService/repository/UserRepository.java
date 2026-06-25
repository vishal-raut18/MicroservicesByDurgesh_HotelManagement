package com.hotelManagement.LearnWithDurgesh.UserService.repository;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
