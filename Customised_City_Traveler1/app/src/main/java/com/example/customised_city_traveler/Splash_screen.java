package com.example.customised_city_traveler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_screen extends AppCompatActivity {
    //variables
    private  static  int SPLASH_TIMER=5000;
    ImageView backgroundImage;
    TextView poweredByLine;
    Animation sideAnim,bottom_anim;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Hooks
        backgroundImage=findViewById(R.id.background_image);
        //poweredByLine=findViewById(R.id.powered_by);

        //animations
        sideAnim= AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //Set Animations
        backgroundImage.setAnimation(sideAnim);
        //poweredByLine.setAnimation(bottom_anim);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(Splash_screen.this, Registration.class);
              startActivity(intent);
              finish();
          }
      },SPLASH_TIMER);
    }
}



