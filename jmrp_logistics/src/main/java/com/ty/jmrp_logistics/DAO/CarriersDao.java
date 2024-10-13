package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Carriers;
import com.ty.jmrp_logistics.entity.Driver;
import com.ty.jmrp_logistics.repository.CarriersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarriersDao {
    @Autowired
    private CarriersRepository carriersRepository;

    public Carriers saveCarriers(Carriers carriers){
        return carriersRepository.save(carriers);
    }

    public Carriers updateCarriers(Carriers carriers){
        return carriersRepository.save(carriers);
    }

    public Carriers findById(int id){
        Optional<Carriers> optional =carriersRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Carriers> findAll(){
        return carriersRepository.findAll();
    }

    public Carriers deleteById(int id) {
        Optional<Carriers> optional = carriersRepository.findById(id);
        if (optional.isPresent()) {
            carriersRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }

}
