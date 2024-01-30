package com.hospital.service.impl;


import com.hospital.dao.PatientEntity;
import com.hospital.dto.Patient;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public  class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;


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
    public List<Patient> retrieveAllPatients(String firstName, String lastName){
        Iterable<PatientEntity> patients;
        if (firstName != null){
            patients = retrievePatientByFirstName(firstName);
        } else if (lastName != null){
            patients = retrievePatientByLastName(lastName);
        } else {
             patients = patientRepository.findAll();
        }

         Iterator<PatientEntity>  iterator = patients.iterator();

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

    //Delete patient
    public Boolean removePatient(Long patientId) {
        //using JPA
        Optional<PatientEntity> patientById = patientRepository.findById(patientId);
        if(patientById.isPresent()){
        patientRepository.deleteById(patientId);
         return true;
         }
        return false;
        }

        //Update patient
    public boolean updatePatient(Long patientId, Patient updatedPatient) {
        Optional<PatientEntity> patientOptional = patientRepository.findById(patientId);

        if (patientOptional.isPresent()) {
            PatientEntity existingPatient = patientOptional.get();

            // Update the existing patient with the new information
            existingPatient.setFirstName(updatedPatient.getFirstName());
            existingPatient.setLastName(updatedPatient.getLastName());
            existingPatient.setDob(updatedPatient.getDob());
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());

            // Save the updated patient back to the repository
            patientRepository.save(existingPatient);

            return true;
        }

        // Patient with the given ID not found
        return false;
    }
}






