package com.mongodb.starter.dto.response;

public class SignInResponsedto {
    private String Status;
    private String Message;

    public SignInResponsedto(String status, String message) {
        Status = status;
        Message = message;
    }

}
