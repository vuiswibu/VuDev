package com.huynhnamvu.last_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        edt1 = (EditText) findViewById(R.id.edt_a);
        edt2 = (EditText) findViewById(R.id.edt_b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, MainActivity2.class);
//                i.putExtra("Key1", "something");
//                i.putExtra("Key2", 20);
//                startActivity(i);
                int a = Integer.parseInt(edt1.getText().toString());
                String b = String.valueOf(edt2.getText());
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("Key1", b);
                bundle.putInt("Key2", a);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}