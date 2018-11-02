package com.example.adrien.test;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Photo> photos = Collections.emptyList();
    public ImageView imageView;

    public void setPhotos(List<Photo> photos){
        this.photos = photos;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // Create a ViewHolder and inflate its XML layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_items, parent,false);

        return new ViewHolder(view);
    }

    //@Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
       Photo photo = photos.get(position);

        Glide.with(viewHolder.imageView.getContext())
                .load(photo.getUrl())
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {

        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        LinearLayout parent_layout;

        public ViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }

    }
}
