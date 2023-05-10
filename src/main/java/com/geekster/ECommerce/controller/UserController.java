package com.geekster.ECommerce.controller;

import com.geekster.ECommerce.model.Address;
import com.geekster.ECommerce.model.Users;
import com.geekster.ECommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        List<Address> addressList = user.getAddress();
        for(Address address : addressList){
            address.setUser(user);
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return userService.getAllUsers();
    }
}
