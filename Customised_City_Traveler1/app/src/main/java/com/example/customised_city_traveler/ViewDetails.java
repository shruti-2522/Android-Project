package com.example.customised_city_traveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebView w1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);


        w1=(WebView) findViewById(R.id.w1);
        w1.getSettings().setJavaScriptEnabled(true);;
        w1.setWebViewClient(new WebViewClient());

        w1.loadUrl(Config.ROOT_URL+"Admin/booking.php?id="+Config.uid+"&hid="+getIntent().getExtras().getString("id"));


    }
}