package com.example.qenawy.soleeklab;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
EditText Email,password;
Button login,register;
boolean isVerified ;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_pass);
        login = view.findViewById(R.id.bt_login);
        register = view.findViewById(R.id.bt_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getmultidata( Email.getText().toString(),password.getText().toString());

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new RegstrationFragment()).commit();

            }
        });
    }

    private void getmultidata(final String email, final String password){
        FirebaseDatabase.getInstance().getReference().child("registration").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                while (iterable.iterator().hasNext())
                {
                    data d = iterable.iterator().next().getValue(data.class);
                    if (d.getEmail().equals(email) && d.getPassword().equals(password)) {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment2()).commit();
                        break;
                    }
                    else if(!iterable.iterator().hasNext())
                    {
                        Toast.makeText(getActivity(),"Please enter correct email and password",Toast.LENGTH_SHORT).show();
                    }
                }
//                for(DataSnapshot snapshot:dataSnapshot.getChildren())
//                {
//                    data d=snapshot.getValue(data.class);
//                    if(d.getEmail().equals(email)&&d.getPassword().equals(password))
//                    {
//                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment2()).commit();
//                        break;
//                    }
//
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(),"oncancel error",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
