package com.aryan.android.oyo;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneRoomFragment extends Fragment {


    private Button Room1;
    private Button Room2;
    private Button Room3;
    LinearLayout layout;
    public OneRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_room, container, false);
        Room1 = (Button) view.findViewById(R.id.room1_button);
        Room2 = (Button) view.findViewById(R.id.room2_button);
        Room3 = (Button) view.findViewById(R.id.room3_button);
        layout = (LinearLayout) view.findViewById(R.id.one_room_layout) ;

        Room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Room1.setTextColor(Color.WHITE);
                Room1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                Room2.setTextColor(Color.BLACK);
                Room2.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                Room3.setTextColor(Color.BLACK);
                Room3.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                SetDatesActivity.tabLayout.getTabAt(2).setText("1 Adult");
            }
        });

        Room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Room2.setTextColor(Color.WHITE);
                Room2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                Room1.setTextColor(Color.BLACK);
                Room1.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                Room3.setTextColor(Color.BLACK);
                Room3.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                SetDatesActivity.tabLayout.getTabAt(2).setText("2 Adult");
            }
        });

        Room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Room3.setTextColor(Color.WHITE);
                Room3.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                Room1.setTextColor(Color.BLACK);
                Room1.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                Room2.setTextColor(Color.BLACK);
                Room2.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                SetDatesActivity.tabLayout.getTabAt(2).setText("3 Adult");
                Snackbar snackbar = Snackbar.make(layout, R.string.test, Snackbar.LENGTH_LONG);
                View snackbarLayout = snackbar.getView();
                snackbarLayout.setBackgroundColor(Color.GRAY);
                snackbarLayout.setPadding(30, 0, 30, 0);
                TextView textView = (TextView)snackbarLayout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_bed, 0, 0, 0);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(Color.BLACK);
                textView.setTextAlignment(snackbarLayout.TEXT_ALIGNMENT_CENTER);
                textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));
                FrameLayout.LayoutParams params =(FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();

                params.setMargins(15, 15, 15, 15);

                snackbarLayout.setLayoutParams(params);
                snackbar.show();

            }
        });
        return view;
    }

}
