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

public class viewRoom extends AppCompatActivity {
    ArrayList price = new ArrayList<>(Arrays.asList());
    ArrayList hid = new ArrayList<>(Arrays.asList());
    ArrayList rqty = new ArrayList<>(Arrays.asList());
    ArrayList totalp = new ArrayList<>(Arrays.asList());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room);
        Config s1=new Config();
        s1.abc();
        s1.api.viewRoom(
                ""+Config.uid,

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

                                rqty.add(jsonObj.getString("rqty").toString());
                                price.add(jsonObj.getString("price").toString());
                                hid.add(jsonObj.getString("hname").toString());
                                int total=Integer.parseInt(jsonObj.getString("price"))*Integer.parseInt((jsonObj.getString("rqty")));
                                //
                                totalp.add(total+"");
                                //Toast.makeText(ViewRoom.this, totalp+"",Toast.LENGTH_LONG).show();

                            }
                            // get the reference of RecyclerView
                            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
// set a LinearLayoutManager with default vertical orientaion
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
// call the constructor of CustomAdapter to send the reference and data to Adapter
                            CustomAdapter2 customAdapter = new CustomAdapter2(viewRoom.this,price,hid,rqty,totalp);
                            recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(viewRoom.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
