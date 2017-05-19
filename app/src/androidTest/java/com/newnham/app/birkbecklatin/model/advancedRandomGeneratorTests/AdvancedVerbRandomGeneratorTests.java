package com.newnham.app.birkbecklatin.model.advancedRandomGeneratorTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.database.DbSchema;
import com.newnham.app.birkbecklatin.Model.verbs.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE_PERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_IMPERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PLUPERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PRESENT;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES FOR 1st COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class AdvancedVerbRandomGeneratorTests {

    // Fields
    // ------

    RandomGenerator randomGenerator;
    DatabaseAccess databaseAccess;
    Context appContext;

    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
        randomGenerator = new RandomGenerator(databaseAccess);
    }



    // --------------------------------- VERB ------------------------------------------------------


    /**
     * testGetRestrictedRandomVerbID()
     * -------------------------------
     * Test for Selecting Verbs for Skill Level 1-3 in the Verb Game
     * Gets A Random Selected Verb ID from a Restricted Verb List (confined to
     * conj 1+2 and Esse Verb) and then gets the nearest Verb Id next to the random
     * selected Verb (which will be used for the incorrect options in multiple choice).
     * @return
     */
    @Test
    public void testGetRestrictedRandomVerbID(){

        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        int id4 = 4;
        int id5 = 5;
        int id6 = 6;
        int id7 = 7;
        int id8 = 8;
        int id9 = 9;
        int id10 = 10;

        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);

        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.CORRECT, 1);

        List<Integer> listofIDs = new ArrayList<>();
        for(int i=0; i<100; i++){
            List<Integer> pairIDs = randomGenerator.getRandomVerbIDpair(2,1,true);  // run method for 100 times
            listofIDs.add(pairIDs.get(0));
            listofIDs.add(pairIDs.get(1));
        }

        assertThat(listofIDs, hasItems(1,5,10));

    }


    /**
     * testGetUnrestrictedRandomVerbID()
     * ---------------------------------
     * Tests for getUnrestrictedRandomVerbID(), which selects a random List of (unrestricted) verb IDs.
     * Note that the verb IDs will be back to back.
     */
    @Test
    public void testGetUnrestrictedRandomVerbID(){


        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        int id4 = 4;
        int id5 = 5;
        int id6 = 6;
        int id7 = 7;
        int id8 = 8;
        int id9 = 9;
        int id10 = 10;

        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);

        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.CORRECT, 1);

        List<Integer> listofIDs = new ArrayList<>();
        for(int i=0; i<50; i++){
            List<Integer> pairIDs = randomGenerator.getRandomVerbIDpair(conjNum1_4, 1, false);  // Select WHERE CORRECT = 1
            listofIDs.add(pairIDs.get(0));
            listofIDs.add(pairIDs.get(1));
        }

        assertThat(10, isIn(listofIDs));  // check sample pair
        // assertThat(9, isIn(listofIDs));
        // assertThat(8, isIn(listofIDs));
        // assertThat(7, isIn(listofIDs));
        // assertThat(6, isIn(listofIDs));
        assertThat(5, isIn(listofIDs));
        // assertThat(4, isIn(listofIDs));
        // assertThat(3, isIn(listofIDs));
        // assertThat(2, isIn(listofIDs));
        assertThat(1, isIn(listofIDs));
    }


    /**
     * testGetVerbTenseList()
     * ----------------------
     * Test for getVerbTenseList(), which generates a random list of three tenses (all different).
     *
     */
    @Test
    public void testGetVerbTenseList(){

        int randomSims = 1200;
        int numTenses = 6;

        int sample = randomSims*3 / numTenses;
        float toleranceFactor = 0.2f;
        int toleranceForSample = (int) (sample * toleranceFactor);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<randomSims; i++) {
            List<String> list = randomGenerator.getVerbTenseList(); // get a list of verbs
            assertFalse(list.get(0).equals(list.get(1)));   // test different tenses in the list
            assertFalse(list.get(1).equals(list.get(2)));
            assertFalse(list.get(0).equals(list.get(2)));

            for(String ans : list) {                    // check for random distribution
                if (!map.containsKey(ans))
                    map.put(ans, 1);
                else
                    map.put(ans, map.get(ans) + 1);
            }
        }

        int x = 5;
        assertThat("Num VERB_TENSE_PRESENT Simulations", map.get(TENSE_PRESENT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PRESENT Simulations", map.get(TENSE_PRESENT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_IMPERFECT Simulations", map.get(TENSE_IMPERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_IMPERFECT Simulations", map.get(TENSE_IMPERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_FUTURE Simulations", map.get(TENSE_FUTURE), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_FUTURE Simulations", map.get(TENSE_FUTURE), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_PERFECT Simulations", map.get(TENSE_PERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PERFECT Simulations", map.get(TENSE_PERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_PLUPERFECT Simulations", map.get(TENSE_PLUPERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PLUPERFECT Simulations", map.get(TENSE_PLUPERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_FUTURE_PERFECT Simulations", map.get(TENSE_FUTURE_PERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_FUTURE_PERFECT Simulations", map.get(TENSE_FUTURE_PERFECT), lessThan(sample + toleranceForSample));
    }



    @Test
    public void testShuffleVerbList(){

        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        int id4 = 4;
        int id5 = 5;
        int id6 = 6;

        Verb v1 =  databaseAccess.sqlVerbListQuery(id1);
        Verb v2 =  databaseAccess.sqlVerbListQuery(id2);
        Verb v3 =  databaseAccess.sqlVerbListQuery(id3);
        Verb v4 =  databaseAccess.sqlVerbListQuery(id4);
        Verb v5 =  databaseAccess.sqlVerbListQuery(id5);
        Verb v6 =  databaseAccess.sqlVerbListQuery(id6);

        List<Verb> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);

        List<Verb> shuffleList = randomGenerator.shuffleVerbList(list);

        assertThat(v1, isIn(shuffleList));
        assertThat(v2, isIn(shuffleList));
        assertThat(v3, isIn(shuffleList));
        assertThat(v4, isIn(shuffleList));
        assertThat(v5, isIn(shuffleList));
        assertThat(v6, isIn(shuffleList));

    }




    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
