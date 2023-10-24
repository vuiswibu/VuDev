package com.huynhnamvu.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQG = new ArrayList<Country>();
        Country qg1 = new Country("Viet nam", "vn",100000);
        Country qg2 = new Country("Nga", "ru",100000);
        Country qg3 = new Country("My", "us",100000);
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);
        ListView lvQG = findViewById(R.id.listCountry);
        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG,this);
        // Gan vao
        lvQG.setAdapter(adapter);
        // Xu ly su kien, nhu bai cu
    }


}