package com.MicroservicesByDurgesh_RatingService.RatingService.repository;

import com.MicroservicesByDurgesh_RatingService.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelId);
}
