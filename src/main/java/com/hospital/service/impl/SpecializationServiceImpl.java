package com.hospital.service.impl;



import com.hospital.dao.SpecializationEntity;
import com.hospital.dto.Specialization;
import com.hospital.repository.SpecializationRepository;
import com.hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    SpecializationRepository specializationRepository;


    //save Appointment
    public void createSpecialization(Specialization specialization){
        SpecializationEntity model = new SpecializationEntity();
        model.setSpecializationSection(specialization.getSpecializationSection());
        specializationRepository.save(model);

    }

    //retrieve all appointment
    public List<Specialization> retrieveAllSpecializations(){
        Iterable<SpecializationEntity> specializationList = specializationRepository.findAll();

        Iterator<SpecializationEntity>  iterator = specializationList.iterator();

        List<Specialization> specializationModelList = new ArrayList<>();

        while(iterator.hasNext()){
            SpecializationEntity specializationDao = iterator.next();

            specializationModelList.add(
                    Specialization.builder()
                            .id(specializationDao.getId())
                            .specializationSection(specializationDao.getSpecializationSection())
                            .build()

            );
        }
        return specializationModelList;
    }

    //Delete Appointment
    public Boolean removeSpecialization(Long specializationId) {
        //using JPA
        Optional<SpecializationEntity> specializationById = specializationRepository.findById(specializationId);
        if(specializationById.isPresent()){
            specializationRepository.deleteById(specializationId);
            return true;
        }
        return false;
    }

}





