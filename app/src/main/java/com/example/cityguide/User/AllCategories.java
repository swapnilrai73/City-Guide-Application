package com.example.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cityguide.R;

public class AllCategories extends AppCompatActivity {
ImageView backPress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        backPress=findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllCategories.this,UserDashboard.class);
                startActivity(i);
            }
        });
    }
}
