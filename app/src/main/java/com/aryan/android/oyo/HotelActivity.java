package com.aryan.android.oyo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mancj.slideup.SlideUp;

public class HotelActivity extends AppCompatActivity {

    RecyclerView mHotelImagesRecyclerView;
    HotelImageAdapter mAdapter;
    Toolbar toolbar;
    FloatingActionButton fab;
    private SlideUp slideUp;
    private View dim;
    private View slideView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        toolbar = (Toolbar) findViewById(R.id.hotel_tool_bar);
        setSupportActionBar(toolbar);

        int[] mHotelImages= {
                R.drawable.room,
                R.drawable.room1,
                R.drawable.room2,
                R.drawable.room3,
                R.drawable.room4,
                R.drawable.room5,
                R.drawable.room6,
                R.drawable.room7,
                R.drawable.room8 };

        mHotelImagesRecyclerView = (RecyclerView) findViewById(R.id.hotel_recycler_view);
        mAdapter = new HotelImageAdapter(this, mHotelImages);
        mHotelImagesRecyclerView.setAdapter(mAdapter);
        mHotelImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        slideView = findViewById(R.id.slideView);
        dim = findViewById(R.id.dim);

        slideUp = new SlideUp(slideView);
        slideUp.hideImmediately();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideUp.animateIn();
                fab.hide();
            }
        });

        slideUp.setSlideListener(new SlideUp.SlideListener() {

            @Override
            public void onSlideDown(float v) {
                dim.setAlpha(1 - (v/100));
            }

            @Override
            public void onVisibilityChanged(int i) {
                if(i == View.GONE) {
                    fab.show();
                }
            }

        });





    }
}
