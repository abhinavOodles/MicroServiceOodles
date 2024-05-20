package com.example.hotel.HotelService.Repository;

import com.example.hotel.HotelService.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
