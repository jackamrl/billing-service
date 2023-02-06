package com.mycompany.billingservice.services;

import com.mycompany.billingservice.dto.quoteItem.QuoteItemRequestDTO;
import com.mycompany.billingservice.dto.quoteItem.QuoteItemResponseDTO;

import java.util.List;

public interface QuoteItemService {

    public QuoteItemResponseDTO save(QuoteItemRequestDTO quoteItemRequestDTO);
    public List<QuoteItemResponseDTO> findAll();
    public QuoteItemResponseDTO findById(Integer id);
    public QuoteItemResponseDTO update (Integer id, QuoteItemRequestDTO quoteItemRequestDTO);
    public void delete(Integer id);
}
