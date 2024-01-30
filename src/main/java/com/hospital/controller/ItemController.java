package com.hospital.controller;

import com.hospital.dto.Element;
import com.hospital.dto.Item;
import com.hospital.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService service;

    //Create Item from UI
    @PostMapping
    public void createItem(@RequestBody Item item){
        service.createItem(item);

    }
    //GetItem from Database
    @GetMapping
    public List<Item> retrieveAllItems(@RequestParam(required = false) String code, @RequestParam(required = false) String name){
        return service.retrieveAllItems(code, name);
    }

    //Delete Appointment from DB
    @DeleteMapping("/{itemId}")
    Map removeItem(@PathVariable Long itemId){
        Boolean response = service.removeItem(itemId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

    //Update item
    @PutMapping("/{itemId}")
    public ResponseEntity<Map<String, String>> updateItem(
            @PathVariable Long itemId,
            @RequestBody Item updatedItem) {

        boolean success = service.updateItem(itemId, updatedItem);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("status", "Record updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("status", "Item not found"));
        }
    }

}

