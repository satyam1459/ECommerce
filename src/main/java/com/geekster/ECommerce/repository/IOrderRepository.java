package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.OrderTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<OrderTable, Integer> {
}
