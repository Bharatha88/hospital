package com.hospital.service.impl;


import com.hospital.dao.ElementEntity;
import com.hospital.dao.ItemEntity;
import com.hospital.dto.Element;
import com.hospital.dto.Item;
import com.hospital.repository.ItemRepository;
import com.hospital.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    //save Item
    public void createItem(Item item){
        ItemEntity model = new ItemEntity();
        model.setCode(item.getCode());
        model.setName(item.getName());
        model.setDescription(item.getDescription());
        model.setDirection(item.getDirection());
        itemRepository.save(model);

    }

    //retrieve all item
    public List<Item> retrieveAllItems(String code, String name){
        Iterable<ItemEntity> items;
        if (code != null){
            items = retrieveItemByCode(code);
        } else if (name != null){
            items = retrieveItemByName(name);
        } else {
            items = itemRepository.findAll();
        }

        Iterator<ItemEntity>  iterator = items.iterator();

        List<Item> itemModelList = new ArrayList<>();

        while(iterator.hasNext()){
            ItemEntity itemDao = iterator.next();

            itemModelList.add(
                    Item.builder()
                            .id(itemDao.getId())
                            .code(itemDao.getCode())
                            .name(itemDao.getName())
                            .description(itemDao.getDescription())
                            .direction(itemDao.getDirection())
                            .build()

            );
        }
        return itemModelList;
    }

    //retrieve by code
    public Iterable<ItemEntity> retrieveItemByCode(String code){
        return itemRepository.findAllByCode(code);
    }

    //retrieve by name
    public Iterable<ItemEntity> retrieveItemByName(String  Name){
        return itemRepository.findAllByName(Name);
    }

    //Delete Item
    public Boolean removeItem(Long itemId) {
        //using JPA
        Optional<ItemEntity> itemById = itemRepository.findById(itemId);
        if(itemById.isPresent()){
            itemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }

    //Update item
    public boolean updateItem(Long itemId, Item updatedItem) {
        Optional<ItemEntity> itemOptional = itemRepository.findById(itemId);

        if (itemOptional.isPresent()) {
            ItemEntity existingItem = itemOptional.get();

            // Update the existing item with the new information
            existingItem.setCode(updatedItem.getCode());
            existingItem.setName(updatedItem.getName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setDirection(updatedItem.getDirection());

            // Save the updated item back to the repository
            itemRepository.save(existingItem);

            return true;
        }

        // Patient with the given ID not found
        return false;
    }

}





