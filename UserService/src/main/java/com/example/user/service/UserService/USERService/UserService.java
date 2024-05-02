package com.example.user.service.UserService.USERService;

import com.example.user.service.UserService.External.Services.HotelService;
import com.example.user.service.UserService.Model.Hotel;
import com.example.user.service.UserService.Model.Rating;
import com.example.user.service.UserService.Model.User;
import com.example.user.service.UserService.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

   @Autowired
   private RestTemplate restTemplate ;

   @Autowired
   private HotelService hotelService ;


   private Logger logger = LoggerFactory.getLogger(UserService.class);

    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserID(randomUserId);

        User user1 = userRepository.save(user) ;
        return user1 ;
    }

    //all user
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE  for showcase all the rating given by user when we go to see the all list of user
        return userRepository.findAll();
    }
 // single user
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow();

         Rating [] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserID(), Rating[].class) ;
       logger.info("{} " ,ratingOfUser );

      List<Rating> ratings =   Arrays.stream(ratingOfUser).toList() ;

       List<Rating> ratingList =ratings.stream().map(rating -> {

           // hotel service path -http://localhost:8082/hotels/173ee99b-fd02-4814-9aee-22ae5713e224;

//        ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class) ;
//        Hotel hotel = forEntity.getBody() ;
//        logger.info("Response Code {} " ,forEntity.getStatusCode());

           Hotel hotel = hotelService.getHotel(rating.getHotelId()) ;

           rating.setHotel(hotel) ;

           return rating;
       }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
