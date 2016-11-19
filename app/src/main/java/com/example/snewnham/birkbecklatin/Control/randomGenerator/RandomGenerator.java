package com.example.snewnham.birkbecklatin.Control.randomGenerator;

import java.util.Random;

/**
 * Uses a Random Generator to Select a Noun From the Noun_List and
 * its arguments (Case, Number, etc.)
 * Created by snewnham on 19/11/2016.
 */

public class RandomGenerator {

    // Fields
    // ------
    private Random randomGenerator;
    private final int NOUN_NUMBER_NUM_OUTCOMES = 2;
    private final String SINGULAR = "singular";
    private final String PLURAL = "plural";

    private final int NOUN_CASE_NUM_OUTCOMES = 52;
    private final int NOUN_CUTOFF_NOMINATIVE = 10;
    private final int NOUN_CUTOFF_ACCUSATIVE = 20;
    private final int NOUN_CUTOFF_GENITIVE = 30;
    private final int NOUN_CUTOFF_DATIVE = 40;
    private final int NOUN_CUTOFF_ABLATIVE = 50;
    private final int NOUN_CUTOFF_VOCATIVE = 52;

    private final int GENDER_NUM_OUTCOMES = 3;
    private final int GENDER_CUTOFF_MALE = 0;
    private final int GENDER_CUTOFF_FEMALE = 1;
    private final int GENDER_CUTOFF_NEUTER = 2;
    private final String GENDER_MALE = "m";
    private final String GENDER_FEMALE = "f";
    private final String GENDER_NEUTER = "n";



    private final String NOMINATIVE = "Nominative";
    private final String ACCUSATIVE = "Accusative";
    private final String GENITIVE = "Genitive";
    private final String DATIVE = "Dative";
    private final String ABLATIVE = "Ablative";
    private final String VOCATIVE = "Vocative";


    public RandomGenerator(){
        randomGenerator = new Random();
    }

    /**
     * calcNounNumber()
     * ----------------
     * Generate a Random "Number" [Singular, Plural] for a Noun
     * if random [0,1] - > "Singular"
     * if random [1,2] - > "Plural"
     * @return number
     */
    public String getNounNumber() {
        int randomNounNumber = randomGenerator.nextInt(NOUN_NUMBER_NUM_OUTCOMES);
        if(randomNounNumber >= 1){
            return SINGULAR;
        } else {
            return PLURAL;
        }
    }

    /**
     * calcNounCase()
     * ----------------
     * Generate a Random "CASE" [Nom, Acc, Gen ...] for a Noun's Declension
     * if random [0,10] - > "Nominative"
     * if random [11,20] - > "Accusative"
     * if random [21,30] - > "Genitive"
     * if random [31,40] - > "Dative"
     * if random [41,50] - > "Ablative"
     * if random [51,23] - > "Vocative"
     * @return Case Declension (N.b., that Vocative has a lower prob weight allocated)
     */
    public String getNounCase() {
        int randomCaseNumber = randomGenerator.nextInt(NOUN_CASE_NUM_OUTCOMES);

        if(randomCaseNumber <= NOUN_CUTOFF_NOMINATIVE)
            return NOMINATIVE;
        else if(randomCaseNumber <= NOUN_CUTOFF_ACCUSATIVE)
            return ACCUSATIVE;
        if(randomCaseNumber <= NOUN_CUTOFF_GENITIVE)
            return GENITIVE;
        if(randomCaseNumber <= NOUN_CUTOFF_DATIVE)
            return DATIVE;
        if(randomCaseNumber <= NOUN_CUTOFF_ABLATIVE)
            return ABLATIVE;
        else
            return VOCATIVE;
    }

    /**
     * calcAdjectiveGender()
     * ---------------------
     * Generate a Random "GENDER" (m,f,n) for Adjectives,
     * if random [0] - > "m"
     * if random [1] - > "f"
     * if random [2] - > "n"
     * @return
     */
    public String getAdjectiveGender() {
        int randomGenderNumber = randomGenerator.nextInt(GENDER_NUM_OUTCOMES);

        if(randomGenderNumber == GENDER_CUTOFF_MALE)
            return GENDER_MALE;
        else if(randomGenderNumber == GENDER_CUTOFF_FEMALE)
            return GENDER_FEMALE;
        else
            return GENDER_NEUTER;
    }


}
