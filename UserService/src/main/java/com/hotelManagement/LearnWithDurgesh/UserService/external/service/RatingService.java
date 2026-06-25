package com.hotelManagement.LearnWithDurgesh.UserService.external.service;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    public Rating crateRating( Rating rating);

    // Update
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId,  Rating rating);

    // DELETE
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
