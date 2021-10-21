package com.example.sweetsinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class displayOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        TextView displayView = (TextView) findViewById(R.id.displayView);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("OrdersPre", Context.MODE_PRIVATE);
        String Orders= sp.getString("Orders", "");
        displayView.setText(Orders);
    }

}