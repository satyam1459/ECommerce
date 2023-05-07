package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.Order_Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<Order_Table, Integer> {
}
