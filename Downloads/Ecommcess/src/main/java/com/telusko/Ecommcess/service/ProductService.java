package com.telusko.Ecommcess.service;

import com.telusko.Ecommcess.model.Product;
import com.telusko.Ecommcess.respsitory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"Iphone",50000),
//            new Product(102,"cemara",60000),
//            new Product(520,"car",80000)
//            ));

    public List<Product> getProduct(){
        return repo.findAll();


    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }


    public Product addProduct (Product product) {
         repo.save(product);
        return product;
    }

    public Product updateProduct(Product product) {

        repo.save(product);
        return product;
    }

    public Product deleteProduct(Product product) {

        repo.delete(product);
        return product;
    }
}
