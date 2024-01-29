package com.hospital.controller;

import com.hospital.dto.Bill;
import com.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService service;

    //Create Bill from UI
    @PostMapping
    public void createBill(@RequestBody Bill bill){
        service.createBill(bill);

    }
    //Get bill from database
    @GetMapping
    public List<Bill> retrieveAllBills(@RequestParam(required = false) String billNumber) {
        return service.retrieveAllBills(billNumber);
    }

    //Delete bill from DB
    @DeleteMapping("/{billId}")
    Map removeBill(@PathVariable Long billId){
        Boolean response = service.removeBill(billId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

