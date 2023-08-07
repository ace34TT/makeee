package com.aceky.makeee.view.screens.mainscreen.ui.details;

import androidx.lifecycle.ViewModel;

import com.aceky.makeee.data.repository.DestinationRepository;
import com.aceky.makeee.model.destination.Province;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

public class ProvinceDetailsViewModel extends ViewModel {
    DestinationRepository repository = new DestinationRepository();

    // TODO: Implement the ViewModel
    public void getProvince(String provinceName , ApiResponseCallback<Province> callback ) {
        repository.handleFindProvince(provinceName, callback);
    }
}