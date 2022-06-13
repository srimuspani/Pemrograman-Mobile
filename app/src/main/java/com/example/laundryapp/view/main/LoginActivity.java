package com.example.laundryapp.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundryapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);

        TextView SignUpText=findViewById(R.id.SignUpText);

        SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten1= new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(inten1);
            }
        });
        final TextView tvUsername = findViewById(R.id.username);
        tvUsername.setText(getIntent().getStringExtra("username"));

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(inten);
            }
        });
    }
}
