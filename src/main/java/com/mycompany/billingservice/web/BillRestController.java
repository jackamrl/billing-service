package com.mycompany.billingservice.web;

import com.mycompany.billingservice.dto.bill.BillRequestDTO;
import com.mycompany.billingservice.dto.bill.BillResponseDTO;
import com.mycompany.billingservice.entities.Bill;
import com.mycompany.billingservice.repositories.BillRepository;
import com.mycompany.billingservice.services.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillRestController {

    private BillRepository billRepository;
    private BillService billService;


    public BillRestController(BillRepository billRepository, BillService billService) {
        this.billRepository = billRepository;
        this.billService = billService;
    }

    @GetMapping("/bills")
    public List<Bill> billList(){
        return billRepository.findAll();
    }

    @GetMapping("/bills/{id}")
    public Bill bill(@PathVariable Integer id){
        return billRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Bill %s not found",id)));
    }

    @PostMapping("bills")
    public BillResponseDTO save(@RequestBody BillRequestDTO billRequestDTO){
        return billService.addBill(billRequestDTO);
    }

    @PutMapping("bills/{id}")
    public Bill update(@PathVariable Integer id, @RequestBody Bill bill){
        Bill mybill = billRepository.findById(id).orElseThrow();
        if (bill.getBillDate()!=null) mybill.setBillDate(new Date());
        if (bill.getValidationDate()!=null) mybill.setValidationDate(new Date());
        if (bill.getDiscountPercentage()!=null) mybill.setDiscountPercentage(bill.getDiscountPercentage());
        if (bill.getTotalHt()!=null) mybill.setTotalHt(bill.getTotalHt());
        if (bill.getTotalTTC()!=null) mybill.setTotalTTC(bill.getTotalTTC());

        return billRepository.save(mybill);
    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill(@PathVariable Integer id){
         billRepository.deleteById(id);

    }

}
