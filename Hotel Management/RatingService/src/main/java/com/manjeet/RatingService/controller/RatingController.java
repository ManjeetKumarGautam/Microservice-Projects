package com.manjeet.RatingService.controller;

import com.manjeet.RatingService.model.Rating;
import com.manjeet.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public String save(@RequestBody Rating rating){
        return ratingService.addRating(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRating();
    }

    @GetMapping("/users/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable String userId){
        return ratingService.getRatingByUserId(userId);
    }

    @GetMapping("/hotels/{hotelId}")
    public List<Rating> getRatingByHotelId(@PathVariable String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }
}
