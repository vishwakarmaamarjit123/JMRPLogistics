package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.AddressDao;
import com.ty.jmrp_logistics.DAO.LoadingDao;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Loading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadingService {
    @Autowired
    private LoadingDao loadingDao;
    @Autowired
    private AddressDao addressDao;

    public ResponseEntity<ResponseStructure<Loading>> saveLoading(Loading loading){
        ResponseStructure<Loading> responseStructure ;
        boolean flag = true;
        if (loading!=null){
            addressDao.saveAddress(loading.getAddress());
            loading= loadingDao.saveLoading(loading);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), loading, "Loading Created");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Loading not created");
        }
        return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Loading>> updateLoading(Loading loading){
        ResponseStructure<Loading> responseStructure ;
        boolean flag = true;
        if (loading!=null){
            addressDao.updateAddress(loading.getAddress());
            loading= loadingDao.updateLoading(loading);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), loading, "Loading updated");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Loading not updated");
        }
        return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Loading>> findByIdLoading(int id){
        ResponseStructure<Loading> responseStructure ;
        boolean flag = true;
        Loading loading = loadingDao.findById(id);
        if (loading!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), loading, "Loading found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Loading not found");
        }
        return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Loading>>> findAllLoading(){
        ResponseStructure<List<Loading>> responseStructure ;
        boolean flag = true;
        List<Loading> list = loadingDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Laoding found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Loading not found");
        }
        return new ResponseEntity<ResponseStructure<List<Loading>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Loading>> deleteLoadingByID(int id){
        ResponseStructure<Loading> responseStructure ;
        boolean flag = true;
        Loading loading = loadingDao.deleteById(id);
        if (loading!=null){
            addressDao.deleteById(loading.getAddress().getId());
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), loading, "Loading deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Loading not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


}
