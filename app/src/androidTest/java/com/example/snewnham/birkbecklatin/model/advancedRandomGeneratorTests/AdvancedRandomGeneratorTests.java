package com.example.snewnham.birkbecklatin.model.advancedRandomGeneratorTests;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
     * testRandomVerbIncorrectTable()
     * ------------------------------
     * Test for random selection of a verb_id from the IncorrectVerb Table.
     *
     * @throws Exception
     */
    @Test
    public void testRandomVerbIncorrectTable() throws Exception {

        int id1 = 1;
        int verbId1 = 10;
        int id2 = 2;
        int verbId2 = 20;
        int id3 = 3;
        int verbId3 = 30;
        int id4 = 4;
        int verbId4 = 40;

        int randomSims = 800;

        // load the table
        databaseAccess.sqlIncorrectVerb_Reset();
        databaseAccess.sqlIncorrectVerb_Insert(verbId1);
        databaseAccess.sqlIncorrectVerb_Insert(verbId2);
        databaseAccess.sqlIncorrectVerb_Insert(verbId3);
        databaseAccess.sqlIncorrectVerb_Insert(verbId4);
        int numVerbs = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE);


        int sample = randomSims / numVerbs;
        float toleranceFactor = 0.15f;
        int toleranceForSample = (int) (sample * toleranceFactor);


        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<randomSims; i++) {
            int ans = randomGenerator.getIncorrectVerbId();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }
        int x = 5;
        assertThat("Num verbId_1 Simulations", map.get(verbId1), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_1 Simulations", map.get(verbId1), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_2 Simulations", map.get(verbId2), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_2 Simulations", map.get(verbId2), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_3 Simulations", map.get(verbId3), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_3 Simulations", map.get(verbId3), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_4 Simulations", map.get(verbId4), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_4 Simulations", map.get(verbId4), lessThan(sample + toleranceForSample));

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
        int randomSims = 100000;
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



    @After
    public void breakDown() {
        databaseAccess.close();
    }





}
