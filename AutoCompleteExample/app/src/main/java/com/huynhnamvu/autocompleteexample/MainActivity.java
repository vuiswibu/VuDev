package com.huynhnamvu.autocompleteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auTV;
    ArrayList<String> Countries = new ArrayList<String>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auTV = findViewById(R.id.AutoCompleteTextView);
        Countries.add("Trong");
        Countries.add("Thai");
        Countries.add("Vu");
        Countries.add("Nga");
        Countries.add("Thai no le");
        ArrayAdapter<String> arrayCountries = new ArrayAdapter<String>(this
                                                                        , android.R.layout.simple_dropdown_item_1line // bo cuc
                                                                        , Countries);// source, database
        auTV.setAdapter(arrayCountries);
        auTV.setThreshold(1);
    }
//    void getWidget()
//    {
//        auTV = findViewById(R.id.AutoCompleteTextView);
//    }
}