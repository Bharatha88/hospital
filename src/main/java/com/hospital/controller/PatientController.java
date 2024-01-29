package com.hospital.controller;

import com.hospital.dao.PatientEntity;
import com.hospital.service.PatientService;
import com.hospital.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService service;

    //Create patient from UI
    @PostMapping
    public void createPatient(@RequestBody Patient patient){
        service.createPatient(patient);

    }

    //GetPatients from Database
    @GetMapping
    public List<Patient> retrieveAllPatients(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return service.retrieveAllPatients(firstName, lastName);
    }

    @DeleteMapping("/{patientId}")
    Map removePatient(@PathVariable Long patientId){
        Boolean response = service.removePatient(patientId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","patient not found");
    }

}

