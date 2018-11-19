package com.aryan.android.oyo;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;
import java.util.List;


public class FirstRunSecondActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button mOneTapLogin;
    RecyclerView spinner_recyclerView;
    List<String> countryNames;
    List<String> code;
    static TypedArray imageArray;
    public static Dialog dialog;
    RecyclerView recyclerView;
    SpinnerRecyclerViewAdapter adapter;
    public static TextView mCountryCode;
    public EditText mPhoneNumber;
    public static ImageView mFlagImage;
    LinearLayout mUserInput;
    RelativeLayout mLayout;
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
        setContentView(R.layout.activity_first_run_second);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mOneTapLogin = (Button) findViewById(R.id.btn_one_tap_login);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mCountryCode = (TextView) findViewById(R.id.country_code);
        mFlagImage = (ImageView) findViewById(R.id.flag_img);
        mUserInput = (LinearLayout)findViewById(R.id.user_input_in_frsa) ;
        mPhoneNumber = (EditText) findViewById(R.id.editText_phone) ;
        mLayout = (RelativeLayout) findViewById(R.id.first_run_second_activity) ;

        countryNames = Arrays.asList(getResources().getStringArray(R.array.countries_list));
        code = Arrays.asList(getResources().getStringArray(R.array.countries_code_list));
        imageArray= getResources().obtainTypedArray(R.array.random_imgs);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_recycler_view);
        dialog.setCanceledOnTouchOutside(true);
        recyclerView = (RecyclerView) dialog.findViewById(R.id.recycler_view_spinner);
        adapter = new SpinnerRecyclerViewAdapter(this, countryNames, code);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Spinner spin = (Spinner) findViewById(R.id.country_code_spinner);
        //spin.setOnItemSelectedListener(this);

       // CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),countryNames, code);
        //spin.setAdapter(customAdapter);


    }

    public void getDialog(View view) {
        dialog.show();
    }

    public void changeBackground(View view) {
        mUserInput.setBackgroundResource(R.drawable.linear_activity_in_activity_first_run_second_background_on_focus);
    }

    public void verify(View view) {

        InputMethodManager mImMan = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mImMan.hideSoftInputFromWindow(mPhoneNumber.getWindowToken(), 0);

        String PhoneNumber = mPhoneNumber.getText().toString();

        if(PhoneNumber.length() == 0){
            mUserInput.setBackground(getResources().getDrawable(R.drawable.error_phone_number));
            Snackbar snackbar= Snackbar.make(mLayout,"Enter phone number",Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.errorSnackBarColor));
            TextView mSnackBarTextView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            mSnackBarTextView.setTextAlignment(snackBarView.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }
        else if(PhoneNumber.length() != 10) {
            mUserInput.setBackground(getResources().getDrawable(R.drawable.error_phone_number));
            Snackbar snackbar= Snackbar.make(mLayout,"Enter valid Phone Number",Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.errorSnackBarColor));
            TextView mSnackBarTextView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            mSnackBarTextView.setTextAlignment(snackBarView.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }
        else {
            String message = mCountryCode.getText() + " " + mPhoneNumber.getText();
            Intent intent = new Intent(this, FirstRunThirdActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }


}
