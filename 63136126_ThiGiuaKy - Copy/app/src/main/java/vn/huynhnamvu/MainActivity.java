package vn.huynhnamvu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =(Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau1 = new Intent(MainActivity.this, Activity_Cau1.class);
                startActivity(cau1);
            }
        });
        btn2 =(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau2 = new Intent(MainActivity.this, Activity_Cau2.class);
                startActivity(cau2);
            }
        });
        btn3 =(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau3 = new Intent(MainActivity.this, Activity_Cau3.class);
                startActivity(cau3);
            }
        });
        btn4 =(Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau4 = new Intent(MainActivity.this, Activity_Cau4.class);
                startActivity(cau4);
            }
        });
    }

}