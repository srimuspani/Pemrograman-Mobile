package com.example.laundryapp.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundryapp.R;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);


        Button btnRegister = findViewById(R.id.btnsignup);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                toLogin.putExtra("username", username.getText().toString());
                toLogin.putExtra("password", password.getText().toString());
                startActivity(toLogin);
            }
        });

        TextView SignInText=findViewById(R.id.SignInText);
        SignInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten1= new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(inten1);
            }
        });
    }
}
