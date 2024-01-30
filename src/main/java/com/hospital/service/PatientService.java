package com.hospital.service;

import com.hospital.dao.PatientEntity;
import com.hospital.dto.Patient;


import java.util.List;

public interface PatientService {


    void createPatient(Patient patient);

    List<Patient> retrieveAllPatients(String firstName, String lastName);

    Iterable<PatientEntity> retrievePatientByFirstName(String firstName);

    Iterable<PatientEntity> retrievePatientByLastName(String lastName);

    Boolean removePatient(Long patientId);

    boolean updatePatient(Long patientId, Patient updatedPatient);


}
