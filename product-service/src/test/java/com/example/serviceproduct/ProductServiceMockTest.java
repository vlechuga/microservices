package com.example.serviceproduct;

import com.example.serviceproduct.entity.Category;
import com.example.serviceproduct.entity.Product;
import com.example.serviceproduct.exceptions.NotFoundException;
import com.example.serviceproduct.repository.ProductRepository;
import com.example.serviceproduct.service.ProductService;
import com.example.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(12.5)
                .stock(5d)
                .build();
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer))
                .thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct() throws NotFoundException {
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock() throws NotFoundException {
        Product newStock = productService.updateStock(1L, 8d);
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);

    }
}
