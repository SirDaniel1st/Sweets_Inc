package com.example.sweetsinc;

import java.io.Serializable;

public class Product implements Serializable {
    String ProductName;
    String FlavorName;
    String Size;

    public Product(String productName, String flavorName, String size) {
        ProductName = productName;
        FlavorName = flavorName;
        Size = size;
    }

    public Product() {
    }
}
