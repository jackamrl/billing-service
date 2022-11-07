package com.mycompany.billingservice.servicesImpl;

import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;
import com.mycompany.billingservice.entities.BillItem;
import com.mycompany.billingservice.mappers.BillItemMapper;
import com.mycompany.billingservice.repositories.BillItemRepository;
import com.mycompany.billingservice.services.BillItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillItemServiceImpl implements BillItemService {

    BillItemRepository billItemRepository;
    BillItemMapper billItemMapper;

    public BillItemServiceImpl(BillItemRepository billItemRepository, BillItemMapper billItemMapper) {
        this.billItemRepository = billItemRepository;
        this.billItemMapper = billItemMapper;
    }

    @Override
    public BillItemResponseDTO addBillItem(BillItemRequestDTO billItemRequestDTO) {
        BillItem billItem = billItemMapper.fromBillItemRequestDTOToBillItem(billItemRequestDTO);
        BillItem saveBillItem = billItemRepository.save(billItem);

        BillItemResponseDTO billItemResponseDTO = billItemMapper.fromBillItemToResponseDTOBillItem(saveBillItem);
        return billItemResponseDTO;
    }
}
