package com.mycompany.billingservice.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JackDev
//update 02/11/2022

import javax.persistence.*;
import java.util.Date;
import java.util.List;


//The entity of bill
//It have relation with Quote, BillItem, Patient and Setlement

@Entity
@Table(name = "bill")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_bill")
    private Integer noBill;
    @Basic(optional = false)
    @Column(name = "bill_date")
    private Date billDate;
    @Basic(optional = false)
    @Column(name = "validation_date")
    private Date validationDate;
    @Basic()
    @Column(name = "discount_percentage")
    private Double discountPercentage;
    @Basic(optional = false)
    @Column(name = "total_ht")
    private Double totalHt;
    @Basic(optional = false)
    @Column(name = "total_ttc")
    private Double totalTTC;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<BillItem> billItemMap;
}
