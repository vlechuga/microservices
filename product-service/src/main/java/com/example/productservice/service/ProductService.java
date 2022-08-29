package com.example.productservice.service;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import com.example.productservice.exceptions.NotFoundException;

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
