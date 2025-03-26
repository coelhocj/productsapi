package com.inallmedia.productapi.services;

import com.inallmedia.productapi.exceptions.InvalidRangeException;
import com.inallmedia.productapi.models.Product;
import com.inallmedia.productapi.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> filterByPrice(int initialRange, int finalRange) {
        if (initialRange < 0 || finalRange < 0 || initialRange > finalRange) {
            throw new InvalidRangeException(
                    "Invalid price range: initial value must be less than or equal to the second value and both must be non-negative.");
        }
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() >= initialRange && p.getPrice() <= finalRange).toList();
    }

    public List<String> sortByPrice() {
        return productRepository.findAll().stream()
                .sorted((p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice()))
                .map(Product::getItem).toList();
    }

    public List<String> getAllProducts(){
        return productRepository.findAll().stream().map(Product::getItem).toList();
    }
    
}
