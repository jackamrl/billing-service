package com.mycompany.billingservice.dto.quoteItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteItemResponseDTO {

    private Integer id;
    private Integer qte;
    private Long noQuote;
}
