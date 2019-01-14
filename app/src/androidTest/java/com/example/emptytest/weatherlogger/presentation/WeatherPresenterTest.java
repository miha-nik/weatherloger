package com.example.emptytest.weatherlogger.presentation;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;

import com.example.emptytest.weatherlogger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class WeatherPresenterTest {

    @Rule
    public ActivityTestRule<WeatherActivity> activityRule=new ActivityTestRule(WeatherActivity.class);

    @Test
    public void save() {
        IdlingResource idlingResource=activityRule.getActivity().countingIdlingResource;
        IdlingRegistry.getInstance().register(idlingResource);

        onView(withId(R.id.action_save)).perform(click()) ;
        onView(withId(R.id.progressBar)).check(selectedDescendantsMatch(isAssignableFrom(ProgressBar.class),not(isDisplayed())));

        IdlingRegistry.getInstance().unregister(idlingResource);
    }
}