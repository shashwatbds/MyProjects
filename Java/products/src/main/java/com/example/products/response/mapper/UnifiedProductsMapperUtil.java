package com.example.products.response.mapper;

import com.example.products.client.model.Product;
import com.example.products.client.model.ProductPrice;
import com.example.products.response.UnifiedProduct;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UnifiedProductsMapperUtil {

    public static Set<UnifiedProduct> getUnifiedProducts(Set<Product> products, Set<ProductPrice> prices) {
        Map<Integer, ProductPrice> pricesMap = prices.parallelStream()
                .collect(Collectors.toMap(ProductPrice::productId, price -> price));

        return products.parallelStream()
                .map(product -> {
                    ProductPrice price = pricesMap.get(product.productId());
                    return new UnifiedProduct(price.productId(), product.name(), product.fullUrl(), product.productType(), price.productPrice(), price.unitPriceMeasure(), price.unitPriceMeasureAmount());
                })
                .collect(Collectors.toSet());
    }
}
