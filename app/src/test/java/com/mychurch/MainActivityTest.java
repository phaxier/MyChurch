package com.mychurch;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import com.mychurch.ui.DailyActivity;
import com.mychurch.ui.MainActivity;

import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = activity.findViewById(R.id.appNameText);
        assertTrue("MyReadings".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findChurchButton).performClick();
        Intent expectedIntent = new Intent(activity, DailyActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
