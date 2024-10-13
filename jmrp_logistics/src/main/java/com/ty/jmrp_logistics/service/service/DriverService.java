package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.DriverDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverDao driverDao;

    public ResponseEntity<ResponseStructure<Driver>> saveDriver(Driver driver){
        ResponseStructure<Driver> responseStructure ;
        boolean flag = true;
        if (driver!=null){
            driver= driverDao.saveDriver(driver);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), driver, "Driver Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Driver not created");
        }
        return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Driver>> updateDriver(Driver driver){
        ResponseStructure<Driver> responseStructure ;
        boolean flag = true;
        if (driver!=null){
            driver= driverDao.updateDriver(driver);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), driver, "Driver updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Driver not updated");
        }
        return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Driver>> findByIdDriver(int id){
        ResponseStructure<Driver> responseStructure ;
        boolean flag = true;
        Driver driver = driverDao.findById(id);
        if (driver!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), driver, "Driver found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Driver not found");
        }
        return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Driver>>> findAllDriver(){
        ResponseStructure<List<Driver>> responseStructure ;
        boolean flag = true;
        List<Driver> list = driverDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Driver found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Driver not found");
        }
        return new ResponseEntity<ResponseStructure<List<Driver>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Driver>> deleteDriverByID(int id){
        ResponseStructure<Driver> responseStructure ;
        boolean flag = true;
        Driver driver = driverDao.deleteById(id);
        if (driver!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), driver, "Driver deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Driver not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }



}
