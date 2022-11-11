package com.mycompany.billingservice.dto.quote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteResponseDTO {

    private Long noQuote;
    private Date quoteDate;
    private Date validationDate;
    private Double totalHT;
    private Double totalTTC;
}
