package com.hospital.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ElementEntity {

    //Create database with Mysql
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String elementNumber;
    private String unitPrice;
    private String description;
    private String quantity;
}
