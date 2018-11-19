package com.aryan.android.oyo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class FirstRunThirdActivity extends AppCompatActivity {

    private static final int CUSTOM_COLOR = 0xFFFF0000 ;
    private Toolbar toolbar;
    private TextView mRegisteredPhoneNumber;
    private TextView mTimer;
    private TextView mResendCode;
    private TextView mTextViewAgreePolicy;
    private TextView mTextViewReferralCode;
    private EditText mEditTextEmail;
    private EditText mEditTextName;
    private EditText mEditTextSixDigitCode;
    private EditText mEditTextReferralCode;
    LinearLayout mLayout;

    Boolean isDeny;
    Boolean isFirstRunThird;
    Boolean isAllow;

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
        setContentView(R.layout.activity_first_run_third);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent intent = getIntent();

        mRegisteredPhoneNumber = (TextView) findViewById(R.id.registered_phone_number);
        mRegisteredPhoneNumber.setText("on "+intent.getStringExtra(FirstRunSecondActivity.EXTRA_MESSAGE));
        mTimer = (TextView) findViewById(R.id.timer);
        mResendCode = (TextView)findViewById(R.id.resend_code) ;
        mTextViewAgreePolicy = (TextView) findViewById(R.id.text_view_agree_policy);
        mTextViewReferralCode = (TextView) findViewById(R.id.text_view_referral_code);

        mEditTextEmail = (EditText) findViewById(R.id.edit_text_email);
        mEditTextName = (EditText) findViewById(R.id.edit_text_name);
        mEditTextSixDigitCode = (EditText) findViewById(R.id.edit_text_6_digit_code) ;
        mEditTextReferralCode = (EditText) findViewById(R.id.edit_text_referral_code) ;

        mLayout = (LinearLayout) findViewById(R.id.first_run_third_activity) ;

        mTextViewAgreePolicy.setText(Html.fromHtml(getResources().getString(R.string.agree)));

        mEditTextSixDigitCode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        mEditTextSixDigitCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mEditTextSixDigitCode.setPaddingRelative(0, 0, 0, 0);
                mEditTextSixDigitCode.setLetterSpacing(1);
                mEditTextSixDigitCode.setTextSize(20);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(mEditTextSixDigitCode.length() == 0) {
                    mEditTextSixDigitCode.setPadding(10, 0, 0, 0);
                    mEditTextSixDigitCode.setLetterSpacing(0);
                    mEditTextSixDigitCode.setTextSize(12);
                }
            }
        });


        new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                String text = String.format(Locale.getDefault(), "Waiting for OTP... %d:%02ds ",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                mTimer.setText(text);
               // mTimer.setText("Waiting for OTP... " + millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                mResendCode.setTextColor(getResources().getColor(R.color.endColor));
            }
        }.start();

        mEditTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mEditTextEmail.setBackground(getResources().getDrawable(R.drawable.linear_activity_in_activity_first_run_second_background_on_focus));
                }else{
                    mEditTextEmail.setBackground(getResources().getDrawable(R.drawable.linear_layout_in_activity_first_run_second_background));
                }
            }
        });

        mEditTextName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mEditTextName.setBackground(getResources().getDrawable(R.drawable.linear_activity_in_activity_first_run_second_background_on_focus));
                }else{
                    mEditTextName.setBackground(getResources().getDrawable(R.drawable.linear_layout_in_activity_first_run_second_background));
                }
            }
        });

        mEditTextSixDigitCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mEditTextSixDigitCode.setBackground(getResources().getDrawable(R.drawable.linear_activity_in_activity_first_run_second_background_on_focus));
                }else{
                    mEditTextSixDigitCode.setBackground(getResources().getDrawable(R.drawable.enter_code_background));
                }
            }
        });

        mEditTextReferralCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mEditTextReferralCode.setBackground(getResources().getDrawable(R.drawable.linear_activity_in_activity_first_run_second_background_on_focus));
                }else{
                    mEditTextReferralCode.setBackground(getResources().getDrawable(R.drawable.linear_layout_in_activity_first_run_second_background));
                }
            }
        });

        isFirstRunThird = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRunThird", true);

        isDeny = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isDeny", false);

        isAllow = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isAllow", false);

        if (isFirstRunThird  || (!isDeny && !isAllow)) {
            //show start activity
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(this);
            myAlertBuilder.setIcon(R.drawable.ic_textsms_black_24dp);
            myAlertBuilder.setTitle(getResources().getText(R.string.dent_allow_sms));
            myAlertBuilder.setPositiveButton("ALLOW", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                                    .putBoolean("isAllow", true).commit();

                            mTimer.setVisibility(mTimer.GONE);
                            mResendCode.setVisibility(mResendCode.GONE);
                            new Timer().schedule(new TimerTask(){
                                public void run() {
                                    FirstRunThirdActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            mEditTextSixDigitCode.setText("589764");
                                        }
                                    });
                                }
                            }, 3000);
                        }
                    });
            myAlertBuilder.setNegativeButton("DENY", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                                    .putBoolean("isDeny", true).commit();
                        }
                    });
            AlertDialog alertDialog= myAlertBuilder.create();
            alertDialog.show();
            Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
            positiveButton.setTextColor(getResources().getColor(R.color.allow_deny_alert));
            Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
            negativeButton.setTextColor(getResources().getColor(R.color.allow_deny_alert));

        }

        if(isDeny) {

           /* AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(this, THEME_HOLO_DARK);
            myAlertBuilder.setMessage("To auto detect OTP,please provide permission to read SMS. ");
            myAlertBuilder.setPositiveButton("OK", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                                    .putBoolean("isAllow", true).commit();
                        }
                    });
            AlertDialog alertDialog= myAlertBuilder.create();
            alertDialog.show();
            TextView messageText = (TextView)alertDialog.findViewById(android.R.id.message);
            messageText.setTextAlignment(messageText.TEXT_ALIGNMENT_CENTER);
            Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
            positiveButton.setTextColor(getResources().getColor(R.color.half_white));
            positiveButton.setBackgroundColor(getResources().getColor(R.color.shade_red1));*/

            LayoutInflater layoutInflater = LayoutInflater.from(this);
            View promptView = layoutInflater.inflate(R.layout.deny_alert_layout, null);

            final AlertDialog alertD = new AlertDialog.Builder(this).create();

            TextView userInput = (TextView) promptView.findViewById(R.id.dent_txt_sms);

            Button btnAdd1 = (Button) promptView.findViewById(R.id.deny_btn);

            btnAdd1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    // btnAdd1 has been clicked
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isAllow", true).commit();

                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isDeny", false).commit();

                    alertD.cancel();

                    mTimer.setVisibility(mTimer.GONE);
                    mResendCode.setVisibility(mResendCode.GONE);
                    new Timer().schedule(new TimerTask(){
                        public void run() {
                            FirstRunThirdActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    mEditTextSixDigitCode.setText("589764");
                                }
                            });
                        }
                    }, 3000);
                }
            });

            alertD.setView(promptView);

            alertD.show();

            alertD.getWindow().getDecorView().getBackground().setColorFilter(new LightingColorFilter(0xFF0000FF, CUSTOM_COLOR));
        }

        if(isAllow) {
            mTimer.setVisibility(mTimer.GONE);
            mResendCode.setVisibility(mResendCode.GONE);
            new Timer().schedule(new TimerTask(){
                public void run() {
                    FirstRunThirdActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            mEditTextSixDigitCode.setText("589764");
                        }
                    });
                }
            }, 3000);
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRunThird", false).commit();

    }

    public void openReferralCodeEditText(View view) {
        mTextViewReferralCode.setVisibility(mTextViewReferralCode.GONE);
        mEditTextReferralCode.setVisibility(mEditTextReferralCode.VISIBLE);
        mEditTextReferralCode.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mTextViewReferralCode, InputMethodManager.SHOW_IMPLICIT);
    }

    public void editPhoneNumber(View view) {
        Intent intent = new Intent(this,FirstRunSecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void createAccount(View view) {

        InputMethodManager mImMan = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mImMan.hideSoftInputFromWindow(mEditTextEmail.getWindowToken(), 0);

        mImMan.hideSoftInputFromWindow(mEditTextName.getWindowToken(), 0);

        mImMan.hideSoftInputFromWindow(mEditTextReferralCode.getWindowToken(), 0);

        mImMan.hideSoftInputFromWindow(mEditTextSixDigitCode.getWindowToken(), 0);

        String email = mEditTextEmail.getText().toString();
        String name = mEditTextName.getText().toString();
        String otp = mEditTextSixDigitCode.getText().toString();
        String phn = mRegisteredPhoneNumber.getText().toString();

        boolean correctEmail = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();

        if(!correctEmail) {
            mEditTextEmail.setBackground(getResources().getDrawable(R.drawable.error_phone_number));
            Snackbar snackbar= Snackbar.make(mLayout,"Please provide a valid email",Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.errorSnackBarColor));
            TextView mSnackBarTextView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            mSnackBarTextView.setTextAlignment(snackBarView.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }

        else if(name.length() == 0) {
            mEditTextName.setBackground(getResources().getDrawable(R.drawable.error_phone_number));
            Snackbar snackbar= Snackbar.make(mLayout,"Please provide your name",Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.errorSnackBarColor));
            TextView mSnackBarTextView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            mSnackBarTextView.setTextAlignment(snackBarView.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }

        else if(otp.length() != 6) {
            mEditTextName.setBackground(getResources().getDrawable(R.drawable.error_phone_number));
            Snackbar snackbar= Snackbar.make(mLayout,"Please enter valid OTP",Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.errorSnackBarColor));
            TextView mSnackBarTextView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            mSnackBarTextView.setTextAlignment(snackBarView.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }

        else {

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putString("name", name).commit();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putString("email", email).commit();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putString("phn", phn).commit();


            Intent intent = new Intent(this, FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

    }
}
