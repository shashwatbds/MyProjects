package com.example.products.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public record UnifiedProduct(@NotNull @Positive int productId,
                             @NotBlank String name,
                             @NotBlank String fullUrl,
                             @NotBlank String productType,
                             @NotNull @Positive double productPrice,
                             @NotBlank String unitPriceMeasure,
                             @NotNull @Positive int unitPriceMeasureAmount) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnifiedProduct that = (UnifiedProduct) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
