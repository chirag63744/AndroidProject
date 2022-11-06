package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class order_food extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b,b1,b2,b4;
    String data;
   ArrayList<String>items=new ArrayList<>();
    int i=1;
    EditText e;
    int price,count=0;
    TextView t;
    FirebaseDatabase root;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Food, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        b = findViewById(R.id.button);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        e=(EditText)findViewById(R.id.editTextTextPersonName);
        t=(TextView)findViewById(R.id.textView7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                t.setText(""+count);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0)
                {
                count=count-1;
                }
                else
                    count=0;

                t.setText(""+count);
            }
        });


            b.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    root=FirebaseDatabase.getInstance();
                    ref=root.getReference("Regno");

                    userhelper help=new userhelper(data,count,price*count);
                    ref.child(e.getText().toString()).child("item"+i).setValue(help);
                    i=i+1;

                    t.setText(""+0);

                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(order_food.this,view_order.class);
                    intent.putExtra("regno",e.getText().toString());
                    intent.putExtra("itemss",items);
                    startActivity(intent);



                }
            });




    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        data = parent.getItemAtPosition(position).toString();
        items.add(data);
        int[]rate={10,20,35,55,120,140,40,30,40,25,200,160,90,94,69,45};
        String[] Order = getResources().getStringArray(R.array.Food);
        for (int i = 0; i < 16; i++) {
            if (data.equals(Order[i])) {
                price = rate[i];
            }
            else
            {
                //do nothing
            }

        }
        count=0;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}





















