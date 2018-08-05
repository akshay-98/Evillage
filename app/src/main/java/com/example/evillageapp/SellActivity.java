package com.example.evillageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SellActivity extends AppCompatActivity {

    TextView cropName;

    public void onlineBid(View view)
    {
        Intent onlineBidIntent=new Intent(SellActivity.this,onlineBidActivity.class);
        this.startActivity(onlineBidIntent);

    }



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
