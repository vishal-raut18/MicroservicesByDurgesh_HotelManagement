package com.MicroservicesByDurgeshHotelManagement.HotelService.controller;


import com.MicroservicesByDurgeshHotelManagement.HotelService.entity.Hotel;
import com.MicroservicesByDurgeshHotelManagement.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // create
    @PostMapping
    public ResponseEntity<Hotel>  create(@RequestBody Hotel hotel){

        Hotel hotel1=hotelService.create(hotel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    // get single
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotel=hotelService.getById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> allHotel=hotelService.getAll();
        return ResponseEntity.ok(allHotel);
    }
}

