package com.example.customised_city_traveler;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViewTemples extends AppCompatActivity {
    mylib l1=new mylib();
    TextView t1,t2,t3,t4;
    Button b1,b2;
    ImageView image;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_temples);
        image = (ImageView) findViewById(R.id.image);
        t1=(TextView)findViewById(R.id.txtname);
        t2=(TextView)findViewById(R.id.txtstime);
        t3=(TextView)findViewById(R.id.txtetime);
        t4=(TextView)findViewById(R.id.txtaddr);
        show();
    }



    public void show() {
        Config s1 = new Config();
        s1.abc();
        s1.api.selecttempledetails(""+getIntent().getExtras().get("id"),

                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {


                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String output = reader.readLine();

                            JSONArray jsonArr = new JSONArray(output);
                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);
                                t1.setText(jsonObj.getString("temp_name").toString());
                                t2.setText(jsonObj.getString("otime").toString());
                                t3.setText(jsonObj.getString("ctime").toString());
                                t4.setText(jsonObj.getString("loc").toString());
                                String path=jsonObj.getString("image").toString();
                                Picasso.with(context).load(Config.ROOT_URL+"Admin/image/"+path).fit().centerInside().into(image);
                            }//for
                            // get the reference of RecyclerView

                        } //try
                        catch (Exception e) {
                            e.printStackTrace();
                        }//catch

                    }//sucess

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(ViewTemples.this, error.toString(), Toast.LENGTH_LONG).show();
                    }

                }

        );



    }


}