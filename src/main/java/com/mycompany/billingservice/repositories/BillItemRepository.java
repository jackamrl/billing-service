package com.mycompany.billingservice.repositories;

import com.mycompany.billingservice.entities.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillItemRepository extends JpaRepository<BillItem, Integer> {
}
