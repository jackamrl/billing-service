package com.mycompany.billingservice.dto.billItem;

import com.mycompany.billingservice.entities.Bill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BillItemRequestDTO {

    private Integer qte;
    private Double amount;
    private Double rateTva;
    private Double discountPercentage;
    private Integer noBill;

}
