package com.example.androidproject;

import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView Order,table,history,feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Order=findViewById(R.id.imageView);
        table=findViewById(R.id.imageView2);
        history=findViewById(R.id.imageView3);
        feedback=findViewById(R.id.imageView4);
        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,order_food.class);
                startActivity(intent);

            }
        });




    }
}