package com.geekbrains.onlinelessons.android.one.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      private Button button;
      private static final String tag = "activity";
      private static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "hello man",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Create");
        initViews();
        Button();
        //setImageView();

    }

    public void setImageView() {
        imageView.setImageDrawable(getDrawable(R.drawable.winter));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "start",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "resume",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "pause",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "stop",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "restart",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroy",Toast.LENGTH_SHORT).show();
        Log.d(tag,"Destroy");
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
          imageView = findViewById(R.id.imageView);
    }//инициализирует


}
