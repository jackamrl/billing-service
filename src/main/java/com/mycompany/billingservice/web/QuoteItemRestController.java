package com.mycompany.billingservice.web;

import com.mycompany.billingservice.dto.quoteItem.QuoteItemRequestDTO;
import com.mycompany.billingservice.dto.quoteItem.QuoteItemResponseDTO;
import com.mycompany.billingservice.services.QuoteItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quoteitem")
public class QuoteItemRestController {

    QuoteItemService quoteItemService;

    public QuoteItemRestController(QuoteItemService quoteItemService) {
        this.quoteItemService = quoteItemService;
    }

    //List of quote items
    @GetMapping("/list")
    public ResponseEntity<List<QuoteItemResponseDTO>> filndAll(){
        List<QuoteItemResponseDTO> quoteItemList = quoteItemService.findAll();
        return new ResponseEntity<>(quoteItemList, HttpStatus.OK);
    }

    // Find quote item by id
    @GetMapping("/{id}")
    public ResponseEntity<QuoteItemResponseDTO> findById(@PathVariable Integer id){
        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemService.findById(id);
        return new ResponseEntity<>(quoteItemResponseDTO,HttpStatus.OK);
    }

    //Add a new quote item
    @PostMapping("save")
    public ResponseEntity<QuoteItemResponseDTO> save(@RequestBody QuoteItemRequestDTO quoteItemRequestDTO){
        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemService.save(quoteItemRequestDTO);
        return new ResponseEntity<>(quoteItemResponseDTO, HttpStatus.CREATED);
    }

    // Edit a quote item
    @PutMapping("/{id}")
    public ResponseEntity<QuoteItemResponseDTO> update(@PathVariable Integer id, @RequestBody QuoteItemRequestDTO quoteItemRequestDTO){
        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemService.update(id,quoteItemRequestDTO);
        return new ResponseEntity<>(quoteItemResponseDTO, HttpStatus.OK);
    }

    //Delete a quote item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        quoteItemService.delete(id);
        return ResponseEntity.ok("quote item "+id+" deleted");

    }
}
