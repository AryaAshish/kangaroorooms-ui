package com.aryan.android.oyo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity1 extends AppCompatActivity {

    private Toolbar toolbar;
    List<String> cityNames;
    RecyclerView mCitiesRecyclerView;
    CitiesAdapter mAdapter;
    public SearchView search;
    private List<String> list = new ArrayList<String>();
    public static TextView mCheckInTextView;
    public static TextView mCheckOutTextView;
    public static TextView mNoOfAdultsTextView;
    public static TextView mNoOfNightsTextView;
    public static final String EXTRA_MESSAGE =
            "com.aryan.android.oyo.extra.MESSAGE";

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
        setContentView(R.layout.activity_search1);

        toolbar = (Toolbar) findViewById(R.id.search_toolbar1);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        cityNames = Arrays.asList(getResources().getStringArray(R.array.places_in_india));
        search = (SearchView) findViewById(R.id.search_view) ;

        mCitiesRecyclerView = (RecyclerView) findViewById(R.id.cities_recycler_view);
        mAdapter = new CitiesAdapter(this,cityNames);
        mCitiesRecyclerView.setAdapter(mAdapter);
        mCitiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCheckInTextView = (TextView) findViewById(R.id.check_in_text_view);
        mCheckOutTextView = (TextView) findViewById(R.id.check_out_text_view);
        mNoOfAdultsTextView = (TextView) findViewById(R.id.no_of_adults_text_view);
        mNoOfNightsTextView = (TextView) findViewById(R.id.nights_Text);

        SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                query = query.toLowerCase();
                final List<String> filteredList = new ArrayList<>();
                for(int i = 0; i < cityNames.size(); i++) {
                    final String text = cityNames.get(i).toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(cityNames.get(i));
                    }
                }
                mCitiesRecyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity1.this));
                mAdapter = new CitiesAdapter(SearchActivity1.this,filteredList);
                mCitiesRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        };

        search.setOnQueryTextListener(listener);
    }

    public void startDateActivity(View view) {
        Intent intent= new Intent(this,SetDatesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.activit_back_in, R.anim.activity_back_out);
    }
}
