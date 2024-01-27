package com.hospital.service;


import com.hospital.dto.Specialization;


import java.util.List;

public interface  SpecializationService {


    void createSpecialization(Specialization specialization);

    List<Specialization> retrieveAllSpecializations();


    Boolean removeSpecialization(Long specializationId);


}
