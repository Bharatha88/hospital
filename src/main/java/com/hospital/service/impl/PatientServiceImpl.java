package com.hospital.service.impl;


import com.hospital.dao.PatientEntity;
import com.hospital.dto.Patient;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public abstract class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    //save patient
    public void registerPatient(Patient patient){
        PatientEntity entity = new PatientEntity();
        entity.setAppointmentNumber(patient.getAppointmentNumber());
        entity.setFirstName(patient.getFirstName());
        entity.setLastName(patient.getLastName());
        entity.setDob(patient.getDob());
        entity.setPhoneNumber(patient.getPhoneNumber());
        patientRepository.save(entity);

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
                         .appointmentNumber(patientDao.getAppointmentNumber())
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
}




