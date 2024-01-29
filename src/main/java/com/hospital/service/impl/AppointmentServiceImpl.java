package com.hospital.service.impl;


import com.hospital.dao.AppointmentEntity;
import com.hospital.dto.Appointment;
import com.hospital.repository.AppointmentRepository;
import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    //save Appointment
    public void createAppointment(Appointment appointment){
        AppointmentEntity model = new AppointmentEntity();
        model.setDoctorName(appointment.getDoctorName());
        model.setPatientName(appointment.getPatientName());
        model.setStatus(appointment.getStatus());
        model.setDateAndTime(appointment.getDateAndTime());
        appointmentRepository.save(model);

    }

    //retrieve all appointment
    public List<Appointment> retrieveAllAppointments(String doctorName, String patientName){
        Iterable<AppointmentEntity> appointments;
        if (doctorName != null){
            appointments = retrieveAppointmentByDoctorName(doctorName);
        } else if (patientName != null){
            appointments = retrieveAppointmentByPatientName(patientName);
        } else {
            appointments = appointmentRepository.findAll();
        }

        Iterator<AppointmentEntity>  iterator = appointments.iterator();

        List<Appointment> appointmentModelList = new ArrayList<>();

        while(iterator.hasNext()){
            AppointmentEntity appointmentDao = iterator.next();

            appointmentModelList.add(
                    Appointment.builder()
                            .id(appointmentDao.getId())
                            .doctorName(appointmentDao.getDoctorName())
                            .patientName(appointmentDao.getPatientName())
                            .status(appointmentDao.getStatus())
                            .dateAndTime(appointmentDao.getDateAndTime())
                            .build()

            );
        }
        return appointmentModelList;
    }

    //retrieve by firstname
    public Iterable<AppointmentEntity> retrieveAppointmentByDoctorName(String doctorName){
        return appointmentRepository.findAllByDoctorName(doctorName);
    }

    //retrieve by lastname
    public Iterable<AppointmentEntity> retrieveAppointmentByPatientName(String patientName){
        return appointmentRepository.findAllByPatientName(patientName);
    }

    //Delete Appointment
    public Boolean removeAppointment(Long appointmentId) {
        //using JPA
        Optional<AppointmentEntity> appointmentById = appointmentRepository.findById(appointmentId);
        if(appointmentById.isPresent()){
            appointmentRepository.deleteById(appointmentId);
            return true;
        }
        return false;
    }

}





