package com.hospital.service;

import com.hospital.dao.BillEntity;
import com.hospital.dto.Bill;

import java.util.List;

public interface BillService {


    void createBill(Bill bill);

    List<Bill> retrieveAllBills(String billNumber);

    Iterable<BillEntity> retrieveBillByBillNumber(String billNumber);


    Boolean removeBill(Long billId);


}
