package com.aryan.android.oyo;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Calendar c;
    int timeOfDay;
    String name;
    String welcomeMessage;
    Typeface custom_font;
    private RecyclerView mRecyclerView;
    private NewAdapter mAdapter;
    private TextView mOyoTextView;
    private TextView mwelcomeMessageTxtView;
   public static BottomNavigationView bottomNavigationView;
    Fragment myFragment;
    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        selectedFragment = HomeFragment.newInstance();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectedFragment = HomeFragment.newInstance();
                        switch (item.getItemId()) {
                            case R.id.home_menu_item:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.saved_hotel_menu_item:
                                selectedFragment = SavedHotelFragment.newInstance();
                                break;
                            case R.id.bookings_menu_item:
                                selectedFragment = Bookings.newInstance();
                                break;
                            case R.id.you_menu_item:
                                selectedFragment = YouFragment.newInstance();
                                break;
                        }
                        myFragment = (Fragment) getFragmentManager().findFragmentByTag("CURRENT_FRAGMENT");
                        if(!(myFragment.getClass().equals(selectedFragment.getClass())) ) {
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, selectedFragment,"CURRENT_FRAGMENT");
                            transaction.commit();
                        }
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance(),"CURRENT_FRAGMENT");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(!((HomeFragment.newInstance()).getClass().equals(selectedFragment.getClass())) ) {
            View view = FirstActivity.bottomNavigationView.findViewById(R.id.home_menu_item);
            view.performClick();
        }
        else {
            finish();
        }

    }

    public void showSearchActivity(View view) {
        Intent intent = new Intent(this,SearchActivity1.class);
        startActivity(intent);
    }
}
