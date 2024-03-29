package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.bill.BillRequestDTO;
import com.mycompany.billingservice.dto.bill.BillResponseDTO;

import java.util.List;

public interface BillService {

    public BillResponseDTO save(BillRequestDTO billRequestDTO);
    public List<BillResponseDTO> findAll();
    public BillResponseDTO findById(Integer id);
    public BillResponseDTO update (Integer id, BillRequestDTO billRequestDTO);
    public void delete(Integer id);
}
