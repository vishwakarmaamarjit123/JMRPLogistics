package com.ty.jmrp_logistics.exceptionhandler;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.exception.CustomException;
import com.ty.jmrp_logistics.exception.UnAuthorizedUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class jmrpExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseStructure<String>> customExceptions(CustomException customException){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(customException.getMessage());
        responseStructure.setData(customException.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnAuthorizedUserException.class)
    public ResponseEntity<ResponseStructure<String>> unAuthAccess(UnAuthorizedUserException unAuthorizedUserException){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        responseStructure.setMessage(unAuthorizedUserException.getMessage());
        responseStructure.setData("login failed / unauthorized access");
        return  new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStructure<Map<String, String>>> methodNotValid(MethodArgumentNotValidException exception){
        ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
        Map<String, String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String feildname = ((FieldError)error).getField();
            String errormsg = error.getDefaultMessage();
            map.put(feildname,errormsg);
        });
        responseStructure.setMessage(map);
        responseStructure.setData("please validate the proper data");
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ResponseStructure<Map<String, String>>>(responseStructure, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> genuineException(Exception exception){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(exception.getStackTrace().toString());
        return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
    }




}
