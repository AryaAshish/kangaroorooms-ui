package com.aryan.android.oyo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckOutfragment extends Fragment implements com.andexert.calendarlistview.library.DatePickerController{

    private DayPickerView dayPickerView;
    public String mEndDate;
    public String endDay;
    public static Calendar endDate;
    public static CheckOutfragment newInstance() {
        // Required empty public constructor
        CheckOutfragment fragment = new CheckOutfragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_outfragment, container, false);
        dayPickerView = (DayPickerView) view.findViewById(R.id.pickerView);
        dayPickerView.setController(this);
        endDate = Calendar.getInstance();
        return view;
    }

    @Override
    public int getMaxYear() {
        return 2019;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {
        Log.e("Day Selected", day + " / " + month + " / " + year);
        endDate.set(year,month,day);
        endDay = SetDatesActivity.getDay(endDate.getTime().getDay());
        mEndDate = new SimpleDateFormat("dd MMM", Locale.getDefault()).format(endDate.getTime());
        SetDatesActivity.tabLayout.getTabAt(1).setText(endDay+", "+mEndDate);
    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {

    }
}
