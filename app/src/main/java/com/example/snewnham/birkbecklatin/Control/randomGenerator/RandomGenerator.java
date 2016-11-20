package com.example.snewnham.birkbecklatin.Control.randomGenerator;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;

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
    private DatabaseAccess databaseAccess;

    private final String NOUN_TABLE = "Noun_List";
    private final String ADJECTIVE_TABLE = "Adjective_List";
    private final String ADVERB_TABLE = "Adverb_List";
    private final String PREPOSITION_TABLE = "Preposition_List";
    private final String CONJUNCTION_TABLE = "Conjunction_List";

    private final String NOUN = "Noun";
    private final String ADJECTIVE = "Adjective";
    private final String PREPOSITION = "Preposition";
    private final String CONJUNCTION = "Conjunction";
    private final String ADVERB = "Adverb";

    private final String ADVERB_COMPARATIVE = "AdverbComparative";
    private final String ADVERB_SUPERLATIVE = "AdverbSuperlative";

    private final int ADJECTIVE_NUM_OUTCOMES= 4;
    private final int ADJECTIVE_CUTOFF = 1;
    private final int ADJECTIVE_COMPARATIVE_CUTOFF = 2;
    private final int ADJECTIVE_SUPERLATIVE_CUTOFF = 3;
    private final String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    private final String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";


    private final int NOUN_NUMBER_NUM_OUTCOMES = 2;
    private final String NOUN_SINGULAR = "Singular";
    private final String NOUN_PLURAL = "Plural";


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


    private final int VERB_PERSON_NUM_OUTCOMES = 3;
    private final int VERB_PERSON_1ST_CUTOFF = 0;
    private final int VERB_PERSON_2ND_CUTOFF = 1;
    private final int VERB_PERSON_3RD_CUTOFF = 2;
    private final String VERB_PERSON_1ST = "1st";
    private final String VERB_PERSON_2ND = "2nd";
    private final String VERB_PERSON_3RD = "3rd";



    private final int VERB_TENSE_NUM_OUTCOMES = 6;
    private final int VERB_TENSE_PRESENT_CUTOFF = 0;
    private final int VERB_TENSE_IMPERFECT_CUTOFF = 1;
    private final int VERB_TENSE_FUTURE_CUTOFF = 2;
    private final int VERB_TENSE_PERFECT_CUTOFF = 3;
    private final int VERB_TENSE_PLUPERFECT_CUTOFF = 4;
    private final int VERB_TENSE_FUTURE_PERFECT_CUTOFF = 5;
    private final String VERB_TENSE_PRESENT = "Present";
    private final String VERB_TENSE_IMPERFECT = "Imperfect";
    private final String VERB_TENSE_FUTURE = "Future";
    private final String VERB_TENSE_PERFECT = "Perfect";
    private final String VERB_TENSE_PLUPERFECT = "Pluperfect";
    private final String VERB_TENSE_FUTURE_PERFECT = "Future Perfect";


    private final int VERB_VOICE_NUM_OUTCOMES = 2;
    private final int VERB_VOICE_ACTIVE_CUTOFF= 0;
    private final int VERB_VOICE_PASSIVE_CUTOFF = 1;
    private final String VERB_VOICE_ACTIVE = "Active";
    private final String VERB_VOICE_PASSIVE = "Passive";

    private final int VERB_NUMBER_NUM_OUTCOMES = 610;
    private final int VERB_NUMBER_SINGULAR_CUTOFF = 301;
    private final int VERB_NUMBER_PLURAL_CUTOFF = 604;
    private final int VERB_NUMBER_INFINITIVE_CUTOFF = 610;
    private final String VERB_NUMBER_SINGULAR = "Singular";
    private final String VERB_NUMBER_PLURAL = "Plural";
    private final String VERB_NUMBER_INFINITIVE = "Infinitive";


    private final int VERB_MOOD_NUM_OUTCOMES = 610;
    private final int VERB_MOOD_INDICATIVE_CUTOFF = 302;
    private final int VERB_MOOD_SUBJUNCTIVE_CUTOFF = 606;
    private final int VERB_MOOD_IMPERATIVE_CUTOFF = 610;
    private final String VERB_MOOD_INDICATIVE = "Indicative";
    private final String VERB_MOOD_SUBJUNCTIVE = "Subjunctive";
    private final String VERB_MOOD_IMPERATIVE = "Imperative";



    // Constructors
    // ------------
    public RandomGenerator(){
        randomGenerator = new Random();
    }

    public RandomGenerator(DatabaseAccess database){
        randomGenerator = new Random();
        databaseAccess = database;
        databaseAccess.open();                                  // OPEN THE DATABASE
    }

    // ------------------------------- NOUNS ----------------------------------------------

    /**
     * getNounEtc()
     * ------------
     * Generate a randomn NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     *
     * @return
     */
    public String getNounEtcType() {

        int numNouns = databaseAccess.sqlTableCountQuery(NOUN_TABLE);
        int numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_TABLE);
        int totalOutcomes = numNouns + numAdjective + numPreposition + numConjunction + numAdverb;

        int cumulNouns = numNouns;
        int cumulAdjective = numNouns + numAdjective;
        int cumulPreposition = numNouns + numAdjective + numPreposition;
        int cumulConjunction = numNouns + numAdjective + numPreposition + numConjunction;
        int cumulAdverb = numNouns + numAdjective + numPreposition + numConjunction + numAdverb;

        int randomNounEtcNumber = randomGenerator.nextInt(totalOutcomes);

        if (randomNounEtcNumber <= cumulNouns)
            return NOUN;
        else if (randomNounEtcNumber <= cumulAdjective)
            return ADJECTIVE;
        if (randomNounEtcNumber <= cumulPreposition)
            return PREPOSITION;
        if (randomNounEtcNumber <= cumulConjunction)
            return CONJUNCTION;
        if (randomNounEtcNumber <= cumulAdverb)
            return ADVERB;
        else
            return null;
    }

    /**
     * getAdjectiveType()
     * ------------------
     * Generate a random Adjective Type (Standard, Comparative, Superlative)
     * @return
     */
    public String getAdjectiveType(){
        int randomAdjectiveNumber = randomGenerator.nextInt(ADJECTIVE_NUM_OUTCOMES);

        if(randomAdjectiveNumber <= ADJECTIVE_CUTOFF)
            return ADJECTIVE;
        else if (randomAdjectiveNumber == ADJECTIVE_COMPARATIVE_CUTOFF)
            return ADJECTIVE_COMPARATIVE;
        else
            return ADJECTIVE_SUPERLATIVE;
    }


    /**
     * getNounNumber()
     * ----------------
     * Generate a Random "Number" [Singular, Plural] for a Noun
     * if random [0] - > "Singular"
     * if random [1] - > "Plural"
     * @return number
     */
    public String getNounNumber() {

        int randomNounNumber = randomGenerator.nextInt(NOUN_NUMBER_NUM_OUTCOMES);
        if(randomNounNumber == 0){
            return NOUN_SINGULAR;
        } else {
            return NOUN_PLURAL;
        }
    }

    /**
     * getNounCase()
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
     * getAdjectiveGender()
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

    //  -------------------------------- VERBS ------------------------------------------------
    /**
     * getVerbPerson()
     * --------------
     * Generate a Random "PERSON" argument (1,2,3) for Verbs
     * if random [0] - > "1st"
     * if random [1] - > "2nd"
     * if random [2] - > "3rd"
     * @return
     */
    public String getVerbPerson(){

        int randomVerbPerson = randomGenerator.nextInt(VERB_PERSON_NUM_OUTCOMES);

        if(randomVerbPerson == VERB_PERSON_1ST_CUTOFF)
            return VERB_PERSON_1ST;
        else if(randomVerbPerson == VERB_PERSON_2ND_CUTOFF)
            return VERB_PERSON_2ND;
        else
            return VERB_PERSON_3RD;
    }

    /**
     * getVerbTense()
     * --------------
     * Generate a Random "TENSE" argument (Present, Imperfect, Future etc) for Verbs
     * if random [0] - > "Present"
     * if random [1] - > "Perfect"
     * if random [2] - > "Imperfect"
     * if random [3] - > "Perfect"
     * if random [4] - > "Pluperfect"
     * if random [5] - > "Future Perfect"
     *
     * @return
     */
    public String getVerbTense(){

        int randomVerbPerson = randomGenerator.nextInt(VERB_TENSE_NUM_OUTCOMES);

        switch (randomVerbPerson) {
            case VERB_TENSE_PRESENT_CUTOFF:
                return VERB_TENSE_PRESENT;

            case VERB_TENSE_IMPERFECT_CUTOFF:
                return VERB_TENSE_IMPERFECT;

            case VERB_TENSE_FUTURE_CUTOFF:
                return VERB_TENSE_FUTURE;

            case VERB_TENSE_PERFECT_CUTOFF:
                return VERB_TENSE_PERFECT;

            case VERB_TENSE_PLUPERFECT_CUTOFF:
                return VERB_TENSE_PLUPERFECT;

            case VERB_TENSE_FUTURE_PERFECT_CUTOFF:
                return VERB_TENSE_FUTURE_PERFECT;
        }
        return null;
    }

    /**
     * getVerbVoice()
     * --------------
     * Generate a Random "Voice" (Active, Passive)
     * if random [0] - > "Active"
     * if random [1] - > "Passive"
     * @return
     */
    public String getVerbVoice() {
        int randomGenderNumber = randomGenerator.nextInt(VERB_VOICE_NUM_OUTCOMES);

        if (randomGenderNumber == VERB_VOICE_ACTIVE_CUTOFF)
            return VERB_VOICE_ACTIVE;
        else
            return VERB_VOICE_PASSIVE;

    }

    /**
     * getVerbNumber()
     * --------------
     * Generate a Random "Number" (Singular, Plural, Infinitive) for a VERB
     * if random [0,302] - > "Singular"
     * if random [302,604] - > "Plural"
     * if random [604,610] - > "Infinitive"
     * @return
     */
    public String getVerbNumber() {
        int randomGenderNumber = randomGenerator.nextInt(VERB_NUMBER_NUM_OUTCOMES);

        if (randomGenderNumber <= VERB_NUMBER_SINGULAR_CUTOFF)
            return VERB_NUMBER_SINGULAR;
        else if (randomGenderNumber <= VERB_NUMBER_PLURAL_CUTOFF)
            return VERB_NUMBER_PLURAL;
        else
            return VERB_NUMBER_INFINITIVE;
    }

    /**
     * getVerbMood()
     * --------------
     * Generate a Random "Mood" (Indicative, Subjunctive, Imperative) for a VERB
     * if random [0,303] - > "Indicative"
     * if random [304,606] - > "Subjunctive"
     * if random [607,610] - > "Imperative"
     * @return
     */
    public String getVerbMood() {
        int randomGenderNumber = randomGenerator.nextInt(VERB_MOOD_NUM_OUTCOMES);

        if (randomGenderNumber <= VERB_MOOD_INDICATIVE_CUTOFF)
            return VERB_MOOD_INDICATIVE;
        else if (randomGenderNumber <= VERB_MOOD_SUBJUNCTIVE_CUTOFF)
            return VERB_MOOD_SUBJUNCTIVE;
        else
            return VERB_MOOD_IMPERATIVE;
    }


}
