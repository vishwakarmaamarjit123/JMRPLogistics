package com.ty.jmrp_logistics.DTO;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseStructure<T> {
    private LocalTime localTime = LocalTime.now();
    private int statusCode;
    private T message;
    private String data;

    public ResponseStructure(){
    }

    public ResponseStructure( int statusCode, T message, String data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime() {
        this.localTime = LocalTime.now();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
