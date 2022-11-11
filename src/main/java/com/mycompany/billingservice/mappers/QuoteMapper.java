package com.mycompany.billingservice.mappers;

import com.mycompany.billingservice.dto.quote.QuoteRequestDTO;
import com.mycompany.billingservice.dto.quote.QuoteResponseDTO;
import com.mycompany.billingservice.entities.Quote;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuoteMapper {

    private ModelMapper modelMapper;

    public QuoteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convert quote to responseDTO
    public QuoteResponseDTO fromQuoteToQuoteResponseDTO(Quote quote){
        QuoteResponseDTO quoteResponseDTO = this.modelMapper.map(quote, QuoteResponseDTO.class);

        return quoteResponseDTO;
    }

    //convert requestDTO to quote
    public Quote fromQuoteRequestDTOToQuote(QuoteRequestDTO quoteRequestDTO){
        Quote quote = modelMapper.map(quoteRequestDTO, Quote.class);

        return quote;
    }

}
