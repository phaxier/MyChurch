package com.mychurch.adapater;

import android.content.Context;
import android.widget.ArrayAdapter;



public class ChurchArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mDailies;
    private String[] mPrayer;


    public ChurchArrayAdapter(Context mContext,int resource, String[] mDailies, String[] mPrayer ){
        super(mContext, resource);
        this.mContext = mContext;
        this.mDailies = mDailies;
        this.mPrayer = mPrayer;

    }
    @Override
    public Object getItem(int position) {
        String dailies = mDailies[position];
//        String prayer = mPrayer[position];

        return String.format("%s \nServes great:", dailies);
    }
    @Override
    public int getCount() {
        return mDailies.length;
    }

}
