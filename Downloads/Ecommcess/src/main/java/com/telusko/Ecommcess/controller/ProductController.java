package com.telusko.Ecommcess.controller;

import com.telusko.Ecommcess.model.Product;
import com.telusko.Ecommcess.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getProducts() {
        List<Product> products = productService.getProduct();
        return new ResponseEntity<>(products, HttpStatus.OK); // 200 OK with product list
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK); // 200 OK with product data
        } else {
            return new ResponseEntity<>("Product with ID " + id + " not found", HttpStatus.NOT_FOUND); // 404 Not Found with custom message
        }
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>("Product added successfully with ID " + newProduct.getId(), HttpStatus.CREATED); // 201 Created with custom message
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return new ResponseEntity<>("Product updated successfully with ID " + updatedProduct.getId(), HttpStatus.OK); // 200 OK with custom message
        } else {
            return new ResponseEntity<>("Product with ID " + product.getId() + " not found", HttpStatus.NOT_FOUND); // 404 Not Found with custom message
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
        Product deletedProduct = productService.deleteProduct(product);
        if (deletedProduct != null) {
            return new ResponseEntity<>("Product deleted successfully with ID " + deletedProduct.getId(), HttpStatus.OK); // 200 OK with custom message
        } else {
            return new ResponseEntity<>("Product with ID " + product.getId() + " not found", HttpStatus.NOT_FOUND); // 404 Not Found with custom message
        }
    }
}
