package com.mycompany.billingservice.servicesImpl;

import com.mycompany.billingservice.dto.quote.QuoteRequestDTO;
import com.mycompany.billingservice.dto.quote.QuoteResponseDTO;
import com.mycompany.billingservice.entities.Quote;
import com.mycompany.billingservice.mappers.QuoteMapper;
import com.mycompany.billingservice.repositories.QuoteRepository;
import com.mycompany.billingservice.services.QuoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    private QuoteMapper quoteMapper;

    public QuoteServiceImpl(QuoteRepository quoteRepository, QuoteMapper quoteMapper) {
        this.quoteRepository = quoteRepository;
        this.quoteMapper = quoteMapper;
    }

    @Override
    public QuoteResponseDTO save(QuoteRequestDTO quoteRequestDTO) {
        Quote quote = quoteMapper.fromQuoteRequestDTOToQuote(quoteRequestDTO);
        Quote saveQuote = quoteRepository.save(quote);

        QuoteResponseDTO quoteResponseDTO = quoteMapper.fromQuoteToQuoteResponseDTO(saveQuote);
        return quoteResponseDTO;
    }

    // I want to return a quote with type dto response.
    // so i map every quote in the list which quoterepo return me
    @Override
    public List<QuoteResponseDTO> findAll() {
        List<Quote> quoteList = quoteRepository.findAll();
        List<QuoteResponseDTO> quoteResponseDTOS = new ArrayList<QuoteResponseDTO>();

        for (Quote quote: quoteList){
            QuoteResponseDTO quoteResponseDTO = quoteMapper.fromQuoteToQuoteResponseDTO(quote);// mapping quote to quote
            quoteResponseDTOS.add(quoteResponseDTO); //adding to the new list of quote response
        }
        return quoteResponseDTOS;
    }

    @Override
    public QuoteResponseDTO findById(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(()-> new RuntimeException(String
                .format("Quote %s not found", id)));
        QuoteResponseDTO quoteResponseDTO = quoteMapper.fromQuoteToQuoteResponseDTO(quote);
        return quoteResponseDTO;
    }

    @Override
    public QuoteResponseDTO update(Long id, QuoteRequestDTO quoteRequestDTO) {

        return null;
    }
//
//    @Override
//    public QuoteResponseDTO update(Long id, QuoteRequestDTO quoteRequestDTO) {
//        Quote quote =  quoteMapper.fromQuoteRequestDTOToQuote(quoteRequestDTO);
//        Quote myQuote = quoteRepository.findById(id).orElseThrow();
//        if(quote.getQuoteDate()!= null) myQuote.setQuoteDate(new Date());
//        if(quote.getValidationDate()!= null) myQuote.setValidationDate(quote.getValidationDate());
//        if(quote.getTotalHT()!= null) myQuote.setTotalHT(quote.getTotalHT());
//        if(quote.getTotalTTC()!= null) myQuote.setTotalTTC(quote.getTotalTTC());
//        quoteRepository.save(myQuote);
//
//        QuoteResponseDTO quoteResponseDTO = quoteMapper.fromQuoteToQuoteResponseDTO(myQuote);
//
//        return quoteResponseDTO;
//    }

    @Override
    public void delete(Long id) {
        quoteRepository.deleteById(id);

    }
}
