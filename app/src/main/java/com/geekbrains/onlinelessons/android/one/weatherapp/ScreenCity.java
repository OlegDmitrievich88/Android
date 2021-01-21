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
import androidx.fragment.app.FragmentTransaction;

public class ScreenCity extends AppCompatActivity {

    private EditText editCityName;
    private Button ok;
    private String city;
    static String keyForCity = "city";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city);
        initViews();
        oK();

        ContainerFragment fragment = new ContainerFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fragment,null);


    }

    private void oK() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = editCityName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(keyForCity,city);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    private void initViews() {
        ok = findViewById(R.id.enter);
        editCityName = findViewById(R.id.enterCity);
            }//инициализирует
}
