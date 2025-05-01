package com.sayed.productcatalog.controller;

import com.sayed.productcatalog.model.Product;
import com.sayed.productcatalog.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indicates this is a REST controller
@RequestMapping("/products") // Sets the base URL path for all requests
public class ProductController {

    @Autowired
    private IProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Delete a product by its ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> updatedProduct = productService.updateProduct(id, product);

        return updatedProduct
                .map(productResponse -> ResponseEntity.ok().body(productResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
