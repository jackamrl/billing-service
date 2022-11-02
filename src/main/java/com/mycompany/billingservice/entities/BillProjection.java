package com.mycompany.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Bill.class, name = "p1")
public interface BillProjection {

    public Integer getnoBill();

    public Double getTotalTTC();
}
