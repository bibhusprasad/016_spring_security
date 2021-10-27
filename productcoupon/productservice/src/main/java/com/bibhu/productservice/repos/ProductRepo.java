package com.bibhu.productservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibhu.productservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
