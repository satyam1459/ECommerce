package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Order_Table;
import com.geekster.ECommerce.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public Order_Table createOrder(Order_Table order) {
        return orderRepository.save(order);
    }

    public Optional<Order_Table> getOrderById(Integer id) {
        return orderRepository.findById(id);

    }
}
