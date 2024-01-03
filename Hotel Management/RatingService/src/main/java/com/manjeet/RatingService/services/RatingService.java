package com.manjeet.RatingService.services;

import com.manjeet.RatingService.model.Rating;
import com.manjeet.RatingService.repository.IRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    IRatingRepo ratingRepo;

//    create

    public String addRating(Rating rating){
        ratingRepo.save(rating);
        return "Rating added...";
    }

    public List<Rating> getAllRating(){
        return ratingRepo.findAll();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }
    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
}
