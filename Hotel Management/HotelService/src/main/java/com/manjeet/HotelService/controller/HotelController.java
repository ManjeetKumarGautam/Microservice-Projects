package com.manjeet.HotelService.controller;

import com.manjeet.HotelService.model.Hotel;
import com.manjeet.HotelService.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelServices hotelServices;

//    save hotel

    @PostMapping
    public String save(@RequestBody Hotel hotel){
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelServices.addHotel(hotel);
    }

    // get hotel by id
    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId){
        return hotelServices.getHotel(hotelId);
    }

//    get all hotel
    @GetMapping
    public List<Hotel> getAllHotel(){
        return hotelServices.getAllHotel();
    }
}
