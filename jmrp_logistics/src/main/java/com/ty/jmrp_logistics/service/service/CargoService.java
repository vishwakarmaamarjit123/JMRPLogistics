package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.CargoDao;
import com.ty.jmrp_logistics.DAO.CarriersDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoDao cargoDao;


    public ResponseEntity<ResponseStructure<Cargo>> saveCargo(Cargo cargo){
        ResponseStructure<Cargo> responseStructure ;
        boolean flag = true;
        if (cargo!=null){
            cargo= cargoDao.saveCargo(cargo);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), cargo, "Cargo Created");
            
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Cargo not created");
        }
        return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Cargo>> updateCargo(Cargo cargo){
        ResponseStructure<Cargo> responseStructure ;
        boolean flag = true;
        if (cargo!=null){
            cargo= cargoDao.updateCargo(cargo);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), cargo, "Cargo updated");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Cargo not updated");
        }
        return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Cargo>> findByIdUser(int id){
        ResponseStructure<Cargo> responseStructure ;
        boolean flag = true;
        Cargo cargo = cargoDao.findById(id);
        if (cargo!=null){
            // user.setUserPassword( dataEncoderDecoder.decoder(user.getUserPassword()) );
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), cargo, "Cargo found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Cargo not found");
        }
        return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Cargo>>> findAllUser(){
        ResponseStructure<List<Cargo>> responseStructure ;
        boolean flag = true;
        List<Cargo> list = cargoDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Cargo found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Cargo not found");
        }
        return new ResponseEntity<ResponseStructure<List<Cargo>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Cargo>> deleteUserByID(int id){
        ResponseStructure<Cargo> responseStructure ;
        boolean flag = true;
        Cargo cargo = cargoDao.deleteById(id);
        if (cargo!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), cargo, "Cargo deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Cargo not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }



}
