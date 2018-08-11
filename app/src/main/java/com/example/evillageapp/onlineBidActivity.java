package com.example.evillageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class onlineBidActivity extends AppCompatActivity {

    Spinner durationSpinner;
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView cropName;
    EditText dateText;
    EditText timeText;


    public void submit(View view)
    {
        Log.i("info","submit button pressed");
        dateText=(EditText)findViewById(R.id.dateText);
        myRef=database.getReference("bidDate");
        myRef.setValue(dateText.getText().toString());
        myRef=database.getReference("bidTime");
        timeText=(EditText)findViewById(R.id.timeText);
        myRef.setValue(timeText.getText().toString());
        myRef=database.getReference("bidDuration");
        myRef.setValue(durationSpinner.getSelectedItem().toString());
        Intent placeBid=new Intent(onlineBidActivity.this,bidPlacedActivity.class);
        this.startActivity(placeBid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_bid);
        cropName=(TextView)findViewById(R.id.cropName);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("selectedCrop");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cropName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(onlineBidActivity.this,"Error reading from database",Toast.LENGTH_LONG).show();



            }
        });



        ArrayList<Integer> durationList=new ArrayList<Integer>();
        durationList.add(12);
        durationList.add(24);
        durationList.add(48);

        durationSpinner=(Spinner)findViewById(R.id.durationSpinner);

        ArrayAdapter<Integer> durationAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,durationList);
        durationSpinner.setAdapter(durationAdapter);
        durationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }
}
