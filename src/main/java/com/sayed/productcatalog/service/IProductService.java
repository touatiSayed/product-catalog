package com.sayed.productcatalog.service;

import com.sayed.productcatalog.model.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts(); // Retrieves all products
    Product addProduct(Product product); // Adds a new product
    void deleteProduct(Long id); // Deletes a product by ID
    Optional<Product> updateProduct(Long id, Product updatedProduct); // Updates an existing product
}
