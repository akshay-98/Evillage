package com.example.evillageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bidPlacedActivity extends AppCompatActivity {

    TextView eventText;
    TextView cropName;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String event;
    String details;

    public void addDetails(final String field)
    {
        myRef=database.getReference(field);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("INFO","data Changed");
                details+=field+":"+dataSnapshot.getValue().toString()+"\n";
                Log.i("details:",details);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_placed);
        eventText=(TextView)findViewById(R.id.eventText);
        cropName=(TextView)findViewById(R.id.cropName);
        event="Event Created\n";
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("selectedCrop");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cropName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        addDetails("bidDate");
        addDetails("bidTime");
        addDetails("bidDuration");
        addDetails("selectedCropAmount");
        addDetails("selectedCropQty");
        Log.i("event:",event);
        event+=details;
        eventText.setText(event);


    }
}
