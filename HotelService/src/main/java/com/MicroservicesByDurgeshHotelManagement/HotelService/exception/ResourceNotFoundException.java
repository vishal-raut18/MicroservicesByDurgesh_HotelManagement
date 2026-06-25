package com.MicroservicesByDurgeshHotelManagement.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException() {
        super("resource Not Found!!");
    }
}
