package com.example.sweetsinc;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
   List<Product> cartItems= new ArrayList<Product>();

   public void addToCart(Product product){
       cartItems.add(product);
   }
   public int Count(){
       int count = 0;
       for (Product product : cartItems){
           count += 1;
       }
       return count;
   }
}

