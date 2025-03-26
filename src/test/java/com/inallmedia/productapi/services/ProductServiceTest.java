package com.inallmedia.productapi.services;

import com.inallmedia.productapi.exceptions.InvalidRangeException;
import com.inallmedia.productapi.models.Product;
import com.inallmedia.productapi.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        product1 = new Product("74001755", "Ball Gown", "Full Body Outfits", 3548, 7, 1);
        product2 = new Product("74002423", "Shawl", "Accessories", 758, 12, 1);
        product3 = new Product("74003145", "T-Shirt", "Casual Wear", 1500, 5, 1);
    }

    @Test
    void shouldReturnProductsWithinValidPriceRange() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        int minPrice = 700;
        int maxPrice = 2000;

        List<Product> filteredProducts = productService.filterByPrice(minPrice, maxPrice);

        assertEquals(2, filteredProducts.size());
        assertTrue(filteredProducts.contains(product2));
        assertTrue(filteredProducts.contains(product3));
    }

    @Test
    void shouldThrowExceptionForInvalidPriceRange() {
        assertThrows(InvalidRangeException.class, () -> productService.filterByPrice(3000, 2000));
    }

    @Test
    void shouldSortProductsByPriceAscending() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        List<String> sortedItems = productService.sortByPrice();

        List<String> expectedOrder = Arrays.asList("Shawl", "T-Shirt", "Ball Gown");
        assertEquals(expectedOrder, sortedItems);
    }

    @Test
    void shouldReturnEmptyListWhenNoProducts() {
        when(productRepository.findAll()).thenReturn(List.of());

        List<Product> filteredProducts = productService.filterByPrice(700, 2000);

        assertTrue(filteredProducts.isEmpty());
    }
}
