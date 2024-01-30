package com.hospital.controller;


import com.hospital.dto.Prescription;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Prescription> retrieveAllPrescriptions(@RequestParam(required = false) String prescriptionNumber) {
        return service.retrieveAllPrescriptions(prescriptionNumber);
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

    //Update prescription
    @PutMapping("/{prescriptionId}")
    public ResponseEntity<Map<String, String>> updatePrescription(
            @PathVariable Long prescriptionId,
            @RequestBody Prescription updatedPrescription) {

        boolean success = service.updatePrescription(prescriptionId, updatedPrescription);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("status", "Record updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("status", "Prescription not found"));
        }
    }

}

