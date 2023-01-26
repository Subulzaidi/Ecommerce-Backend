package com.mongodb.starter.dto.response;

public class SignupResponsedto {
    private String Status;
    private String message;

    public SignupResponsedto(String status, String message) {
        Status = status;
        this.message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
