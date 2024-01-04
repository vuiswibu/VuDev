package com.huynhnamvu.weatherapp.Main_processing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiInterface {
    @GET("weather")
    Call<WeatherApp> getWeatherData(
            @Query("q") String city,
            @Query("appid") String appid,
            @Query("units") String units
    );
}
