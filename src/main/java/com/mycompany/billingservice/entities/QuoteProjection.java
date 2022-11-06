package com.mycompany.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Quote.class, name = "q1")
public interface QuoteProjection {

    public Integer getNoQuote();

    public Double getTotalTTC();
}
