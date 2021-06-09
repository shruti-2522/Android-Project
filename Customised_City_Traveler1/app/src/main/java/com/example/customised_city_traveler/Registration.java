package com.example.customised_city_traveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Registration extends AppCompatActivity  implements View.OnClickListener{

    mylib l1=new mylib();
    EditText t1,t2,t3;
    Button b1;
    TextView e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void init() {
        t1=(EditText)findViewById(R.id.name);
        t2=(EditText)findViewById(R.id.email);
        t3=(EditText)findViewById(R.id.password);
        b1=(Button) findViewById(R.id.register_button);
        e1=(TextView)findViewById(R.id.login);
        b1.setOnClickListener(this);
        e1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register_button:
                Config s1=new Config();
                s1.abc();
                s1.api.insertUser(
                        t1.getText().toString(),
                        t2.getText().toString(),
                        t3.getText().toString(),

                        new Callback<Response>() {
                            @Override
                            public void success(Response result, Response response) {

                                try {

                                    BufferedReader reader =new BufferedReader(new InputStreamReader(result.getBody().in()));
                                    String  output = reader.readLine();
                                    if(output.equals("1"))
                                    {
                                        l1.showpopup(Registration.this,"Error","Check the values");

                                    }
                                    else
                                    {
                                        l1.showpopup(Registration.this,"Success","Records Inserted Successfull");

                                        Intent i1=new Intent(Registration.this,login.class);
                                        startActivity(i1);
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(Registration.this, error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                );
                break;
            case R.id.login:
                Intent i1=new Intent(Registration.this,login.class);
                startActivity(i1);
                break;
        } }
}