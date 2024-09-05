package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")  // Added base path for better organization
@Validated
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PostMapping("/addBulk")
    public ResponseEntity<List<Product>> addProducts(@Valid @RequestBody List<Product> products) {
        List<Product> savedProducts = service.saveProducts(products);
        return ResponseEntity.ok(savedProducts);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = service.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String name) {
        Product product = service.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
        Product updatedProduct = service.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        String response = service.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
