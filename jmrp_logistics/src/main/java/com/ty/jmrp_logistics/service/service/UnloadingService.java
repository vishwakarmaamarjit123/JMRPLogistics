package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.AddressDao;
import com.ty.jmrp_logistics.DAO.UnloadingDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Unloading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnloadingService {
    @Autowired
    private UnloadingDao unloadingDao;
    @Autowired
    private AddressDao addressDao;


    public ResponseEntity<ResponseStructure<Unloading>> saveUnloading(Unloading unloading){
        ResponseStructure<Unloading> responseStructure ;
        boolean flag = true;
        if (unloading!=null){
            addressDao.saveAddress(unloading.getAddress());
            unloading= unloadingDao.saveUnloading(unloading);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), unloading, "Unloading Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Unloading not created");
        }
        return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(Unloading unloading){
        ResponseStructure<Unloading> responseStructure ;
        boolean flag = true;
        if (unloading!=null){
            addressDao.updateAddress(unloading.getAddress());
            unloading= unloadingDao.saveUnloading(unloading);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), unloading, "Unloading updated");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Unloading not updated");
        }
        return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Unloading>> findByIdUnloading(int id){
        ResponseStructure<Unloading> responseStructure ;
        boolean flag = true;
        Unloading unloading = unloadingDao.findById(id);
        if (unloading!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), unloading, "Unloading found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Unloading not found");
        }
        return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Unloading>>> findAllUnloading(){
        ResponseStructure<List<Unloading>> responseStructure ;
        boolean flag = true;
        List<Unloading> list = unloadingDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Unloading found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Unloading not found");
        }
        return new ResponseEntity<ResponseStructure<List<Unloading>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Unloading>> deleteUnloadingByID(int id){
        ResponseStructure<Unloading> responseStructure ;
        boolean flag = true;
        Unloading unloading = unloadingDao.deleteById(id);
        if (unloading!=null){
            addressDao.deleteById(unloading.getAddress().getId());
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), unloading, "Unloading deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Unloading not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }





}
