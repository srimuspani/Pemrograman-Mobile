package com.example.laundryapp.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.laundryapp.R;
import com.example.laundryapp.view.CuciBasahActivity;
import com.example.laundryapp.view.DryCleanActivity;
import com.example.laundryapp.view.IroningActivity;
import com.example.laundryapp.view.PremiumWashActivity;

public class ServiceActivity extends AppCompatActivity{
    private ImageView gambar1, gambar2, gambar3, gambar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        gambar1 = findViewById(R.id.cucibasah);
        gambar2 = findViewById(R.id.drycleaning);
        gambar3 = findViewById(R.id.premiumwash);
        gambar4 = findViewById(R.id.ironing);

        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cucibasah = new Intent(ServiceActivity.this, CuciBasahActivity.class);
                startActivity(cucibasah);
            }
        });
        gambar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drycleaning = new Intent(ServiceActivity.this, DryCleanActivity.class);
                startActivity(drycleaning);
            }
        });
        gambar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent premiumwash = new Intent(ServiceActivity.this, PremiumWashActivity.class);
                startActivity(premiumwash);
            }
        });
        gambar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ironing = new Intent(ServiceActivity.this, IroningActivity.class);
                startActivity(ironing);
            }
        });
    }
}
