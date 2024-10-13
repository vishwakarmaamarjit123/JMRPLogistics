package com.ty.jmrp_logistics.repository;

import com.ty.jmrp_logistics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
