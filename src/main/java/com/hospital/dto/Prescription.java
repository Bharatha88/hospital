package com.hospital.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prescription {

    private Long id;
    private String prescriptionNumber;
    private String advice;
    private String medicine;
    private String remark;
}
