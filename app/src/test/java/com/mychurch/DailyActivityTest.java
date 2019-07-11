package com.mychurch;


import android.widget.ListView;

import com.mychurch.ui.DailyActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(RobolectricTestRunner.class)

public class DailyActivityTest {

    private DailyActivity activity;
    private ListView mReadingsListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(DailyActivity.class);
        mReadingsListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void restaurantListViewPopulates() {
        assertNotNull(mReadingsListView.getAdapter());
        assertEquals(mReadingsListView.getAdapter().getCount(), 15);
    }

}
