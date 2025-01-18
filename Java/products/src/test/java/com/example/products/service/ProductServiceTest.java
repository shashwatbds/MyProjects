package com.example.products.service;

import com.example.products.client.ProductsClient;
import com.example.products.client.model.Product;
import com.example.products.client.model.ProductPrice;
import com.example.products.response.UnifiedProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductsClient productsClient;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetProductsFromApi() {
        Set<Product> mockProducts = Set.of(
                new Product(6447344, "Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g", "https://www.sainsburys.co.uk/gol-ui/product/sainsburys-responsibly-sourced-scottish-salmon-fillet-x2-240g", "BASIC"),
                new Product(3052068, "Lurpak Slightly Salted Spreadable Blend of Butter \\u0026 Rapeseed Oil 500g", "https://www.sainsburys.co.uk/gol-ui/product/lurpak-slightly-salted-spreadable-500g", "BASIC")
        );

        Set<ProductPrice> mockPrices= Set.of(
                new ProductPrice(6447344, 15.63, "Kg", 1),
                new ProductPrice(3052068, 7.5, "Kg", 1)
        );
        when(this.productsClient.getAllProducts()).thenReturn(mockProducts);
        when(this.productsClient.getProductPrices()).thenReturn(mockPrices);

        Set<UnifiedProduct> products = this.productService.getAllProducts();
        assertThat(products).isNotNull();
    }
}
