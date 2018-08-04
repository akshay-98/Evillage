package com.example.evillageapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> crops;
    EditText cropAdd;
    ArrayAdapter<String> cropAdapter;
    Spinner cropSpinner;
    Button addtoList;

    public void cantFind(View view)
    {

        cropAdd.setVisibility(View.VISIBLE);
        addtoList.setVisibility(View.VISIBLE);
    }

    public void addCrop(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cropAdd.getWindowToken(), 0);
        boolean isDuplicate = false;
        String crop = cropAdd.getText().toString();
        for (int i = 0; i < crops.size(); i++) {

            if (crop.equalsIgnoreCase(crops.get(i))) {
                isDuplicate = true;
                break;

            }

        }
        if (!isDuplicate) {

            Toast.makeText(this, crop + " added", Toast.LENGTH_LONG).show();
            crops.add(crop);
            cropAdapter.notifyDataSetChanged();
            cropSpinner.setSelection(cropAdapter.getPosition(crop));

        }
        else
        {
            Toast.makeText(this,"Item Already Present",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cropAdd=(EditText)findViewById(R.id.cropAddText);

        addtoList=(Button)findViewById(R.id.addToList);

        crops =new ArrayList<String>();
        crops.add("Paddy");
        crops.add("Rice");
        crops.add("Pulses");

        cropSpinner=(Spinner)findViewById(R.id.spinner);
        cropAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,crops);
        cropSpinner.setAdapter(cropAdapter);
        cropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }


}
