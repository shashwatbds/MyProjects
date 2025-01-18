package com.example.products.service;

import com.example.products.client.ProductsClient;
import com.example.products.client.model.Product;
import com.example.products.client.model.ProductPrice;
import com.example.products.response.UnifiedProduct;
import com.example.products.response.mapper.UnifiedProductsMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductsClient productsClient;

    public Set<UnifiedProduct> getAllProducts() {

        Set<Product> products = this.productsClient.getAllProducts();
        Set<ProductPrice> productPrices = this.productsClient.getProductPrices();
        return UnifiedProductsMapperUtil.getUnifiedProducts(products, productPrices);
    }
}
