package com.bsystemslimited.flexpay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jason on 03/11/2015.
 */
public class TabsAdapter extends FragmentPagerAdapter {
    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new HomeFragment();
            case 1:
                return new AccountsFragment();
            case 2:
                return new TransactionsFragment();
            default:
                return null;
        }

}

    @Override
    public int getCount() {
        return 3;
    }
}
