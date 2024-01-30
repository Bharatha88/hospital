package com.hospital.controller;

import com.hospital.dto.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Doctor> retrieveAllDoctors(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return service.retrieveAllDoctors(firstName, lastName);
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

    //Update doctor
    @PutMapping("/{doctorId}")
    public ResponseEntity<Map<String, String>> updateDoctor(
            @PathVariable Long doctorId,
            @RequestBody Doctor updatedDoctor) {

        boolean success = service.updateDoctor(doctorId, updatedDoctor);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("status", "Record updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("status", "Bill not found"));
        }
    }

}

