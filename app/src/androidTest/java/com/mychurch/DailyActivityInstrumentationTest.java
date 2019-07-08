package com.mychurch;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

public class DailyActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<DailyActivity> activityTestRule =
            new ActivityTestRule<>(DailyActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant(){
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String churchName = "Cathedral";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(churchName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(churchName)));
    }
}
