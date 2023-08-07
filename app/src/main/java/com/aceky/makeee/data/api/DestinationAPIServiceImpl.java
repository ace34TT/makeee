package com.aceky.makeee.data.api;

import com.aceky.makeee.model.destination.Hotel;
import com.aceky.makeee.model.destination.Province;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DestinationAPIServiceImpl {
    @GET("destination/province/{provinceName}")
    Call<Province> getProvince (@Path("provinceName") String provinceName);
    @GET("destination/search/{search_text}")
    Call<ArrayList<Hotel>> findHotel (@Path("search_text") String search_text);
}
