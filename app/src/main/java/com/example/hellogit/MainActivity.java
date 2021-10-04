package com.example.hellogit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hellogit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.slider_pager);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.img_1,"Slide Title /nmore text here"));
        lstSlides.add(new Slide(R.drawable.img_2,"Slide Title /nmore text here"));
        lstSlides.add(new Slide(R.drawable.img_1,"Slide Title /nmore text here"));
        lstSlides.add(new Slide(R.drawable.img_2,"Slide Title /nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);
    }
}