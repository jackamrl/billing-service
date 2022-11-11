package com.mycompany.billingservice.web;


import com.mycompany.billingservice.dto.quote.QuoteRequestDTO;
import com.mycompany.billingservice.dto.quote.QuoteResponseDTO;
import com.mycompany.billingservice.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quote")
public class QuoteRestController {

    private QuoteService quoteService;

    public QuoteRestController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    //List of quotes
    @GetMapping("/list")
    public ResponseEntity<List<QuoteResponseDTO>> filndAll(){
        List<QuoteResponseDTO> quoteList = quoteService.findAll();
        return new ResponseEntity<>(quoteList, HttpStatus.OK);
    }
    // Find quote by id
    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> findById(@PathVariable Long id){
        QuoteResponseDTO quoteResponseDTO = quoteService.findById(id);
        return new ResponseEntity<>(quoteResponseDTO,HttpStatus.OK);
    }
    //Add a new quote
    @PostMapping("save")
    public ResponseEntity<QuoteResponseDTO> save(@RequestBody QuoteRequestDTO quoteRequestDTO){
        QuoteResponseDTO quoteResponseDTO = quoteService.save(quoteRequestDTO);
        return new ResponseEntity<>(quoteResponseDTO, HttpStatus.CREATED);
    }
    // Edit a quote
    @PutMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> update(@PathVariable Long id, @RequestBody QuoteRequestDTO quoteRequestDTO){
        QuoteResponseDTO quoteResponseDTO = quoteService.update(id,quoteRequestDTO);
        return new ResponseEntity<>(quoteResponseDTO, HttpStatus.OK);
    }
    // Delete a quote
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        quoteService.delete(id);
        return ResponseEntity.ok("quote "+id+" deleted");

    }

}
