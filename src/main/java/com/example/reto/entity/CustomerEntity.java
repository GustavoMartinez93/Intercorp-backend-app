package com.example.reto.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String lastname;

    @Column( name = "year_old")
    private Integer yearOld;

    @Column( name = "date_of_birth")
    private LocalDate dateOfBirth;

    public interface YearOld{
        Integer getYearOld();
    }
}
