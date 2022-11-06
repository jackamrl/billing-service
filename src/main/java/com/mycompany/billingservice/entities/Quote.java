package com.mycompany.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JackDev
//update 02/11/2022

import javax.persistence.*;
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

    @OneToMany( mappedBy = "quote")
    private List<QuoteItem> quoteItemList;
}
