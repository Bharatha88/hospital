package com.hospital.service;

import com.hospital.dao.AppointmentEntity;
import com.hospital.dto.Appointment;



import java.util.List;

public interface  AppointmentService {


    void createAppointment(Appointment appointment);

    List<Appointment> retrieveAllAppointments();

    Iterable<AppointmentEntity> retrieveAppointmentByDoctorName(String doctorName);

    Iterable<AppointmentEntity> retrieveAppointmentByPatientName(String patientName);

    Boolean removeAppointment(Long appointmentId);


}
