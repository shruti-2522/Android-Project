package com.example.customised_city_traveler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {


    ArrayList personImages;
    ArrayList price;
    ArrayList hid;
    ArrayList rqty;
    ArrayList total;
    Context context;

    public CustomAdapter2(Context context,  ArrayList price, ArrayList hid,ArrayList rqty,ArrayList total) {
        this.context = context;

        this.price = price;
        this.hid=hid;
        this.rqty=rqty;
        this.total=total;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_2, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.hid.setText(hid.get(position).toString());
          holder.price.setText(price.get(position).toString());
        holder.rqty.setText(rqty.get(position).toString());
        holder.total.setText(total.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// open another activity on item click
              Intent intent = new Intent(context, ViewDetails.class);
              intent.putExtra("id",hid.get(position).toString().trim());
        context.startActivity(intent); // start Intent
            }
        });
    }



    @Override
    public int getItemCount() {
        return hid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView hid,rqty,total;

        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            hid = (TextView) itemView.findViewById(R.id.id);
            rqty = (TextView) itemView.findViewById(R.id.txtrqty);
            total = (TextView) itemView.findViewById(R.id.txttotal);

            price = (TextView) itemView.findViewById(R.id.price);

        }
    }
}