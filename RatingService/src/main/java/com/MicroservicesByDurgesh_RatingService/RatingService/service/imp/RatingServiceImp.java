package com.MicroservicesByDurgesh_RatingService.RatingService.service.imp;

import com.MicroservicesByDurgesh_RatingService.RatingService.entity.Rating;
import com.MicroservicesByDurgesh_RatingService.RatingService.repository.RatingRepo;
import com.MicroservicesByDurgesh_RatingService.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImp implements RatingService {

    @Autowired
    private RatingRepo ratingrepo;

    @Override
    public Rating create(Rating rating) {
        String rattingId= UUID.randomUUID().toString();
        rating.setRatingId(rattingId);
        return ratingrepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingrepo.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userid) {
        return ratingrepo.findByUserId(userid);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingrepo.findByHotelId(hotelId);
    }
}
