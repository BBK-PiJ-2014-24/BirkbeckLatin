package com.example.snewnham.birkbecklatin.model.randomGeneratorTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES FOR 1st COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class RandomGeneratorTests {

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

    RandomGenerator randomGenerator;


    @Before
    public void setUp() {

        randomGenerator = new RandomGenerator();

    }



    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testNounCase() throws Exception {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<10000; i++) {
            String ans = randomGenerator.getNounCase();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

    }



}
