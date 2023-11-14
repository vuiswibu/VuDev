package vn.huynhnamvu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_Cau3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        ArrayList<MonAn> dsMonAn = new ArrayList<>();
        dsMonAn.add(new MonAn("Com", 1, "Mo ta 1", R.drawable.ru));
        dsMonAn.add(new MonAn("Pho", 2, "Mo ta 2", R.drawable.us));
        dsMonAn.add(new MonAn("Mi", 3, "Mo ta 3", R.drawable.vn));

        MonAnAdapter adapter = new MonAnAdapter(dsMonAn, this);
        lvDSMonAn.setAdapter(adapter);
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonAn monAnChon = dsMonAn.get(i);
                Toast.makeText(Activity_Cau3.this, monAnChon.getMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}