package com.manjeet.HotelService.service;

import com.manjeet.HotelService.model.Hotel;
import com.manjeet.HotelService.repository.IHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {

    @Autowired
    IHotelRepo hotelRepo;

    public String addHotel(Hotel hotel){
       hotelRepo.save(hotel);
       return "New user Added...";
    }

    public Hotel getHotel(String hotelId){
        return hotelRepo.findById(hotelId).get();
    }

    public List<Hotel> getAllHotel(){
        return hotelRepo.findAll();
    }
}
