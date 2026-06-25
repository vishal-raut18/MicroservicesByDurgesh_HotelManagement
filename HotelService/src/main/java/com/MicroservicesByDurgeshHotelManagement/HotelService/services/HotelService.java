package com.MicroservicesByDurgeshHotelManagement.HotelService.services;

import com.MicroservicesByDurgeshHotelManagement.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get By Id
    Hotel getById(String id);

}
