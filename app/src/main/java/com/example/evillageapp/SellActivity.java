package com.example.evillageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SellActivity extends AppCompatActivity {

    TextView cropName;
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText qtyText,amountText;

    public void onlineBid(View view)
    {
        Intent onlineBidIntent=new Intent(SellActivity.this,onlineBidActivity.class);
        storeData();
        this.startActivity(onlineBidIntent);

    }
    public void storeData()
    {
        qtyText=(EditText)findViewById(R.id.qtyEditText);
        amountText=(EditText)findViewById(R.id.amountEditText);
        myRef=database.getReference("selectedCropQty");
        myRef.setValue(qtyText.getText().toString());
        myRef=database.getReference("selectedCropAmount");
        myRef.setValue(amountText.getText().toString());
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference("selectedCrop");


        Intent sellIntent=getIntent();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String selectedCrop=dataSnapshot.getValue().toString();
                cropName=findViewById(R.id.cropName);
                cropName.setText(selectedCrop);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
