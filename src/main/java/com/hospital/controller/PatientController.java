package com.hospital.controller;

import com.hospital.dao.PatientEntity;
import com.hospital.service.PatientService;
import com.hospital.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    //Create patient from UI
    @PostMapping
    public void createPatient(@RequestBody Patient patient){
        patientService.createPatient(patient);

    }
    //GetPatients from Database
    @GetMapping
    public List<Patient> retrieveAllPatients(){
        return patientService.retrieveAllPatients();
    }

    //GetPatient data using first name - path variable
    @GetMapping("/{firstName}")
    public Iterable<PatientEntity> retrievePatientFirstName(
            @PathVariable String firstName){
        return patientService.retrievePatientByFirstName(firstName);
    }

    //GetPatient data using last name - path variable
    @GetMapping("/{lastName}")
    public Iterable<PatientEntity> retrievePatientLastName(
            @PathVariable String lastName){
        return patientService.retrievePatientByLastName(lastName);
    }

}

