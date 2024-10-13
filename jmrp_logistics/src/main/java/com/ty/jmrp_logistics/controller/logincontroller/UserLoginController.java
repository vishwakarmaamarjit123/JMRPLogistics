package com.ty.jmrp_logistics.controller.logincontroller;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.User;
import com.ty.jmrp_logistics.service.entityservice.LoginEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/user")
public class UserLoginController {
    @Autowired
    private LoginEntityService loginEntityService;

    @GetMapping
    public ResponseEntity<ResponseStructure<User>> loginUser(@RequestBody User user){
        return loginEntityService.loginUser(user);
    }

    @PostMapping
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        return loginEntityService.registerUser(user);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseStructure<User>> logoutUser(){
        return loginEntityService.logoutUser();
    }

}
