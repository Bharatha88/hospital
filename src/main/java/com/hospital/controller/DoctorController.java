package com.hospital.controller;

;
import com.hospital.dao.DoctorEntity;
import com.hospital.dto.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService service;

    //Create doctor from UI
    @PostMapping
    public void createDoctor(@RequestBody Doctor doctor){
        service.createDoctor(doctor);

    }
    //Getdoctor from Database
    @GetMapping
    public List<Doctor> retrieveAllDoctors(){
        return service.retrieveAllDoctors();
    }

    //GetDoctor data using first name - path variable
    @GetMapping("/{firstName}")
    public Iterable<DoctorEntity> retrieveDoctorFirstName(
            @PathVariable String firstName){
        return service.retrieveDoctorByFirstName(firstName);
    }

    //GetDoctor data using last name - path variable
    @GetMapping("/{lastName}")
    public Iterable<DoctorEntity> retrieveDoctorLastName(
            @PathVariable String lastName){
        return service.retrieveDoctorByLastName(lastName);
    }

    //Delete doctor from DB
    @DeleteMapping("/{doctorId}")
    Map removeDoctor(@PathVariable Long doctorId){
        Boolean response = service.removeDoctor(doctorId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

