package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.AddressDao;
import com.ty.jmrp_logistics.DAO.UserDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.User;
import com.ty.jmrp_logistics.utility.Authentication;
import com.ty.jmrp_logistics.utility.DataEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private DataEncoderDecoder dataEncoderDecoder;
    @Autowired
    private Authentication authentication;


    public ResponseEntity<ResponseStructure<User>> saveUser(User user){
        ResponseStructure<User> responseStructure ;
        boolean flag = true;
        if (user!=null){
            user.setUserPassword( dataEncoderDecoder.encoder(user.getUserPassword()) );
            addressDao.saveAddress(user.getAddress());
            user= userDao.saveUser(user);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), user, "User Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "User not created");
        }
        return new ResponseEntity<ResponseStructure<User>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<User>> updateUser(User user){
        ResponseStructure<User> responseStructure ;
        boolean flag = true;
        if (user!=null){
            user.setUserPassword( dataEncoderDecoder.encoder(user.getUserPassword()) );
            addressDao.updateAddress(user.getAddress());
            user= userDao.updateUser(user);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), user, "User updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "User not updated");
        }
        return new ResponseEntity<ResponseStructure<User>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<User>> findByIdUser(int id){
        ResponseStructure<User> responseStructure ;
        boolean flag = true;
        User user = userDao.findById(id);
        if (user!=null){
           // user.setUserPassword( dataEncoderDecoder.decoder(user.getUserPassword()) );
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), user, "User found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "User not found");
        }
        return new ResponseEntity<ResponseStructure<User>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
        ResponseStructure<List<User>> responseStructure ;
        boolean flag = true;
        List<User> list = userDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "User found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "User not found");
        }
        return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<User>> deleteUserByID(int id){
        ResponseStructure<User> responseStructure ;
        boolean flag = true;
        User user = userDao.deleteById(id);
        if (user!=null){
            addressDao.deleteById(user.getAddress().getId());
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), user, "User deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "User not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<User>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }






}
