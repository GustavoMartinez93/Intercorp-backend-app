package com.example.reto.controller;

import com.example.reto.dto.CustomerDto;
import com.example.reto.dto.CustomerKpiDto;

public interface CustomerController {
    CustomerDto create(CustomerDto customerDto);
    CustomerKpiDto kpi();
    Iterable<CustomerDto> findAll();
}
