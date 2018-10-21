package com.example.qenawy.soleeklab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.jar.Attributes;

public class Countries {

    @SerializedName("Name")
    @Expose
    private String name;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
