package com.hotelManagement.LearnWithDurgesh.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource Not Found On server !!");
    }
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
