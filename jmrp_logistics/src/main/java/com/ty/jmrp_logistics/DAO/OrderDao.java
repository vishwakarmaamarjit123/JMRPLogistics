package com.ty.jmrp_logistics.DAO;


import com.ty.jmrp_logistics.entity.Order;
import com.ty.jmrp_logistics.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }

    public Order findById(int id){
        Optional<Order> optional =orderRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order deleteById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            orderRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }
    
}
