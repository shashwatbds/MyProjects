package com.example.products.client.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public record ProductPrice(@NotNull @Positive int productId,
                           @NotNull @Positive double productPrice,
                           @NotBlank String unitPriceMeasure,
                           @NotNull @Positive int unitPriceMeasureAmount) {

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
