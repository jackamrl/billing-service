package com.mycompany.billingservice.web;

import com.mycompany.billingservice.dto.bill.BillRequestDTO;
import com.mycompany.billingservice.dto.bill.BillResponseDTO;

import com.mycompany.billingservice.repositories.BillRepository;
import com.mycompany.billingservice.services.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillRestController {

    private BillService billService;


    public BillRestController(BillService billService) {
        this.billService = billService;
    }

    //List of bills
    @GetMapping("/list")
    public ResponseEntity<List<BillResponseDTO>> filndAll(){
        List<BillResponseDTO> billList = billService.findAll();
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }
    // Find bill by id
    @GetMapping("/{id}")
    public ResponseEntity<BillResponseDTO> findById(@PathVariable Integer id){
        BillResponseDTO billResponseDTO = billService.findById(id);
        return new ResponseEntity<>(billResponseDTO,HttpStatus.OK);
    }
    //Add a new bill
    @PostMapping("save")
    public ResponseEntity<BillResponseDTO> save(@RequestBody BillRequestDTO billRequestDTO){
        BillResponseDTO billResponseDTO = billService.save(billRequestDTO);
        return new ResponseEntity<>(billResponseDTO, HttpStatus.CREATED);
    }
    // Edit a bill
    @PutMapping("/{id}")
    public ResponseEntity<BillResponseDTO> update(@PathVariable Integer id, @RequestBody BillRequestDTO billRequestDTO){
        BillResponseDTO billResponseDTO = billService.update(id,billRequestDTO);
        return new ResponseEntity<>(billResponseDTO, HttpStatus.OK);
    }
    // Delete a bill
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
         billService.delete(id);
         return ResponseEntity.ok("bill "+id+" deleted");

    }

}
