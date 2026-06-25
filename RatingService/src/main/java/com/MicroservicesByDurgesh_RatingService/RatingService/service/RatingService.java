package com.MicroservicesByDurgesh_RatingService.RatingService.service;

import com.MicroservicesByDurgesh_RatingService.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    //create

    Rating create(Rating rating);

    // get all
    List<Rating> getAllRating();

    // get  all rating by Userid
    List<Rating> getAllRatingByUserId(String userid);

    //get all Rating by Hotelid
    List<Rating> getAllRatingByHotelId(String hotelId);


    void delete(String ratingId);
}
