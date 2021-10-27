package com.bibhu.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.productservice.model.Product;
import com.bibhu.productservice.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/products")
    public Product create(@RequestBody final Product product){
        return this.productRepo.save(product);
    }
}
