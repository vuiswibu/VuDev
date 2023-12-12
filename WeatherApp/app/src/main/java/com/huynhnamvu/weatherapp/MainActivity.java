package com.huynhnamvu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.huynhnamvu.weatherapp.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private IApiInterface apiInterface;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchWeatherData("Ha Noi");
        SearchCity();
    }
       private void SearchCity() {
           SearchView searchView = binding.searchView;
//            SearchView searchView = findViewById(R.id.searchView);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) {
                    fetchWeatherData(query);
                    return true;
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
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
                    binding.sunRise.setText(sunRise);
                    binding.sunSet.setText(sunSet);
                    binding.humidity.setText(humidity+"%");
                    binding.ap.setText(pressure+"hPa");
                    binding.weather.setText(condition);
                    binding.cityName.setText(cityName);
                    binding.day.setText(System.currentTimeMillis()));

                }
            }
            @Override
            public void onFailure(Call<WeatherApp> call, Throwable t) {
                // Xử lý khi có lỗi xảy ra
            }
        });
    }

    }
}