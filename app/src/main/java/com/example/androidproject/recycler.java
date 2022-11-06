package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    RecyclerView recyclerView;

    adapter_rec myAdapter;
    ArrayList<user>list;
    DatabaseReference database;
    String regn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Intent i=getIntent();
        regn=i.getStringExtra("regno");
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter =new adapter_rec(this,list);
        recyclerView.setAdapter(myAdapter);
         database= FirebaseDatabase.getInstance().getReference("Regno/"+regn+"/item1");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        user u = dataSnapshot.getValue(user.class);
                        list.add(u);
                    }
                }
                else
                {
                    Intent intent=new Intent(recycler.this,order_food.class);
                    //intent.putExtra("regno",e.getText().toString());
                    startActivity(intent);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}