package com.hospital.controller;

import com.hospital.dao.ItemEntity;
import com.hospital.dto.Item;
import com.hospital.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Item> retrieveAllItems(){
        return service.retrieveAllItems();
    }

    //GetItem data using code - path variable
    @GetMapping("/{code}")
    public Iterable<ItemEntity> retrieveItemsCode(
            @PathVariable String code){
        return service.retrieveItemByCode(code);
    }

    //GetItem from data using  name - path variable
    @GetMapping("/{name}")
    public Iterable<ItemEntity> retrieveItemsName(
            @PathVariable String  Name){
        return service.retrieveItemByName(Name);
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

}

