package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.AddressDao;
import com.ty.jmrp_logistics.DAO.UserDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.User;
import com.ty.jmrp_logistics.utility.Auth;
import com.ty.jmrp_logistics.utility.Authentication;
import com.ty.jmrp_logistics.utility.DataEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private DataEncoderDecoder dataEncoderDecoder;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private Authentication authentication;

    public ResponseEntity<ResponseStructure<User>> loginUser(int id, String password){
        User user = userDao.findById(id);
        boolean flag = false;
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if(user!=null){
            authentication.isAgainAuthen();
            String currPassword = password;
            String dbPassword = dataEncoderDecoder.decoder(user.getUserPassword());
            if(currPassword.equals(dbPassword)){
               Auth.creater();
               responseStructure.setStatusCode(HttpStatus.OK.value());
               responseStructure.setMessage(user);
               responseStructure.setData("Welcome to JMRP Logistics");
               flag = true;
            }
            else {
                responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
                responseStructure.setMessage(null);
                responseStructure.setData("Incorrect password");
            }

        }
        else {
            responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
            responseStructure.setMessage(null);
            responseStructure.setData("Incorrect user id");
        }
        return  new ResponseEntity<ResponseStructure<User>>(responseStructure, flag==true ? HttpStatus.OK : HttpStatus.UNAUTHORIZED );
    }



    public ResponseEntity<ResponseStructure<User>> registerUser(User user){
        boolean flag = false;
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if(user!=null){
            user.setUserPassword(dataEncoderDecoder.encoder(user.getUserPassword()));
            addressDao.saveAddress(user.getAddress());
            User user1 = userDao.saveUser(user);
            if(user1!=null ){
                Auth.creater();
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMessage(user);
                responseStructure.setData("Welcome to JMRP Logistics");
                flag = true;
            }
            else {
                responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
                responseStructure.setMessage(null);
                responseStructure.setData("data not saved");
            }

        }
        else {
            responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
            responseStructure.setMessage(null);
            responseStructure.setData("please provide complete details");
        }
        return  new ResponseEntity<ResponseStructure<User>>(responseStructure, flag==true ? HttpStatus.OK : HttpStatus.UNAUTHORIZED );
    }


    public ResponseEntity<ResponseStructure<User>> logoutUser(){
        boolean flag = false;
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if(Auth.isAuthenticated()){
                Auth.destroyer();
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMessage(null);
                responseStructure.setData("Thank you for be a part of JMRP Logistics");
                flag = true;
            }
            else {
                responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
                responseStructure.setMessage(null);
                responseStructure.setData("please log in first");
            }

        return  new ResponseEntity<ResponseStructure<User>>(responseStructure, flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }






}
