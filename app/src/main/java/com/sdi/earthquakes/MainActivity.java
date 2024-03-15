package com.sdi.earthquakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getEqList().observe(this, eqList->{
            for(Earthquake eq : eqList){
                Log.d("eq", eq.getMagnitude()+" "+eq.getPlace());
            }
        });

        viewModel.getEartquakes();
    }
}