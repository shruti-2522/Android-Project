package com.example.customised_city_traveler;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class CustomAdapter7 extends RecyclerView.Adapter<CustomAdapter7.MyViewHolder> {

    ArrayList parkName;
    ArrayList parkImages;
    //ArrayList stime;
    ArrayList pid;
    Context context;
    ImageView image;

    public CustomAdapter7(Context context, ArrayList parkName, ArrayList parkImages, ArrayList pid) {
        this.context = context;
        this.parkName = parkName;
        this.parkImages =parkImages;
        //this.stime = stime;
        this.pid=pid;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout7, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(parkName.get(position).toString());
        String path=parkImages.get(position).toString();
        Picasso.with(context).load(Config.ROOT_URL+"Admin/image/"+path).fit().centerInside().into(image);
        //holder.image.setImageResource(Integer.parseInt(personImages.get(position).toString()));
        //holder.stime.setText(stime.get(position).toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// open another activity on item click
                Intent intent = new Intent(context, viewPark.class);
                intent.putExtra("id",pid.get(position).toString().trim());
                context.startActivity(intent); // start Intent
            }
        });
    }



    @Override
    public int getItemCount() {
        return parkName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // init the item view's
        TextView name;

        TextView stime;

        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

            //stime = (TextView) itemView.findViewById(R.id.stime);

        }
    }
}