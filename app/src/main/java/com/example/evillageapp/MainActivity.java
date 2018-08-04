package com.example.evillageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> crops;
    EditText cropAdd;
    ArrayAdapter<String> cropAdapter;
    Spinner cropSpinner;

    public void cantFind(View view)
    {

        cropAdd.setVisibility(View.VISIBLE);
    }

    public void addCrop(View view)
    {
        String crop=cropAdd.getText().toString();
        crops.add(crop);
        cropAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cropAdd=(EditText)findViewById(R.id.cropAddText);

        crops =new ArrayList<String>();
        crops.add("Paddy");
        crops.add("Rice");
        crops.add("Pulses");

        cropSpinner=(Spinner)findViewById(R.id.spinner);
        cropAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,crops);
        cropSpinner.setAdapter(cropAdapter);
    }


}
