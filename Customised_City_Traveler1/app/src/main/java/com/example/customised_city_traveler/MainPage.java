package com.example.customised_city_traveler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {
  CardView  hotel;
  CardView rest;
  CardView temp;
  CardView malls;
  CardView parks;
  CardView musiam;
    CardView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hotel=(CardView) findViewById(R.id.hotel);
        rest=(CardView) findViewById(R.id.rest);
         temp=(CardView) findViewById(R.id.temp);
         malls=(CardView) findViewById(R.id.malls);

        musiam=(CardView) findViewById(R.id.musiam);
        parks=(CardView) findViewById(R.id.parks);
        map=(CardView) findViewById(R.id.map);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainPage.this,Hotels.class));
            }
        });

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Restaurents.class));
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Temples.class));
            }
        });


        malls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Malls.class));
            }
        });

        musiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Musiam.class));
            }
        });
        parks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Parks.class));
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Map.class));
            }
        });









    }
}