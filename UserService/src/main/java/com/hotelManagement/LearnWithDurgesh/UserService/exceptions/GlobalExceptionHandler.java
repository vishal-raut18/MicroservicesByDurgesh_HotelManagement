package com.hotelManagement.LearnWithDurgesh.UserService.exceptions;


import com.hotelManagement.LearnWithDurgesh.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String msg=ex.getMessage();
      ApiResponse response=  ApiResponse.builder().msg(msg).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
}
