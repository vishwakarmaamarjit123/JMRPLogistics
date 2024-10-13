package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.TruckDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {
    @Autowired
    private TruckDao truckDao;

    public ResponseEntity<ResponseStructure<Truck>> saveTruck(Truck truck){
        ResponseStructure<Truck> responseStructure ;
        boolean flag = true;
        if (truck!=null){
            truckDao.saveTruck(truck);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), truck, "Truck Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Truck not created");
        }
        return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Truck>> updateTruck(Truck truck){
        ResponseStructure<Truck> responseStructure ;
        boolean flag = true;
        if (truck!=null){
            truck= truckDao.updateTruck(truck);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), truck, "Truck updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Truck not updated");
        }
        return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Truck>> findByIdTruck(int id){
        ResponseStructure<Truck> responseStructure ;
        boolean flag = true;
        Truck truck = truckDao.findById(id);
        if (truck!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), truck, "Truck found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Truck not found");
        }
        return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Truck>>> findAllTruck(){
        ResponseStructure<List<Truck>> responseStructure ;
        boolean flag = true;
        List<Truck> list = truckDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Truck found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Truck not found");
        }
        return new ResponseEntity<ResponseStructure<List<Truck>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Truck>> deleteTruckByID(int id){
        ResponseStructure<Truck> responseStructure ;
        boolean flag = true;
        Truck truck = truckDao.deleteById(id);
        if (truck!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), truck, "Truck deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Truck not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }




}
