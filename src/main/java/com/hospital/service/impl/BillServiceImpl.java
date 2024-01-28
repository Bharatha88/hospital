package com.hospital.service.impl;


import com.hospital.dao.BillEntity;
import com.hospital.dto.Bill;
import com.hospital.repository.BillRepository;
import com.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;


    //save bill
    public void createBill(Bill bill){
        BillEntity model = new BillEntity();
        model.setBillNumber(bill.getBillNumber());
        model.setAmount( bill.getAmount());
        model.setDate(bill.getDate());
        billRepository.save(model);

    }

    //retrieve all bill
    public List<Bill> retrieveAllBills(){
        Iterable<BillEntity> billList = billRepository.findAll();

        Iterator<BillEntity>  iterator = billList.iterator();

        List<Bill> billModelList = new ArrayList<>();

        while(iterator.hasNext()){
            BillEntity billDao = iterator.next();

            billModelList.add(
                    Bill.builder()
                            .id(billDao.getId())
                            .billNumber(billDao.getBillNumber())
                            .amount(billDao.getAmount())
                            .date(billDao.getDate())
                            .build()
            );
        }
        return billModelList;
    }

    //retrieve by billNumber
    public Iterable<BillEntity> retrieveBillByBillNumber(String billNumber){
        return billRepository.findAllByBillNumber(billNumber);
    }

    //Delete Admin
    public Boolean removeBill(Long billId) {
        //using JPA
        Optional<BillEntity> billById = billRepository.findById(billId);
        if(billById.isPresent()){
            billRepository.deleteById(billId);
            return true;
        }
        return false;
    }

}





