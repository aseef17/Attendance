package com.example.aseef.attendance;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TimeTableDayAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public TimeTableDayAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }



    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MondayFragment();
        } else if (position == 1) {
            return new TuesdayFragment();
        } else if (position == 2) {
            return new WednesdayFragment();
        } else if  (position == 3){
            return new ThursdayFragment();
        } else if  (position == 4){
            return new FridayFragment();
        } else {
            return new SaturdayFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.monday);
        } else if (position == 1) {
            return mContext.getString(R.string.tuesday);
        } else if (position == 2) {
            return mContext.getString(R.string.wednesday);
        } else if (position == 3){
            return mContext.getString(R.string.thursday);
        } else if (position == 4){
            return mContext.getString(R.string.friday);
        } else
            return mContext.getString(R.string.saturday);
        }
    }