package com.aryan.android.oyo;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class YouFragment extends Fragment {


    private TextView openProfile;
    private TextView mTitleTextView;

    public static YouFragment newInstance() {
        // Required empty public constructor
        YouFragment fragment = new YouFragment();
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_you, container, false);

        Toolbar toolbar = view.findViewById(R.id.my_you_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        if(((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //open profile
        openProfile = (TextView) view.findViewById(R.id.profile);
        openProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(YouFragment.this.getActivity(),user_profile.class);
                startActivity(i);
            }
        });
        mTitleTextView = view.findViewById(R.id.you_title);
        mTitleTextView.setText(HomeFragment.mwelcomeMessageTxtView.getText());
        return view;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                View view = FirstActivity.bottomNavigationView.findViewById(R.id.home_menu_item);
                view.performClick();

            default:
                return super.onOptionsItemSelected(item);
        }
    }





}
