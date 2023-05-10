package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Address;
import com.geekster.ECommerce.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;


    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public ResponseEntity<Address> getAddressById(Long id) {
            Optional<Address> myAddress = addressRepository.findById(id);
            if(myAddress.isPresent()){
                return new ResponseEntity<Address>(myAddress.get(), HttpStatus.FOUND);
            }else{
                return ResponseEntity.notFound().build();
            }
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }
}
