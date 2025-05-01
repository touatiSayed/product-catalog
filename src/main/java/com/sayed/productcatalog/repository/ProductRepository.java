package com.sayed.productcatalog.repository;

import com.sayed.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // No need to write any methods — JpaRepository gives you CRUD by default
}
