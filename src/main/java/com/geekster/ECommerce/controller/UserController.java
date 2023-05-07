package com.geekster.ECommerce.controller;

import com.geekster.ECommerce.model.Address;
import com.geekster.ECommerce.model.Users;
import com.geekster.ECommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        List<Address> addressList = user.getAddress();
        for(Address address : addressList){
            address.setUser(user);
        }
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
