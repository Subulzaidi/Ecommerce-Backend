package com.mongodb.starter.Exception;

public class CustomExceptions extends IllegalArgumentException{
    public CustomExceptions(String msg){
        super(msg);

    }
}
