package com.mycompany.billingservice.servicesImpl;

import com.mycompany.billingservice.dto.quoteItem.QuoteItemRequestDTO;
import com.mycompany.billingservice.dto.quoteItem.QuoteItemResponseDTO;
import com.mycompany.billingservice.entities.QuoteItem;
import com.mycompany.billingservice.mappers.QuoteItemMapper;
import com.mycompany.billingservice.repositories.QuoteItemRepository;
import com.mycompany.billingservice.services.QuoteItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuoteItemServiceImpl implements QuoteItemService {

    QuoteItemRepository quoteItemRepository;
    QuoteItemMapper quoteItemMapper;

    public QuoteItemServiceImpl(QuoteItemRepository quoteItemRepository, QuoteItemMapper quoteItemMapper) {
        this.quoteItemRepository = quoteItemRepository;
        this.quoteItemMapper = quoteItemMapper;
    }

    @Override
    public QuoteItemResponseDTO save(QuoteItemRequestDTO quoteItemRequestDTO) {
        QuoteItem quoteItem = quoteItemMapper.fromQuoteItemRequestDTOToQuoteItem(quoteItemRequestDTO);
        QuoteItem saveQuoteItem = quoteItemRepository.save(quoteItem);

        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemMapper.fromQuoteItemToQuoteItemResponse(saveQuoteItem);
        return quoteItemResponseDTO;
    }

    @Override
    public List<QuoteItemResponseDTO> findAll() {

        List<QuoteItem> quoteItemList =  quoteItemRepository.findAll();
        List<QuoteItemResponseDTO> quoteItemResponseDTOS = new ArrayList<QuoteItemResponseDTO>();

        for (QuoteItem quoteItem : quoteItemList){
            QuoteItemResponseDTO quoteItemResponseDTO = quoteItemMapper.fromQuoteItemToQuoteItemResponse(quoteItem);
            quoteItemResponseDTOS.add(quoteItemResponseDTO);
        }
        return quoteItemResponseDTOS;
    }

    @Override
    public QuoteItemResponseDTO findById(Integer id) {

        QuoteItem quoteItem = quoteItemRepository.findById(id).orElseThrow(()-> new RuntimeException(String
                .format("Bill item %s not found", id)));
        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemMapper.fromQuoteItemToQuoteItemResponse(quoteItem);
        return quoteItemResponseDTO;
    }

    @Override
    public QuoteItemResponseDTO update(Integer id, QuoteItemRequestDTO quoteItemRequestDTO) {

        return null;
    }

//    @Override
//    public QuoteItemResponseDTO update(Integer id, QuoteItemRequestDTO quoteItemRequestDTO) {
//        QuoteItem quoteItem =  quoteItemMapper.fromQuoteItemRequestDTOToQuoteItem(quoteItemRequestDTO);
//        QuoteItem myQuoteItem = quoteItemRepository.findById(id).orElseThrow();
//        if (quoteItem.getQte()!=null) myQuoteItem.setQte(quoteItem.getQte());
//        if (quoteItem.getQuote()!=null) myQuoteItem.setQuote(quoteItem.getQuote());
//        quoteItemRepository.save(myQuoteItem);
//
//        QuoteItemResponseDTO quoteItemResponseDTO = quoteItemMapper.fromQuoteItemToQuoteItemResponse(myQuoteItem);
//
//        return quoteItemResponseDTO;
//    }

    @Override
    public void delete(Integer id) {
        quoteItemRepository.deleteById(id);
    }
}
