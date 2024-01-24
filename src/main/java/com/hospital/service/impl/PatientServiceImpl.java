package com.hospital.service.impl;


import com.hospital.dao.PatientEntity;
import com.hospital.dto.Patient;
import com.hospital.repository.PatientNativeRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientNativeRepository patientNativeRepository;

    //save patient
    public void createPatient(Patient patient){
        PatientEntity model = new PatientEntity();
        model.setFirstName(patient.getFirstName());
        model.setLastName(patient.getLastName());
        model.setDob(patient.getDob());
        model.setPhoneNumber(patient.getPhoneNumber());
        patientRepository.save(model);

    }

    //retrieve all patient
    public List<Patient> retrieveAllPatients(){
         Iterable<PatientEntity> patientList = patientRepository.findAll();

         Iterator<PatientEntity>  iterator = patientList.iterator();

         List<Patient> patientModelList = new ArrayList<>();

         while(iterator.hasNext()){
             PatientEntity patientDao = iterator.next();

             patientModelList.add(
                     Patient.builder()
                             .id(patientDao.getId())
                             .firstName(patientDao.getFirstName())
                         .lastName(patientDao.getLastName())
                         .dob(patientDao.getDob())
                         .phoneNumber(patientDao.getPhoneNumber())
                         .build()

             );
         }
         return patientModelList;
    }

    //retrieve by firstname
    public Iterable<PatientEntity> retrievePatientByFirstName(String firstName){
        return patientRepository.findAllByFirstName(firstName);
    }

    //retrieve by lastname
    public Iterable<PatientEntity> retrievePatientByLastName(String lastName){
        return patientRepository.findAllByLastName(lastName);
    }

    public Boolean removePatient(Long patientId) {
        //using JPA
        Optional<PatientEntity> patientById = patientRepository.findById(patientId);
        if(patientById.isPresent()){
        patientRepository.deleteById(patientId);
         return true;
         }
        return false;
        }

        //using native method
        //return patientNativeRepository.removePatient(patientId);
    }





