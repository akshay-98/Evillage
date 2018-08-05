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

import java.util.ArrayList;

public class onlineBidActivity extends AppCompatActivity {

    Spinner durationSpinner;

    public void submit(View view)
    {
        Log.i("info","submit button pressed");
        Intent placeBid=new Intent(onlineBidActivity.this,bidPlacedActivity.class);
        this.startActivity(placeBid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_bid);



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
