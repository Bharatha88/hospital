package com.hospital.service.impl;


import com.hospital.dao.AdminEntity;
import com.hospital.dto.Admin;
import com.hospital.repository.AdminRepository;
import com.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;


    //save Admin
    public void createAdmin(Admin admin){
        AdminEntity model = new AdminEntity();
        model.setFirstName(admin.getFirstName());
        model.setLastName( admin.getLastName());
        model.setGender(admin.getGender());
        model.setAddress(admin.getAddress());
        adminRepository.save(model);

    }

    //retrieve all admin
    public List<Admin> retrieveAllAdmins(){
        Iterable<AdminEntity> adminList = adminRepository.findAll();

        Iterator<AdminEntity>  iterator = adminList.iterator();

        List<Admin> adminModelList = new ArrayList<>();

        while(iterator.hasNext()){
            AdminEntity adminDao = iterator.next();

            adminModelList.add(
                    Admin.builder()
                            .id(adminDao.getId())
                            .firstName(adminDao.getFirstName())
                            .lastName(adminDao.getLastName())
                            .gender(adminDao.getGender())
                            .address(adminDao.getAddress())
                            .build()
            );
        }
        return adminModelList;
    }

    //retrieve by firstname
    public Iterable<AdminEntity> retrieveAdminByFirstName(String firstName){
        return adminRepository.findAllByFirstName(firstName);
    }

    //retrieve by lastname
    public Iterable<AdminEntity> retrieveAdminByLastName(String lastName){
        return adminRepository.findAllByLastName(lastName);
    }

    //Delete Admin
    public Boolean removeAdmin(Long adminId) {
        //using JPA
        Optional<AdminEntity> adminById = adminRepository.findById(adminId);
        if(adminById.isPresent()){
            adminRepository.deleteById(adminId);
            return true;
        }
        return false;
    }

}





