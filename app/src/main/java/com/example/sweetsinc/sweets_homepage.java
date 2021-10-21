package com.example.sweetsinc;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class sweets_homepage extends AppCompatActivity {
    final static public String CART_ID= "CART";
    public Cart mycart = new Cart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweets_homelayout);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        //Open Cart page when the button is clicked
        findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sweets_homepage.this, CheckoutMenu.class);
                intent.putExtra(CART_ID , mycart);
                startActivity(intent);

            }
        });

        //Create a cupcake product
        findViewById(R.id.cupcake_addtocart).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Spinner flavor = (Spinner) findViewById(R.id.spinnerflavor);
                Spinner size = (Spinner) findViewById(R.id.spinnersize);
                String cupcakeflavor = flavor.getSelectedItem().toString();
                String cupcakesize = size.getSelectedItem().toString();
                Product Cupcake = new Product("Cupcake",cupcakeflavor,cupcakesize);
                mycart.addToCart(Cupcake);
                Toast.makeText(getApplicationContext(),"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });

        //Create a macaroon product
        findViewById(R.id.macaroons_addtocart).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Spinner flavor = (Spinner) findViewById(R.id.macaroonsspinnerflavor);
                Spinner size = (Spinner) findViewById(R.id.macaroonsspinnersize);
                String macaroonflavor = flavor.getSelectedItem().toString();
                String macaroonsize = size.getSelectedItem().toString();
                Product Cupcake = new Product("Macaroons",macaroonflavor,macaroonsize);
                mycart.addToCart(Cupcake);
                Toast.makeText(getApplicationContext(),"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });

        //Create a cake product
        findViewById(R.id.cake_addtocart).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Spinner flavor = (Spinner) findViewById(R.id.cakespinnerflavor);
                Spinner size = (Spinner) findViewById(R.id.cakespinnersize);
                String macaroonflavor = flavor.getSelectedItem().toString();
                String macaroonsize = size.getSelectedItem().toString();
                Product Cupcake = new Product("Cake",macaroonflavor,macaroonsize);
                mycart.addToCart(Cupcake);
                Toast.makeText(getApplicationContext(),"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });
    }
}