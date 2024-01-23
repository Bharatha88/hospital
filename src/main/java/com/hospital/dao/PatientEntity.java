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

public class PatientEntity {

    //Create database with Mysql
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String appointmentNumber;
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;
}
