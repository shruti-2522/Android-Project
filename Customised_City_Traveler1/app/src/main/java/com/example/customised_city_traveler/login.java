package com.example.customised_city_traveler;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class login extends AppCompatActivity implements View.OnClickListener {
    mylib l1=new mylib();
    EditText t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        t1=(EditText)findViewById(R.id.email);
        t2=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.login_button);
        b1.setOnClickListener(this);
        t1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login_button:
                Config s1=new Config();
                s1.abc();
                s1.api.loginUser(
                        t1.getText().toString(),
                        t2.getText().toString(),


                        new Callback<Response>() {
                            @Override
                            public void success(Response result, Response response) {

                                try {

                                    BufferedReader reader =new BufferedReader(new InputStreamReader(result.getBody().in()));
                                    String  output = reader.readLine();
                                    if(output.equals("1"))
                                    {
                                        l1.showpopup(login.this,"Error","Invalid Credetials");
                                    }
                                    else
                                    {
                                        l1.showpopup(login.this,"Success","Login Successfull");
                                        Config.uid=output;


                                        Intent i1=new Intent(login.this,MainActivity2.class);
                                        startActivity(i1);

                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(login.this, error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                );
                break;
            case R.id.login:
                Intent i1=new Intent(login.this,MainActivity2.class);
                startActivity(i1);
                break;

        }

    }

}


