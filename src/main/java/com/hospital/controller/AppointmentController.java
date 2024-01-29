package com.hospital.controller;

import com.hospital.dao.AppointmentEntity;
import com.hospital.dto.Appointment;
import com.hospital.dto.Patient;
import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    //Create patient from UI
    @PostMapping
    public void createAppointment(@RequestBody Appointment appointment){
        service.createAppointment(appointment);

    }
    //GetPatients from Database
    @GetMapping
    public List<Appointment> retrieveAllAppointments(@RequestParam(required = false) String doctorName, @RequestParam(required = false) String patientName){
        return service.retrieveAllAppointments(doctorName, patientName);
    }

    //GetPatient data using first name - path variable
    @GetMapping("/{doctorName}")
    public Iterable<AppointmentEntity> retrieveAppointmentsDoctorName(
            @PathVariable String doctorName){
        return service.retrieveAppointmentByDoctorName(doctorName);
    }

    //GetPatient data using last name - path variable
    @GetMapping("/{patientName}")
    public Iterable<AppointmentEntity> retrieveAppointmentsPatientName(
            @PathVariable String patientName){
        return service.retrieveAppointmentByPatientName(patientName);
    }

    @DeleteMapping("/{appointmentId}")
    Map removeAppointment(@PathVariable Long appointmentId){
        Boolean response = service.removeAppointment(appointmentId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

