package com.example.serviceproduct.service;

import com.example.serviceproduct.entity.Category;
import com.example.serviceproduct.entity.Product;
import com.example.serviceproduct.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    Product getProduct(Long id) throws NotFoundException;

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(Long id) throws NotFoundException;

    List<Product> findByCategory(Category category);

    Product updateStock(Long id, Double quantity) throws NotFoundException;
}
