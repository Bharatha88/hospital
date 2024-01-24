package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {


    //Variables and data transfer objects
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;

    //FirstName Validation(Avoid null and space)
    public void setFirstName(String firstName){
        if(firstName == null) return;
        if("".equalsIgnoreCase(firstName)) return;
        this.firstName = firstName;
    }

    //LastName Validation(Avoid null and space)
    public void setLastName(String lastName){
        if (lastName == null) return;
        if ("".equalsIgnoreCase(lastName)) return;
        this.lastName = lastName;
    }
}

