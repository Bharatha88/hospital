package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {


    //Variables and data transfer objects
    private Long id;
    private String reviewNumber;
    private String rating;
    private String comment;

}

