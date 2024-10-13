package com.ty.jmrp_logistics.repository;

import com.ty.jmrp_logistics.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
}
