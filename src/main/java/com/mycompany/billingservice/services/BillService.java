package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.bill.BillRequestDTO;
import com.mycompany.billingservice.dto.bill.BillResponseDTO;

public interface BillService {

    public BillResponseDTO addBill(BillRequestDTO billRequestDTO) ;
}
