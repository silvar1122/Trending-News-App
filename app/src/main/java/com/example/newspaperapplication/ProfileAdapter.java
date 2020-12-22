package com.example.newspaperapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.viewHolder> {
    ArrayList<ProfileModal>profileModals;
    Context context;

    public ProfileAdapter(ArrayList<ProfileModal> profileModals, Context context) {
        this.profileModals = profileModals;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.profile_item_layout,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ProfileModal profileModal=profileModals.get(position);
        holder.profile_image.setImageResource(profileModal.getIcon());
        holder.title.setText(profileModal.getTitle());
        holder.description.setText(profileModal.getDescription());

    }

    @Override
    public int getItemCount() {
        return profileModals.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView profile_image;
        TextView title, description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image=itemView.findViewById(R.id.icon_image);
            title=itemView.findViewById(R.id.icon_title);
            description=itemView.findViewById(R.id.icon_description);
        }
    }
}
