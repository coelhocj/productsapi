package com.inallmedia.productapi.controllers;

import com.inallmedia.productapi.models.Product;
import com.inallmedia.productapi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filter/price/{initialRange}/{finalRange}")
    public ResponseEntity<List<Product>> filterByPrice(@PathVariable int initialRange, @PathVariable int finalRange) {
        return ResponseEntity.ok(productService.filterByPrice(initialRange, finalRange));
    }

    @GetMapping("/sort/price")
    public ResponseEntity<List<String>> sortByPrice() {
        return ResponseEntity.ok(productService.sortByPrice());
    }
}