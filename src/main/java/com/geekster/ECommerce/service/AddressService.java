package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Address;
import com.geekster.ECommerce.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Address> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }
}
