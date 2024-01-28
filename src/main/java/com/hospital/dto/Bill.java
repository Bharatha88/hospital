package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill {


    //Variables and data transfer objects
    private Long id;
    private String billNumber;
    private String amount;
    private String date;

}

