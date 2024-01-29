package com.hospital.service;

import com.hospital.dao.AdminEntity;
import com.hospital.dto.Admin;


import java.util.List;

public interface AdminService {


    void createAdmin(Admin admin);

    List<Admin> retrieveAllAdmins(String firstName, String lastName);

    Iterable<AdminEntity> retrieveAdminByFirstName(String firstName);

    Iterable<AdminEntity> retrieveAdminByLastName(String lastName);

    Boolean removeAdmin(Long adminId);


}
