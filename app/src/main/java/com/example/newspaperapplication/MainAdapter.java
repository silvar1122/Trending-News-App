package com.example.newspaperapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Model2>category;
    private LayoutInflater layoutInflater;

    public MainAdapter(Context context, ArrayList<Model2> category) {
        this.context = context;
        this.category = category;
    }

    @Override
    public int getCount() {
        return category.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Model2 model2=category.get(position);

        if(layoutInflater==null){
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.row_item2,null);
        }
        ImageView imageView=convertView.findViewById(R.id.the_image);
        TextView textView=convertView.findViewById(R.id.the_title);
        CardView the_card=convertView.findViewById(R.id.the_card);

        imageView.setImageResource(model2.getThe_image());
        textView.setText(model2.getTitle());
        the_card.setCardBackgroundColor(Color.parseColor(model2.getBackground()));
        return convertView;


    }
}
