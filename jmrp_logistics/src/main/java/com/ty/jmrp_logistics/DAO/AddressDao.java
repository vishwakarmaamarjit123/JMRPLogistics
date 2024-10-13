package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.Address;
import com.ty.jmrp_logistics.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressDao {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }

    public Address findById(int id){
        Optional<Address> optional =addressRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address deleteById(int id) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            addressRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }


}
