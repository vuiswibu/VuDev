package com.huynhnamvu.weatherapp.Main_processing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.huynhnamvu.weatherapp.R;
import com.huynhnamvu.weatherapp.Activity.SavedCity;
import com.huynhnamvu.weatherapp.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private IApiInterface apiInterface;
    private ActivityMainBinding binding;
    private String cName;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        txt = findViewById(R.id.city_name);
        setContentView(binding.getRoot());

        //Khởi tạo SharedPreferences
        SharedPreferences sp = getSharedPreferences("cityDb", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        Intent intent = getIntent();

        if (intent != null) {
            String receivedString = intent.getStringExtra("keyString");
            if (receivedString != null) {
                editor.putString("exampleKey", receivedString);
                editor.apply();
                if (sp.contains("exampleKey"))
                {
                    String value = sp.getString("exampleKey", "Nha Trang");
                    cName = value;
                    fetchWeatherData(value);
                }
            }
        }
        if (sp.contains("exampleKey")){
            String value = sp.getString("exampleKey", "Nha Trang");
            if (value == null)
            {
                cName = "Nha Trang";
                fetchWeatherData("Nha Trang");
            }
            else
            {
                cName = value;
                fetchWeatherData(value);}
            }
        else
            fetchWeatherData("Nha Trang");
    }
    public void chuyenPage(View view)
    {
        Intent i = new Intent(MainActivity.this, SavedCity.class);
        startActivity(i);
    }
    private void fetchWeatherData(String cityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .build();
        apiInterface = retrofit.create(IApiInterface.class);
        Call<WeatherApp> call = apiInterface.getWeatherData(cityName, "fb816b46903d5871219d34d23cf4433c", "metric");
        call.enqueue(new Callback<WeatherApp>() {
            @Override
            public void onResponse(Call<WeatherApp> call, Response<WeatherApp> response) {
                WeatherApp responseBody = response.body();

                if (responseBody != null && response.isSuccessful()) {
                    //Lấy dữ liệu
                    double temperature = responseBody.getMain().getTemp();
                    double windSpeed = responseBody.getWind().getSpeed();
                    double maxTemp = responseBody.getMain().getTemp_max();
                    double minTemp = responseBody.getMain().getTemp_min();
                    int sunRise = responseBody.getSys().getSunrise();
                    int sunSet = responseBody.getSys().getSunset();
                    int humidity = responseBody.getMain().getHumidity();
                    int pressure = responseBody.getMain().getPressure();
                    String condition;
                    if (responseBody.getWeather() != null && !responseBody.getWeather().isEmpty()) {
                        condition = responseBody.getWeather().get(0).getMain();
                    } else {
                        condition = "unknown";
                    }
                    Long.valueOf(sunRise);
                    Long.valueOf(sunSet);
                    //Gán giá trị
                    binding.temp.setText(temperature+"°C");
                    binding.windSpeed.setText(windSpeed+"m/s");
                    binding.maxTemp.setText("Max temp: "+ maxTemp+"°C");
                    binding.minTemp.setText("Min temp: "+ minTemp+"°C");
                    binding.sunRise.setText(time(sunRise));
                    binding.sunSet.setText(time(sunSet));
                    binding.humidity.setText(humidity+"%");
                    binding.ap.setText(pressure+"hPa");
                    binding.weather.setText(condition);
                    binding.cityName.setText(cityName);
                    binding.day.setText(dayName(System.currentTimeMillis()));
                    binding.date.setText(date());
                    changeImage(condition);
                }
            }
            @Override
            public void onFailure(Call<WeatherApp> call, Throwable t) {
            }
        });
    }
    public static String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return sdf.format(new Date());
    }
    public static String time(long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(timeStamp * 1000));
    }
    public static String dayName(long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        return sdf.format(new Date());
    }
    private void changeImage(String condition) {
        switch (condition)
        {
            case "Clear sky": case "Sunny": case "Clear":
            binding.getRoot().setBackgroundResource(R.drawable.sunny_background);
            binding.lottieAnimationView.setAnimation(R.raw.sun);
            break;
            case "Partly Clouds": case "Clouds": case "Overcast": case "Mist": case "Foggy":
            binding.getRoot().setBackgroundResource(R.drawable.colud_background);
            binding.lottieAnimationView.setAnimation(R.raw.cloud);
            break;
            case "Light Rain": case "Drizzle": case "Showers": case "Moderate Rain": case "Heavy Rain":
            binding.getRoot().setBackgroundResource(R.drawable.rain_background);
            binding.lottieAnimationView.setAnimation(R.raw.rain);
            break;
            case "Light Snow": case "Moderate Snow": case "Heavy Snow": case "Blizzard":
            binding.getRoot().setBackgroundResource(R.drawable.snow_background);
            binding.lottieAnimationView.setAnimation(R.raw.snow);
            break;
            default:
                binding.getRoot().setBackgroundResource(R.drawable.sunny_background);
                binding.lottieAnimationView.setAnimation(R.raw.sun);
                break;
        }
        binding.lottieAnimationView.playAnimation();
        }
    }