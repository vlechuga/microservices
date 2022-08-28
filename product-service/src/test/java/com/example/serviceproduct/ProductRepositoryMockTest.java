package com.example.serviceproduct;

import com.example.serviceproduct.entity.Category;
import com.example.serviceproduct.entity.Product;
import com.example.serviceproduct.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindCategory_thenReturnProductList() {


        Product product1 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(10.0)
                .price(1240.25)
                .status("created")
                .createdAt(new Date()).build();
        productRepository.save(product1);

        List<Product> founds = productRepository.findByCategory(product1.getCategory());

        Assertions.assertTrue(founds.size() == 3);
    }
}
