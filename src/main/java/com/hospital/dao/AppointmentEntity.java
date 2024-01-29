package com.hospital.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AppointmentEntity {

    //Create database with Mysql
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String appointmentNumber;
    private String doctorName;
    private String patientName;
    private String status;
    private String dateAndTime;
}
