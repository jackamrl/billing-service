package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;

import java.util.List;

public interface BillItemService {
    public BillItemResponseDTO save(BillItemRequestDTO billItemRequestDTO);
    public List<BillItemResponseDTO> findAll();
    public BillItemResponseDTO findById(Integer id);
    public BillItemResponseDTO update (Integer id, BillItemRequestDTO billItemRequestDTO);
    public void delete(Integer id);

}
