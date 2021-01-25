package com.geekbrains.onlinelessons.android.one.weatherapp;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;


public class ContainerFragment extends Fragment {
    private ListView listCity;// список
    private TextView nameCity;// имена


    private boolean orientation;// чтобы понять какая ориентация
    private int selectedCity = 0;// позиция в списке

    @Nullable
    @Override//создали фпагмент
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_for_city,container,false);
    }
    @Override//подключили
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

             initViews(view);// метод тнтцтализации вьюх
             initList();//
    }

    private void initList() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.city,android.R.layout.simple_list_item_activated_1);
        listCity.setAdapter(adapter);
        listCity.setEmptyView(nameCity);
        listCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                listCity.setItemChecked(pos, true);// почкму-то не работает
            if(pos == 0){
                FragmentForCityOne sun = new FragmentForCityOne();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentChange,sun);
                transaction.commit();
            }else if(pos == 1){
                FragmentVulkan vul = new FragmentVulkan();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentChange,vul);
                transaction.commit();
            }else if(pos == 2){
                FragmentRain rain = new FragmentRain();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentChange,rain);
                transaction.commit();
            }else if(pos == 3){
                FragmentTornado tornado = new FragmentTornado();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentChange,tornado);
                transaction.commit();
            }else if(pos == 4){
                FragmentSnow snow = new FragmentSnow();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentChange,snow);
                transaction.commit();
            }


            }
        });
    }



    private void initViews(View view) {
       listCity = view.findViewById(R.id.list); // инициализировали список
        nameCity = view.findViewById(R.id.listCityName);// инициализировали название

    }

}







