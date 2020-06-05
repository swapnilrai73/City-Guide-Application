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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<CategoryHelperClass> categoryLocations;

    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryLocations) {
        this.categoryLocations = categoryLocations;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_carddesign, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass categoryHelperClass = categoryLocations.get(position);
        holder.title.setText(categoryHelperClass.getTitle());
        holder.image.setImageResource(categoryHelperClass.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryLocations.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);
        }
    }
}
