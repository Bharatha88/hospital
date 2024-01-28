package com.hospital.service.impl;


import com.hospital.dao.ElementEntity;
import com.hospital.dto.Element;
import com.hospital.repository.ElementRepository;
import com.hospital.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class ElementServiceImpl implements ElementService {

    @Autowired
    ElementRepository elementRepository;


    //save element
    public void createElement(Element element){
        ElementEntity model = new ElementEntity();
        model.setElementNumber(element.getElementNumber());
        model.setUnitPrice( element.getUnitPrice());
        model.setDescription(element.getDescription());
        model.setQuantity(element.getQuantity());
        elementRepository.save(model);

    }

    //retrieve all element
    public List<Element> retrieveAllElements(){
        Iterable<ElementEntity> elementList = elementRepository.findAll();

        Iterator<ElementEntity>  iterator = elementList.iterator();

        List<Element> elementModelList = new ArrayList<>();

        while(iterator.hasNext()){
            ElementEntity elementDao = iterator.next();

            elementModelList.add(
                    Element.builder()
                            .id(elementDao.getId())
                            .elementNumber(elementDao.getElementNumber())
                            .unitPrice(elementDao.getUnitPrice())
                            .description(elementDao.getDescription())
                            .quantity(elementDao.getQuantity())
                            .build()
            );
        }
        return elementModelList;
    }

    //retrieve by elementNumber
    public Iterable<ElementEntity> retrieveElementByElementNumber(String elementNumber){
        return elementRepository.findAllByElementNumber(elementNumber);
    }

    //Delete Admin
    public Boolean removeElement(Long elementId) {
        //using JPA
        Optional<ElementEntity> elementById = elementRepository.findById(elementId);
        if(elementById.isPresent()){
            elementRepository.deleteById(elementId);
            return true;
        }
        return false;
    }

}





