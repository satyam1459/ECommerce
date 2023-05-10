package com.geekster.ECommerce.controller;

import com.geekster.ECommerce.model.OrderTable;
import com.geekster.ECommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderTable order) {

        String response;
        HttpStatus status;
        try {
            orderService.createOrder(order);
            response = "Your order of " + order.getProductQuantity() + " was placed...successfully!!!";
            status = HttpStatus.CREATED;
        }catch(Exception e)
        {
            response = "Orders can't be placed as no such details filled with order are available";
            status = HttpStatus.BAD_REQUEST;
            System.out.println(e);
        }
        return new ResponseEntity<String>(response,status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderTable> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

}
