package com.mycompany.billingservice.mappers;

import com.mycompany.billingservice.dto.BillRequestDTO;
import com.mycompany.billingservice.dto.BillResponseDTO;
import com.mycompany.billingservice.entities.Bill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

//My mapper class
// we use Model Mapper

@Component
public class BillMapper {

    private ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BillResponseDTO fromBill(Bill bill){
        BillResponseDTO billResponseDTO = new BillResponseDTO();
        BeanUtils.copyProperties(bill, billResponseDTO);

        return billResponseDTO;

    }
    //convert bill to responseDTO
    public BillResponseDTO fromBillToBillResponseDTO(Bill bill){
        BillResponseDTO billResponseDTO = this.modelMapper.map(bill,BillResponseDTO.class);

        return billResponseDTO;
    }
    //convert bill to requestDTO
    public BillRequestDTO fromBillToBillRequestDTO(Bill bill){
        BillRequestDTO billRequestDTO = this.modelMapper.map(bill,BillRequestDTO.class);

        return billRequestDTO;
    }
    //convert requestDTO to bill
    public Bill fromBillRequestDTOToBill(BillRequestDTO billRequestDTO){
        Bill bill = this.modelMapper.map(billRequestDTO,Bill.class);

        return bill;
    }

}
