package com.aryan.android.oyo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class FirstRunOneActivity extends AppCompatActivity {

    private ViewGroup mSceneRoot;

    private TextView oyoTextView;
    private TextView mFreeWifi;
    private TextView mAcRooms;
    private Animation mItemAnim;
    private RelativeLayout mSceneContainer;
    private Button mGetStartedBtn;
    private CoordinatorLayout mParentFirstRunOne;

    private RecyclerView mRecyclerView;
    private FirstRunAdapter mAdapter;
    private int[] mImages;
    private final LinkedList<String> mWordList = new LinkedList<>();
   // private final LinkedList<Integer> mWordImageList = new LinkedList<>();
    private TextView mTxt2;
    float f = 0.2f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_first_run_one);

        mWordList.addLast("Free Wi-Fi");
        mWordList.addLast("AC Rooms");
        mWordList.addLast("Breakfast Included");
        mWordList.addLast("Book Now Pay Later");
        mWordList.addLast("Clean and Hyegenic Rooms");

        int[] mImages = {R.drawable.ic_wifi,R.drawable.ic_air_conditioner,R.drawable.ic_toaster,R.drawable.ic_rupee,R.drawable.ic_bed};

        // Create recycler view.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new FirstRunAdapter(this, mWordList, mImages);
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        oyoTextView = (TextView) findViewById(R.id.oyo);
        //mFreeWifi = (TextView)findViewById(R.id.free_wifi);
       // mAcRooms = (TextView) findViewById(R.id.ac_rooms);
        //mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        mItemAnim = AnimationUtils.loadAnimation(this,R.anim.item_animation_from_bottom);
        mTxt2 = (TextView)findViewById(R.id.txt2);
        mGetStartedBtn = (Button) findViewById(R.id.get_started);
       mParentFirstRunOne = (CoordinatorLayout) findViewById(R.id.parent_first_run_one);

        //mGetStartedBtn.setY(0.83f*getScreenHeight());
       // mSceneContainer = (RelativeLayout) findViewById(R.id.scene_container);
        final Animation ctt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_to_top);
        final LayoutAnimationController mLayoutAnim = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_from_bottom);
        final LayoutAnimationController animation1 = AnimationUtils.loadLayoutAnimation(FirstRunOneActivity.this, R.anim.layout_animation_from_bottom);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/anagram.ttf");
        oyoTextView.setTypeface(custom_font);
        oyoTextView.setLetterSpacing(-0.09f);
        Animation zoom = AnimationUtils.loadAnimation(this,R.anim.zoom);
        zoom.setFillAfter(true);
        zoom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ctt.setFillAfter(true);
                oyoTextView.startAnimation(ctt);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ctt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                oyoTextView.setVisibility(oyoTextView.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
               /* mFreeWifi.startAnimation(mItemAnim);
                mFreeWifi.setVisibility(mFreeWifi.VISIBLE);
                mAcRooms.startAnimation(mItemAnim);
                mAcRooms.setVisibility(mAcRooms.VISIBLE);
               mSceneContainer.setLayoutAnimation(mLayoutAnim);
               mSceneContainer.startLayoutAnimation();
                mSceneContainer.setVisibility(mSceneContainer.VISIBLE);*/

                mRecyclerView.setLayoutAnimation(animation1);
                mRecyclerView.startLayoutAnimation();
                mRecyclerView.setVisibility(mRecyclerView.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
       // oyoTextView.startAnimation(as);
        //zoom.setFillAfter(true);

        oyoTextView.startAnimation(zoom);
       final Animation a = AnimationUtils.loadAnimation(this,R.anim.slide_up_1);
        a.setFillAfter(true);
        mRecyclerView.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mTxt2.startAnimation(a);
                mTxt2.setVisibility(mTxt2.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mGetStartedBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_forward_black_24dp, 0);
        final Animation btn = AnimationUtils.loadAnimation(this,R.anim.slide_up_2);
        //btn.setFillAfter(true);
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                mGetStartedBtn.startAnimation(btn);
                mGetStartedBtn.setVisibility(mGetStartedBtn.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                float h = mParentFirstRunOne.getHeight();
                mGetStartedBtn.setTranslationY(0.83f*h);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

//                Log.d("partent Height",Float.toString(h));
                Log.d("btn position",Float.toString(mGetStartedBtn.getY()));
                Log.d("btn position",Float.toString(mGetStartedBtn.getX()));
                //mGetStartedBtn.setTranslationY((int)(0.83f*h)-mGetStartedBtn.getTop());
                //mGetStartedBtn.animate().y((int)(0.83f*h)-mGetStartedBtn.getTop());
               // LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)mGetStartedBtn.getLayoutParams();
               // Log.d("fgfg",Integer.toString(lp.width));
  //              mGetStartedBtn.setY(mGetStartedBtn.getY()+(0.83f*h));
                //lp.topMargin = (int)(mGetStartedBtn.getY()+(0.83f*h));
                //mGetStartedBtn.setLayoutParams(lp);
                Log.d("btn position",Float.toString(mGetStartedBtn.getY()));
                Log.d("btn position",Float.toString(mGetStartedBtn.getX()));
               // mGetStartedBtn.setTop((int)(0.83f*h));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }




    public void getStarted(View view) {
        Intent intent = new Intent(FirstRunOneActivity.this, FirstRunSecondActivity.class);
        startActivity(new Intent(FirstRunOneActivity.this, FirstRunSecondActivity.class));
    }
}
