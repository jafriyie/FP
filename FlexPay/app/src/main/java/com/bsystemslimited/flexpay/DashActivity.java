package com.bsystemslimited.flexpay;

import android.support.v7.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DashActivity extends AppCompatActivity implements ActionBar.TabListener {
    TabsAdapter myAdapter;
    ViewPager pager;
    android.support.v7.app.ActionBar actionBar;
    String[] titles = {"Home", "Payments", "Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        pager = (ViewPager) findViewById(R.id.pager);
        myAdapter = new TabsAdapter(getSupportFragmentManager());
        pager.setAdapter(myAdapter);


        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String tab_name : titles){
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
