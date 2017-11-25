package com.newnham.app.GCSE_Latin;

import com.newnham.app.GCSE_Latin.Control.randomGenerator.RandomGenerator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BasicRandomGeneratorJUnitTests {


    // Fields
    // ------
    String SINGULAR = "Singular";
    String PLURAL = "Plural";


    String GENDER_MALE = "m";
    String GENDER_FEMALE = "f";
    String GENDER_NEUTER = "n";

    String NOMINATIVE = "Nominative";
    String ACCUSATIVE = "Accusative";
    String GENITIVE = "Genitive";
    String DATIVE = "Dative";
    String ABLATIVE = "Ablative";
    String VOCATIVE = "Vocative";

    String VERB_PERSON_1ST = "1st";
    String VERB_PERSON_2ND = "2nd";
    String VERB_PERSON_3RD = "3rd";

    String VERB_TENSE_PRESENT = "Present";
    String VERB_TENSE_IMPERFECT = "Imperfect";
    String VERB_TENSE_FUTURE = "Future";
    String VERB_TENSE_PERFECT = "Perfect";
    String VERB_TENSE_PLUPERFECT = "Pluperfect";
    String VERB_TENSE_FUTURE_PERFECT = "Future Perfect";

    String VERB_VOICE_ACTIVE = "Active";
    String VERB_VOICE_PASSIVE = "Passive";

    String VERB_NUMBER_SINGULAR = "Singular";
    String VERB_NUMBER_PLURAL = "Plural";
    String VERB_NUMBER_INFINITIVE = "Infinitive";

    String VERB_MOOD_INDICATIVE = "Indicative";
    String VERB_MOOD_SUBJUNCTIVE = "Subjunctive";
    String VERB_MOOD_IMPERATIVE = "Imperative";

    RandomGenerator randomGenerator;


    @Before
    public void setUp() {
        randomGenerator = new RandomGenerator();
    }


    // -------------------------------- NOUNS --------------------------------------------------

    /**
     * testRandomNounCase()
     * --------------------
     * Tests the Randomness of Generating Case Declensions for Nouns
     * @throws Exception
     */
    @Test
    public void testRandomNounCase() throws Exception {

        Map<String, Integer> map = new HashMap<>();
        int randomSims = 10400;
        int numOutcomes = 52;
        int numVocaOutcome = 2;
        int tolerance = 300;
        int approxAns =  randomSims/(numOutcomes/10);
        int approxVocAns = ((randomSims*numVocaOutcome)/numOutcomes);

        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getNounCase();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        int a = map.get(NOMINATIVE);
        assertThat("Num Nominative Simulations", map.get(NOMINATIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Nominative Simulations", map.get(NOMINATIVE), lessThan(approxAns + tolerance));

        assertThat("Num Accusative Simulations", map.get(ACCUSATIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Accusative Simulations", map.get(ACCUSATIVE), lessThan(approxAns + tolerance));

        assertThat("Num Genitive Simulations", map.get(GENITIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Genitive Simulations", map.get(GENITIVE), lessThan(approxAns + tolerance));

        assertThat("Num Dative Simulations", map.get(DATIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Dative Simulations", map.get(DATIVE), lessThan(approxAns + tolerance));

        assertThat("Num Ablative Simulations", map.get(ABLATIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Ablative Simulations", map.get(ABLATIVE), lessThan(approxAns + tolerance));

        assertThat("Num Vocative Simulations", map.get(VOCATIVE), greaterThan(approxVocAns - tolerance));
        assertThat("Num Vocative Simulations", map.get(VOCATIVE), lessThan(approxVocAns + tolerance));
    }


    /**
     * testRandomNounNumber()
     * ----------------------
     * Tests the randomness of generating NUMBER arguments (Singular, Plural)
     * @throws Exception
     */
    @Test
    public void testRandomNounNumber() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 40000;
        int numOutcomes = 2;
        int approxAns =  randomSims/numOutcomes;
        int tolerance = 1000;


        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getNounNumber();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        assertThat("Num Singular Simulations", map.get(SINGULAR), greaterThan(approxAns - tolerance));
        assertThat("Num Singular Simulations", map.get(SINGULAR), lessThan(approxAns + tolerance));

        assertThat("Num Plural Simulations", map.get(PLURAL), greaterThan(approxAns - tolerance));
        assertThat("Num Plural Simulations", map.get(PLURAL), lessThan(approxAns + tolerance));
    }

    /**
     * testRandomAdjGender()
     * ----------------------
     * Tests the randomness of generating GENDER arguments for Adjectives (m,f,n)
     * @throws Exception
     */
    @Test
    public void testRandomAdjGender() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 60000;
        int numOutcomes = 3;
        int approxAns =  randomSims/numOutcomes;
        int tolerance = 1000;


        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getAdjectiveGender();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        assertThat("Num Gender_Male Simulations", map.get(GENDER_MALE), greaterThan(approxAns - tolerance));
        assertThat("Num Gender_Male Simulations", map.get(GENDER_MALE), lessThan(approxAns + tolerance));

        assertThat("Num Gender_Female Simulations", map.get(GENDER_FEMALE), greaterThan(approxAns - tolerance));
        assertThat("Num Gender_Female Simulations", map.get(GENDER_FEMALE), lessThan(approxAns + tolerance));

        assertThat("Num Gender_Neuter Simulations", map.get(GENDER_NEUTER), greaterThan(approxAns - tolerance));
        assertThat("Num Gender_Neuter Simulations", map.get(GENDER_NEUTER), lessThan(approxAns + tolerance));
    }


    /**
     * testRandomAdjGender()
     * ----------------------
     * Tests the randomness of generating GENDER arguments for Adjectives (m,f,n)
     * @throws Exception
     */
    @Test
    public void testRandomVerbPersons() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 60000;
        int numOutcomes = 3;
        int approxAns =  randomSims/numOutcomes;
        int tolerance = 1000;


        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getVerbPerson();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        assertThat("Num Verb 1st Person Simulations", map.get(VERB_PERSON_1ST), greaterThan(approxAns - tolerance));
        assertThat("Num Verb 1st Person Simulations", map.get(VERB_PERSON_1ST), lessThan(approxAns + tolerance));

        assertThat("Num Verb 2nd Person Simulations", map.get(VERB_PERSON_2ND), greaterThan(approxAns - tolerance));
        assertThat("Num Verb 2nd Person Simulations", map.get(VERB_PERSON_2ND), lessThan(approxAns + tolerance));

        assertThat("Num Verb 3rd Person Simulations", map.get(VERB_PERSON_3RD), greaterThan(approxAns - tolerance));
        assertThat("Num Verb 3rd Person Simulations", map.get(VERB_PERSON_3RD), lessThan(approxAns + tolerance));
    }


    // -------------------------------- VERBS --------------------------------------------------

    /**
     * testRandomVerbTense()
     * ----------------------
     * Tests the randomness of generating TENSE arguments for VERBS (TENSE_PRESENT, TENSE_IMPERFECT, ETC.)
     * @throws Exception
     */
    @Test
    public void testRandomVerbTense() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 120000;
        int numOutcomes = 6;
        int approxAns =  randomSims/numOutcomes;
        int tolerance = 1000;


        for(int i=0; i<randomSims; i++) {
            String ans = randomGenerator.getVerbTense();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        assertThat("Num Verb TENSE_PRESENT TENSE Simulations", map.get(VERB_TENSE_PRESENT), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_PRESENT TENSE Simulations", map.get(VERB_TENSE_PRESENT), lessThan(approxAns + tolerance));

        assertThat("Num Verb TENSE_IMPERFECT TENSE Simulations", map.get(VERB_TENSE_IMPERFECT), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_IMPERFECT TENSE Simulations", map.get(VERB_TENSE_IMPERFECT), lessThan(approxAns + tolerance));

        assertThat("Num Verb TENSE_FUTURE TENSE Simulations", map.get(VERB_TENSE_FUTURE), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_FUTURE TENSE Simulations", map.get(VERB_TENSE_FUTURE), lessThan(approxAns + tolerance));

        assertThat("Num Verb TENSE_PERFECT TENSE Simulations", map.get(VERB_TENSE_PERFECT), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_PERFECT TENSE Simulations", map.get(VERB_TENSE_PERFECT), lessThan(approxAns + tolerance));

        assertThat("Num Verb TENSE_PLUPERFECT TENSE Simulations", map.get(VERB_TENSE_PLUPERFECT), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_PLUPERFECT TENSE Simulations", map.get(VERB_TENSE_PLUPERFECT), lessThan(approxAns + tolerance));

        assertThat("Num Verb TENSE_FUTURE_PERFECT TENSE Simulations", map.get(VERB_TENSE_FUTURE_PERFECT), greaterThan(approxAns - tolerance));
        assertThat("Num Verb TENSE_FUTURE_PERFECT TENSE Simulations", map.get(VERB_TENSE_FUTURE_PERFECT), lessThan(approxAns + tolerance));
    }

    /**
     * testRandomAdjGender()
     * ----------------------
     * Tests the randomness of generating GENDER arguments for Adjectives (m,f,n)
     * @throws Exception
     */
    @Test
    public void testRandomVerbVoice() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 40000;
        int numOutcomes = 2;
        int approxAns = randomSims / numOutcomes;
        int tolerance = 1000;


        for (int i = 0; i < randomSims; i++) {
            String ans = randomGenerator.getVerbVoice();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }

        assertThat("Num Verb Voice VOICE_ACTIVE", map.get(VERB_VOICE_ACTIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Verb Voice VOICE_ACTIVE", map.get(VERB_VOICE_ACTIVE), lessThan(approxAns + tolerance));

        assertThat("Num Verb Voice VOICE_PASSIVE", map.get(VERB_VOICE_PASSIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Verb Voice VOICE_PASSIVE", map.get(VERB_VOICE_PASSIVE), lessThan(approxAns + tolerance));
    }


    /**
     * testRandomVerbNumber()
     * ----------------------
     * Tests the randomness of generating NUMBER arguments for Verbs (Singular, Plural, Infinitive)
     * @throws Exception
     */
    @Test
    public void testRandomVerbNumber() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 61000;
        int numOutcomes = 610;
        int numInfinitiveOutcome = 6;
        int tolerance = 1000;
        int infinitiveTolerance = 150;
        int approxAns =  randomSims/2;
        int approxInfinitiveAns = (randomSims*numInfinitiveOutcome)/numOutcomes;


        for (int i = 0; i < randomSims; i++) {
            String ans = randomGenerator.getVerbNumber();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }


        assertThat("Num Verb NUMBER SINGULAR", map.get(VERB_NUMBER_SINGULAR), greaterThan(approxAns - tolerance));
        assertThat("Num Verb NUMBER SINGULAR", map.get(VERB_NUMBER_SINGULAR), lessThan(approxAns + tolerance));

        assertThat("Num Verb NUMBER PLURAL", map.get(VERB_NUMBER_PLURAL), greaterThan(approxAns - tolerance));
        assertThat("Num Verb NUMBER PLURAL", map.get(VERB_NUMBER_PLURAL), lessThan(approxAns + tolerance));

        assertThat("Num Verb NUMBER INFINITIVE", map.get(VERB_NUMBER_INFINITIVE), greaterThan(approxInfinitiveAns - infinitiveTolerance));
        assertThat("Num Verb NUMBER INFINITIVE", map.get(VERB_NUMBER_INFINITIVE), lessThan(approxInfinitiveAns + infinitiveTolerance));
    }

    /**
     * testRandomMoodNumber()
     * ----------------------
     * Tests the randomness of generating MOOD arguments for Verbs (Indicative, Subjunctive, Imperative)
     * @throws Exception
     */
    @Test
    public void testRandomMoodNumber() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int randomSims = 61000;
        int numOutcomes = 610;
        int numImperativeOutcome = 4;
        int tolerance = 1000;
        int imperativeTolerance = 150;
        int approxAns =  randomSims/2;
        int approxInfinitiveAns = (randomSims*numImperativeOutcome)/numOutcomes;


        for (int i = 0; i < randomSims; i++) {
            String ans = randomGenerator.getVerbMood();
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);
        }


        assertThat("Num Verb MOOD MOOD_INDICATIVE", map.get(VERB_MOOD_INDICATIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Verb MOOD MOOD_INDICATIVE", map.get(VERB_MOOD_INDICATIVE), lessThan(approxAns + tolerance));

        assertThat("Num Verb MOOD MOOD_SUBJUNCTIVE", map.get(VERB_MOOD_SUBJUNCTIVE), greaterThan(approxAns - tolerance));
        assertThat("Num Verb MOOD MOOD_SUBJUNCTIVE", map.get(VERB_MOOD_SUBJUNCTIVE), lessThan(approxAns + tolerance));

        assertThat("Num Verb MOOD MOOD_IMPERATIVE", map.get(VERB_MOOD_IMPERATIVE), greaterThan(approxInfinitiveAns - imperativeTolerance));
        assertThat("Num Verb MOOD MOOD_IMPERATIVE", map.get(VERB_MOOD_IMPERATIVE), lessThan(approxInfinitiveAns + imperativeTolerance));
    }


}