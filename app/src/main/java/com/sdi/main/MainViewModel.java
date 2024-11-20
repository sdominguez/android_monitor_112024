package com.sdi.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sdi.Earthquake;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<List<Earthquake>> eqList = new MutableLiveData<>();
    private MainRepository repository = new MainRepository();

    public LiveData<List<Earthquake>> getEqList(){
        return eqList;
    }

    List<Earthquake> list = new ArrayList<>();



    public void getEarthquakes(){
        repository.getEarthquakes(earthquakeList -> {
            eqList.setValue(earthquakeList);
        });
        /*
        list.add(new Earthquake("aaaa","CDMX",4.0,12365498L,105.23,98.127));
        list.add(new Earthquake("bbbb","La Paz",1.8,12365498L,105.23,98.127));
        list.add(new Earthquake("cccc","Barcelona",0.5,12365498L,105.23,98.127));
        list.add(new Earthquake("dddd","Buenos Aires",3.7,12365498L,105.23,98.127));
        list.add(new Earthquake("eeee","Washington D.C",2.8,12365498L,105.23,98.127));
        eqList.setValue(list);
        */
    }


}
