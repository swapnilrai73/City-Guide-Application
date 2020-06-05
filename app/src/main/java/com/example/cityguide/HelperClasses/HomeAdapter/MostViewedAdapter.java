package com.example.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {
    private ArrayList<MostViewedHelperClass> mostviewedLocations;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostviewedLocations){
        this.mostviewedLocations = mostviewedLocations;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MostViewedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewes_carddesign,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
    MostViewedHelperClass mostViewedHelperClass = mostviewedLocations.get(position);
    holder.image.setImageResource(mostViewedHelperClass.getImage());
    holder.title.setText(mostViewedHelperClass.getTitle());
    holder.description.setText(mostViewedHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostviewedLocations.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, description;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.most_image);
            title=itemView.findViewById(R.id.most_title);
            description=itemView.findViewById(R.id.most_description);
        }
    }
}
