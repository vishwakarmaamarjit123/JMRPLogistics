package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.CarriersDao;
import com.ty.jmrp_logistics.DAO.DriverDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Carriers;
import com.ty.jmrp_logistics.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarriersService {
    @Autowired
    private CarriersDao carriersDao;
    @Autowired
    private DriverDao driverDao;
    
    
    public ResponseEntity<ResponseStructure<Carriers>> saveCarriers(Carriers carriers){
        ResponseStructure<Carriers> responseStructure ;
        boolean flag = true;
        if (carriers!=null){
            List<Driver> list1 = carriers.getDriver();
            List<Driver> list = list1;
            for(Driver driver:list){
                driver.setCarriers(null);
                driverDao.saveDriver(driver);
            }
            Carriers carriers1= carriersDao.saveCarriers(carriers);
            for (Driver driver: list1){
                driverDao.updateDriver(driver);
            }
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), carriers, "Carrier Created");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Carrier not created");
        }
        return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Carriers>> updateCarrier(Carriers carriers){
        ResponseStructure<Carriers> responseStructure ;
        boolean flag = true;
        if (carriers!=null){
            carriers= carriersDao.saveCarriers(carriers);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), carriers, "Carrier updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Carrier not updated");
        }
        return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Carriers>> findByIdCarriers(int id){
        ResponseStructure<Carriers> responseStructure ;
        boolean flag = true;
        Carriers carriers = carriersDao.findById(id);
        if (carriers!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), carriers, "Carrier found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Carrier not found");
        }
        return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Carriers>>> findAllCarrier(){
        ResponseStructure<List<Carriers>> responseStructure ;
        boolean flag = true;
        List<Carriers> list = carriersDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Carriers found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Carrier not found");
        }
        return new ResponseEntity<ResponseStructure<List<Carriers>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Carriers>> deleteCarrierByID(int id){
        ResponseStructure<Carriers> responseStructure ;
        boolean flag = true;
        List<Driver> list = carriersDao.findById(id).getDriver();
        for (Driver driver:list){
            Driver driver1 = driverDao.findById(driver.getId());
            driver1.setCarriers(null);
             driverDao.updateDriver( driver1 );
        }
        Carriers carriers = carriersDao.deleteById(id);
        if (carriers!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), carriers, "Carrier deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Carrier not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }



}
