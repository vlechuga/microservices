package com.example.serviceproduct.service;

import com.example.serviceproduct.entity.Category;
import com.example.serviceproduct.entity.Product;
import com.example.serviceproduct.exceptions.NotFoundException;
import com.example.serviceproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long id) throws NotFoundException {
        Product jpa = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.deleteById(id);
        return jpa;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Transactional
    @Override
    public Product updateStock(Long id, Double quantity) throws NotFoundException {
        Product jpa = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        jpa.setStock(jpa.getStock() + quantity);
        productRepository.updateStock(id, jpa.getStock());
        return jpa;
    }
}
