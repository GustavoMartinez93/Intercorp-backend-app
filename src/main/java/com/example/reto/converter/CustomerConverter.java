package com.example.reto.converter;

import com.example.reto.dto.CustomerDto;
import com.example.reto.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerConverter {

    public void entityToDto(CustomerEntity customerEntity, CustomerDto customerDto){
        customerDto.setLastname(customerEntity.getLastname());
        customerDto.setName(customerEntity.getName());
        customerDto.setDateOfBirth(null);
        customerDto.setYearOld(customerEntity.getYearOld());
    }

    public void dtoToEntity(CustomerDto customerDto, CustomerEntity customerEntity){
        customerEntity.setLastname(customerDto.getLastname());
        customerEntity.setName(customerDto.getName());
        customerEntity.setDateOfBirth(null);
        customerEntity.setYearOld(customerDto.getYearOld());
    }
    public double [] yearOldsToArrayDouble(List<CustomerEntity.YearOld> yearOldEntity){
        double[] vReturn = new double[yearOldEntity.size()];
        for (int i = 0; i < vReturn.length; i++){
            vReturn[i] = yearOldEntity.get(i).getYearOld().doubleValue();
        }
        return  vReturn;
    }
}
