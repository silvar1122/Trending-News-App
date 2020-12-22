package com.example.newspaperapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.viewHolder>{
    Context context;
    ArrayList<Model>theDays;

    public MyRecyclerAdapter(Context context, ArrayList<Model> theDays) {
        this.context = context;
        this.theDays = theDays;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        Model model=theDays.get(position);
        holder.the_image.setImageResource(model.getThe_image());
        holder.description.setText(model.getDescription());
        holder.date.setText(model.getDate());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent=new Intent(context,Fruits.class);
                    context.startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(context,Series.class);
                    context.startActivity(intent);

                }
                else if(position==2){
                    Intent intent=new Intent(context,Coronavirus.class);
                    context.startActivity(intent);

                }
                else {
                    Intent intent=new Intent(context,Infinix.class);
                    context.startActivity(intent);

                }
            }
        });





    }

    @Override
    public int getItemCount() {
        return theDays.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView description,date;
        ImageView the_image;
        LinearLayout linearLayout;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            description=itemView.findViewById(R.id.description);
            date=itemView.findViewById(R.id.date);
            the_image=itemView.findViewById(R.id.the_image);
            linearLayout=itemView.findViewById(R.id.the_news);

        }
    }
}
