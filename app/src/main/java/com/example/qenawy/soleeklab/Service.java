package com.example.qenawy.soleeklab;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    String Baseurl="http://countryapi.gear.host/v1/Country/";
    @GET("getCountries")
    Call<RetrofitResponse> getcountries();

}
