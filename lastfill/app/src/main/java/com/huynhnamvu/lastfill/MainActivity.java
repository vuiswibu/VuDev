package com.huynhnamvu.lastfill;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;

import java.util.Arrays;

public class   MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!Places.isInitialized())
        {
            Places.initialize(getApplicationContext(), "AIzaSyD9Y-DsHJ36D1vY53mZN2e038jQ8PsCY6o");
        }

//        AutocompleteSupportFragment autocompleteSupportFragment = (getSupportFragmentManager().getFragmentb(R.id.fragment) as AutocompleteSUpportFragment).setPlaceFields(
//                listOf(Place.Field.LAT_LNG, Place.Field.NAME)
        AutocompleteSupportFragment autocompleteSupportFragment = (AutocompleteSupportFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragment);
        autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.LAT_LNG, Place.Field.NAME));

    }
}