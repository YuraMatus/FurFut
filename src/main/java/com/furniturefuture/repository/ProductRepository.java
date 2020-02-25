package com.furniturefuture.repository;

import com.furniturefuture.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Product save(Product product);

    Product findByProductName(String productName);

    @Override
    List<Product> findAll();
}