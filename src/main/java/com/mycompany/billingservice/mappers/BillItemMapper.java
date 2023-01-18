package com.mycompany.billingservice.mappers;

import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;
import com.mycompany.billingservice.entities.Bill;
import com.mycompany.billingservice.entities.BillItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//My mapper class
// we use Model Mapper
@Component
public class BillItemMapper {

    private ModelMapper modelMapper;

    public BillItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convert billItemRequest to billItem
    public BillItem fromBillItemRequestDTOToBillItem(BillItemRequestDTO billRequestDTO){
        BillItem billItem  = this.modelMapper.map(billRequestDTO,BillItem.class);

        return billItem;
    }

    //convert billitem to billItemResponse
    public BillItemResponseDTO fromBillItemToBillItemResponseDTO(BillItem billItem){
        BillItemResponseDTO billItemResponseDTO = this.modelMapper.map(billItem, BillItemResponseDTO.class);

        return billItemResponseDTO;
    }
}
