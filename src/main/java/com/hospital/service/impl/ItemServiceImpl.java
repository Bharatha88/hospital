package com.hospital.service.impl;


import com.hospital.dao.ItemEntity;
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
    public List<Item> retrieveAllItems(){
        Iterable<ItemEntity> itemList = itemRepository.findAll();

        Iterator<ItemEntity>  iterator = itemList.iterator();

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

}





