package com.mycompany.billingservice.repositories;

import com.mycompany.billingservice.entities.QuoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuoteItemRepository extends JpaRepository<QuoteItem, Integer> {
}
