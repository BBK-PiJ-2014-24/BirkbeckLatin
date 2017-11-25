package com.newnham.app.GCSE_Latin.Control.randomGenerator;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.NounEtc;
import com.newnham.app.GCSE_Latin.Model.verbs.Verb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ABLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ACCUSATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_COMPARATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_SUPERLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_COMPARATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_SUPERLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENDER_FEMALE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENDER_MALE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENDER_NEUTER;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENITIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOMINATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_IRREGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_REGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PERSON_1ST;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PERSON_2ND;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PERSON_3RD;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PREPOSITION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_FUTURE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_FUTURE_PERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_IMPERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PLUPERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PRESENT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOCATIVE;
import static com.newnham.app.GCSE_Latin.Model.database.DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE;
import static com.newnham.app.GCSE_Latin.Model.database.DbSchema.ConjunctionListTable.CONJUNCTION_TABLE;
import static com.newnham.app.GCSE_Latin.Model.database.DbSchema.PrepositionListTable.PREPOSITION_TABLE;

/**
 * Uses a Random Generator to Select a Noun From the Noun_List and
 * its arguments (Case, Number, etc.)
 * Created by snewnham on 19/11/2016.
 */

public class RandomGenerator<T> {

    // Fields
    // ------
    private Random randomGenerator;
    private DatabaseAccess databaseAccess;

    private static final int ADVERB_NUM_OUTCOMES= 4;
    private static final int ADVERB_CUTOFF = 1;
    private static final int ADVERB_COMPARATIVE_CUTOFF = 2;
    private static final int ADVERB_SUPERLATIVE_CUTOFF = 3;

    private static final int ADJECTIVE_NUM_OUTCOMES= 4;
    private static final int ADJECTIVE_CUTOFF = 1;
    private static final int ADJECTIVE_COMPARATIVE_CUTOFF = 2;
    private static final int ADJECTIVE_SUPERLATIVE_CUTOFF = 3;


    private static final int NOUN_NUMBER_NUM_OUTCOMES = 2;
    private static final String NOUN_SINGULAR = "Singular";
    private static final String NOUN_PLURAL = "Plural";


    private static final int NOUN_CASE_NUM_OUTCOMES = 52;
    private static final int NOUN_CUTOFF_NOMINATIVE = 10;
    private static final int NOUN_CUTOFF_ACCUSATIVE = 20;
    private static final int NOUN_CUTOFF_GENITIVE = 30;
    private static final int NOUN_CUTOFF_DATIVE = 40;
    private static final int NOUN_CUTOFF_ABLATIVE = 50;
    private static final int NOUN_CUTOFF_VOCATIVE = 52;

    private static final int GENDER_NUM_OUTCOMES = 3;
    private static final int GENDER_CUTOFF_MALE = 0;
    private static final int GENDER_CUTOFF_FEMALE = 1;
    private static final int GENDER_CUTOFF_NEUTER = 2;

    private final int VERB_PERSON_NUM_OUTCOMES = 3;
    private final int VERB_PERSON_1ST_CUTOFF = 0;
    private final int VERB_PERSON_2ND_CUTOFF = 1;
    private final int VERB_PERSON_3RD_CUTOFF = 2;


    private final int VERB_TENSE_NUM_OUTCOMES = 6;
    private final int VERB_TENSE_PRESENT_CUTOFF = 0;
    private final int VERB_TENSE_IMPERFECT_CUTOFF = 1;
    private final int VERB_TENSE_FUTURE_CUTOFF = 2;
    private final int VERB_TENSE_PERFECT_CUTOFF = 3;
    private final int VERB_TENSE_PLUPERFECT_CUTOFF = 4;
    private final int VERB_TENSE_FUTURE_PERFECT_CUTOFF = 5;


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
     * getRandomNounEtcIDlist()
     * ------------------------
     * Random Selection of six NounEtc IDs from a NounEtc table, given argument constraints of
     * skill level and Field CORRECT.
     * @param table - NounEtc tables, NounList, Adjective etc.
     * @param skillLevel - Game SkillLevel. Restrict Declensions if skill == 1
     * @param correct - Select WHERE CORRECT = 0 {Incorrect}, CORRECT = 1 {Correct}
     * @return List<Integer> of Six NounEtc IDs
     */
    public List<Integer> getRandomNounEtcIDlist(String table, int skillLevel, int correct){

        int numQuestions = 6;

        // determine restriction given skillLevel for
        boolean restricted = (skillLevel < 2) ? true : false;

        // random selection of index of a NounList
        List<Integer> nounList = databaseAccess.getNounEtcIDlist(table, correct, restricted);
        int nounListSize = nounList.size();
        int indexID1 = randomGenerator.nextInt(nounListSize);

        // Select six consecutive Noun IDs from the given index
        List<Integer> idList =  new ArrayList<>(6);
        for(int i=0; i<numQuestions; i++){
            int index = indexID1 + i;        // iterate the index
            if(index > nounListSize - 1)         // check for overflow of loop
                index = index - nounListSize; // loop back to the beginning if overflow
            idList.add(nounList.get(index)); // select the corresponding NounID from nounList
        }
        return idList;
    }


    /**
     * getNounEtc()
     * ------------
     * Generate a randomn NounEtc (Noun, Pronoun, Adjective, Preposition etc.)
     *
     * @return
     */
    public String getNounEtcType() {

        int numNounRegular = databaseAccess.sqlNounTypeCount(NOUN_REGULAR);
        int numNounIrregular = databaseAccess.sqlNounTypeCount(NOUN_IRREGULAR);
        int numNouns = numNounRegular + numNounIrregular;
        int numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_LIST_TABLE);
        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_LIST_TABLE);
        int totalOutcomes = numNouns + numAdjective + numPreposition + numConjunction + numAdverb;

        int cumulRegularNouns = numNounRegular;
        int cumulIrregularNouns = numNouns;
        int cumulAdjective = numNouns + numAdjective;
        int cumulPreposition = numNouns + numAdjective + numPreposition;
        int cumulConjunction = numNouns + numAdjective + numPreposition + numConjunction;
        int cumulAdverb = numNouns + numAdjective + numPreposition + numConjunction + numAdverb;

        int randomNounEtcNumber = randomGenerator.nextInt(totalOutcomes)+1;


        if(randomNounEtcNumber <= cumulRegularNouns)
            return NOUN_REGULAR;
        else if (randomNounEtcNumber <= cumulIrregularNouns)
            return NOUN_IRREGULAR;
        else if (randomNounEtcNumber <= cumulAdjective)
            return ADJECTIVE;
        else if (randomNounEtcNumber <= cumulPreposition)
            return PREPOSITION;
        else if (randomNounEtcNumber <= cumulConjunction)
            return CONJUNCTION;
        else if (randomNounEtcNumber <= cumulAdverb)
            return ADVERB;
        else
            return null;
    }

    /**
     * getNounEtcType(int skillLevel)
     * --------------
     * Randomly select a NounType constrained by skillLevel
     * Level 1: Nouns Only
     * Level 2: Nouns Only
     * Level 3: Nouns or Prepositions or Conjunctions
     * Level 4: Nouns or Prepositions or Conjunctions or Adjectives
     * Level 5: Nouns or Prepositions or Conjunctions or Adjectives or Adverbs
     *
     * @param skillLevel Noun Skill Level
     * @return NounEtc Type - Noun, Preposition, etc.
     */
    public String getNounEtcType(int skillLevel) {

        int numNounRegular = databaseAccess.sqlNounTypeCount(NOUN_REGULAR);
        int numNounIrregular = databaseAccess.sqlNounTypeCount(NOUN_IRREGULAR);
        int numNouns = numNounRegular + numNounIrregular;

        int numPreposition = databaseAccess.sqlTableCountQuery(PREPOSITION_TABLE);
        int numConjunction = databaseAccess.sqlTableCountQuery(CONJUNCTION_TABLE);
        int numAdjective = databaseAccess.sqlTableCountQuery(ADJECTIVE_LIST_TABLE);
        int numAdverb = databaseAccess.sqlTableCountQuery(ADJECTIVE_LIST_TABLE);

        int totalOutcomes = 0;
        switch(skillLevel){
            case 1:
                totalOutcomes = numNounRegular;
                break;
            case 2:
                totalOutcomes = numNouns;
                break;
            case 3:
                totalOutcomes = numNouns + numPreposition + numConjunction;
                break;
            case 4:
                totalOutcomes = numNouns + numPreposition + numConjunction + numAdjective;
                break;
            case 5:
                totalOutcomes = numNouns + numPreposition + numConjunction + numAdjective + numAdverb;
                break;
        }

        int randomNounEtcNumber = randomGenerator.nextInt(totalOutcomes)+1;

        int cumulRegularNouns = numNounRegular;
        int cumulIrregularNouns = numNouns;
        int cumulPreposition = numNouns + numPreposition;
        int cumulConjunction = numNouns + numPreposition + numConjunction;
        int cumulAdjective = numNouns + numPreposition + numConjunction + numAdjective;
        int cumulAdverb = numNouns + numPreposition + numConjunction + numAdjective + numAdverb;

        if (randomNounEtcNumber <= cumulRegularNouns)
            return NOUN_REGULAR;
        else if (randomNounEtcNumber <= cumulIrregularNouns)
            return NOUN_IRREGULAR;
        else if (randomNounEtcNumber <= cumulPreposition)
            return PREPOSITION;
        else if (randomNounEtcNumber <= cumulConjunction)
            return CONJUNCTION;
        else if (randomNounEtcNumber <= cumulAdjective)
            return ADJECTIVE;
        else if (randomNounEtcNumber <= cumulAdverb)
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
     * getAdverbType()
     * ------------------
     * Generate a random Adverb Type (Standard, Comparative, Superlative)
     * @return
     */
    public String getAdverbType(){
        int randomAdverbNumber = randomGenerator.nextInt(ADVERB_NUM_OUTCOMES);

        if(randomAdverbNumber <= ADVERB_CUTOFF)
            return ADVERB;
        else if (randomAdverbNumber == ADVERB_COMPARATIVE_CUTOFF)
            return ADVERB_COMPARATIVE;
        else
            return ADVERB_SUPERLATIVE;
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


    /**
     * shuffleNounEtcList()
     * --------------------
     * Shuffles the nounEtc list.
     *
     * @param nounEtcList - original NounEtc List
     * @return shuffled verb list
     */
    public List<NounEtc> shuffleNounList(List<NounEtc> nounEtcList){

        // Implementing Adjusted Fisher–Yates to shuffle NounEtc
        // -------------------------------------------------------

        NounEtc[] nounArr = new NounEtc[nounEtcList.size()];  // initialize verb Array
        nounArr = nounEtcList.toArray(nounArr);         // convert List to Array

        int indexStart = randomGenerator.nextInt(nounArr.length);
        NounEtc n = nounArr[0];
        nounArr[0] = nounArr[indexStart];
        nounArr[indexStart] = n;

        for(int i = nounArr.length - 1; i >= 0; i--) {
            int index = randomGenerator.nextInt(nounArr.length);
            NounEtc swap = nounArr[index];
            nounArr[index] = nounArr[i];
            nounArr[i] = swap;
        }

        List<NounEtc> shuffleList = Arrays.asList(nounArr);  // convert to List
        return shuffleList;
    }


    /**
     * getRandomVerbIDpair(int conjNum, int inCorrect, boolean restricted)
     * -----------------------------------------------
     * Selects a list of two random verb IDs subject to restrictions, conjNum, inCorrect, restricted
     * @param conjNum - conj Num restriction
     * @param correct - Select correct (1) or incorrect verb ID (0)
     * @param restricted - verb Type restrictions (Deponent, Semi Deponent, Irregulars)
     * @return List of two verb IDs
     */
    public List<Integer> getRandomVerbIDpair(int conjNum, int correct, boolean restricted){

        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){
            System.out.println("got interrupted!");
        }

        List<Integer> list = databaseAccess.getVerbIDList(conjNum, correct, restricted);

        int indexOfId1 = randomGenerator.nextInt(list.size());

        int indexOfId2;     // determine the neighbouring index of ID2
        if(indexOfId1 != 0)  // check condition so that don't overrun the list.
            indexOfId2 = indexOfId1-1;
        else
            indexOfId2 = indexOfId1+1;

        int id1 = list.get(indexOfId1);
        int id2 = list.get(indexOfId2); // retrieve the Verb ID2

        List<Integer> verbIDlist = new ArrayList<>();
        verbIDlist.add(id1);    // add ID1 to the List
        verbIDlist.add(id2);    // add ID2 to the List

        return verbIDlist;
    }


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
            return PERSON_1ST;
        else if(randomVerbPerson == VERB_PERSON_2ND_CUTOFF)
            return PERSON_2ND;
        else
            return PERSON_3RD;
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
                return TENSE_PRESENT;

            case VERB_TENSE_IMPERFECT_CUTOFF:
                return TENSE_IMPERFECT;

            case VERB_TENSE_FUTURE_CUTOFF:
                return TENSE_FUTURE;

            case VERB_TENSE_PERFECT_CUTOFF:
                return TENSE_PERFECT;

            case VERB_TENSE_PLUPERFECT_CUTOFF:
                return TENSE_PLUPERFECT;

            case VERB_TENSE_FUTURE_PERFECT_CUTOFF:
                return TENSE_FUTURE_PERFECT;
        }
        return null;
    }

    /**
     * getVerbTenseList()
     * ------------------
     * Generates a random list of three tenses for the VerbGame.
     * @return
     */
    public List<String> getVerbTenseList(){

        String[] verbArr = new String[]{
                TENSE_PRESENT,
                TENSE_IMPERFECT,
                TENSE_FUTURE,
                TENSE_PERFECT,
                TENSE_PLUPERFECT,
                TENSE_FUTURE_PERFECT
        };

        // Implementing Adjusted Fisher–Yates to shuffle tenses
        // ----------------------------------------------------

        int indexStart = randomGenerator.nextInt(verbArr.length);
        String t = verbArr[0];
        verbArr[0] = verbArr[indexStart];
        verbArr[indexStart] = t;

        for(int i = verbArr.length - 1; i >= 0; i--) {
            int index = randomGenerator.nextInt(verbArr.length);
            String swap = verbArr[index];
            verbArr[index] = verbArr[i];
            verbArr[i] = swap;
        }

        String[] subArray = Arrays.copyOfRange(verbArr, 0, 3);  // subArray of first 3 tenses
        List<String> shuffleList = Arrays.asList(subArray);  // convert to List
       return shuffleList;
    }

    /**
     * getSubjunctiveVerbTenseList()
     * -----------------------------
     * Generates a SPECIAL random list of three tenses for the VerbGame restricted to non-Future
     * tenses. This is only for the subjunctives SQL queries.
     * @return a random list of three tenses
     */
    public List<String> getSubjunctiveVerbTenseList(){

        String[] verbArr = new String[]{
                TENSE_PRESENT,
                TENSE_IMPERFECT,
                TENSE_PERFECT,
                TENSE_PLUPERFECT,
        };

        // Implementing Adjusted Fisher–Yates to shuffle tenses
        // ----------------------------------------------------

        int indexStart = randomGenerator.nextInt(verbArr.length);
        String t = verbArr[0];
        verbArr[0] = verbArr[indexStart];
        verbArr[indexStart] = t;

        for(int i = verbArr.length - 1; i >= 0; i--) {
            int index = randomGenerator.nextInt(verbArr.length);
            String swap = verbArr[index];
            verbArr[index] = verbArr[i];
            verbArr[i] = swap;
        }

        String[] subArray = Arrays.copyOfRange(verbArr, 0, 3);  // subArray of first 3 tenses
        List<String> shuffleList = Arrays.asList(subArray);  // convert to List
        return shuffleList;
    }

    /**
     * getSubjunctiveVerbTenseList()
     * -----------------------------
     * Generates a SPECIAL random list of three tenses for the VerbGame restricted to non-Future
     * tenses. This is only for the subjunctives SQL queries.
     * @return a random list of three tenses
     */
    public List<String> getInfinitiveVerbTenseList(){

        String[] verbArr = new String[]{
                TENSE_PRESENT,
                TENSE_PERFECT,
                TENSE_FUTURE,
        };

        // Implementing Adjusted Fisher–Yates to shuffle tenses
        // ----------------------------------------------------

        int indexStart = randomGenerator.nextInt(verbArr.length);
        String t = verbArr[0];
        verbArr[0] = verbArr[indexStart];
        verbArr[indexStart] = t;

        for(int i = verbArr.length - 1; i >= 0; i--) {
            int index = randomGenerator.nextInt(verbArr.length);
            String swap = verbArr[index];
            verbArr[index] = verbArr[i];
            verbArr[i] = swap;
        }

        List<String> shuffleList = Arrays.asList(verbArr);  // convert to List
        return shuffleList;
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


    /**
     * shuffleVerbList()
     * -----------------
     * Shuffles the verb list
     *
     * @param verbList - original Verb List
     * @return shuffled verb list
     */
    public List<Verb> shuffleVerbList(List<Verb> verbList){

        // Implementing Adjusted Fisher–Yates to shuffle tenses
        // ----------------------------------------------------

        Verb[] verbArr = new Verb[verbList.size()];  // initialize verb Array
        verbArr = verbList.toArray(verbArr);         // convert List to Array

        int indexStart = randomGenerator.nextInt(verbArr.length);
        Verb v = verbArr[0];
        verbArr[0] = verbArr[indexStart];
        verbArr[indexStart] = v;

        for(int i = verbArr.length - 1; i >= 0; i--) {
            int index = randomGenerator.nextInt(verbArr.length);
            Verb swap = verbArr[index];
            verbArr[index] = verbArr[i];
            verbArr[i] = swap;
        }

        List<Verb> shuffleList = Arrays.asList(verbArr);  // convert to List
        return shuffleList;

    }

}
