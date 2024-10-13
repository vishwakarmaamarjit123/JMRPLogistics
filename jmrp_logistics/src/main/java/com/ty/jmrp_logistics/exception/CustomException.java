package com.ty.jmrp_logistics.exception;

public class CustomException extends RuntimeException{
    private String message;

    public CustomException() {
    }

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
