package com.example.products.Controller;

import com.example.products.response.UnifiedProduct;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("${api.getAllProducts.url}")
    public Set<UnifiedProduct> getAllProducts() {
        return this.productService.getAllProducts();
    }
}
