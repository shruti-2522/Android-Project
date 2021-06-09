package com.example.customised_city_traveler;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class viewHotel extends AppCompatActivity {
    mylib l1=new mylib();
    Spinner spinner;
    TextView t1,t2,t3,t4,t5;
    Button b1,b2;
    ImageView image;
    Context context;
    EditText edt;
    DatePickerDialog datePickerDialog;

    EditText chooseTime;
    TimePickerDialog timePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hotel);
        image = (ImageView) findViewById(R.id.image);
        t1=(TextView)findViewById(R.id.txtname);
        t2=(TextView)findViewById(R.id.txtstime);
        t3=(TextView)findViewById(R.id.txtetime);
        t4=(TextView)findViewById(R.id.txtaddr);
        t5=(TextView)findViewById(R.id.txtprice);
        b1=(Button) findViewById(R.id.btnaddroom);
        b2=(Button) findViewById(R.id.btnnext);
        edt=findViewById(R.id.edt);
        chooseTime = findViewById(R.id.etChooseTime);

        Calendar calendar=Calendar.getInstance();
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);




        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog=new DatePickerDialog(viewHotel.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }

        });


        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(viewHotel.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        chooseTime.setText(hourOfDay+":"+(minutes));
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }


        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookroom();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(viewHotel.this,viewRoom.class);
                startActivity(i1);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        show();


    }
    public void bookroom() {
        Config s1 = new Config();
        s1.abc();
        s1.api.bookroom(
                ""+getIntent().getExtras().get("id"),
                ""+Config.uid,""+spinner.getSelectedItem().toString(), edt.getText().toString(),chooseTime.getText().toString(),

                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {


                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String output = reader.readLine();
                            if(output.equals("1")) {
                                l1.showpopup(viewHotel.this, "Rooms added", "Success");
                                // get the reference of RecyclerView
                            }
                            else
                            {
                                l1.showpopup(viewHotel.this, ""+output, "Failed");

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(viewHotel.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void show() {
        Config s1 = new Config();
        s1.abc();
        s1.api.selecthotelsdetails(""+getIntent().getExtras().get("id"),



                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {


                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String output = reader.readLine();
                            // Toast.makeText(ViewHotel.this, "" + output, Toast.LENGTH_SHORT).show();
                            JSONArray jsonArr = new JSONArray(output);
                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);


                                t1.setText(jsonObj.getString("hname").toString());
                                t2.setText(jsonObj.getString("stime").toString());
                                t3.setText(jsonObj.getString("etime").toString());
                                t4.setText(jsonObj.getString("addr").toString());
                                t5.setText(jsonObj.getString("price").toString());
                                String path=jsonObj.getString("image").toString();
                                Picasso.with(context).load(Config.ROOT_URL+"Admin/image/"+path).fit().centerInside().into(image);

                                //t7.setText(jsonObj.getString("hid").toString());

                            }//for
                            // get the reference of RecyclerView

                        } //try
                        catch (Exception e) {
                            e.printStackTrace();
                        }//catch

                    }//sucess

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(viewHotel.this, error.toString(), Toast.LENGTH_LONG).show();
                    }

                }

        );



    }


}