package com.company;

public class Product {
    int id;
    String name;
    String description;
    double price;
    int quantity;

    public Product(int id, String productName, String productDescription, double productPrice ) {

        this.id = id;
        this.name = productName;
        this.description = productDescription;
        this.price = productPrice;
    }
}
