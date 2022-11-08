package com.mycompany.billingservice.web;


import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;
import com.mycompany.billingservice.repositories.BillItemRepository;
import com.mycompany.billingservice.services.BillItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillItemRestController {

    private BillItemRepository billItemRepository;
    private BillItemService billItemService;


    public BillItemRestController(BillItemRepository billItemRepository, BillItemService billItemService) {
        this.billItemRepository = billItemRepository;
        this.billItemService = billItemService;
    }

    @PostMapping("billitems")
    public ResponseEntity<BillItemResponseDTO> save(@RequestBody BillItemRequestDTO billItemRequestDTO){
        BillItemResponseDTO billItemResponseDTO = billItemService.addBillItem(billItemRequestDTO);
        return new ResponseEntity<>(billItemResponseDTO, HttpStatus.CREATED);
    }

}
