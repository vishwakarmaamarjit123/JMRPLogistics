package com.ty.jmrp_logistics.service.entityservice;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.User;
import com.ty.jmrp_logistics.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginEntityService {
    @Autowired
    private LoginService loginService;

    public ResponseEntity<ResponseStructure<User>> loginUser( User user){
        return loginService.loginUser(user.getId(), user.getUserPassword());
    }

    public ResponseEntity<ResponseStructure<User>> registerUser(User user){
        return loginService.registerUser(user);
    }

    public ResponseEntity<ResponseStructure<User>> logoutUser(){
        return loginService.logoutUser();
    }


}
