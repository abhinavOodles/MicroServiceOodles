package com.example.hotel.HotelService.Service;

import com.example.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.example.hotel.HotelService.Model.Hotel;
import com.example.hotel.HotelService.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository ;

    public Hotel create(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepository.save(hotel) ;
    }

    public Hotel get(String hotelId) throws ResourceNotFoundException {
        return hotelRepository.findById(hotelId).
                orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found Exception"));    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll() ;
    }
}
