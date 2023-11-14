package com.huynhnamvu.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        EditText edtA, edtB;
        Button btnkq;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            edtA = findViewById(R.id.edtA);
            edtB = findViewById(R.id.edtB);
            btnkq = findViewById(R.id.btnkq);

            btnkq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(edtA.getText().toString()) ;
                    int b = Integer.parseInt(edtB.getText().toString()) ;
                    //Goi chua giu lieu
                    Bundle myBundle = new Bundle();
                    //truyen du lieu vao goi
                    myBundle.putInt("soa", a);
                    myBundle.putInt("sob", b);
                    //Dua goi vao intent
                    i.putExtra("data", myBundle);

                    startActivity(i);
                }
            });
        }
    }