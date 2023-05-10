package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IAddressRepository extends CrudRepository<Address,Long> {

    Optional<Address> findByAddressId(Long addressID);
}
