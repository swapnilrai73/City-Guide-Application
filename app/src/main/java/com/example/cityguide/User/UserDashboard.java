package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.cityguide.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView featuredRecycler, mostviewedRecycler, categoryRecycler;
    RecyclerView.Adapter adapter1, adapter2, adapter3;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoryRecycler = findViewById(R.id.category_recycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationDrawer();
        featuredRecycler();
        mostviewedRecycler();
        categoryRecycler();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark2));
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void categoryRecycler() {
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CategoryHelperClass> categoryLocations = new ArrayList<>();
        categoryLocations.add(new CategoryHelperClass(R.drawable.dinner, "Restaurant"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.hotel, "Hotel"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.mall, "Mall"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.wine, "Bars/Pubs"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.museum, "Heritage sites"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.fuel, "Gas Station"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.movie, "Cineplex"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.bus_stop, "Bus Stand"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.metro, "metro Stations"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.convenience, "Convenience Store"));
        adapter3 = new CategoryAdapter(categoryLocations);
        categoryRecycler.setAdapter(adapter3);


    }

    private void mostviewedRecycler() {
        mostviewedRecycler.setHasFixedSize(true);
        mostviewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostviewedLocations = new ArrayList<>();
        mostviewedLocations.add(new MostViewedHelperClass(R.drawable.macdss, "McDonald's Flagship", "spacex spacex spacex spacex spacex spacex spacex spacex spacex"));
        mostviewedLocations.add(new MostViewedHelperClass(R.drawable.fifth_ave, "Fifth Avenue", "spacex spacex spacex spacex spacex spacex spacex spacex spacex"));
        mostviewedLocations.add(new MostViewedHelperClass(R.drawable.apple_fifth_ave_hero, "Apple Store", "spacex spacex spacex spacex spacex spacex spacex spacex spacex"));

        adapter2 = new MostViewedAdapter(mostviewedLocations);
        mostviewedRecycler.setAdapter(adapter2);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.apple_fifth_ave_hero, "Apple Store", "spacex spacex spacex spacex spacex spacex"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.fifth_ave, "Fifth Avenue", "spacex spacex spacex spacex spacex spacex"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.macdss, "McDonald's flagship", "spacex spacex spacex spacex spacex spacex"));

        adapter1 = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter1);
    }

}
