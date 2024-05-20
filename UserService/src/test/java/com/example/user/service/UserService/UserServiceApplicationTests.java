package com.example.user.service.UserService;

import com.example.user.service.UserService.External.Services.RatingService;
import com.example.user.service.UserService.Model.Rating;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	RatingService ratingService ;

//     void createRating (){
//		 Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is feign Client")
//				 .build();
//		Rating newRating =  ratingService.create(rating);
//
//		System.out.println("New Rating Created");
//	 }

}
