package com.example.snewnham.birkbecklatin.model.espressoTests;

import android.support.test.rule.ActivityTestRule;

import android.support.test.espresso.intent.Intents;


import com.example.snewnham.birkbecklatin.R;
import com.example.snewnham.birkbecklatin.view.MainActivity2;
import com.example.snewnham.birkbecklatin.view.VerbGameActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by snewnham on 29/12/2016.
 */

public class IntentTests {

    @Rule
    public ActivityTestRule<MainActivity2> mActivityTestRule = new ActivityTestRule<>(MainActivity2.class);


    /**
     * checkSendIntentToVerbPager()
     * ----------------------------
     * Tests for an outgoing intent From Main Activity -> Verb Pager
     * @throws Exception
     */
//    @Test
//    public void checkSendIntentToVerbPager() throws Exception {
//        Intents.init();
//
//        Thread.sleep(3000);
//        onView(withId(R.id.buttonPager)).perform(click());
//
//        intended(allOf(
//                hasComponent( VerbPagerActivity.class.getName() ),
//                hasExtra( "Conj_Number", 1) ) );
//
//        Intents.release();
//    }


    /**
     * checkSendIntentToVerbGame()
     * ----------------------------
     * Tests for an outgoing intent From Main Activity -> Verb Pager
     * @throws Exception
     */
    @Test
    public void checkSendIntentToVerbGame() throws Exception {
        Intents.init();

        Thread.sleep(3000);
        onView(withId(R.id.buttonVerbGame)).perform(click());

        intended( hasComponent(VerbGameActivity.class.getName()) );

        Intents.release();
    }
}


