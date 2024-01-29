package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {


    //Variables and data transfer objects
    private Long id;
    private String appointmentNumber;
    private String doctorName;
    private String patientName;
    private String status;
    private String dateAndTime;


}

