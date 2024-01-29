package com.hospital.controller;

import com.hospital.dto.Specialization;
import com.hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/specialization")
public class SpecializationController {

    @Autowired
    SpecializationService service;

    //Create doctor from UI
    @PostMapping
    public void createSpecialization(@RequestBody Specialization specialization){
        service.createSpecialization(specialization);

    }
    //Get specialization from Database
    @GetMapping
    public List<Specialization> retrieveAllSpecializations(){
        return service.retrieveAllSpecializations();
    }


    //Delete doctor from DB
    @DeleteMapping("/{specializationId}")
    Map removeSpecialization(@PathVariable Long specializationId){
        Boolean response = service.removeSpecialization(specializationId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

