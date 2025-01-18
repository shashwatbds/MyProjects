package com.example.productsrepo.controller;

import com.example.productsrepo.model.Product;
import com.example.productsrepo.model.ProductPrice;
import com.example.productsrepo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@RestController
public class ProductRepoController {

 @Autowired
 ProductsService productsService;

 @GetMapping("${api.getProducts.url}")
 public Set<Product> getProducts() throws IOException {
  return productsService.getProducts();
 }

 @GetMapping("${api.getPrices.url}")
 public Set<ProductPrice> getProductPrices() throws IOException {
  return productsService.getPrices();
 }
}
