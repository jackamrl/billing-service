package com.mycompany.billingservice.mappers;

import com.mycompany.billingservice.dto.quote.QuoteRequestDTO;
import com.mycompany.billingservice.dto.quoteItem.QuoteItemRequestDTO;
import com.mycompany.billingservice.dto.quoteItem.QuoteItemResponseDTO;
import com.mycompany.billingservice.entities.QuoteItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuoteItemMapper {

    private ModelMapper modelMapper;

    public QuoteItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convert requestDto to QuoteItem
    public QuoteItem fromQuoteItemRequestDTOToQuoteItem(QuoteItemRequestDTO quoteItemRequestDTO){
        QuoteItem quoteItem = modelMapper.map(quoteItemRequestDTO, QuoteItem.class);

        return quoteItem;
    }

    //convert QuoteItem to responsDTO
    public QuoteItemResponseDTO fromQuoteItemToQuoteItemResponse(QuoteItem quoteItem){
        QuoteItemResponseDTO quoteItemResponseDTO = modelMapper.map(quoteItem, QuoteItemResponseDTO.class);

        return quoteItemResponseDTO;
    }

}
