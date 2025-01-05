package com.example.ecommerce_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Maps to the "Products" table in PostgreSQL.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String brand;
    private String title;
    private String color;

    private Integer discountedPrice;
    private Integer price;
    private Integer discountPercent;

    /**
     * JSONB column in PostgreSQL to store array of size objects.
     * Example JSON:
     * [
     *   {"name": "S", "quantity": 20},
     *   {"name": "M", "quantity": 30},
     *   {"name": "L", "quantity": 50}
     * ]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Size> size;

    private Integer quantity;

    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;

    @Column(length = 2000) // or whatever length you need
    private String description;

    /**
     * Inner class (POJO) to represent each item of the "size" array.
     * Could also be a separate @Entity if you want a dedicated table.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Size {
        private String name;
        private Integer quantity;
    }
}