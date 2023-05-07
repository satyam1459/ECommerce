package com.geekster.ECommerce.controller;

import com.geekster.ECommerce.model.Order_Table;
import com.geekster.ECommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @PostMapping
    public Order_Table createOrder(@RequestBody Order_Table order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<Order_Table> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }
}
