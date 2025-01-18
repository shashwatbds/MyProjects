package com.example.productsrepo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public record ProductPrice(@NotNull @Positive @JsonProperty("product_uid") int productId,
                           @NotNull @Positive @JsonProperty("unit_price") double productPrice,
                           @NotBlank @JsonProperty("unit_price_measure") String unitPriceMeasure,
                           @NotNull @Positive @JsonProperty("unit_price_measure_amount") int unitPriceMeasureAmount) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
