package com.aryan.android.oyo;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelsActivity extends AppCompatActivity {

    int redColorOn;
    private TextView mToolText;
    private String mCity;
    private Toolbar toolbar;
    RecyclerView mHotelsRecyclerView;
    HotelAdapter mHotelAdapter;
    private ImageButton mFavouriteIcon;
    private TextView mRoomOriginalCost;
   // public HotelAdapter.OnItemClicked onclick;
   TypedArray mHotelImages;
    ArrayList<Integer> mFavouriteImages = new ArrayList<Integer>(100);
    List<String> mRoomIds;
    List<String> mHotelNames;
    List<String> mHotelLocations;
    List<String> mOriginalRates;
    List<String> mReducedCosts;
    List<String> mDiscounts;
    List<String> mHotelRatings;
    List<String> Descriptions;
    List<String> mRatings;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
            overridePendingTransition(R.anim.activit_back_in, R.anim.activity_back_out);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        redColorOn = 0;
        mToolText = (TextView) findViewById(R.id.tool_text);
        Intent intent = getIntent();
        mCity = intent.getStringExtra(SearchActivity1.EXTRA_MESSAGE);
        Log.d("city",mCity);
        mToolText.setText(mCity);
        toolbar = (Toolbar) findViewById(R.id.activity_hotels_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mHotelImages = getResources().obtainTypedArray(R.array.room_imgs);
        mRoomIds = Arrays.asList(getResources().getStringArray(R.array.room_ids));
        mHotelNames = Arrays.asList(getResources().getStringArray(R.array.hotel_names));
        mHotelLocations = Arrays.asList(getResources().getStringArray(R.array.hotel_locations));
        mOriginalRates = Arrays.asList(getResources().getStringArray(R.array.original_rates));
        mReducedCosts = Arrays.asList(getResources().getStringArray(R.array.reduced_rates));
        mDiscounts = Arrays.asList(getResources().getStringArray(R.array.discounts));
        mHotelRatings = Arrays.asList(getResources().getStringArray(R.array.hotel_ratings));
        Descriptions = Arrays.asList(getResources().getStringArray(R.array.hotel_descriptions));
        mRatings = Arrays.asList(getResources().getStringArray(R.array.ratings));

        //mFavouriteImages = getResources().obtainTypedArray(R.array.favourite_imgs);
        /* int[] mHotelImages= {
                R.drawable.room,
                R.drawable.room1,
                R.drawable.room2,
                R.drawable.room3,
                R.drawable.room4,
                R.drawable.room5,
                R.drawable.room6,
                R.drawable.room7,
                R.drawable.room8 };*/

        /*int[] mFavouriteImages= {
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp,
                R.drawable.ic_favorite_white_24dp};*/
        for(int i=0;i<100;i++) {
            mFavouriteImages.add(R.drawable.ic_favorite_white_24dp);
        }

       /* int[] mRoomIds = { 2286, 2267, 2289, 2258, 2268, 2264, 2214, 2205, 2290,};

        String[] mHotelNames = {
                "Aaradhya Residency",
                "Hotel White Inn",
                "Sun Hotel",
                "Hotel Admiral Suites",
                "Hotel Sky Court",
                "Hotel Riviera",
                "Hotel Starlight",
                "Hotel Alankar",
                "Hotel Maple Green Suites"
        };*/

        /*String[] mHotelLocations = {
                "Next to Maharaja Signal",
                "M.V Extension",
                "Next to Majestic Railway Station",
                "Near K.B circle",
                "New Osampura",
                "Jalan Road",
                "Nirala Bazar",
                "Mondha Road",
                "Opp. Railway Station"
        };*/

        /*int[] mOriginalRates = { 1929, 1626, 1751, 1983, 1606, 1865, 1564, 1593, 1570 };*/
       /* int[] mReducedCosts = { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 727 };*/
       /* int[] mDiscounts = { 48, 38, 43, 50, 38, 46, 36, 37, 54 };*/
       /* Double[] mHotelRatings = {4.2, 4.4, 3.6, 4.8, 4.3, 4.3, 3.9, 4.1, 3.0 };
        String[] Descriptions = {
                "Very Good",
                "Very Good",
                "Good",
                "Excellent",
                "Very Good",
                "Very Good",
                "Good",
                "Very Good",
                "Average"
        };

        int[] mRatings = { 600, 620, 200, 1160, 550, 404, 320, 589, 101};*/



        mRoomOriginalCost = (TextView) findViewById(R.id.room_original_cost) ;
        mFavouriteIcon = (ImageButton) findViewById(R.id.favourite_symbol1);

        mHotelsRecyclerView = (RecyclerView) findViewById(R.id.hotels_recycler_view);
        mHotelAdapter = new HotelAdapter(this,mHotelImages,mFavouriteImages,mCity,mRoomIds,mHotelNames,
                mOriginalRates, mReducedCosts, mDiscounts, mHotelRatings, Descriptions, mRatings, mHotelLocations);
        mHotelsRecyclerView.setAdapter(mHotelAdapter);
        //mHotelAdapter.setOnClick(onclick);
        mHotelsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHotelsRecyclerView.setMotionEventSplittingEnabled(false);

    }

    public void startDateActivity(View view) {
        Intent intent= new Intent(this,SetDatesActivity.class);
        startActivity(intent);
    }


    /*@Override
    public void onItemClick(int position) {
        mFavouriteIcon.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
    }*/
}
