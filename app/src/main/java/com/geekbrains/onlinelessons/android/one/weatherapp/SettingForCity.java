package com.geekbrains.onlinelessons.android.one.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SettingForCity extends AppCompatActivity {
    private RadioButton radioButton3;
    private RadioButton radioButton2;
    private ImageView imageView;
    private Button accept;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private boolean isChecked1;
    private boolean isChecked2;
    private boolean isChecked3;
    private boolean isChecked4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_window);
        initViews();
        checkBoxListener();
       // Intent set = new Intent(SettingForCity.this,MainActivity.class);

       // setRadioButton();
    }

    private void checkBoxListener() {
       checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
               if (checkBox1.isChecked()){
                   isChecked1 = true;
               }
           }
       });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (checkBox2.isChecked()){
                    isChecked2 = true;
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (checkBox3.isChecked()){
                    isChecked3 = true;
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
              if (checkBox4.isChecked()){
                  isChecked4 = true;
              }


            }
        });
    }


    private void initViews() {
          radioButton3 = findViewById(R.id.radioButton3);
          radioButton2 = findViewById(R.id.radioButton2);
          imageView = findViewById(R.id.imageView);
          accept = findViewById(R.id.acceptSetting);
         checkBox1 = findViewById(R.id.temp);
          checkBox2 = findViewById(R.id.pressure1);
          checkBox3 = findViewById(R.id.wind1);
          checkBox4 = findViewById(R.id.wet1);
    }//инициализирует

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.getBoolean(String.valueOf(checkBox1),isChecked1);
        outState.getBoolean(String.valueOf(checkBox2),isChecked2);
        outState.getBoolean(String.valueOf(checkBox3),isChecked3);
        outState.getBoolean(String.valueOf(checkBox4),isChecked4);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        checkBox1.setChecked(savedInstanceState.getBoolean(String.valueOf(checkBox1),isChecked1));
        checkBox2.setChecked(savedInstanceState.getBoolean(String.valueOf(checkBox2),isChecked2));
        checkBox3.setChecked(savedInstanceState.getBoolean(String.valueOf(checkBox3),isChecked3));
        checkBox4.setChecked(savedInstanceState.getBoolean(String.valueOf(checkBox4),isChecked4));
    }
}

