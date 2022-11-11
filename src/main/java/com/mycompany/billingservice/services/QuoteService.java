package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.quote.QuoteRequestDTO;
import com.mycompany.billingservice.dto.quote.QuoteResponseDTO;

import java.util.List;

public interface QuoteService {

    public QuoteResponseDTO save (QuoteRequestDTO quoteRequestDTO);
    public List<QuoteResponseDTO> findAll();
    public QuoteResponseDTO findById(Long id);
    public QuoteResponseDTO update (Long id, QuoteRequestDTO quoteRequestDTO);
    public void delete(Long id);
}
