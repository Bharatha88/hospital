package com.hospital.controller;

import com.hospital.dao.AdminEntity;
import com.hospital.dto.Admin;
import com.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

    //Create Admin from UI
    @PostMapping
    public void createAdmin(@RequestBody Admin admin){
        service.createAdmin(admin);

    }
    //GetAdmin from Database
    @GetMapping
    public List<Admin> retrieveAllAdmins(){
        return service.retrieveAllAdmins();
    }

    //Get Admin data using first name - path variable
    @GetMapping("/{firstName}")
    public Iterable<AdminEntity> retrieveAdminsFirstName(
            @PathVariable String firstName){
        return service.retrieveAdminByFirstName(firstName);
    }

    //Get Admin using last name - path variable
    @GetMapping("/{lastName}")
    public Iterable<AdminEntity> retrieveAdminsLastName(
            @PathVariable String lastName){
        return service.retrieveAdminByLastName(lastName);
    }

    //Delete Admin from DB
    @DeleteMapping("/{adminId}")
    Map removeAdmin(@PathVariable Long adminId){
        Boolean response = service.removeAdmin(adminId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

