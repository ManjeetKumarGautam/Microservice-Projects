package com.manjeet.RatingService.repository;

import com.manjeet.RatingService.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IRatingRepo extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
