package vn.huynhnamvu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

public class Activity_Cau4 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        btn =(Button) findViewById(R.id.fab);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau1 = new Intent(Activity_Cau4.this, MainActivity.class);
                startActivity(cau1);
            }
        });

        ImageView imageView = findViewById(R.id.avatar);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Drawable img;
        img = AppCompatResources.getDrawable(this,R.drawable.thai);
        imageView.setImageDrawable(img);

    }

}