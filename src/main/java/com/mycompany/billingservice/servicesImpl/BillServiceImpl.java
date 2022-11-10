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

import java.util.Date;
import java.util.List;


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
    public BillResponseDTO save(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.fromBillRequestDTOToBill(billRequestDTO);
        Bill saveBill = billRepository.save(bill);

        BillResponseDTO billResponseDTO = billMapper.fromBillToBillResponseDTO(bill);

        return billResponseDTO;
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public BillResponseDTO findById(Integer id) {
        Bill billResponse = billRepository.findById(id).orElseThrow(()-> new RuntimeException(String
                .format("Bill %s not found", id)));
        BillResponseDTO billResponseDTO = billMapper.fromBillToBillResponseDTO(billResponse);
        return billResponseDTO;
    }

    @Override
    public BillResponseDTO update(Integer id, BillRequestDTO billRequestDTO) {
        Bill bill =  billMapper.fromBillRequestDTOToBill(billRequestDTO);
        Bill myBill = billRepository.findById(id).orElseThrow();
        if (bill.getBillDate()!=null) myBill.setBillDate(new Date());
        if (bill.getValidationDate()!=null) myBill.setValidationDate(bill.getValidationDate());
        if (bill.getDiscountPercentage()!=null) myBill.setDiscountPercentage(bill.getDiscountPercentage());
        if (bill.getTotalHt()!=null) myBill.setTotalHt(bill.getTotalHt());
        if (bill.getTotalTTC()!=null) myBill.setTotalTTC(bill.getTotalTTC());
        billRepository.save(myBill);

        BillResponseDTO billResponseDTO = billMapper.fromBillToBillResponseDTO(myBill);

        return billResponseDTO;
    }

    @Override
    public void delete(Integer id) {
        billRepository.deleteById(id);

    }

}


