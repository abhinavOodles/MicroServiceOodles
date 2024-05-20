package com.example.hotel.HotelService.Exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource not found !!");
    }
}

