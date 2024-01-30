package com.hospital.service;

import com.hospital.dao.ElementEntity;
import com.hospital.dto.Doctor;
import com.hospital.dto.Element;

import java.util.List;

public interface ElementService {


    void createElement(Element element);

    List<Element> retrieveAllElements(String elementNumber);

    Iterable<ElementEntity> retrieveElementByElementNumber(String elementNumber);

    Boolean removeElement(Long elementId);

    boolean updateElement(Long elementId, Element updatedElement);


}
