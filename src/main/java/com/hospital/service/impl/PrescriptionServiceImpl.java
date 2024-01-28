package com.hospital.service.impl;



import com.hospital.dao.PrescriptionEntity;
import com.hospital.dto.Prescription;
import com.hospital.repository.PrescriptionRepository;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class  PrescriptionServiceImpl  implements PrescriptionService  {

    @Autowired
    PrescriptionRepository prescriptionRepository;


    //save Prescription
    public void createPrescription(Prescription prescription){
        PrescriptionEntity model = new PrescriptionEntity();
        model.setPrescriptionNumber(prescription.getPrescriptionNumber());
        model.setAdvice(prescription.getAdvice());
        model.setMedicine(prescription.getMedicine());
        model.setRemark(prescription.getRemark());
        prescriptionRepository.save(model);

    }

    //retrieve all appointment
    public List<Prescription> retrieveAllPrescriptions(){
        Iterable<PrescriptionEntity> prescriptionList = prescriptionRepository.findAll();

        Iterator<PrescriptionEntity>  iterator = prescriptionList.iterator();

        List<Prescription> prescriptionModelList = new ArrayList<>();

        while(iterator.hasNext()){
            PrescriptionEntity prescriptionDao = iterator.next();

            prescriptionModelList.add(
                    Prescription.builder()
                            .id(prescriptionDao.getId())
                            .prescriptionNumber(prescriptionDao.getPrescriptionNumber())
                            .advice(prescriptionDao.getAdvice())
                            .medicine(prescriptionDao.getMedicine())
                            .remark(prescriptionDao.getRemark())
                            .build()

            );
        }
        return prescriptionModelList;
    }

    //retrieve by prescription number
    public Iterable<PrescriptionEntity> retrievePrescriptionByPrescriptionNumber(String prescriptionNumber){
        return prescriptionRepository.findAllByPrescriptionNumber(prescriptionNumber);
    }

    //Delete Prescription
    public Boolean removePrescription(Long prescriptionId) {
        //using JPA
        Optional<PrescriptionEntity> prescriptionById = prescriptionRepository.findById(prescriptionId);
        if(prescriptionById.isPresent()){
            prescriptionRepository.deleteById(prescriptionId);
            return true;
        }
        return false;
    }

}





