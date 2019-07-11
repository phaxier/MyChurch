package com.mychurch.adapater;

import android.content.Context;
import android.widget.ArrayAdapter;


public class MyChurchArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mReadings;
    private String[] mPrayers;

    public MyChurchArrayAdapter (Context mContext, int resource, String[] mReadings, String[] mPrayers){
        super(mContext, resource);
        this.mContext = mContext;
        this.mPrayers = mPrayers;
        this.mReadings = mReadings;
    }


     @Override
    public int getCount() {
        return mReadings.length;
    }

    @Override
    public Object getItem(int i) {
        String readings = mReadings[getPosition(mReadings)];
        String prayers = mPrayers[getPosition(mPrayers)];
        return String.format("%s \n Serves great: ", readings);

    }


}
