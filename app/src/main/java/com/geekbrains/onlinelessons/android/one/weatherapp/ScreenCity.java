package com.geekbrains.onlinelessons.android.one.weatherapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ScreenCity extends AppCompatActivity {
    private ListView listCity;
    private EditText editCityName;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city);
        initViews();
        cityName();
        oKandCreateNewWindow();
    }

    private void oKandCreateNewWindow() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenCity.this, SettingForCity.class);
                startActivity(intent);
            }
        });
    }

    private void cityName() {
        String[] cityNames = getResources().getStringArray(R.array.city);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cityNames);
        listCity.setAdapter(adapter);
    } // добавляет список городов
    private void initViews() {
        ok = findViewById(R.id.enter);
        listCity = findViewById(R.id.cityName);
        editCityName = findViewById(R.id.enterCity);
    }//инициализирует
}
