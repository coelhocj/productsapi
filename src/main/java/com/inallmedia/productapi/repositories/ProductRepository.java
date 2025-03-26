package com.inallmedia.productapi.repositories;

import com.inallmedia.productapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {
    
}
