package com.aryan.android.oyo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aryan.android.oyo.R;
import com.squareup.picasso.Picasso;

public class user_profile extends AppCompatActivity implements View.OnClickListener {


    int i;
    private Button EditProfile;
    private Button logout;
    private EditText name;
    private EditText email_id;
    private EditText mobile_number;
    private EditText aadhar_number;
    private EditText address;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        logout = (Button) findViewById(R.id.logout);
        name = (EditText) findViewById(R.id.name);
        email_id = (EditText) findViewById(R.id.email_id);
        mobile_number = (EditText) findViewById(R.id.mobile_number);
        aadhar_number = (EditText) findViewById(R.id.aadhar_number);
        address = (EditText) findViewById(R.id.address);


        EditProfile = findViewById(R.id.edit_profile);
        EditProfile.setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {

                Uri selectedImageURI = data.getData();

                Picasso.with(user_profile.this).load(selectedImageURI).noPlaceholder().centerCrop().fit()
                        .into((ImageView) findViewById(R.id.imgView));
            }

        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.edit_profile:
                // Do something

                //Intent intent = new Intent(MainActivity.this , edit_profile.class);
                //startActivity(intent);

                if(i==1)
                {
                    name.setEnabled(true);
                    email_id.setEnabled(true);
                    mobile_number.setEnabled(true);
                    aadhar_number.setEnabled(true);
                    address.setEnabled(true);
                    EditProfile.setText("SAVE");
                    logout.setText("CHANGE PIC");
                    i=0;
                    break;
                }
                if(i==0)
                {
                    name.setEnabled(false);
                    email_id.setEnabled(false);
                    mobile_number.setEnabled(false);
                    aadhar_number.setEnabled(false);
                    address.setEnabled(false);
                    name.setText(name.getText());
                    email_id.setText(email_id.getText());
                    mobile_number.setText(mobile_number.getText());
                    aadhar_number.setText(aadhar_number.getText());
                    address.setText(address.getText());
                    EditProfile.setText("EDIT PROFILE");
                    i=1;
                    break;
                }


        }
    }



}
