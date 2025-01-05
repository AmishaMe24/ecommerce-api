package com.example.ecommerce_api.service;

import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer to encapsulate business logic for Products.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor-based injection (recommended).
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Get all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get a product by ID
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID " + id));
    }

    /**
     * Create a new product
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update an existing product fully (overwrites fields).
     *
     * In a real app, you'd handle partial updates differently.
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        // Retrieve existing product or throw an exception
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID " + id));

        // Update fields
        existing.setImageUrl(updatedProduct.getImageUrl());
        existing.setBrand(updatedProduct.getBrand());
        existing.setTitle(updatedProduct.getTitle());
        existing.setColor(updatedProduct.getColor());
        existing.setDiscountedPrice(updatedProduct.getDiscountedPrice());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDiscountPercent(updatedProduct.getDiscountPercent());
        existing.setSize(updatedProduct.getSize());
        existing.setQuantity(updatedProduct.getQuantity());
        existing.setTopLevelCategory(updatedProduct.getTopLevelCategory());
        existing.setSecondLevelCategory(updatedProduct.getSecondLevelCategory());
        existing.setThirdLevelCategory(updatedProduct.getThirdLevelCategory());
        existing.setDescription(updatedProduct.getDescription());

        return productRepository.save(existing);
    }

    /**
     * Delete a product by ID
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}