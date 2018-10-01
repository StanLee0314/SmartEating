package com.example.steven.smarteating.fragment;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.view.Gravity;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by steven on 8/31/2018.
 */

public class FunctionTesting {
    private MainActivity mActivity;
    private static final String RightEmail = "abcde@gmail.com";
    private static final String RightPassword = "abcdefg";
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

    @Before
    public void setUp() {


    }

    // underNutrtion shows
    @Test
    public void underNutritionCheck() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start new fragment
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.home));
        onView(withId(R.id.vitamin_b1_click)).perform(click());
        onView(withId(R.id.introduction))
                .check(matches(isDisplayed()));
    }

    // nutrition Facts table show
    @Test
    public void nutrionFactsFunctionTesting() {
        Activity mActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 3000);
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start new fragment
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nutritionFacts));
        mActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        Espresso.onView(allOf(isDisplayed(), withId(R.id.foodsearch_rv_list))).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.input_foodName))
                .check(matches(isDisplayed()));
    }
}
