package com.example.products.client;

import com.example.products.client.model.Product;
import com.example.products.client.model.ProductPrice;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Set;

@Component
public class ProductsClient {

    @NotNull
    @Value("${s3.products.endpoint.baseurl}")
    private String s3ProductEndpointBaseUrl;

    @NotNull
    @Value("${s3.productDtls.endpoint.url}")
    private String s3ProductDtlsEndpointUrl;

    @NotNull
    @Value("${s3.productPrices.endpoint.url}")
    private String s3ProductPricesEndpointUrl;

    private final WebClient webClient;

    @Autowired
    public ProductsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(s3ProductEndpointBaseUrl).build();
    }

    public Set<Product> getAllProducts() {
        return this.webClient.get()
                .uri(s3ProductDtlsEndpointUrl)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Set<Product>>() {
                })
                .blockLast();
    }

    public Set<ProductPrice> getProductPrices() {
        return this.webClient.get()
                .uri(s3ProductPricesEndpointUrl)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Set<ProductPrice>>() {
                })
                .blockLast();
    }

}
