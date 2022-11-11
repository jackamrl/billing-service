package com.mycompany.billingservice.web;


import com.mycompany.billingservice.dto.billItem.BillItemRequestDTO;
import com.mycompany.billingservice.dto.billItem.BillItemResponseDTO;
import com.mycompany.billingservice.repositories.BillItemRepository;
import com.mycompany.billingservice.services.BillItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billitem")
public class BillItemRestController {

    private BillItemService billItemService;


    public BillItemRestController(BillItemService billItemService) {
        this.billItemService = billItemService;
    }

    //List of bill items
    @GetMapping("/list")
    public ResponseEntity<List<BillItemResponseDTO>> filndAll(){
        List<BillItemResponseDTO> billItemList = billItemService.findAll();
        return new ResponseEntity<>(billItemList, HttpStatus.OK);
    }

    // Find bill item by id
    @GetMapping("/{id}")
    public ResponseEntity<BillItemResponseDTO> findById(@PathVariable Integer id){
        BillItemResponseDTO billItemResponseDTO = billItemService.findById(id);
        return new ResponseEntity<>(billItemResponseDTO,HttpStatus.OK);
    }

    //Add a new bill item
    @PostMapping("save")
    public ResponseEntity<BillItemResponseDTO> save(@RequestBody BillItemRequestDTO billItemRequestDTO){
        BillItemResponseDTO billItemResponseDTO = billItemService.save(billItemRequestDTO);
        return new ResponseEntity<>(billItemResponseDTO, HttpStatus.CREATED);
    }

    // Edit a bill item
    @PutMapping("/{id}")
    public ResponseEntity<BillItemResponseDTO> update(@PathVariable Integer id, @RequestBody BillItemRequestDTO billItemRequestDTO){
        BillItemResponseDTO billItemResponseDTO = billItemService.update(id,billItemRequestDTO);
        return new ResponseEntity<>(billItemResponseDTO, HttpStatus.OK);
    }

    // Delete a bill item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        billItemService.delete(id);
        return ResponseEntity.ok("bill "+id+"item deleted");

    }



}
