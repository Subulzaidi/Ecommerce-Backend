package com.mongodb.starter.common;

import java.time.LocalDateTime;

public class ApiResponse {
    private final boolean status;
    private String message;

    public ApiResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getTimestamop(){
        return LocalDateTime.now().toString();
    }
}
