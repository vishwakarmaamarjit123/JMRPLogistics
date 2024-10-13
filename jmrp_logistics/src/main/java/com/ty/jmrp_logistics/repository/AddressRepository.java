package com.ty.jmrp_logistics.repository;

import com.ty.jmrp_logistics.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
