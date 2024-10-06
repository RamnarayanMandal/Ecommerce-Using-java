package com.telusko.Ecommcess.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {
    @Id
    private int productID;
    private String productName;
    private int productPrice;

    public Product() {
    }
    public Product(int productID,String productName, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;

    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
