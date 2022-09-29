package com.spring.boot.jdbc.Spring.Boot.JDBC.ErrorResponse;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(){
        super();
    }


    public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrack){
        super(message,cause,enableSuppression,writableStackTrack);
    }

    public PlayerNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public PlayerNotFoundException(String message){
        super(message);
    }

    public PlayerNotFoundException(Throwable cause){
        super(cause);
    }







}
