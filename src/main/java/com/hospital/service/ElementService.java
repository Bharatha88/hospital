package com.hospital.service;

import com.hospital.dao.ElementEntity;
import com.hospital.dto.Element;

import java.util.List;

public interface ElementService {


    void createElement(Element element);

    List<Element> retrieveAllElements();

    Iterable<ElementEntity> retrieveElementByElementNumber(String elementNumber);

    Boolean removeElement(Long elementId);


}
