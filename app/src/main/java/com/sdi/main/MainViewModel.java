package com.sdi.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sdi.Earthquake;
import com.sdi.api.RequestStatus;
import com.sdi.api.StatusWithDescription;
import com.sdi.database.EqDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        EqDatabase database = EqDatabase.getDatabase(application);
        repository = new MainRepository(database);
    }

    private MutableLiveData<StatusWithDescription> statusMutableLiveData = new MutableLiveData<>();

    public LiveData<List<Earthquake>> getEqList(){
        return repository.getEqList();
    }

    public LiveData<StatusWithDescription> getStatusMutableLiveData(){
        return statusMutableLiveData;
    }


    public void downloadEarthquakes(){
        statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.LOADING,""));
        repository.downloadAndSaveEarthquakes(new MainRepository.DownloadStatusListener() {
            @Override
            public void downloadSuccess() {
                statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.DONE,""));
            }

            @Override
            public void downloadError(String message) {
                statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.LOADING, message));
            }
        });
    }


}
