package com.hotelManagement.LearnWithDurgesh.UserService.external.service;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId);
}
