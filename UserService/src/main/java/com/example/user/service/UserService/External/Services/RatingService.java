package com.example.user.service.UserService.External.Services;

import com.example.user.service.UserService.Model.Rating;
import jakarta.ws.rs.POST;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating create (Rating value) ;

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating (@PathVariable ("ratingId")String ratingId , Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteMapping (@PathVariable("ratingId") String ratingId )  ;
}
