package com.mychurch;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText(){
        onView(withId(R.id.locationEditText)).perform(typeText("Parish"))
                .check(matches(withText("Parish")));
    }

    @Test
    public void locationIsSentToRestaurantsActivity(){
        String location = "Parish";
        onView(withId(R.id.locationEditText)).perform(typeText(location)).perform(closeSoftKeyboard());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted again!");
        }
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.locationTextView)).check(matches
                (withText("Here are the daily readings: " + location)));
    }
}
