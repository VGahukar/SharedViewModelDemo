package com.neosoft.myapplication.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Vishakha Gahukar on 10/10/19.
 * Email : vishakha.gahukar@neosofttech.com
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private int totalTabs;

    public PagerAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FirstChildFragment();
            case 1:
                return new SecondChildFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
