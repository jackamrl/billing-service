package com.mycompany.billingservice.servicesImpl;

import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;
import com.mycompany.billingservice.entities.BillItem;
import com.mycompany.billingservice.mappers.BillItemMapper;
import com.mycompany.billingservice.repositories.BillItemRepository;
import com.mycompany.billingservice.services.BillItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public BillItemResponseDTO save(BillItemRequestDTO billItemRequestDTO) {
        BillItem billItem = billItemMapper.fromBillItemRequestDTOToBillItem(billItemRequestDTO);
        BillItem saveBillItem = billItemRepository.save(billItem);

        BillItemResponseDTO billItemResponseDTO = billItemMapper.fromBillItemToBillItemResponseDTO(saveBillItem);
        return billItemResponseDTO;
    }

    // I want to return a bill item with type dto response.
    // so i map every bill item in the list which billitemrepo return me
    @Override
    public List<BillItemResponseDTO> findAll() {
        List<BillItem> billItemList =  billItemRepository.findAll();// this is the list which billItem repo return me
        List<BillItemResponseDTO> billItemResponseDTOS = new ArrayList<BillItemResponseDTO>();

        for (BillItem billItem : billItemList){
            BillItemResponseDTO billItemResponseDTO = billItemMapper.fromBillItemToBillItemResponseDTO(billItem);// mapping bill to billresponse
            billItemResponseDTOS.add(billItemResponseDTO);//adding to the new list of billItem response
        }
        return billItemResponseDTOS;
    }

    @Override
    public BillItemResponseDTO findById(Integer id) {
        BillItem billItem = billItemRepository.findById(id).orElseThrow(()-> new RuntimeException(String
                .format("Bill item %s not found", id)));
        BillItemResponseDTO billItemResponseDTO = billItemMapper.fromBillItemToBillItemResponseDTO(billItem);
        return billItemResponseDTO;
    }

    @Override
    public BillItemResponseDTO update(Integer id, BillItemRequestDTO billItemRequestDTO) {
        BillItem billItem =  billItemMapper.fromBillItemRequestDTOToBillItem(billItemRequestDTO);
        BillItem myBillItem = billItemRepository.findById(id).orElseThrow();
        if (billItem.getAmount()!=null) myBillItem.setAmount(billItem.getAmount());
        if (billItem.getDiscountPercentage()!=null) myBillItem.setDiscountPercentage(billItem.getDiscountPercentage());
        if (billItem.getQte()!=null) myBillItem.setQte(billItem.getQte());
        if (billItem.getRateTva()!=null) myBillItem.setRateTva(billItem.getRateTva());
        if (billItem.getBill()!=null) myBillItem.setBill(billItem.getBill());
        billItemRepository.save(myBillItem);

        BillItemResponseDTO billItemResponseDTO = billItemMapper.fromBillItemToBillItemResponseDTO(myBillItem);

        return billItemResponseDTO;
    }

    @Override
    public void delete(Integer id) {
        billItemRepository.deleteById(id);

    }
}
