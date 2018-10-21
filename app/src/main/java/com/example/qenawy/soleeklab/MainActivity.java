package com.example.qenawy.soleeklab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
  ///  FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference myRef = database.getReference("message");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      getSupportFragmentManager().beginTransaction().replace(R.id.container,new LoginFragment()).commit();
    }


       // myRef.setValue("Hello, World!");

    }
//    ValueEventListener postListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            // Get Post object and use the values to update the UI
//           // Post post = dataSnapshot.getValue(Post.class);
//            String value = dataSnapshot.getValue(String.class);
//            Log.d("TAG", "Value is: " + value);
//            // ...
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//            // Getting Post failed, log a message
//            Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
//            // ...
//        }
//    };

