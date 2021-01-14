package com.geekbrains.onlinelessons.android.one.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenCity extends AppCompatActivity {
    private ListView listCity;
    private EditText editCityName;
    private Button ok;
    private Button acceptAllSetting;
    static String city = "City";
    private static final int requestCodeSet2 = 12345;
    private String temp;
    private String kPa;
    private String wind;
    private String wet;
    static String settingKey = "settingKey";
    static String settingKey1 = "settingKey1";
    static String settingKey2 = "settingKey2";
    static String settingKey3 = "settingKey3";
    static String settingKey4 = "settingKey4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city);
        initViews();
        cityName();
        oKandCreateNewWindow();
        allAccept();


    }



    private void allAccept() {
        acceptAllSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = editCityName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(settingKey,city);
                intent.putExtra(settingKey1,temp);
                intent.putExtra(settingKey2,kPa);
                intent.putExtra(settingKey3,wind);
                intent.putExtra(settingKey4,wet);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "SETTING",Toast.LENGTH_SHORT).show();

        if (requestCode == requestCodeSet2 && resultCode == RESULT_OK) {

            editCityName.setText(data.getStringExtra(SettingForCity.settingKey));
            temp = data.getStringExtra(SettingForCity.settingKey1);
            kPa = data.getStringExtra(SettingForCity.settingKey2);
            wind = data.getStringExtra(SettingForCity.settingKey3);
            wet = data.getStringExtra(SettingForCity.settingKey4);

        }
    }



    private void oKandCreateNewWindow() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = editCityName.getText().toString();
                Intent intent = new Intent(ScreenCity.this, SettingForCity.class);
                intent.putExtra(city,cityName);
                startActivityForResult(intent,requestCodeSet2);

            }
        });
    }// по нажатию кнопки открывает новую активити и передает туда выбранный город
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
        acceptAllSetting = findViewById(R.id.button1);

    }//инициализирует
}
