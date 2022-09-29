package com.spring.boot.jdbc.Spring.Boot.JDBC.ErrorResponse;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class PlayerErrorResponse {
    private int statusCode;
    private String path;
    private String message;

    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private ZonedDateTime timeStamp;

    public PlayerErrorResponse(){}

    public PlayerErrorResponse(int statusCode, String path, String message, ZonedDateTime timeStamp) {
        this.statusCode = statusCode;
        this.path = path;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
