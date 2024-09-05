package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        repository.deleteById(id);
        return "Product removed with id: " + id;
    }

    public Product updateProduct(Product product) {
        if (!repository.existsById(product.getId())) {
            throw new ResourceNotFoundException("Product not found with id: " + product.getId());
        }
        return repository.save(product);
    }
}
