package com.example.reto.service;

import com.example.reto.dto.CustomerDto;
import com.example.reto.dto.CustomerKpiDto;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);
    CustomerKpiDto kpi();
    Iterable<CustomerDto> findAll();
}
