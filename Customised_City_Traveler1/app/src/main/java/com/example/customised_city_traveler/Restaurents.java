package com.example.customised_city_traveler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Restaurents extends AppCompatActivity {


    // ArrayList for person names
    ArrayList restNames = new ArrayList<>(Arrays.asList());
    ArrayList restImages = new ArrayList<>(Arrays.asList());
    //ArrayList stime = new ArrayList<>(Arrays.asList());
    ArrayList rid = new ArrayList<>(Arrays.asList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurents2);

        Config s1 = new Config();
        s1.abc();
        s1.api.selectrest(
                "",

                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {


                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String output = reader.readLine();
                            JSONArray jsonArr = new JSONArray(output);
                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);
                                restNames.add(jsonObj.getString("rname").toString());
                                restImages.add(jsonObj.getString("image").toString());
                                // stime.add(jsonObj.getString("stime").toString());
                                rid.add(jsonObj.getString("rid").toString());
                            }
                            // get the reference of RecyclerView
                            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
// set a LinearLayoutManager with default vertical orientaion
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
// call the constructor of CustomAdapter to send the reference and data to Adapter
                            CustomAdapter3 customAdapter3 = new CustomAdapter3(Restaurents.this, restNames, restImages, rid);
                            recyclerView.setAdapter(customAdapter3); // set the Adapter to RecyclerView
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(Restaurents.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}