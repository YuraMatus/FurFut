package com.furniturefuture.service;

import com.furniturefuture.entity.Product;
import com.furniturefuture.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        if (productRepository.findByProductName(product.getProductName()) == null) {
            return productRepository.save(product);
        }
        return null;
    }

    public Product findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

}
