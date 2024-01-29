package com.hospital.service;


import com.hospital.dao.DoctorEntity;
import com.hospital.dto.Doctor;


import java.util.List;

public interface  DoctorService {


    void createDoctor(Doctor doctor);

    List<Doctor> retrieveAllDoctors(String firstName, String lastName);

    Iterable<DoctorEntity> retrieveDoctorByFirstName(String firstName);

    Iterable<DoctorEntity> retrieveDoctorByLastName(String lastName);

    Boolean removeDoctor(Long doctorId);


}
