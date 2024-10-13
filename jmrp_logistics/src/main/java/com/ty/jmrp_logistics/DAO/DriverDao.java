package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Driver;
import com.ty.jmrp_logistics.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DriverDao {
    @Autowired
    private DriverRepository driverRepository;

    public Driver saveDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver findById(int id){
        Optional<Driver> optional =driverRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

    public Driver deleteById(int id) {
        Optional<Driver> optional = driverRepository.findById(id);
        if (optional.isPresent()) {
            driverRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }
    
}
