package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;

public interface BillItemService {
    public BillItemResponseDTO addBillItem(BillItemRequestDTO billItemRequestDTO);
}
