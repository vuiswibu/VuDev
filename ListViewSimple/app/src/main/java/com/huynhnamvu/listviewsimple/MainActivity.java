package com.huynhnamvu.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> lst = new ArrayList<>();
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widGetwid();
        lst.add("C++");
        lst.add("C#");
        lst.add("Java");
        lst.add("Python");
        lst.add("Dart");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,lst);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Toast currentToast = null;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //String mucChon = arrayAdapter.getItem(i); cach 1
                String mucChon = lst.get(i);
                Toast currentToast = null;
                if (currentToast != null) {
                    currentToast.cancel(); // Tắt thông báo cũ nếu có
                }

                currentToast = Toast.makeText(getApplicationContext(), mucChon, Toast.LENGTH_LONG);
                currentToast.show();
            }
        });
    }
    public void widGetwid()
    {
        listView = findViewById(R.id.lvText);
    }
}