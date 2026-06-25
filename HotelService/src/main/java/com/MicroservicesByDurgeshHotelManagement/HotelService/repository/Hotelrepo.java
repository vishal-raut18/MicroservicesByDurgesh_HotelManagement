package com.MicroservicesByDurgeshHotelManagement.HotelService.repository;

import com.MicroservicesByDurgeshHotelManagement.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hotelrepo extends JpaRepository<Hotel,String> {
}
