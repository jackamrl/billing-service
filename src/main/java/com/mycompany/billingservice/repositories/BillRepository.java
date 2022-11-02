package com.mycompany.billingservice.repositories;

import com.mycompany.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @RestResource(path="byDiscountPercentage", rel="byDiscountPercentage")
    List<Bill> findByDiscountPercentage(@Param("d") Double discountPercentage);
}
