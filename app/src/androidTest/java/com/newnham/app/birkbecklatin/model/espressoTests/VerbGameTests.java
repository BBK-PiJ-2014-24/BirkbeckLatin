package com.newnham.app.birkbecklatin.model.espressoTests;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import com.newnham.app.birkbecklatin.R;
import com.newnham.app.birkbecklatin.view.MainActivity2;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by snewnham on 29/12/2016.
 */

public class VerbGameTests {

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

        Thread.sleep(1000);
        onView(withId(R.id.buttonVerbGame)).perform(click());
        Thread.sleep(5000);

         for(int i=0; i<5; i++) {
            Thread.sleep(1000);
            onView(withId(R.id.buttonNext)).perform(click());
        }

        int x=5;

    }
}


