package com.example.productservice.repository;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    @Modifying
    @Query(value = "UPDATE tbl_product SET stock =:quantity WHERE id =:id", nativeQuery = true)
    void updateStock(@Param("id") Long id, @Param("quantity") Double quantity);

}
