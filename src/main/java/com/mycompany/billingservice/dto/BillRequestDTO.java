package com.mycompany.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BillRequestDTO {

    private Date validationDate;
    private Double discountPercentage;
    private Double totalHt;
    private Double totalTTC;
}
