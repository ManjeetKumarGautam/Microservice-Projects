package com.manjeet.HotelService.repository;

import com.manjeet.HotelService.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepo extends JpaRepository<Hotel,String> {
}
