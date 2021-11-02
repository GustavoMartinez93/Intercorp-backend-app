package com.example.reto.repository;

import com.example.reto.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
    List<CustomerEntity.YearOld> findByYearOldIsNotNull();
}