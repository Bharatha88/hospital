package com.hospital.controller;

import com.hospital.dto.Element;
import com.hospital.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/element")
public class ElementController {

    @Autowired
    ElementService service;

    //Create element from UI
    @PostMapping
    public void createElement(@RequestBody Element element){
        service.createElement(element);

    }
    //Get element from Database
    @GetMapping
    public List<Element> retrieveAllElements(@RequestParam(required = false) String elementNumber) {
        return service.retrieveAllElements(elementNumber);
    }

    //Delete element from DB
    @DeleteMapping("/{elementId}")
    Map removeElement(@PathVariable Long elementId){
        Boolean response = service.removeElement(elementId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

