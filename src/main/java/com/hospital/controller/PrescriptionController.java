package com.hospital.controller;


import com.hospital.dao.PrescriptionEntity;
import com.hospital.dto.Prescription;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService service;

    //Create Prescription from UI
    @PostMapping
    public void createPrescription(@RequestBody Prescription prescription){
        service.createPrescription(prescription);

    }
    //GetPrescription from Database
    @GetMapping
    public List<Prescription> retrieveAllPrescriptions(){
        return service.retrieveAllPrescriptions();
    }
    //GetPrescription data using description number - path variable
    @GetMapping("/{descriptionNumber}")
    public Iterable<PrescriptionEntity> retrievePrescriptionDescriptionNumber(
            @PathVariable String descriptionNumber){
        return service.retrievePrescriptionByPrescriptionNumber(descriptionNumber);
    }

    //Delete Prescription from DB
    @DeleteMapping("/{prescriptionId}")
    Map removePrescription(@PathVariable Long prescriptionId){
        Boolean response = service.removePrescription(prescriptionId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

