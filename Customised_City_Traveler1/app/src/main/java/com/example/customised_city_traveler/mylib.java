package com.example.customised_city_traveler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;


public class mylib extends Activity {
    public void showpopup(Context context,String Title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }
}