package com.huynhnamvu.weatherapp.Activity;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.huynhnamvu.weatherapp.Data;
import com.huynhnamvu.weatherapp.DataAdapter;
import com.huynhnamvu.weatherapp.DataDAO;
import com.huynhnamvu.weatherapp.Main_processing.MainActivity;
import com.huynhnamvu.weatherapp.MyAppDatabase;
import com.huynhnamvu.weatherapp.R;

import java.util.ArrayList;
import java.util.List;

public class SavedCity extends AppCompatActivity {
    TextView txt;
    private MyAppDatabase database;
    private DataDAO dataDAO;
    private ListView listView;
    private DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_city);
        txt = findViewById(R.id.Def_City);

        //Truy xuất vào dữ liệu trong SharedPreferences
        SharedPreferences sp = getSharedPreferences("cityDb", MODE_PRIVATE);
        String value = sp.getString("exampleKey", "Nha Trang");

        Toolbar toolbar1 = findViewById(R.id.tool);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Du lieu tu trang tim kiem
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("dataFromSearch");

        txt.setText(value);
        if (myBundle != null) {
            String pName = myBundle.getString("nameCheck");
            Data placeName = new Data();
            placeName.setName(pName);
            new Thread(() -> dataDAO.insertUser(placeName)).start();
        }
        //Truyen du lieu
        database = MyAppDatabase.getInstance(this);
        dataDAO = database.dataDao();


        // Tạo và thiết lập Adapter cho ListView
        listView = findViewById(R.id.list_item);
        adapter = new DataAdapter(this, new ArrayList<>());
        listView.setAdapter(adapter);


        // Lấy LiveData danh sách người dùng từ cơ sở dữ liệu
        LiveData<List<Data>> usersLiveData = dataDAO.getAllData();
        usersLiveData.observe(this, data     -> {
            // Cập nhật giao diện khi danh sách người dùng thay đổi
            adapter.clear(); // Xóa dữ liệu cũ
            adapter.addAll(data); // Thêm dữ liệu mới
            adapter.notifyDataSetChanged(); // Cập nhật giao diện
        });


        //Nhấn 1 lần để đánh dấu thích//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getTheChoosenCity(position);
            }
        });

        //Nhấn đè để xóa//
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SavedCity.this);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có muốn xóa thành phố này khỏi danh sách yêu thích không?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDataFromDataDAO(position);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

                return true; // Đảm bảo không xử lý sự kiện click ngắn (nếu có)
            }
        });
    }

    //Chuyển trang
    public void toSearchPage(View view)
    {
        Intent s = new Intent(this, ActivitySearch.class);
        startActivity(s);
    }
    private void chuyenTrang(String cityName) {
        String myString = cityName;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("keyString", myString);
        startActivity(intent);
    }

    private void getTheChoosenCity(int position) {
        LiveData<List<Data>> userData = dataDAO.getAllData();
        userData.observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> users) {
                if (users != null && position >= 0 && position < users.size()) {
                    Data selectedUser = users.get(position); // Lấy thanh pho từ danh sách LiveData tại vị trí 'position
                    String cityName = selectedUser.getName(); // Lấy tên của thành phố
                    chuyenTrang(cityName);
                }
            }
        });
    }

    private void getDataFromDataDAO(int position) {
        LiveData<List<Data>> userData = dataDAO.getAllData(); // Lấy LiveData từ userDAO
        final String[] tam = {null};
        userData.observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> users) {
                if (users != null && position >= 0 && position < users.size() && tam[0] == null) {
                    Data selectedUser = users.get(position); // Lấy thanh pho từ danh sách LiveData tại vị trí 'position
                    String coutryName = selectedUser.getName(); // Lấy tên của thành phố
                    tam[0] = coutryName;
                    new Thread(() -> dataDAO.deleteUserByName(coutryName)).start();
                }
            }
        });
    }
}