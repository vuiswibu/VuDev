package vn.huynhnamvu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Cau3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        ArrayList<MonAn> dsMonAn = new ArrayList<>();
        dsMonAn.add(new MonAn("Com", 100000, "Khong co anh nen em lay tam", R.drawable.ru));
        dsMonAn.add(new MonAn("Pho", 20000, "Khong co anh nen em lay tam", R.drawable.us));
        dsMonAn.add(new MonAn("Mi", 30000, "Khong co anh nen em lay tam", R.drawable.vn));

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