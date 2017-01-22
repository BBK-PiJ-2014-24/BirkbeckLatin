package com.example.snewnham.birkbecklatin.model.advancedRandomGeneratorTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.IncorrectNounOutput;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class AdvancedRandomGeneratorTests {

    // Fields
    // ------
    String SINGULAR = "singular";
    String PLURAL = "plural";


    String GENDER_MALE = "m";
    String GENDER_FEMALE = "f";
    String GENDER_NEUTER = "n";

    String NOMINATIVE = "Nominative";
    String ACCUSATIVE = "Accusative";
    String GENITIVE = "Genitive";
    String DATIVE = "Dative";
    String ABLATIVE = "Ablative";
    String VOCATIVE = "Vocative";

    String NOUN_TABLE = "Noun_List";
    String ADJECTIVE_TABLE = "Adjective_List";
    String ADVERB_TABLE = "Adverb_List";
    String PREPOSITION_TABLE = "Preposition_List";
    String CONJUNCTION_TABLE = "Conjunction_List";

    String NOUN = "Noun";
    String ADJECTIVE = "Adjective";
    String PREPOSITION = "Preposition";
    String CONJUNCTION = "Conjunction";
    String ADVERB = "Adverb";
    String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";
    String ADVERB_COMPARATIVE = "AdverbComparative";
    String ADVERB_SUPERLATIVE = "AdverbSuperlative";

    final String VERB_TENSE_PRESENT = "Present";
    final String VERB_TENSE_IMPERFECT = "Imperfect";
    final String VERB_TENSE_FUTURE = "Future";
    final String VERB_TENSE_PERFECT = "Perfect";
    final String VERB_TENSE_PLUPERFECT = "Pluperfect";
    final String VERB_TENSE_FUTURE_PERFECT = "Future Perfect";

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
        for(int i=0; i<100; i++){
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
        assertThat("Num VERB_TENSE_PRESENT Simulations", map.get(VERB_TENSE_PRESENT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PRESENT Simulations", map.get(VERB_TENSE_PRESENT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_IMPERFECT Simulations", map.get(VERB_TENSE_IMPERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_IMPERFECT Simulations", map.get(VERB_TENSE_IMPERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_FUTURE Simulations", map.get(VERB_TENSE_FUTURE), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_FUTURE Simulations", map.get(VERB_TENSE_FUTURE), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_PERFECT Simulations", map.get(VERB_TENSE_PERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PERFECT Simulations", map.get(VERB_TENSE_PERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_PLUPERFECT Simulations", map.get(VERB_TENSE_PLUPERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_PLUPERFECT Simulations", map.get(VERB_TENSE_PLUPERFECT), lessThan(sample + toleranceForSample));

        assertThat("Num VERB_TENSE_FUTURE_PERFECT Simulations", map.get(VERB_TENSE_FUTURE_PERFECT), greaterThan(sample - toleranceForSample));
        assertThat("Num VERB_TENSE_FUTURE_PERFECT Simulations", map.get(VERB_TENSE_FUTURE_PERFECT), lessThan(sample + toleranceForSample));
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







    // --------------------------------- NOUN ------------------------------------------------------
    /**
     * testRandomNounEtcType()
     * -----------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * @throws Exception
     */
    @Test
    public void testRandomNounEtcType() throws Exception {

        Map<String, Integer> map = new HashMap<>();
        int randomSims = 10000;
        int numNouns = databaseAccess.sqlTableCountQuery(NOUN_TABLE);
        int numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        int total = numNouns + numAdjective + numPreposition + numConjunction + numAdverb;

        int sampleNouns = (randomSims * numNouns)/total;
        int sampleAdjective = (randomSims * numAdjective)/total;
        int samplePreposition = (randomSims * numPreposition)/total;
        int sampleConjunction = (randomSims * numConjunction)/total;
        int sampleAdverb = (randomSims * numAdverb)/total;

        float toleranceFactor = 0.15f;
        int toleranceNoun = (int) (sampleNouns * toleranceFactor);
        int toleranceAdjective = (int) (sampleAdjective * toleranceFactor);
        int tolerancePreposition = (int) (samplePreposition * toleranceFactor);
        int toleranceConjunction = (int) (sampleConjunction * toleranceFactor);
        int toleranceAdverb = (int) (sampleAdverb * toleranceFactor);


        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getNounEtcType();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }
        int x = 5;
        assertThat("Num NOUN Simulations", map.get(NOUN), greaterThan(sampleNouns - toleranceNoun));
        assertThat("Num NOUN Simulations", map.get(NOUN), lessThan(sampleNouns + toleranceNoun));

        assertThat("Num ADJECTIVE Simulations", map.get(ADJECTIVE), greaterThan(sampleAdjective - toleranceAdjective));
        assertThat("Num ADJECTIVE Simulations", map.get(ADJECTIVE), lessThan(sampleAdjective + toleranceAdjective));

        assertThat("Num PREPOSITION Simulations", map.get(PREPOSITION), greaterThan(samplePreposition - tolerancePreposition));
        assertThat("Num PREPOSITION Simulations", map.get(PREPOSITION), lessThan(samplePreposition + tolerancePreposition));

        assertThat("Num CONJUNCTION Simulations", map.get(CONJUNCTION), greaterThan(sampleConjunction - toleranceConjunction));
        assertThat("Num CONJUNCTION Simulations", map.get(CONJUNCTION), lessThan(sampleConjunction + toleranceConjunction));

        assertThat("Num ADVERB Simulations", map.get(ADVERB), greaterThan(sampleAdverb - toleranceAdverb));
        assertThat("Num ADVERB Simulations", map.get(ADVERB), lessThan(sampleAdverb + toleranceAdverb));

    }

    /**
     * testConstrainedRandomNounEtcType()
     * -----------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * subject to Skill Level.
     * @throws Exception
     */
    @Test
    public void testConstrainedRandomNounEtcType() throws Exception {


        int randomSims = 10000;
        int numNouns = databaseAccess.sqlTableCountQuery(NOUN_TABLE);
        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int total = numNouns +  numPreposition + numConjunction;

        int sampleNouns = (randomSims * numNouns)/total;
        int samplePreposition = (randomSims * numPreposition)/total;
        int sampleConjunction = (randomSims * numConjunction)/total;

        float toleranceFactor = 0.15f;
        int toleranceNoun = (int) (sampleNouns * toleranceFactor);
        int tolerancePreposition = (int) (samplePreposition * toleranceFactor);
        int toleranceConjunction = (int) (sampleConjunction * toleranceFactor);


        // Test for Skill Level 1, where only Nouns are Accepted
        int skillLevel1 = 1;
        Map<String, Integer> map1 = new HashMap<>();
        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getNounEtcType(skillLevel1);
            if (!map1.containsKey(ans))
                map1.put(ans, 1);
            else
                map1.put(ans, map1.get(ans) + 1);
        }

        assertEquals("Size of Map1", 1, map1.size());
        assertEquals("Num NOUN Simulations", map1.get(NOUN), randomSims, 2);

        // Test for Skill Level 3, where only Nouns, Prepositions and Conjunctions are Accepted
        skillLevel1 = 3;
        Map<String, Integer> map3 = new HashMap<>();
        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getNounEtcType(skillLevel1);
            if (!map3.containsKey(ans))
                map3.put(ans, 1);
            else
                map3.put(ans, map3.get(ans) + 1);
        }

        assertEquals("Size of map3", 3, map3.size());

        assertThat("Num NOUN Simulations", map3.get(NOUN), greaterThan(sampleNouns - toleranceNoun));
        assertThat("Num NOUN Simulations", map3.get(NOUN), lessThan(sampleNouns + toleranceNoun));

        assertThat("Num PREPOSITION Simulations", map3.get(PREPOSITION), greaterThan(samplePreposition - tolerancePreposition));
        assertThat("Num PREPOSITION Simulations", map3.get(PREPOSITION), lessThan(samplePreposition + tolerancePreposition));

        assertThat("Num CONJUNCTION Simulations", map3.get(CONJUNCTION), greaterThan(sampleConjunction - toleranceConjunction));
        assertThat("Num CONJUNCTION Simulations", map3.get(CONJUNCTION), lessThan(sampleConjunction + toleranceConjunction));

    }



    /**
     * testRandomAdjectiveType()
     * -------------------------
     * Generate a random Adjective Type (Standard, Comparative, Superlative)
     * @throws Exception
     */
    @Test
    public void testRandomAdjectiveType() throws Exception {

        int randomSims = 80000;
        int numAdjective = 2;
        int numAdjComparative = 1;
        int numAdjSuperlative = 1;
        int total = 4;

        int sampleAdjective = (randomSims * numAdjective)/total;
        int sampleComparative = (randomSims * numAdjComparative)/total;
        int sampleSuperlative = (randomSims * numAdjSuperlative)/total;
        float toleranceFactor = 0.15f;
        int toleranceAdjective = (int) (sampleAdjective * toleranceFactor);
        int toleranceComparative = (int) (sampleComparative * toleranceFactor);
        int toleranceSuperlative = (int) (sampleSuperlative * toleranceFactor);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getAdjectiveType();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }
        int x = 5;
        assertThat("Num ADJECTIVE_STANDARD Simulations", map.get(ADJECTIVE), greaterThan(sampleAdjective - toleranceAdjective));
        assertThat("Num ADJECTIVE_STANDARD Simulations", map.get(ADJECTIVE), lessThan(sampleAdjective + toleranceAdjective));

        assertThat("Num ADJECTIVE_COMPARATIVE Simulations", map.get(ADJECTIVE_COMPARATIVE), greaterThan(sampleComparative - toleranceComparative));
        assertThat("Num ADJECTIVE_COMPARATIVE Simulations", map.get(ADJECTIVE_COMPARATIVE), lessThan(sampleComparative + toleranceComparative));

        assertThat("Num ADJECTIVE_SUPERLATIVE Simulations", map.get(ADJECTIVE_SUPERLATIVE), greaterThan(sampleComparative - toleranceSuperlative));
        assertThat("Num ADJECTIVE_SUPERLATIVE Simulations", map.get(ADJECTIVE_SUPERLATIVE), lessThan(sampleComparative + toleranceSuperlative));
    }

    /**
     * testRandomAdverbType()
     * -------------------------
     * Generate a random Adverb Type (Standard, Comparative, Superlative)
     * @throws Exception
     */
    @Test
    public void testRandomAdverbType() throws Exception {

        int randomSims = 80000;
        int numAdverb = 2;
        int numAdverbComparative = 1;
        int numAdverbSuperlative = 1;
        int total = 4;

        int sampleAdverb = (randomSims * numAdverb)/total;
        int sampleComparative = (randomSims * numAdverbComparative)/total;
        int sampleSuperlative = (randomSims * numAdverbSuperlative)/total;
        float toleranceFactor = 0.15f;
        int toleranceAdjective = (int) (sampleAdverb * toleranceFactor);
        int toleranceComparative = (int) (sampleComparative * toleranceFactor);
        int toleranceSuperlative = (int) (sampleSuperlative * toleranceFactor);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getAdverbType();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }
        int x = 5;
        assertThat("Num ADVERB_STANDARD Simulations", map.get(ADVERB), greaterThan(sampleAdverb - toleranceAdjective));
        assertThat("Num ADVERB_STANDARD Simulations", map.get(ADVERB), lessThan(sampleAdverb + toleranceAdjective));

        assertThat("Num ADVERB_COMPARATIVE Simulations", map.get(ADVERB_COMPARATIVE), greaterThan(sampleComparative - toleranceComparative));
        assertThat("Num ADVERB_COMPARATIVE Simulations", map.get(ADVERB_COMPARATIVE), lessThan(sampleComparative + toleranceComparative));

        assertThat("Num ADVERB_SUPERLATIVE Simulations", map.get(ADVERB_SUPERLATIVE), greaterThan(sampleComparative - toleranceSuperlative));
        assertThat("Num ADVERB_SUPERLATIVE Simulations", map.get(ADVERB_SUPERLATIVE), lessThan(sampleComparative + toleranceSuperlative));
    }


//    /**
//     * testRandomNounIncorrectTable()
//     * ------------------------------
//     * Test for random selection of a noun_id + Noun_Type from the IncorrectVerb Table
//     * using the IncorrectNounOutput class to take the (Noun_Type, NounID) pair.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testRandomNounIncorrectTable() throws Exception {
//
//        String noun = "NOUN";
//        String irregularNoun = "IRREGULAR_NOUN";
//        String adjective = "ADJECTIVE";
//        String conjunction = "CONJUNCTION";
//        String preposition = "PREPOSITION";
//
//        int nounId1 = 10;
//        int nounId2 = 20;
//        int nounId3 = 30;
//        int nounId4 = 40;
//
//        int randomSims = 400;
//
//        // load the table
//        databaseAccess.sqlIncorrectNounEtc_Reset();
//        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId1);
//        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId2);
//        databaseAccess.sqlIncorrectNounEtc_Insert(adjective, nounId3);
//        databaseAccess.sqlIncorrectNounEtc_Insert(adjective, nounId4);
//        int numVerbs = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
//
//
//        int sample = randomSims / numVerbs;
//        float toleranceFactor = 0.25f;
//        int toleranceForSample = (int) (sample * toleranceFactor);
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0; i<randomSims; i++) {
//            IncorrectNounOutput ans = randomGenerator.getIncorrectNounOutput();
//            if (!map.containsKey(ans.getNounId()))
//                map.put(ans.getNounId(), 1);
//            else
//                map.put(ans.getNounId(), map.get(ans.getNounId()) + 1);
//        }
//        int x = 5;
//        assertThat("Num nounId_1 Simulations", map.get(nounId1), greaterThan(sample - toleranceForSample));
//        assertThat("Num nounId_1 Simulations", map.get(nounId1), lessThan(sample + toleranceForSample));
//
//        assertThat("Num nounId_2 Simulations", map.get(nounId2), greaterThan(sample - toleranceForSample));
//        assertThat("Num nounId_2 Simulations", map.get(nounId2), lessThan(sample + toleranceForSample));
//
//        assertThat("Num nounId_3 Simulations", map.get(nounId3), greaterThan(sample - toleranceForSample));
//        assertThat("Num nounId_3 Simulations", map.get(nounId3), lessThan(sample + toleranceForSample));
//
//        assertThat("Num nounId_4 Simulations", map.get(nounId4), greaterThan(sample - toleranceForSample));
//        assertThat("Num nounId_4 Simulations", map.get(nounId4), lessThan(sample + toleranceForSample));
//
//    }







    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
