package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Truck;
import com.ty.jmrp_logistics.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TruckDao {
    @Autowired
    private TruckRepository truckRepository;

    public Truck saveTruck(Truck truck){
        return truckRepository.save(truck);
    }

    public Truck updateTruck(Truck truck){
        return truckRepository.save(truck);
    }

    public Truck findById(int id){
        Optional<Truck> optional =truckRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Truck> findAll(){
        return truckRepository.findAll();
    }

    public Truck deleteById(int id) {
        Optional<Truck> optional = truckRepository.findById(id);
        if (optional.isPresent()) {
            truckRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }

}
