package com.example.productsrepo.service;

import com.example.productsrepo.model.Product;
import com.example.productsrepo.model.ProductPrice;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Set;

@Service
public class ProductsService {


    @Value("classpath:data/products.json")
    Resource productsJson;

    @Value("classpath:data/prices.json")
    Resource pricesJson;

    public Set<Product> getProducts() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new ClassPathResource("data/products.json").getFile(), new TypeReference<Set<Product>>(){});
    }

    public Set<ProductPrice> getPrices() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new ClassPathResource("data/prices.json").getFile(), new TypeReference<Set<ProductPrice>>(){});
    }
}
