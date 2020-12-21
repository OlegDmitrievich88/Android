package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButton3;
    private RadioButton radioButton2;
    private ImageView imageView;
    private TextView city;
    private Button button;
    private EditText text;
    private Button buttonTwo;
    private EditText day;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        setRadioButton();
        setCity();
        setData();
    }

    private void setData() {
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                data.setText(day.getText().toString());
            }
        });
    }

    private void setCity() {
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
               city.setText(text.getText().toString());
            }
        });
    }

    private void setRadioButton() {
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getDrawable(R.drawable.summer));
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getDrawable(R.drawable.winter));
            }
        });
    }

    private void initViews() {
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        city = findViewById(R.id.textView3);
        text = findViewById(R.id.editText);
        buttonTwo = findViewById(R.id.button2);
        day = findViewById(R.id.editTextDate);
        data = findViewById(R.id.textViewData);
    }
}