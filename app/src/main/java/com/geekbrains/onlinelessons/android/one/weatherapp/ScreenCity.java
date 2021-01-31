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

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ScreenCity extends AppCompatActivity {


    private String city;
    static String keyForCity = "city";
    private TextInputEditText cityMaterial;
    private MaterialButton buttonOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city);
        initViews();
        materialButton();

        ContainerFragment fragment = new ContainerFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fragment,null);

    }



    private void materialButton() {
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = cityMaterial.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(keyForCity,city);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    private void initViews() {


        cityMaterial = findViewById(R.id.inputLoginCity);
        buttonOk = findViewById(R.id.accept);
            }//инициализирует
}
