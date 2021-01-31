package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geekbrains.onlinelessons.android.one.weatherapp.wetherinternet.WeatherRequest;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import static com.geekbrains.onlinelessons.android.one.weatherapp.SettingForCity.settingKey;

public class MainActivity extends AppCompatActivity {
      private Button button;
      private Button buttonGoogle;
      private Button setting;
      private static final String tag = "activity";
      private ImageView imageView;
      private TextView temp;
      private TextView kPa;
      private TextView wind;
      private TextView wet;
      private TextView city;
      static String cityKey = "City";
      private static final int requestCodeSet = 1234;
      private static final int requestCodeSet2 = 12345;
      private RecyclerView recyclerView;
      public ArrayList<String> listForecast;
      private String[] list;
      private Button update;
      private String cityUrl;

    private static final String TAG = "WEATHER";
   // private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=";
   private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "hello man",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Create");
        initViews();
        ButtonGoogle();
        Button();
        buttonSetting();
        setRecyclerView();
        updateButton();


    }

    private void setRecyclerView() {

        list = getResources().getStringArray(R.array.forecast2345);
        listForecast = new ArrayList<>(Arrays.asList(list));

        LinearLayoutManager manager = new LinearLayoutManager(getBaseContext());
        AdapterForRecyclerView adapter = new AdapterForRecyclerView(listForecast);

        DividerItemDecoration decoration = new DividerItemDecoration(getBaseContext(),LinearLayoutManager.VERTICAL);
        decoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(getBaseContext(),R.drawable.iconsun)));
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void buttonSetting() {
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = city.getText().toString();
                Intent intent = new Intent(MainActivity.this, SettingForCity.class);
                intent.putExtra(cityKey,cityName);
                startActivityForResult(intent,requestCodeSet2);

            }
        });
    }

    private void ButtonGoogle() {
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "https://yandex.ru/pogoda/"+city.getText().toString();
                Uri uri = Uri.parse(URL);
                Intent googleIntent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(googleIntent);
            }
        });
    }// по нажатию вызывает страницу с инфой о погоде в выбранном городе

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "SETTING",Toast.LENGTH_SHORT).show();
        if (requestCode == requestCodeSet2 && resultCode == RESULT_OK) {


            temp.setText(data.getStringExtra(SettingForCity.settingKey1));
            kPa.setText(data.getStringExtra(SettingForCity.settingKey2));
            wind.setText(data.getStringExtra(SettingForCity.settingKey3));
            wet.setText(data.getStringExtra(SettingForCity.settingKey4));

        }
        if (requestCode == requestCodeSet && resultCode == RESULT_OK){
            city.setText(data.getStringExtra(ScreenCity.keyForCity));
            cityUrl = getIntent().getStringExtra(ScreenCity.keyForCity);
        }

    }





    private void Button(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScreenCity.class);
                startActivityForResult(intent, requestCodeSet);
            }
        });
    }

    private void initViews() {
          button = findViewById(R.id.button1);
          imageView = findViewById(R.id.imageView);
          temp = findViewById(R.id.textView4);
          kPa = findViewById(R.id.pressure);
          wind = findViewById(R.id.wind);
          wet = findViewById(R.id.wet);
          city = findViewById(R.id.textView3);
          buttonGoogle = findViewById(R.id.buttonGoogle);
          setting = findViewById(R.id.setting);
          recyclerView = findViewById(R.id.recycler1Main);
          update = findViewById(R.id.update);

    }//инициализирует

    private void updateButton(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    final URL uri = new URL(WEATHER_URL +cityUrl+ "&appid=3eb7351351a50bf16967d714e2e37e6f");
                   // final URL uri = new URL(WEATHER_URL + "3eb7351351a50bf16967d714e2e37e6f");
                    final Handler handler = new Handler();
                    new Thread(new Runnable() {
                        public void run() {
                            HttpsURLConnection urlConnection = null;
                            try {
                                urlConnection = (HttpsURLConnection) uri.openConnection();
                                urlConnection.setRequestMethod("GET");
                                urlConnection.setReadTimeout(10000);
                                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                                String result = getLines(in);

                                Gson gson = new Gson();
                                final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        displayWeather(weatherRequest);
                                    }
                                });
                            } catch (Exception e) {
                                Log.e(TAG, "Fail connection", e);
                                e.printStackTrace();
                            } finally {
                                if (null != urlConnection) {
                                    urlConnection.disconnect();
                                }
                            }
                        }
                    }).start();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Fail URI", e);
                    e.printStackTrace();
                }
            }
        });
    }



        private String getLines(BufferedReader in) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return in.lines().collect(Collectors.joining("\n"));
            }
            return null;
        }

        private void displayWeather(WeatherRequest weatherRequest){
            city.setText(weatherRequest.getName());
            String temperatureValue = String.format(Locale.getDefault(), "%.2f", weatherRequest.getMain().getTemp());
            temp.setText(temperatureValue);

            String pressureText = String.format(Locale.getDefault(),"%d", weatherRequest.getMain().getPressure());
            kPa.setText(pressureText);

            String humidityStr = String.format(Locale.getDefault(), "%d", weatherRequest.getMain().getHumidity());
            wet.setText(humidityStr);

            String windSpeedStr = String.format(Locale.getDefault(), "%f", weatherRequest.getWind().getSpeed());
            wind.setText(windSpeedStr);
        }
    };



