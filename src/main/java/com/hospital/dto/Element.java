package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Element {


    //Variables and data transfer objects
    private Long id;
    private String elementNumber;
    private String unitPrice;
    private String description;
    private String quantity;

}

