package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.geekbrains.onlinelessons.android.one.weatherapp.SettingForCity.settingKey;

public class MainActivity extends AppCompatActivity {
      private Button button;
      private Button buttonGoogle;
      private static final String tag = "activity";
      private ImageView imageView;
      private TextView temp;
      private TextView kPa;
      private TextView wind;
      private TextView wet;
      private TextView city;
      private static final int requestCodeSet = 1234;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "hello man",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Create");
        initViews();
        //set();
        ButtonGoogle();
        Button();
        //setImageView();

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
    }

    private void set() {
        Container container = (Container) getIntent().getExtras().getSerializable("settingKey");
        temp.setText(container.temp);
        kPa.setText(container.kPa);
        wind.setText(container.wind);
        wet.setText(container.wet);
        city.setText(container.city);
    }

    public void setImageView() {
        imageView.setImageDrawable(getDrawable(R.drawable.winter));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "SETTING",Toast.LENGTH_SHORT).show();
        if (requestCode == requestCodeSet && resultCode == RESULT_OK) {

            city.setText(data.getStringExtra(ScreenCity.settingKey));
            temp.setText(data.getStringExtra(ScreenCity.settingKey1));
            kPa.setText(data.getStringExtra(ScreenCity.settingKey2));
            wind.setText(data.getStringExtra(ScreenCity.settingKey3));
            wet.setText(data.getStringExtra(ScreenCity.settingKey4));

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

    }//инициализирует


}
