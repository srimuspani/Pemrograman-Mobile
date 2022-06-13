package com.example.laundryapp.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.laundryapp.R;
import com.example.laundryapp.view.history.HistoryActivity;
import com.example.laundryapp.view.main.ServiceActivity;

public class DashboardActivity extends AppCompatActivity{
    private ImageView gambar1, gambar2, gambar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gambar1 = findViewById(R.id.order);
        gambar2 = findViewById(R.id.history);
        gambar3 = findViewById(R.id.info);

        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(DashboardActivity.this, ServiceActivity.class);
                startActivity(service);
            }
        });
        gambar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(history);
            }
        });
        gambar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(DashboardActivity.this, InfoActivity.class);
                startActivity(info);
            }
        });
    }
}