package com.davidmadethis.dampp;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.davidmadethis.dampp.adapter.HomePagerAdapter;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.vp_main)
    ViewPager mViewPager;
    @Bind(R.id.nts_center)
    NavigationTabStrip mCenterNavigationTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mViewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);

        mViewPager.setCurrentItem(1);
        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts_center);
        navigationTabStrip.setViewPager(mViewPager);


        FlowingDrawer mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);

        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
    }
}
