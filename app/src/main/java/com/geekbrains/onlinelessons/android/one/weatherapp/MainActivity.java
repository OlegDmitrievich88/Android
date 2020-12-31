package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
      private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        Button();

    }



    private void Button(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScreenCity.class);
        startActivity(intent);
            }
        });
    }

    private void initViews() {
          button = findViewById(R.id.button1);
    }//инициализирует

//    public void createNewWindow(View view) {
//        Intent intent = new Intent(this, ScreenCity.class);
//        startActivity(intent);
//    }
}
