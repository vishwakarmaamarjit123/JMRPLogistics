package com.ty.jmrp_logistics.exception;

public class UnAuthorizedUserException extends RuntimeException{
    private String message;

    public UnAuthorizedUserException(){
    }

    public UnAuthorizedUserException(String message) {
       this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
