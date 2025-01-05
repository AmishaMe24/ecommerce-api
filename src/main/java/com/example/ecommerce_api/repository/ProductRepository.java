package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for Product entities.
 * Spring Data JPA will generate the implementations automatically.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom query methods here if needed
}