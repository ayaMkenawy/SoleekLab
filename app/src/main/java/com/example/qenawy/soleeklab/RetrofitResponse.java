package com.example.qenawy.soleeklab;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrofitResponse {

    @SerializedName("Response")
    List<Countries> countries;

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }
}
