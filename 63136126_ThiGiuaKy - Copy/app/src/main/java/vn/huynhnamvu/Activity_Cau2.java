package vn.huynhnamvu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Cau2 extends AppCompatActivity {
    ArrayList<String> lst = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        listView = findViewById(R.id.lvText);
        lst.add("Vũ");
        lst.add("Nga");
        lst.add("Trọng");
        lst.add("Thái");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,lst);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Toast currentToast = null;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mucChon = lst.get(i);
                Toast currentToast = null;
                if (currentToast != null) {
                    currentToast.cancel();
                }
                currentToast = Toast.makeText(getApplicationContext(), mucChon, Toast.LENGTH_LONG);
                currentToast.show();
            }
        });
    }
}