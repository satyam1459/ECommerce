package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends CrudRepository<Product,Long> {

    @Query(value = "Select * from Product where category =:category",nativeQuery = true)
    List<Product> findByCategory(String category);

    Optional<Product> findByProductId(Long productId);
}
