package com.example.laundryapp.view.main;

import androidx.appcompat.app.AppCompatActivity;
import com.example.laundryapp.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InfoActivity extends AppCompatActivity{
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mLocationEditText = findViewById(R.id.location_edittext1);
        mLocationEditText = findViewById(R.id.location_edittext2);
        mLocationEditText = findViewById(R.id.location_edittext3);
    }

    public void openLocation(View view) {
        String url = mLocationEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri loc = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, loc);

        // Find an activity to hand the intent and start that activity.
        startActivity(intent);
    }

}
