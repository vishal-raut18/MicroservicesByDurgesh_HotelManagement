package com.MicroservicesByDurgeshHotelManagement.HotelService.services.imp;

import com.MicroservicesByDurgeshHotelManagement.HotelService.entity.Hotel;
import com.MicroservicesByDurgeshHotelManagement.HotelService.exception.ResourceNotFoundException;
import com.MicroservicesByDurgeshHotelManagement.HotelService.repository.Hotelrepo;
import com.MicroservicesByDurgeshHotelManagement.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImp implements HotelService {


    @Autowired
    private Hotelrepo hotelrepo;

    @Override
    public Hotel create(Hotel hotel) {

        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelrepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelrepo.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user with give id is not found on server "+id));
    }
}

