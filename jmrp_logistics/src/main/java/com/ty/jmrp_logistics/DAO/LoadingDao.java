package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Loading;
import com.ty.jmrp_logistics.repository.LoadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoadingDao {

    @Autowired
    private LoadingRepository loadingRepository;

    public Loading saveLoading(Loading loading){
        return loadingRepository.save(loading);
    }

    public Loading updateLoading(Loading loading){
        return loadingRepository.save(loading);
    }

    public Loading findById(int id){
        Optional<Loading> optional =loadingRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Loading> findAll(){
        return loadingRepository.findAll();
    }

    public Loading deleteById(int id) {
        Optional<Loading> optional = loadingRepository.findById(id);
        if (optional.isPresent()) {
            loadingRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }
    
}
