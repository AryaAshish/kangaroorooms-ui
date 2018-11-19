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
public class CheckInFragment extends Fragment implements com.andexert.calendarlistview.library.DatePickerController {

    private DayPickerView dayPickerView;
    public static  Calendar startDate;
    public String mStartDate;
    public String startDay;
    public CheckInFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_in, container, false);
        dayPickerView = (DayPickerView) view.findViewById(R.id.pickerView1);
        dayPickerView.setController(this);
        startDate = Calendar.getInstance();



        return view;
    }


    @Override
    public int getMaxYear() {
        return 2019;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {
        Log.e("Day Selected", day + " / " + month + " / " + year);
        startDate.set(year, month, day);
        /*final LayoutInflater factory = getActivity().getLayoutInflater();
        final View setDatesLayout = factory.inflate(R.layout.activity_set_dates, null);
        TabLayout tabLayout = (TabLayout) setDatesLayout.findViewById(R.id.tab_layout);*/
        startDay = SetDatesActivity.getDay(startDate.getTime().getDay());
        mStartDate = new SimpleDateFormat("dd MMM", Locale.getDefault()).format(startDate.getTime());
        SetDatesActivity.tabLayout.getTabAt(0).setText(startDay+", "+mStartDate);
    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {
        Log.e("Date range selected", selectedDays.getFirst().toString() + " --> " + selectedDays.getLast().toString());
    }


}
