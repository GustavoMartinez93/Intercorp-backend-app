package com.example.reto.controller.impl;

import com.example.reto.controller.CustomerController;
import com.example.reto.dto.CustomerDto;
import com.example.reto.dto.CustomerKpiDto;
import com.example.reto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultCustomerController implements CustomerController {

    private final CustomerService customerService;

    public DefaultCustomerController(@Autowired CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/creacliente")
    public CustomerDto create(CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    @GetMapping("/kpidecliente")
    public CustomerKpiDto kpi() {
        return this.customerService.kpi();
    }

    @GetMapping("/listclientes")
    public Iterable<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

}
