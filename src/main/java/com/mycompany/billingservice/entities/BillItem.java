package com.mycompany.billingservice.entities;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

// JackDev
//update 02/11/2022

import javax.persistence.*;

//The entity of billItem
//It have relation with Bill and Product

@Entity
@Table(name = "bill_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "qte")
    private Integer qte;
    @Basic(optional = false)
    @Column(name = "amount")
    private Double amount;
    @Basic()
    @Column(name = "rate_tva")
    private Double rateTva;
    @Basic(optional = false)
    @Column(name = "discount_percentage")
    private Double discountPercentage;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "no_bill", referencedColumnName = "no_bill")
    //@RestResource(path = "libraryAddress", rel="bill")
    private Bill bill;

}
