package com.example.sweetsinc;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class CheckoutMenu extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    String Orders = "Orders";
    SharedPreferences sharedpreferences;
    TextView cartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_menu);
        Log.d(TAG, "onCreate():");
    }

    @Override
    protected void onResume() {
        super.onResume();
        cartView = findViewById(R.id.displayView);
        StringBuilder Productdetails = new StringBuilder();
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(sweets_homepage.CART_ID)) {
            Cart cart = (Cart) getIntent().getSerializableExtra(sweets_homepage.CART_ID);
            int index = cart.Count();
            for (Product product : cart.cartItems) {
                Productdetails.append(product.ProductName).append(' ').append(product.FlavorName).append(' ').append(product.Size).append('\n');
            }
            cartView.setText(Productdetails);
        }
        sharedpreferences= getSharedPreferences("OrdersPre",Context.MODE_PRIVATE);

        findViewById(R.id.send_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+18687151687&text="+Productdetails));
                startActivity(intent);
                StringBuilder ListOrders =new StringBuilder();
                ListOrders.append(Productdetails).append('\n').append('\n');
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Orders, (String.valueOf(ListOrders)+Orders));
                editor.commit();
            }
        });

        findViewById(R.id.display_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutMenu.this, displayOrder.class);
                startActivity(intent);
            }
        });
    }
}