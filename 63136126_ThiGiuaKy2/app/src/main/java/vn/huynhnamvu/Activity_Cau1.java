package vn.huynhnamvu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Cau1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);
    }
    public int Input(TextView in){
        int num = 0;
        try {
            num = Integer.parseInt(in.getText().toString());
        } catch (NumberFormatException e) {
            Log.d("info", "Nhập sai");
        }
        return num;
    }

    public void tinhToanClick(View v) {
        int a = Input(findViewById(R.id.soA));
        int b = Input(findViewById(R.id.soB));
        double result = a+b ;
        TextView mTextView = findViewById(R.id.ketQua);
        mTextView.setText(String.valueOf(String.format("%.1f", result)));
    }
}