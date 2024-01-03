package com.ecommerce.user.UserService.service;

import com.ecommerce.user.UserService.model.Hotel;
import com.ecommerce.user.UserService.model.Rating;
import com.ecommerce.user.UserService.model.User;
import com.ecommerce.user.UserService.repository.IUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepo;

    @Autowired
    RestTemplate restTemplate;


    public String addUser(User user){
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        userRepo.save(user);
        return "User sucessfully added.";
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUser(String userId){
        User user = userRepo.findById(userId).get();
        Rating[] userRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        List<Rating> ratings= Arrays.stream(userRatings).toList();

        List<Rating> ratingList=ratings.stream().map(rating -> {
            ResponseEntity<Hotel> hotelEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=hotelEntity.getBody();
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
