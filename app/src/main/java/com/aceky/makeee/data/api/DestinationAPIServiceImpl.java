package com.aceky.makeee.data.api;

import com.aceky.makeee.model.destination.Province;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DestinationAPIServiceImpl {
    @GET("destination/province/{provinceName}")
    Call<Province> getProvince (@Path("provinceName") String provinceName);
}
