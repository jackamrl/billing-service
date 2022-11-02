package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.BillRequestDTO;
import com.mycompany.billingservice.dto.BillResponseDTO;
import com.mycompany.billingservice.entities.Bill;

public interface BillService {

    public BillResponseDTO addBill(BillRequestDTO billRequestDTO) ;
}
