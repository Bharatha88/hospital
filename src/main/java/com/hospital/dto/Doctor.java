package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {


    //Variables and data transfer objects
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String experience;


}

