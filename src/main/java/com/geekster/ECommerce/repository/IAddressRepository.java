package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address,Integer> {
}
