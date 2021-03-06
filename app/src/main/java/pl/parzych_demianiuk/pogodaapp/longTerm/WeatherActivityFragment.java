package pl.parzych_demianiuk.pogodaapp.longTerm;

import android.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;


import pl.parzych_demianiuk.pogodaapp.AboutProgramActivity;
import pl.parzych_demianiuk.pogodaapp.MainActivity;
import pl.parzych_demianiuk.pogodaapp.R;
import pl.parzych_demianiuk.pogodaapp.longTerm.Listener;
import pl.parzych_demianiuk.pogodaapp.longTerm.Manager;
import pl.parzych_demianiuk.pogodaapp.longTerm.WeatherAdapter;

public class WeatherActivityFragment extends Fragment {

    private RecyclerView recyclerView;
    public WeatherActivityFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Manager manager = Manager.getInstance(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForWeather);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        Manager.GetWeather(new Listener<ArrayList>() {
            @Override
            public void onResult(ArrayList object) {

                WeatherAdapter weatherAdapter = new WeatherAdapter(getActivity(), object);
                recyclerView.setAdapter(weatherAdapter);
            }
        }, new Listener() {
            @Override
            public void onResult(Object object) {

            }
        },LongTermActivity.recentCity);
        return view;
    }





}
