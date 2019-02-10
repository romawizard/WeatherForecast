package com.diachenko.weatherforecast.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    private  final int numOfTabs;

    public WeatherPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CurrentWeatherFragment();
            default:
                return new CurrentWeatherFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
