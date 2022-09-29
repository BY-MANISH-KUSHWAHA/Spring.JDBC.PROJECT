package com.spring.boot.jdbc.Spring.Boot.JDBC.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(PlayerNotFoundException exception, HttpServletRequest request){
        //int statusCode, String path, String message, ZonedDateTime timeStamp
        PlayerErrorResponse responseError = new PlayerErrorResponse(HttpStatus.NOT_FOUND.value(),request.getRequestURI(),exception.getMessage(),ZonedDateTime.now());
        return new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);
    }
}
