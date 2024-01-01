package com.huynhnamvu.weatherapp.AutoCompleteSearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.huynhnamvu.weatherapp.R;
import com.huynhnamvu.weatherapp.Saved_info.SavedCity;

public class ActivitySearch extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        cities = Cities.getCities();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cities);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = (String) parent.getItemAtPosition(position);
                Intent i = new Intent(ActivitySearch.this, SavedCity.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("nameCheck", selectedCity);
                i.putExtra("dataFromSearch", myBundle);
                startActivity(i);
            }
        });
    }
}