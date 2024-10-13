package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Unloading;
import com.ty.jmrp_logistics.repository.UnloadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UnloadingDao {
    @Autowired
    private UnloadingRepository unloadingRepository;

    public Unloading saveUnloading(Unloading unloading){
        return unloadingRepository.save(unloading);
    }

    public Unloading updateUnloading(Unloading unloading){
        return unloadingRepository.save(unloading);
    }

    public Unloading findById(int id){
        Optional<Unloading> optional =unloadingRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Unloading> findAll(){
        return unloadingRepository.findAll();
    }

    public Unloading deleteById(int id) {
        Optional<Unloading> optional = unloadingRepository.findById(id);
        if (optional.isPresent()) {
            unloadingRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }

}
