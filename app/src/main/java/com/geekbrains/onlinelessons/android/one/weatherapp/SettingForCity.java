package com.geekbrains.onlinelessons.android.one.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingForCity extends AppCompatActivity {
    private RadioButton radioButton3;
    private RadioButton radioButton2;
    private ImageView imageView;
    private Button accept;
    private CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_window);
        initViews();
    }
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
      //    accept = findViewById(R.id.acceptSetting);
       //   checkBox = findViewById(R.id.temp);
      //    checkBox = findViewById(R.id.pressure1);
    }//инициализирует
}

