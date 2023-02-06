package com.mycompany.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JackDev
//update 02/11/2022

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//The entity of quote
//It have relation with QuoteItem and Bill

@Entity
@Table(name = "quote")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_quote")
    private Long noQuote;
    @Basic(optional = false)
    @Column(name = "quote_date")
    private Date quoteDate;
    @Basic(optional = false)
    @Column(name = "validation_date")
    private Date validationDate;
    @Basic(optional = false)
    @Column(name = "total_ht")
    private Double totalHT;
    @Basic(optional = false)
    @Column(name = "total_ttc")
    private Double totalTTC;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "quote",fetch = FetchType.LAZY)
    private List<QuoteItem> quoteItemList = new ArrayList<QuoteItem>();
}
