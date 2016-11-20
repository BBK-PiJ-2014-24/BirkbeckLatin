package com.example.snewnham.birkbecklatin.model.advancedRandomGeneratorTests;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

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
    String CONJUNCTION_TABLE = "Conjunction_Table";

    String NOUN = "Noun";
    String ADJECTIVE = "Adjective";
    String PREPOSITION = "Preposition";
    String CONJUNCTION = "Conjunction";
    String ADVERB = "Adverb";

    RandomGenerator randomGenerator;
    DatabaseAccess databaseAccess;
    Context appContext;

    @Before
    public void setUp() {
        randomGenerator = new RandomGenerator();
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
    }


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
            String ans = randomGenerator.getNounEtc();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

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

    @After
    public void breakDown() {
        databaseAccess.close();
    }





}
