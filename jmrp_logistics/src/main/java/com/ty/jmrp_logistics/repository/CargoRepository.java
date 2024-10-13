package com.ty.jmrp_logistics.repository;

import com.ty.jmrp_logistics.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository  extends JpaRepository<Cargo, Integer> {
}
