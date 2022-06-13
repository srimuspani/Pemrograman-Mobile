package com.example.laundryapp.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.laundryapp.R;
import com.example.laundryapp.view.history.HistoryActivity;
import com.example.laundryapp.view.main.ServiceActivity;
import com.example.laundryapp.view.main.InfoActivity;

public class DashboardActivity extends AppCompatActivity{
    private ImageView gambar4, gambar5, gambar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        gambar4 = findViewById(R.id.order);
        gambar5 = findViewById(R.id.history);
        gambar6 = findViewById(R.id.info);

        gambar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(DashboardActivity.this, ServiceActivity.class);
                startActivity(service);
            }
        });
        gambar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(history);
            }
        });
        gambar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(DashboardActivity.this, InfoActivity.class);
                startActivity(info);
            }
        });
    }
}