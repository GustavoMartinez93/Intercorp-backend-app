package com.example.reto.service.impl;

import com.example.reto.converter.CustomerConverter;
import com.example.reto.dto.CustomerDto;
import com.example.reto.dto.CustomerKpiDto;
import com.example.reto.entity.CustomerEntity;
import com.example.reto.repository.CustomerRepository;
import com.example.reto.service.CustomerService;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerConverter customerConverter;

    public DefaultCustomerService(@Autowired CustomerRepository customerRepository, @Autowired CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        CustomerDto vReturn = new CustomerDto();
        CustomerEntity customerEntity = new CustomerEntity();
        this.customerConverter.dtoToEntity(customerDto, customerEntity);
        customerEntity = this.customerRepository.save(customerEntity);
        this.customerConverter.entityToDto(customerEntity,vReturn);
        return vReturn;
    }

    @Override
    public CustomerKpiDto kpi() {
        CustomerKpiDto vReturn = new CustomerKpiDto();
        double [] yearsOld = this.customerConverter.yearOldsToArrayDouble(this.customerRepository.findByYearOldIsNotNull());
        double average = (int) Arrays.stream(yearsOld).average().getAsDouble();
        StandardDeviation sd = new StandardDeviation(false);
        double standardDeviation = sd.evaluate(yearsOld);

        vReturn.setAverageAge(average);
        vReturn.setStandardDeviation(standardDeviation);
        return vReturn;
    }

    @Override
    public Iterable<CustomerDto> findAll() {
        List<CustomerDto> vReturn = new ArrayList<>();
        Iterable<CustomerEntity> listAll = this.customerRepository.findAll();
        listAll.forEach(customerEntity -> {
            CustomerDto customerDto = new CustomerDto();
            this.customerConverter.entityToDto(customerEntity,customerDto);
            vReturn.add(customerDto);
        });
        return vReturn;
    }

}
