package com.huynhnamvu.custom_list_view_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Com", 1, "Mo ta 1", R.drawable.ru));
        dsMonAn.add(new MonAn("Pho", 2, "Mo ta 2", R.drawable.us));
        dsMonAn.add(new MonAn("Mi", 3, "Mo ta 3", R.drawable.vn));

        MonAnAdapter adapter = new MonAnAdapter(dsMonAn, this);
        lvDSMonAn.setAdapter(adapter);

        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonAn monAnChon = dsMonAn.get(i);
                Toast.makeText(MainActivity.this, monAnChon.getMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}