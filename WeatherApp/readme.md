# 63CNTT-Mobile-Dev: LẬP TRÌNH ỨNG DỤNG MOBILE
> Sinh viên: Huỳnh Nam Vũ 63CNTT-CLC1
 ## Install:
 - Android Studio
 - Android 7.0 (Nougat API 24)
 - Java SE Development Kit (8u77)

 ***Quá trình thực hiện bài tập***
 ## Dữ liệu
 - Dự án ứng dụng xem thời tiết
 - TIến độ hoàn thành dự án
 ![](https://geps.dev/progress/85)

 - Dữ liệu được lấy từ trang web: 'https://openweathermap.org'
 - Kết nối API
    ```java
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .build();
        apiInterface = retrofit.create(IApiInterface.class);
        Call<WeatherApp> call = apiInterface.getWeatherData(cityName, "fb816b46903d5871219d34d23cf4433c", "metric");
    ```

    ***Trang web***
 ![image](https://cdn.discordapp.com/attachments/1096764946089508975/1184077318583496754/web.png?ex=658aa8ef&is=657833ef&hm=41b9e188c7c4402bc5f86ed114a24a9810a8f92c391cf763f5af916cf46ad806&)

 * Binding dữ liệu
    ```java
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
                   binding.day.setText(System.currentTimeMillis());
               }
           }
           @Override
           public void onFailure(Call<WeatherApp> call, Throwable t) {
                // Xử lý khi có lỗi xảy ra
            }
    ```
* Sự kiện button `search`

    ```java
       private void SearchCity(){
           SearchView searchView = binding.searchView;
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
    ```
    ***Khi người dùng thực hiện tìm kiếm***
    ![image](https://cdn.discordapp.com/attachments/1096764946089508975/1184076394850947213/search.png?ex=658aa813&is=65783313&hm=8a96a15cbece95da7dfa3c332aca7e255dc1bdef6d051069c24d8fccf0ca14ea&)

