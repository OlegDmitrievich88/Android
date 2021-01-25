package com.geekbrains.onlinelessons.android.one.weatherapp;

public class Container {
    String text;

    private static Container instance;
    private Container(){};
    static Container getInstance(){
        if(instance == null) instance = new Container();
        return instance;


    };
}
