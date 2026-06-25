package com.hotelManagement.LearnWithDurgesh.UserService.services.imp;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.Hotel;
import com.hotelManagement.LearnWithDurgesh.UserService.entity.Rating;
import com.hotelManagement.LearnWithDurgesh.UserService.entity.User;
import com.hotelManagement.LearnWithDurgesh.UserService.exceptions.ResourceNotFoundException;
import com.hotelManagement.LearnWithDurgesh.UserService.external.service.HotelService;
import com.hotelManagement.LearnWithDurgesh.UserService.repository.UserRepository;
import com.hotelManagement.LearnWithDurgesh.UserService.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        //This get the from User service for that userid but not get ratting so we need to call rating service
        User user1 = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user with give id is not found on server " + userId));

        // So fetch the rating of above user from RATING-SERVICE
        // http://localhost:8083/ratings/users/aa2c9ec4-c776-40a3-90ca-100e5a5ad715
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user1.getUserId(), Rating[].class);
        logger.info("{} " + ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel =hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user1.setRatings(ratingList);
        return user1;
    }
}
