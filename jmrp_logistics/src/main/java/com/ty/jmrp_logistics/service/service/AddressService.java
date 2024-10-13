package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.AddressDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Address;
import com.ty.jmrp_logistics.utility.DataEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private DataEncoderDecoder dataEncoderDecoder;
    @Autowired
    private AddressDao addressDao;


    public ResponseEntity<ResponseStructure<Address>> saveAddress(Address  address){
        ResponseStructure<Address> responseStructure ;
        boolean flag = true;
        if (address!=null){
            addressDao.saveAddress(address);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), address, "Address Created");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Address not created");
        }
        return new ResponseEntity<ResponseStructure<Address>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
        ResponseStructure<Address> responseStructure ;
        boolean flag = true;
        if (address!=null){
            addressDao.updateAddress(address);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), address, "Address updated");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Address not updated");
        }
        return new ResponseEntity<ResponseStructure<Address>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Address>> findByIdAddress(int id){
        ResponseStructure<Address> responseStructure ;
        boolean flag = true;
        Address address = addressDao.findById(id);
        if (address!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), address, "Address found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Address not found");
        }
        return new ResponseEntity<ResponseStructure<Address>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress(){
        ResponseStructure<List<Address>> responseStructure ;
        boolean flag = true;
        List<Address> list = addressDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Address found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Address not found");
        }
        return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Address>> deleteUserByAddress(int id){
        ResponseStructure<Address> responseStructure ;
        boolean flag = true;
        Address address = addressDao.deleteById(id);
        if (address!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), address, "Address deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Address not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Address>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }





}
