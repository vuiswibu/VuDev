package com.huynhnamvu.last_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String value1 = b.getString("Key1");
        int value2 = b.getInt("Key2", 0);
//        String value1 = i.getStringExtra("Key1");
//        int value2 = i.getIntExtra("Key2",0);

        tv1.setText(value1);

        tv2.setText(""+value2);
    }
}