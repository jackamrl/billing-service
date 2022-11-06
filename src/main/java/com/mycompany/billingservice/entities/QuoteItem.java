package com.mycompany.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JackDev
//update 02/11/2022

import javax.persistence.*;

//The entity of quote
//It have relation with Product and Quote

@Entity
@Table(name = "quote_item")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class QuoteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "qte")
    private Integer qte;
    @JoinColumn(name = "no_quote", referencedColumnName = "no_quote", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Quote quote;


}
