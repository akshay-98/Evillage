package com.example.evillageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SellActivity extends AppCompatActivity {

    TextView cropName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Intent sellIntent=getIntent();
        String selectedCrop=sellIntent.getStringExtra("selectedCrop");
        cropName=findViewById(R.id.cropName);
        cropName.setText(selectedCrop);

    }
}
