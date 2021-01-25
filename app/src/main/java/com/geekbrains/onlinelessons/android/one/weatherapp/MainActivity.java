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
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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

    }//инициализирует


}
