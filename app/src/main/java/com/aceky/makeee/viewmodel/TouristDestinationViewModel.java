package com.aceky.makeee.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aceky.makeee.model.TouristDestination;

import java.util.List;

public class TouristDestinationViewModel  extends ViewModel {
    MutableLiveData<List<TouristDestination>> destinations ;
    public LiveData<List<TouristDestination>> getTouristDestination() {
        if (destinations == null) {
            destinations = new MutableLiveData<List<TouristDestination>>();
        }
        return destinations;
    }
}
