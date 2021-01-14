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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private TextView nameCity;
    static String settingKey = "settingKey";
    static String settingKey1 = "settingKey1";
    static String settingKey2 = "settingKey2";
    static String settingKey3 = "settingKey3";
    static String settingKey4 = "settingKey4";
    private String temp;
    private String kPa;
    private String wind;
    private String wet;
    private String city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_window);
        initViews();
        String text = getIntent().getExtras().getString("City");
        nameCity.setText(text);
        checkBoxListener();
        acceptSetting();



    }


    private void acceptSetting() {
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = nameCity.getText().toString();
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

    private void checkBoxListener() {
       checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
               if (checkBox1.isChecked()){
                   isChecked1 = true;
                   temp = "25 C";

               }
           }
       });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (checkBox2.isChecked()){
                    isChecked2 = true;
                    kPa = "99.8 kPa";

                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (checkBox3.isChecked()){
                    isChecked3 = true;
                    wind = "50 m/s";

                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
              if (checkBox4.isChecked()){
                  isChecked4 = true;
                  wet = "57%";

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
          nameCity = findViewById(R.id.nameCity);
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

