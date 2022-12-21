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


//The entity of bill
//It have relation with Quote, BillItem, Patient and Settlement

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bill",fetch = FetchType.LAZY)
    private List<BillItem> billItemList = new ArrayList<BillItem>();
}
