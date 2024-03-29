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
    public List<Element> retrieveAllElements(String elementNumber){
        Iterable<ElementEntity> elements;
        if (elementNumber != null){
            elements = retrieveElementByElementNumber(elementNumber);
        } else{
            elements = elementRepository.findAll();
        }

        Iterator<ElementEntity> iterator = elements.iterator();


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

    //Update element
    public boolean updateElement(Long elementId, Element updatedElement) {
        Optional<ElementEntity> elementOptional = elementRepository.findById(elementId);

        if (elementOptional.isPresent()) {
            ElementEntity existingElement = elementOptional.get();

            // Update the existing element with the new information
            existingElement.setElementNumber(updatedElement.getElementNumber());
            existingElement.setUnitPrice(updatedElement.getUnitPrice());
            existingElement.setDescription(updatedElement.getDescription());
            existingElement.setQuantity(updatedElement.getQuantity());

            // Save the updated element back to the repository
            elementRepository.save(existingElement);

            return true;
        }

        // Patient with the given ID not found
        return false;
    }

}





