package com.example.products.controller;

import com.example.products.response.UnifiedProduct;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Value("${my.custom.property}")
    private String myProperty;


    @GetMapping("${api.getAllProducts.url}")
    public Set<UnifiedProduct> getAllProducts() {
        return this.productService.getAllProducts();
    }
}
