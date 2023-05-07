package com.geekster.ECommerce.repository;

import com.geekster.ECommerce.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Users,Long> {
}
