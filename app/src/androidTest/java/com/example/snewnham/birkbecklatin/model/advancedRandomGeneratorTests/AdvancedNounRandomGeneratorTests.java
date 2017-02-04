package com.example.snewnham.birkbecklatin.model.advancedRandomGeneratorTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

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

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES FOR 1st COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class AdvancedNounRandomGeneratorTests {

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

    String NOUN_REGULAR = "NounRegular";
    String NOUN_IRREGULAR = "NounIrregular";

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

    int numNounRegular;
    int numNounIrregular;
    int numNouns = numNounRegular + numNounIrregular;
    int numPreposition;
    int numConjunction;
    int numAdjective;
    int numAdverb;

    RandomGenerator randomGenerator;
    DatabaseAccess databaseAccess;
    Context appContext;

    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
        randomGenerator = new RandomGenerator(databaseAccess);

        numNounRegular = databaseAccess.sqlNounTypeCount(NOUN_REGULAR);
        numNounIrregular = databaseAccess.sqlNounTypeCount(NOUN_IRREGULAR);
        numNouns = numNounRegular + numNounIrregular;
        numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);

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
        int randomSims = 100;
        int numNounRegular = databaseAccess.sqlNounTypeCount(NOUN_REGULAR);
        int numNounIrregular = databaseAccess.sqlNounTypeCount(NOUN_IRREGULAR);
        int numNouns = numNounRegular + numNounIrregular;
        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        int numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);

        int total = numNouns + numPreposition + numConjunction + numAdjective + numAdverb;

        int sampleNounRegulars = (randomSims * numNounRegular)/total;
        int sampleNounIrregulars = (randomSims * numNounIrregular)/total;
        int sampleAdjective = (randomSims * numAdjective)/total;
        int samplePreposition = (randomSims * numPreposition)/total;
        int sampleConjunction = (randomSims * numConjunction)/total;
        int sampleAdverb = (randomSims * numAdverb)/total;

        float toleranceFactor = 0.55f;
        int toleranceNounRegulars = (int) (sampleNounRegulars * toleranceFactor);
        int toleranceNounIrregulars = (int) (sampleNounIrregulars * toleranceFactor) + 5;
        int toleranceAdjective = (int) (sampleAdjective * toleranceFactor);
        int tolerancePreposition = (int) (samplePreposition * toleranceFactor);
        int toleranceConjunction = (int) (sampleConjunction * toleranceFactor);
        int toleranceAdverb = (int) (sampleAdverb * toleranceFactor);

        for(int i=0; i<randomSims; i++) {
            Thread.sleep(100);
            String ans = randomGenerator.getNounEtcType();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }
        int x = 5;
        Thread.sleep(100);
        assertThat("Num NOUN_REGULAR Simulations", map.get(NOUN_REGULAR), greaterThan(sampleNounRegulars - toleranceNounRegulars));
        assertThat("Num NOUN_REGULAR Simulations", map.get(NOUN_REGULAR), lessThan(sampleNounRegulars + toleranceNounRegulars));

        assertThat("Num NOUN_IRREGULAR Simulations", map.get(NOUN_IRREGULAR), greaterThan(sampleNounIrregulars - toleranceNounIrregulars));
        assertThat("Num NOUN_IRREGULAR Simulations", map.get(NOUN_IRREGULAR), lessThan(sampleNounIrregulars + toleranceNounIrregulars));

        assertThat("Num PREPOSITION Simulations", map.get(PREPOSITION), greaterThan(samplePreposition - tolerancePreposition));
        assertThat("Num PREPOSITION Simulations", map.get(PREPOSITION), lessThan(samplePreposition + tolerancePreposition));

        assertThat("Num CONJUNCTION Simulations", map.get(CONJUNCTION), greaterThan(sampleConjunction - toleranceConjunction));
        assertThat("Num CONJUNCTION Simulations", map.get(CONJUNCTION), lessThan(sampleConjunction + toleranceConjunction));

        assertThat("Num ADJECTIVE Simulations", map.get(ADJECTIVE), greaterThan(sampleAdjective - toleranceAdjective));
        assertThat("Num ADJECTIVE Simulations", map.get(ADJECTIVE), lessThan(sampleAdjective + toleranceAdjective));

        assertThat("Num ADVERB Simulations", map.get(ADVERB), greaterThan(sampleAdverb - toleranceAdverb));
        assertThat("Num ADVERB Simulations", map.get(ADVERB), lessThan(sampleAdverb + toleranceAdverb));
    }

    /**
     * testConstrainedRandomNounEtcType() - SkillLevel1
     * ----------------------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * subject to Skill Level.
     * @throws Exception
     */
    @Test
    public void testConstrainedRandomNounEtcType_SkillLevel_1() throws Exception {

        int randomSims = 200;
        int total = numNounRegular;


        // Test for Skill Level 1, where only REGULAR Nouns are Accepted
        int skillLevel1 = 1;
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < randomSims; i++) {
            Thread.sleep(10);
            String ans = randomGenerator.getNounEtcType(skillLevel1);
            if (!map1.containsKey(ans))
                map1.put(ans, 1);
            else
                map1.put(ans, map1.get(ans) + 1);
        }
        assertEquals("Size of Map1", map1.size(), 1);
        assertEquals("Num NOUN Simulations", map1.get(NOUN_REGULAR), randomSims, 2);

    }

    /**
     * testConstrainedRandomNounEtcType() - SkillLevel2
     * ----------------------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * subject to Skill Level.
     * @throws Exception
     */
    @Test
    public void testConstrainedRandomNounEtcType_SkillLevel_2() throws Exception {

        int skillLevel2 = 2;
        int randomSims = 40;
        int total = numNounRegular + numNounIrregular;

        int sampleNounRegulars = (randomSims * numNounRegular) / total;
        int sampleNounIrregulars = (randomSims * numNounIrregular) / total;

        float toleranceFactor = 0.45f;
        int toleranceNounRegulars = (int) (sampleNounRegulars * toleranceFactor);
        int toleranceNounIrregulars = (int) (sampleNounIrregulars * toleranceFactor) + 5;



        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<randomSims; i++) {
            Thread.sleep(100);
            String ans = randomGenerator.getNounEtcType(skillLevel2);
            if (!map2.containsKey(ans))
                map2.put(ans, 1);
            else
                map2.put(ans, map2.get(ans) + 1);
        }
        int x = 5;
        Thread.sleep(100);
        assertEquals("Size of Map2", map2.size(), 2);

        assertThat("Num NOUN_REGULAR Simulations", map2.get(NOUN_REGULAR), greaterThan(sampleNounRegulars - toleranceNounRegulars));
        assertThat("Num NOUN_REGULAR Simulations", map2.get(NOUN_REGULAR), lessThan(sampleNounRegulars + toleranceNounRegulars));

        assertThat("Num NOUN_IRREGULAR Simulations", map2.get(NOUN_IRREGULAR), greaterThan(sampleNounIrregulars - toleranceNounIrregulars));
        assertThat("Num NOUN_IRREGULAR Simulations", map2.get(NOUN_IRREGULAR), lessThan(sampleNounIrregulars + toleranceNounIrregulars));
    }


    /**
     * testConstrainedRandomNounEtcType() - SkillLevel3
     * ----------------------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * subject to Skill Level.
     * @throws Exception
     */
    @Test
    public void testConstrainedRandomNounEtcType_SkillLevel_3() throws Exception {

        int skillLevel3 = 3;
        int randomSims = 75;
        int total = numNounRegular + numNounIrregular + numConjunction + numPreposition;

        int sampleNounRegulars = (randomSims * numNounRegular) / total;
        int sampleNounIrregulars = (randomSims * numNounIrregular) / total;
        int sampleConjunction = (randomSims * numConjunction) / total;
        int samplePreposition = (randomSims * numPreposition) / total;

        float toleranceFactor = 0.45f;
        int toleranceNounRegulars = (int) (sampleNounRegulars * toleranceFactor);
        int toleranceNounIrregulars = (int) (sampleNounIrregulars * toleranceFactor) + 5;
        int tolerancePreposition = (int) (samplePreposition * toleranceFactor);
        int toleranceConjunction = (int) (sampleConjunction * toleranceFactor);


        Map<String, Integer> map3 = new HashMap<>();
        for(int i=0; i<randomSims; i++) {
            Thread.sleep(100);
            String ans = randomGenerator.getNounEtcType(skillLevel3);
            if (!map3.containsKey(ans))
                map3.put(ans, 1);
            else
                map3.put(ans, map3.get(ans) + 1);
        }
        int x = 5;
        Thread.sleep(100);
        assertEquals("Size of Map3", 4, map3.size());

        assertThat("Num NOUN_REGULAR Simulations", map3.get(NOUN_REGULAR), greaterThan(sampleNounRegulars - toleranceNounRegulars));
        assertThat("Num NOUN_REGULAR Simulations", map3.get(NOUN_REGULAR), lessThan(sampleNounRegulars + toleranceNounRegulars));

        assertThat("Num NOUN_IRREGULAR Simulations", map3.get(NOUN_IRREGULAR), greaterThan(sampleNounIrregulars - toleranceNounIrregulars));
        assertThat("Num NOUN_IRREGULAR Simulations", map3.get(NOUN_IRREGULAR), lessThan(sampleNounIrregulars + toleranceNounIrregulars));

        assertThat("Num PREPOSITION Simulations", map3.get(PREPOSITION), greaterThan(samplePreposition - tolerancePreposition));
        assertThat("Num PREPOSITION Simulations", map3.get(PREPOSITION), lessThan(samplePreposition + tolerancePreposition));

        assertThat("Num CONJUNCTION Simulations", map3.get(CONJUNCTION), greaterThan(sampleConjunction - toleranceConjunction));
        assertThat("Num CONJUNCTION Simulations", map3.get(CONJUNCTION), lessThan(sampleConjunction + toleranceConjunction));

    }


    /**
     * testConstrainedRandomNounEtcType() - SkillLevel4
     * ----------------------------------
     * Tests the randomness of Generating a NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     * subject to Skill Level.
     * @throws Exception
     */
    @Test
    public void testConstrainedRandomNounEtcType_SkillLevel_4() throws Exception {

        int skillLevel4 = 4;
        int randomSims = 75;
        int total = numNounRegular + numNounIrregular + numConjunction + numPreposition;

        int sampleNounRegulars = (randomSims * numNounRegular) / total;
        int sampleNounIrregulars = (randomSims * numNounIrregular) / total;
        int sampleConjunction = (randomSims * numConjunction) / total;
        int samplePreposition = (randomSims * numPreposition) / total;
        int sampleAdjective = (randomSims * numAdjective)/total;


        float toleranceFactor = 0.45f;
        int toleranceNounRegulars = (int) (sampleNounRegulars * toleranceFactor);
        int toleranceNounIrregulars = (int) (sampleNounIrregulars * toleranceFactor) + 5;
        int tolerancePreposition = (int) (samplePreposition * toleranceFactor);
        int toleranceConjunction = (int) (sampleConjunction * toleranceFactor) + 5;
        int toleranceAdjective = (int) (sampleAdjective * toleranceFactor);


        Map<String, Integer> map4 = new HashMap<>();
        for(int i=0; i<randomSims; i++) {
            Thread.sleep(100);
            String ans = randomGenerator.getNounEtcType(skillLevel4);
            if (!map4.containsKey(ans))
                map4.put(ans, 1);
            else
                map4.put(ans, map4.get(ans) + 1);
        }
        int x = 5;
        Thread.sleep(100);
        assertEquals("Size of Map4", 5, map4.size());

        assertThat("Num NOUN_REGULAR Simulations", map4.get(NOUN_REGULAR), greaterThan(sampleNounRegulars - toleranceNounRegulars));
        assertThat("Num NOUN_REGULAR Simulations", map4.get(NOUN_REGULAR), lessThan(sampleNounRegulars + toleranceNounRegulars));

        assertThat("Num NOUN_IRREGULAR Simulations", map4.get(NOUN_IRREGULAR), greaterThan(sampleNounIrregulars - toleranceNounIrregulars));
        assertThat("Num NOUN_IRREGULAR Simulations", map4.get(NOUN_IRREGULAR), lessThan(sampleNounIrregulars + toleranceNounIrregulars));

        assertThat("Num PREPOSITION Simulations", map4.get(PREPOSITION), greaterThan(samplePreposition - tolerancePreposition));
        assertThat("Num PREPOSITION Simulations", map4.get(PREPOSITION), lessThan(samplePreposition + tolerancePreposition));

        assertThat("Num CONJUNCTION Simulations", map4.get(CONJUNCTION), greaterThan(sampleConjunction - toleranceConjunction));
        assertThat("Num CONJUNCTION Simulations", map4.get(CONJUNCTION), lessThan(sampleConjunction + toleranceConjunction));

        assertThat("Num ADJECTIVE Simulations", map4.get(ADJECTIVE), greaterThan(sampleAdjective - toleranceAdjective));
        assertThat("Num ADJECTIVE Simulations", map4.get(ADJECTIVE), lessThan(sampleAdjective + toleranceAdjective));

    }
    /**
     * testGetRandomNounEtcIDlist()
     * ----------------------------
     * Tests getRandomNounEtcIDlist() can generate six random NounEtc IDs
     * @throws Exception
     */
    @Test
    public void testGetRandomNounEtcIDlist() throws Exception {

        databaseAccess.sqlNounEtcTable_Reset(NOUN_TABLE, "Correct");
        databaseAccess.sqlNounEtcTable_Reset(NOUN_TABLE, "Asked");

        int skillLevel = 4;
        int correct = 1;
        List<Integer> listofIDs = new ArrayList<>();
        for(int i=0; i<100; i++){
            List<Integer> randomIDs = randomGenerator.getRandomNounEtcIDlist(NOUN_TABLE, skillLevel, correct );  // Select WHERE CORRECT = 1
            listofIDs.add(randomIDs.get(0));
            listofIDs.add(randomIDs.get(1));
            listofIDs.add(randomIDs.get(2));
            listofIDs.add(randomIDs.get(3));
            listofIDs.add(randomIDs.get(4));
            listofIDs.add(randomIDs.get(5));
        }
        int x=5;
        assertThat( listofIDs, hasItems(1,2,3,4,5,6,7,8,9,10,11,12,13) );  // check all IDs are included

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
