package com.example.products.client;

import com.example.products.client.model.Product;
import com.example.products.client.model.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Set;

@Component
public class ProductsClient {

    private final WebClient webClient;

    @Autowired
    public ProductsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products").build();
    }

    public Set<Product> getAllProducts() {
        return this.webClient.get()
                .uri("/products_v2.json")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Set<Product>>() {
                })
                .blockFirst();
    }

    public Set<ProductPrice> getProductPrices() {
        return this.webClient.get()
                .uri("/products_price_v2.json")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Set<ProductPrice>>() {
                })
                .blockFirst();
    }

}
