package com.hospital.service.impl;



import com.hospital.dao.DoctorEntity;
import com.hospital.dto.Doctor;
import com.hospital.repository.DoctorRepository;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    //save doctor
    public void createDoctor(Doctor doctor){
        DoctorEntity model = new DoctorEntity();
        model.setFirstName(doctor.getFirstName());
        model.setLastName(doctor.getLastName());
        model.setAge(doctor.getAge());
        model.setExperience(doctor.getExperience());
        doctorRepository.save(model);

    }

    //retrieve all doctors
    public List<Doctor> retrieveAllDoctors(String firstName, String lastName){
        Iterable<DoctorEntity> doctors;
        if (firstName != null){
            doctors = retrieveDoctorByFirstName(firstName);
        } else if (lastName != null){
            doctors = retrieveDoctorByLastName(lastName);
        } else {
            doctors = doctorRepository.findAll();
        }

        Iterator<DoctorEntity>  iterator = doctors.iterator();

        List<Doctor> doctorModelList = new ArrayList<>();

        while(iterator.hasNext()){
            DoctorEntity doctorDao = iterator.next();

            doctorModelList.add(
                    Doctor.builder()
                            .id(doctorDao.getId())
                            .firstName(doctorDao.getFirstName())
                            .lastName(doctorDao.getLastName())
                            .age(doctorDao.getAge())
                            .experience(doctorDao.getExperience())
                            .build()

            );
        }
        return doctorModelList;
    }

    //retrieve by firstname
    public Iterable<DoctorEntity> retrieveDoctorByFirstName(String firstName){
        return doctorRepository.findAllByFirstName(firstName);
    }

    //retrieve by lastname
    public Iterable<DoctorEntity> retrieveDoctorByLastName(String lastName){
        return doctorRepository.findAllByLastName(lastName);
    }

    //Delete Doctors from DB
    public Boolean removeDoctor(Long doctorId) {
        //using JPA
        Optional<DoctorEntity> doctorById = doctorRepository.findById(doctorId);
        if(doctorById.isPresent()){
            doctorRepository.deleteById(doctorId);
            return true;
        }
        return false;
    }

    //Update doctor
    public boolean updateDoctor(Long doctorId, Doctor updatedDoctor) {
        Optional<DoctorEntity> doctorOptional = doctorRepository.findById(doctorId);

        if (doctorOptional.isPresent()) {
            DoctorEntity existingDoctor = doctorOptional.get();

            // Update the existing doctor with the new information
            existingDoctor.setFirstName(updatedDoctor.getFirstName());
            existingDoctor.setLastName(updatedDoctor.getLastName());
            existingDoctor.setAge(updatedDoctor.getAge());
            existingDoctor.setExperience(updatedDoctor.getExperience());

            // Save the updated doctor back to the repository
            doctorRepository.save(existingDoctor);

            return true;
        }

        // Patient with the given ID not found
        return false;
    }


}





