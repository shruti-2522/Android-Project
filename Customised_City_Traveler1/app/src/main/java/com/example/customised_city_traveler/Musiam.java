package com.example.customised_city_traveler;



import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Musiam extends AppCompatActivity {


    // ArrayList for person names
    ArrayList musiamName = new ArrayList<>(Arrays.asList());
    // ArrayList personImages = new ArrayList<>(Arrays.asList());

    ArrayList musiamImages = new ArrayList<>(Arrays.asList());
    //ArrayList stime = new ArrayList<>(Arrays.asList());
    ArrayList musiam_id = new ArrayList<>(Arrays.asList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiam);

        Config s1=new Config();
        s1.abc();
        s1.api.selectmusiams(
                "",

                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {


                        try {
                            BufferedReader reader =new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String  output = reader.readLine();
                            JSONArray jsonArr = new JSONArray(output);
                            for (int i = 0; i < jsonArr.length(); i++)
                            {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);
                                musiamImages.add(jsonObj.getString("image").toString());
                                musiamName.add(jsonObj.getString("mname").toString());
                                // stime.add(jsonObj.getString("stime").toString());
                                musiam_id.add(jsonObj.getString("musiam_id").toString());
                            }
                            // get the reference of RecyclerView
                            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
// set a LinearLayoutManager with default vertical orientaion
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
// call the constructor of CustomAdapter to send the reference and data to Adapter
                            CustomAdapter5 customAdapter5 = new CustomAdapter5(Musiam.this, musiamName,musiamImages,musiam_id);
                            recyclerView.setAdapter(customAdapter5); // set the Adapter to RecyclerView
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(Musiam.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}