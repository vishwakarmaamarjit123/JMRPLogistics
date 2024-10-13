package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Cargo;
import com.ty.jmrp_logistics.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CargoDao {
    
    @Autowired
    private CargoRepository cargoRepository;

    public Cargo saveCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public Cargo updateCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public Cargo findById(int id){
        Optional<Cargo> optional =cargoRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

    public Cargo deleteById(int id) {
        Optional<Cargo> optional = cargoRepository.findById(id);
        if (optional.isPresent()) {
            cargoRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }
    
    
}
