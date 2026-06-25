package com.hotelManagement.LearnWithDurgesh.UserService;

import com.hotelManagement.LearnWithDurgesh.UserService.entity.Rating;
import com.hotelManagement.LearnWithDurgesh.UserService.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void crateRating(){
//		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using Feign Client").build();
//		Rating savedRating = ratingService.crateRating(rating);
//		System.out.println("new Rating Created");
//	}
}
