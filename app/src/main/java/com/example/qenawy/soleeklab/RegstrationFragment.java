package com.example.qenawy.soleeklab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegstrationFragment extends Fragment {
    EditText Email,password,passconfirm;
    Button btnregister;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("registration");
    public RegstrationFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_regstration, container, false);
        Email=v.findViewById(R.id.et_email);
        password=v.findViewById(R.id.et_pass);
        btnregister=v.findViewById(R.id.bt_register);
        passconfirm=v.findViewById(R.id.et_confirmpass);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(passconfirm.getText().toString())&&Email.getText().toString()!=null)
                {
                    Toast.makeText(getActivity(),"iam here",Toast.LENGTH_SHORT).show();
                    data d=new data(Email.getText().toString(),password.getText().toString());
                    myRef.push().setValue(d);
                    ///////////go to home
                    Fragment fragment = new HomeFragment2 ();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);

                    fragmentTransaction.commit();
                }
               else
                {
                    Toast.makeText(getActivity(),"Please make sure you filled all fields correctly",Toast.LENGTH_SHORT).show();

                }
            }
        });
   return v; }


    }



