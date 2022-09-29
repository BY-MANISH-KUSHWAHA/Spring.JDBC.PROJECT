package com.spring.boot.jdbc.Spring.Boot.JDBC.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@ControllerAdvice // without it. it's giving 500 server error, with it. it will give 404 record not found
public class PlayerExceptionHandler {

    @ExceptionHandler
    // Map both class based on parameter passed in below method like ErrorResponse and NotfoundException for player.
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(PlayerNotFoundException exception, HttpServletRequest request){
        //int statusCode, String path, String message, ZonedDateTime timeStamp
        PlayerErrorResponse responseError = new PlayerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                exception.getMessage()+" Custom response",
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    // Map both class based on parameter passed in below method like ErrorResponse and NotfoundException for player.
    public ResponseEntity<PlayerErrorResponse> genericHandler(
            Exception exception,
            HttpServletRequest request
    ){
        //int statusCode, String path, String message, ZonedDateTime timeStamp
        PlayerErrorResponse responseError = new PlayerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                exception.getMessage()+" , Generic Class",
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
    }



}
