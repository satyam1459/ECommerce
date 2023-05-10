package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Users;
import com.geekster.ECommerce.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;


    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    public ResponseEntity<Users> getUserById(Long id) {
        Optional<Users> existingUser = userRepository.findById(id);
        return existingUser.isPresent() ? new ResponseEntity<>(existingUser.get(), HttpStatus.FOUND) : ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = (List<Users>) userRepository.findAll();
        return users.size()!= 0 ? new ResponseEntity<>(users,HttpStatus.FOUND) : ResponseEntity.noContent().build();
    }
}
