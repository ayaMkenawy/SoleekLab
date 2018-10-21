package com.example.qenawy.soleeklab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment2 extends Fragment {
    Button logout;
    ListView listView;
    public ArrayList<Countries> arrayList = new ArrayList<Countries>();
    public ArrayAdapter adapter;

    public HomeFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        logout = view.findViewById(R.id.btnlogout);

        listView = view.findViewById(R.id.country_list);
        adapter = new ArrayAdapter<Countries>(getContext(),android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).commit();

            }
        });


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.Baseurl)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        Service service = retrofit.create(Service.class);
        service.getcountries().enqueue(new Callback<RetrofitResponse>() {
            @Override
            public void onResponse(Call<RetrofitResponse> call, Response<RetrofitResponse> response) {

                arrayList.addAll(response.body().getCountries());
                adapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(Call<RetrofitResponse> call, Throwable t) {

            }
        });

        return view;
    }

}



