package com.mycompany.billingservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Product {
    private Long idProduct;
    private String label;
    private Double amountHt;
}
