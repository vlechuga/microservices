package com.example.serviceproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    private String description;
    @Positive(message = "Stock must be greater than zero")
    private Double stock;
    private Double price;
    private String status;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull(message = "Category cannot be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
}
