package com.aryan.android.oyo;


import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Calendar c;
    int timeOfDay;
    String name;
    String welcomeMessage;
    Typeface custom_font;
    private RecyclerView mRecyclerView;
    private NewAdapter mAdapter;
    private TextView mOyoTextView;
    public static TextView mwelcomeMessageTxtView;
    private TextView mSearchBarTextView;
    private NestedScrollView mScrollRecycleView;

    public static HomeFragment newInstance() {
        // Required empty public constructor
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        c = Calendar.getInstance();
        timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        name =  this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("name", null);


        custom_font = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/anagram.ttf");

        if(timeOfDay >= 0 && timeOfDay < 12){
            welcomeMessage = "Good Morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            welcomeMessage = "Good Afternoon";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            welcomeMessage = "Good Evening";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            welcomeMessage = "Good Night";
        }


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setPadding(0, 0, 0, 0);

        String[] items = { "Nearby", "coachings","schools","others"};
        int[] city_imgs = {
                R.drawable.ic_location_searching_black_24dp,
                R.drawable.banglore,
                R.drawable.goa,
                R.drawable.ic_keyboard_arrow_right_black_24dp
        };

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvToDoList);
        mAdapter = new NewAdapter(getActivity().getApplicationContext(),items,city_imgs,getResources());
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(mRecyclerView,false);

        mOyoTextView = (TextView) view.findViewById(R.id.first_activity_oyo_txt_view);
        mwelcomeMessageTxtView = (TextView) view.findViewById(R.id.welcome_msg) ;

        mOyoTextView.setTypeface(custom_font);
        mwelcomeMessageTxtView.setText(welcomeMessage+", "+name);

        mSearchBarTextView = (TextView) view.findViewById(R.id.sb);


        return view;
    }



}
