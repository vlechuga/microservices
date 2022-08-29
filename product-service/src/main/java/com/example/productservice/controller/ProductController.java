package com.example.productservice.controller;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        final List<Product> list;
        if (categoryId == null) {
            list = productService.listAllProduct();
        } else {
            list = productService.findByCategory(Category.builder().id(categoryId).build());
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }
}
