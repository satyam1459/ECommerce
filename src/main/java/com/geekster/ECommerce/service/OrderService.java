package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Address;
import com.geekster.ECommerce.model.OrderTable;
import com.geekster.ECommerce.model.Product;
import com.geekster.ECommerce.model.Users;
import com.geekster.ECommerce.repository.IAddressRepository;
import com.geekster.ECommerce.repository.IOrderRepository;
import com.geekster.ECommerce.repository.IProductRepository;
import com.geekster.ECommerce.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private IAddressRepository iAddressRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IUserRepository iUserRepository;

    public void createOrder(OrderTable order){
        Long addressID = order.getOrderAddress().getAddressId();
        Optional<Address> myAddress  = iAddressRepository.findByAddressId(addressID);

        Long productId = order.getOrderProduct().getProductId();
        Optional<Product> myProduct = iProductRepository.findByProductId(productId);

        Long userId = order.getOrderUser().getUserId();
        Optional<Users> myUser = iUserRepository.findByUserId(userId);

        if(myAddress.isPresent() && myProduct.isPresent() && myUser.isPresent()) {
            order.setOrderAddress(myAddress.get());
            order.setOrderProduct(myProduct.get());
            order.setOrderUser(myUser.get());
            iOrderRepository.save(order);
        }else
        {
            throw new NoSuchElementException("Id's sent for  creating order are not valid");
        }
    }

    public ResponseEntity<OrderTable> getOrderById(Integer id) {
        Optional<OrderTable> myOrder =  iOrderRepository.findById(id);
        if(myOrder.isPresent()){
            return ResponseEntity.ok(myOrder.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}
