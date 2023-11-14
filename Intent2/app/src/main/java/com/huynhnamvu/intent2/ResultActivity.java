package com.huynhnamvu.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nghiem;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt_nghiem = findViewById(R.id.txt_nghiem);
        btnback = findViewById(R.id.btnback);
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("data");

        int a =myBundle.getInt("soa");
        int b =myBundle.getInt("sob");

        txt_nghiem.setText(a+b);
    }
}