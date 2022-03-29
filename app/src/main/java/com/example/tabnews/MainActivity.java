package com.example.tabnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        // Add Fragment
        adapter.AddFragment(new FragmentAll(), "All");
        adapter.AddFragment(new FragmentSports(), "Sports");
        adapter.AddFragment(new FragmentScience(), "Science");
        adapter.AddFragment(new FragmentTechnology(), "Technology");
        adapter.AddFragment(new FragmentBusiness(), "Business");
        adapter.AddFragment(new FragmentEntertainment(), "Entertainment");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}