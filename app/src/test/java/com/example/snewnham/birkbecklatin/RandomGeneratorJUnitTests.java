package com.example.snewnham.birkbecklatin;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;

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
public class RandomGeneratorJUnitTests {



    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

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





}