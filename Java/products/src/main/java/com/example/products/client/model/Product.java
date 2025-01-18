package com.example.products.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public record Product(@NotNull @Positive @JsonProperty("product_uid") int productId,
                      @NotBlank @JsonProperty("name") String name,
                      @NotBlank @JsonProperty("full_url") String fullUrl,
                      @NotBlank @JsonProperty("product_type") String productType) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
