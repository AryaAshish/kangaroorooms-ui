package com.aryan.android.oyo;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedHotelFragment extends Fragment {

    private Toolbar toolbar;
    private TextView mSavedHotelTextView2;
    public static SavedHotelFragment newInstance() {
        // Required empty public constructor
        SavedHotelFragment fragment = new SavedHotelFragment();
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
        View view = inflater.inflate(R.layout.fragment_saved_hotel, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        mSavedHotelTextView2 = (TextView)view.findViewById(R.id.saved_hotel_fragment_txt_2) ;
        mSavedHotelTextView2.setText(Html.fromHtml(getResources().getString(R.string.saved_hotel_txt_2)));

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null){
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(" ");
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                /*getFragmentManager().popBackStack();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, HomeFragment.newInstance(),"CURRENT_FRAGMENT");
                transaction.commit();*/
                View view = FirstActivity.bottomNavigationView.findViewById(R.id.home_menu_item);
                view.performClick();
                return true; //Notice you must returning true here

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
