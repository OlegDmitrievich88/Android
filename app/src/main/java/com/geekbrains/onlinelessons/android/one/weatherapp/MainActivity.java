package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButton3;
    private RadioButton radioButton2;
    private ImageView imageView;
    private ListView listCity;
    private Button button;
    private EditText editCityName;// пока не используется
    private TextView cityName;//опка не используется

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setRadioButton();
        cityName();
        enterCity();
    }

    private void enterCity() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    } // по нажатию кнопки будет переходить в меню настроек для выбранного города

    private void cityName() {
        String[] cityNames = getResources().getStringArray(R.array.city);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cityNames);
        listCity.setAdapter(adapter);
    } // добавляет список городов

    private void setRadioButton() {
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getDrawable(R.drawable.sun));
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getDrawable(R.drawable.winter));
            }
        });
    }// меняет темы на главном экране

    private void initViews() {
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.enter);
        listCity = findViewById(R.id.cityName);
        editCityName = findViewById(R.id.enterCity);



    }//инициализирует
}