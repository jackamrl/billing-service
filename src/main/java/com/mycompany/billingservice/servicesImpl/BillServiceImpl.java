package com.mycompany.billingservice.servicesImpl;

import com.mycompany.billingservice.dto.bill.BillRequestDTO;
import com.mycompany.billingservice.dto.bill.BillResponseDTO;
import com.mycompany.billingservice.entities.Bill;
import com.mycompany.billingservice.mappers.BillMapper;
import com.mycompany.billingservice.repositories.BillRepository;
import com.mycompany.billingservice.services.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;


    private BillMapper billMapper;

    public BillServiceImpl(BillRepository billRepository,BillMapper billMapper) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }


    @Override
    public BillResponseDTO addBill(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.fromBillRequestDTOToBill(billRequestDTO);
        Bill saveBill = billRepository.save(bill);

        BillResponseDTO billResponseDTO = billMapper.fromBillToBillResponseDTO(bill);

        return billResponseDTO;
    }

}


