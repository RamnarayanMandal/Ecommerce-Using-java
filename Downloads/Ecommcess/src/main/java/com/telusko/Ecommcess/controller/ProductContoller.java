package com.telusko.Ecommcess.controller;


import com.telusko.Ecommcess.model.Product;
import com.telusko.Ecommcess.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductContoller {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getPoducts(){


        return productService.getProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);

    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product")
    public Product deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }
}
