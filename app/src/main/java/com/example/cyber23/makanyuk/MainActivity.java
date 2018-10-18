package com.example.cyber23.makanyuk;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private Button mBackButton;
    private Button mNextButton;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SliderAdapter sliderAdapter;
        final ViewPager mSlideViewPager;

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout =  findViewById(R.id.dotsLayout);

        mNextButton = findViewById(R.id.button_next);
        mBackButton = findViewById(R.id.button_back);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("TEST FINISH")
                .setTitle("JUDUL");

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        final AlertDialog dialog = builder.create();

        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);

                if (mCurrentPage == mDots.length-1) {

                }
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for(int i=0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhiteTransparent));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (i==0) {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(false);
                mBackButton.setVisibility(View.INVISIBLE);

                mNextButton.setText("Next");
                mBackButton.setText("");
            } else if (i==mDots.length - 1) {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("Finish");
                mBackButton.setText("Back");
            } else {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("Next");
                mBackButton.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
