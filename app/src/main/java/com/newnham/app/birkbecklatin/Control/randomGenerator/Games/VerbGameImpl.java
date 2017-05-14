package com.newnham.app.birkbecklatin.Control.randomGenerator.Games;

import com.newnham.app.birkbecklatin.Control.randomGenerator.Item;
import com.newnham.app.birkbecklatin.Control.randomGenerator.ItemResponseTheory;
import com.newnham.app.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.database.DbSchema;
import com.newnham.app.birkbecklatin.Model.verbs.Answer;
import com.newnham.app.birkbecklatin.Model.verbs.Verb;
import com.newnham.app.birkbecklatin.Model.verbs.VerbDeponent;
import com.newnham.app.birkbecklatin.Model.verbs.VerbIrregular;
import com.newnham.app.birkbecklatin.Model.verbs.VerbRegular;
import com.newnham.app.birkbecklatin.Model.verbs.VerbSemiDeponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ1;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ1_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ2;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ2_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ3;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ3_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ4;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJ4_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_IMPERATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_IMPERATIVE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_INDICATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_INDICATIVE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_SUBJUNCTIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_SUBJUNCTIVE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NUMBER_INFINITIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NUMBER_PLURAL;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NUMBER_SINGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE_PERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_FUTURE_PERFECT_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_IMPERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_IMPERFECT_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PERFECT_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PLUPERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PLUPERFECT_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PRESENT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PRESENT_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_DEPONENT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_IRREGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_REGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_SEMI_DEPONENT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_SKILL_LEVEL;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_THETA;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_TOTAL;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VERB_TOTAL_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOICE_ACTIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOICE_ACTIVE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOICE_PASSIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOICE_PASSIVE_HIST_PERC;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.esse;

/**
 * CLASS: VerbGame
 * ----------------
 *  RandomGenerator - Random Generator Class;
 *  mDatabaseAccess - Database;
 *  mSkillLevel - skillLevel of Game
 *  mTheta - IRT skill level
 *  List<Verb> mVerbQuestionList - List of 6 Verbs
 *  List<Answer> mAnswerList - List of Results for each question
 *  TIME_FOR_INCORRECT_QUESTION - The Number of Questions Asked Before Testing an Incorrect Question
 *  mQuestionNumber - The Counter for Questions. Keeps TALLY to determine when to test Incorrect Question
 *  mCorrectVerb - The Correct Verb in the List of 6 Verbs
 *  mCorrectVerbIndex - The Index of the Correct Verb in the list of Six Verbs
 *  mCorrectVerbDifficulty - The IRT difficulty of the Correct Verb
 *  mCorrectVerbMood - The Mood of the Correct Verb
 *  mCorrectVerbVoice The Voice of the Correct Verb
 *
 */

public class VerbGameImpl implements VerbGame {


    // CONSTANTS FOR KEYS IN DATABASE and StatisticsMap
    //-------------------------------------------------

    private static final int CONJNUM1_2 = 2;
    private static final int CONJNUM1_4 = 40;


    private static final int VALUE_CORRECT = 1;
    private static final int VALUE_INCORRECT = 0;
    private static final int ASKED_YES = 1;
    private static final int ASKED_NO = 0;

    private final static String ASKED = "Asked";


    private static final String CONJ1_SCORE = "ConjScore1";  // Historical Score of Correct Con# Questions
    private static final String CONJ2_SCORE = "ConjScore2";  // Key for Meta Table in DB
    private static final String CONJ3_SCORE = "ConjScore3";
    private static final String CONJ4_SCORE = "ConjScore4";

    private final String CONJ1_TALLY = "ConjTally1";  // Tally of All Conj# Questions Asked
    private final String CONJ2_TALLY = "ConjTally2";  // Key for Meta Table in DB
    private final String CONJ3_TALLY = "ConjTally3";
    private final String CONJ4_TALLY = "ConjTally4";

    private final String PRESENT_SCORE = "PresentScore";   // Historical Score of Correct Tense Questions
    private final String IMPERFECT_SCORE = "ImperfectScore";  // Key for Meta Table in DB
    private final String FUTURE_SCORE = "FutureScore";
    private final String PERFECT_SCORE = "PerfectScore";
    private final String PLUPERFECT_SCORE = "PluperfectScore";
    private final String FUT_PERFECT_SCORE = "FutPerfectScore";

    private final String PRESENT_TALLY = "PresentTally";   // Tally of All Tense Questions Asked
    private final String IMPERFECT_TALLY = "ImperfectTally"; // Key for Meta Table in DB
    private final String FUTURE_TALLY = "FutureTally";
    private final String PERFECT_TALLY = "PerfectTally";
    private final String PLUPERFECT_TALLY = "PluperfectTally";
    private final String FUT_PERFECT_TALLY = "FutPerfectTally";

    private final String INDICATIVE_SCORE = "IndicativeScore";    // Historical Score of Correct Mood Questions
    private final String SUBJUNCTIVE_SCORE = "SubjunctiveScore";  // Key for Meta Table in DB
    private final String IMPERATIVE_SCORE = "ImperativeScore";

    private final String INDICATIVE_TALLY = "IndicativeTally";  // Tally of All Mood Questions Asked
    private final String SUBJUNCTIVE_TALLY = "SubjunctiveTally";   // Key for Meta Table in DB
    private final String IMPERATIVE_TALLY = "ImperativeTally";

    private final String ACTIVE_SCORE = "ActiveScore";    // Historical Score of Correct Voice Questions
    private final String PASSIVE_SCORE = "PassiveScore";  // Key for Meta Table in DB

    private final String ACTIVE_TALLY = "ActiveTally";    // Tally of All Voice Questions Asked
    private final String PASSIVE_TALLY = "PassiveTally";  // Key for Meta Table in DB

    private final static String VERB_TOTAL_SCORE = "VerbTotalScore";  // Historical Score of ALL Correct Questions
    private final static String VERB_TOTAL_TALLY = "VerbTotalTally";  // Tally of All Correct Questions Asked


    private final static double SKILL_LEVEL_TO_THETA_ADJ = 3.0;  // Used to Calc Theta when Given Skill Level Manually,
    private final static int START_CORRECT_VERB_INDEX = 100;
    private final static int START_CORRECT_VERB_DIFFICULTY = 100;

    private final int TIME_FOR_INCORRECT_QUESTION = 3;


    // Fields
    // ------

    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<Verb> mVerbQuestionList;  // List of 6 Verbs for a Multiple Choice Questions
    private List<Answer> mAnswerList;
    private int mQuestionNumber;
    private Verb mCorrectVerb;
    private int mCorrectVerbIndex;
    private int mCorrectVerbDifficulty;
    private String mCorrectVerbMood;
    private String mCorrectVerbVoice;
    private Map<String, Integer> mStatMap;  // KeyValue Map of Score Statistics



    // Constructors
    // ------------
    public VerbGameImpl(DatabaseAccess databaseAccess, int skillLevel){   // Used for Testing
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = skillLevel;
        mTheta = skillLevel - SKILL_LEVEL_TO_THETA_ADJ;
        mVerbQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 0;
        mCorrectVerb = null;
        mCorrectVerbIndex = START_CORRECT_VERB_INDEX;
        mCorrectVerbDifficulty = START_CORRECT_VERB_DIFFICULTY;
        mCorrectVerbMood = null;
        mCorrectVerbVoice = null;
    }

    public VerbGameImpl(DatabaseAccess databaseAccess){     // Actual Game Constructor
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = mDatabaseAccess.sqlMetaQuery(VERB_SKILL_LEVEL);  // Access From Database
        mTheta = mDatabaseAccess.sqlMetaQuery(VERB_THETA);
        mVerbQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 0;
        mCorrectVerb = null;
        mCorrectVerbIndex = START_CORRECT_VERB_INDEX;
        mCorrectVerbDifficulty = START_CORRECT_VERB_DIFFICULTY;
        mCorrectVerbMood = null;
        mCorrectVerbVoice = null;
    }

    /**
     * runVerbGame()
     * -------------
     * Generates:
     * 1) a pair of Verb IDs, restricted according to skillLevel and either from Correct or Incorrect Lists
     *    (If the game counter signals a scheduled Incorrect Verb or Not)
     * 2) Updates the VerbList Table, updating the ASKED FIELD == 1
     * 3) Forms a Question List of 6 Verbs from the pair of Verb IDs
     * 4) Randomly selects a correctVerb
     * 5) Shuffles the order of the list.
     *
     */
    @Override
    public void runVerbGame(){

        mQuestionNumber++; // Increase Counter

        List<Verb> newVerbList = new ArrayList<>(6);
        mVerbQuestionList = newVerbList; // Hack to Reset The Verb Question List

        int conj = CONJNUM1_2;
        boolean restricted = true; // Restrict to Regular Verbs (with exception of ESSE)
        switch(mSkillLevel) {      // Find out what Verb Restrictions are required, given Skill Level
            case 1:
                conj = CONJNUM1_2;
                restricted = true;
                break;
            case 2:
                conj = CONJNUM1_4;
                restricted = true;
                break;
            case 3:
                conj = CONJNUM1_4;
                restricted = true;
                break;
            case 4:
                conj = CONJNUM1_4;
                restricted = false;
                break;
            case 5:
                conj = CONJNUM1_4;
                restricted = false;
                break;
        }

        // defence check to see how many (Unasked) CORRECT Verbs left
        List<Integer> correctTable = mDatabaseAccess.getVerbIDList(conj, VALUE_CORRECT , restricted);
        int correctTableSize = correctTable.size();
        if(correctTableSize < 2) {                    // If all but 1 CORRECT VerbIDs have have been asked  ...
            mDatabaseAccess.sqlVerbList_AskedReset(VALUE_CORRECT);  // ...then Reset all ASKED Fields = 0 for CORRECT VERBS;
            correctTable = mDatabaseAccess.getVerbIDList(conj, VALUE_CORRECT , restricted);
            correctTableSize = correctTable.size();
            if(correctTableSize < 2) {  // If still small table -> Then ALL verbs have been answered INCORRECT
                mDatabaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT); // Reset CORRECT FIELD
                mDatabaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
            }
        }

        // defence check to see how many (Unasked) INCORRECT Verbs left
        List<Integer> incorrectTable = mDatabaseAccess.getVerbIDList(conj, VALUE_INCORRECT , restricted);
        int incorrectTableSize = incorrectTable.size(); // must have than 1 for a pair


        // Check if time for Incorrect Question ...
        int correctValue;
        if(mQuestionNumber % TIME_FOR_INCORRECT_QUESTION == 0  && incorrectTableSize  > 2 )
            correctValue = VALUE_INCORRECT;                              // Yes. Not All Verbs in Correct Table been tested
        else
            correctValue = VALUE_CORRECT;

        // generate pair of Verb ID
        List<Integer> idPairList = mRandomGenerator.getRandomVerbIDpair(conj, correctValue, restricted);

        // Updates the Database that verb IDs have been used
        mDatabaseAccess.sqlVerbList_Insert(idPairList.get(0), DbSchema.VerbListTable.Cols.ASKED, ASKED_YES );
        mDatabaseAccess.sqlVerbList_Insert(idPairList.get(1), DbSchema.VerbListTable.Cols.ASKED, ASKED_YES );

        // Generate question list
        mVerbQuestionList = getVerbQuestionSet(idPairList);

        // Select a correctVerb Verb from id1 randomly
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(3);
        mCorrectVerb = mVerbQuestionList.get(rndIndex);

        mVerbQuestionList = mRandomGenerator.shuffleVerbList(mVerbQuestionList); // shuffle Question List

        mCorrectVerbIndex = mVerbQuestionList.indexOf(mCorrectVerb); // find the index of the Correct Verb
                                                                     // in the shuffle list.
    }

    /**
     * storeAnswer()
     * -------------
     * 1) Updates ViewList Table, updating CORRECT Field
     * 2) Creates Answer object to contain data for the question and adds to Answer List.
     * @param ans answer flag - correct/incorrect (1 or 0)
     * @return If answer is correct/incorrect (1 or 0)
     */
    @Override
    public int storeAnswer(int ans){

        // Update Database
        mDatabaseAccess.sqlVerbList_Insert(mCorrectVerb.getId(), DbSchema.VerbListTable.Cols.CORRECT, ans);

        // Form Answer Object and Add to Lists
        mCorrectVerbDifficulty = determineQuestionDifficulty(); // determine Difficulty of Question
        Answer answer = new Answer(mCorrectVerb.getId(), ans, mCorrectVerbDifficulty, mCorrectVerb);  // Set Answer Object
        mAnswerList.add(answer); // Add to buffer mAsked List

        return answer.correct;  // Return if answer is correct/incorrect
    }


    /**
     * endGame()
     * ---------
     * Run at the end of the game:
     * 1) updates the students IRT Theta and game skill level.
     * 2) Stores Theta and SkillLevel in the Meta Table.
     * 3) Run CalcStatics()
     *
     */
    @Override
    public void endGame(){
        updateSkillLevel(mAnswerList); // update the Skill Level after the Test
        mDatabaseAccess.sqlMeta_Insertion(VERB_SKILL_LEVEL, mSkillLevel*1.0); // Add skill, Theta to meta table
        mDatabaseAccess.sqlMeta_Insertion(VERB_THETA, mTheta);

        mStatMap = calcStatistics(mAnswerList);  // Calc Statistics

    }

    /**
     * determineQuestionDifficulty()
     * -----------------------------
     * Determines the skillLevel difficulty of the Correct Verb
     * @return difficulty 1- 5
     */
    public int determineQuestionDifficulty(){

        if(mCorrectVerbMood.equals(MOOD_SUBJUNCTIVE))
            return 5;
        else if(mCorrectVerb.getLatin_Type().equals(VERB_DEPONENT) || mCorrectVerb.getLatin_Type().equals(VERB_SEMI_DEPONENT) ||
                (mCorrectVerb.getLatin_Type().equals(VERB_IRREGULAR) && !mCorrectVerb.getLatin_Infinitive().equals(esse)))
            return 4;
        else if(mCorrectVerbVoice.equals(VOICE_PASSIVE))
            return 3;
        else if(mCorrectVerb.getLatin_ConjNum() > 2)
            return 2;
        else
            return 1;
    }


    /**
     * getVerbQuestionSet()
     * --------------------
     *
     * Generates a list of 6 verb questions given the skill level of the student.
     * @param idList - Pair of IDs
     * @return  a list of six Verb objects
     */
    @Override
    public List<Verb> getVerbQuestionSet(List<Integer> idList){

        String person = null;
        String number = null;
        String voice1 = null;
        String voice2 = null;
        String type0 = null;
        String type1 = null;

        String mood = null;
        List<String> tenseList0; // list of random tenses
        List<String> tenseList1;

        int esse_ID = 10;  // Need to check that Esse Verbs Are only Active.

        switch(mSkillLevel){
            case 1:
                person = mRandomGenerator.getVerbPerson();
                do {
                    number = mRandomGenerator.getVerbNumber();  // NO INFINTIVES - Cannot Handle TENSE_IMPERFECT TENSE!!!
                } while (number.equals(NUMBER_INFINITIVE));
                voice1 = VOICE_ACTIVE;
                mood = MOOD_INDICATIVE;


                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_PRESENT, mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_IMPERFECT, mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_FUTURE, mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_PRESENT, mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_IMPERFECT, mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_FUTURE, mood, voice1));
                break;

            case 2:
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice1 = VOICE_ACTIVE;
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice1));
                break;

            case 3:
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();

                voice1 = mRandomGenerator.getVerbVoice(); // Allow VOICE_ACTIVE and VOICE_PASSIVE, but Checking for Deponent/Semi-Deponent or Esse Verb
                voice2 = voice1;
                if(voice1.equals(VOICE_PASSIVE)) {
                    type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                    type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                    if(type0.equals(VERB_DEPONENT) || type0.equals(VERB_SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(VERB_DEPONENT) || type1.equals(VERB_SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));

                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 4:
                type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice1 = mRandomGenerator.getVerbVoice();
                voice2 = voice1;


                // Allow VOICE_ACTIVE and VOICE_PASSIVE, but Checking for Deponent/Semi-Deponent
                if(voice1.equals(VOICE_PASSIVE)) {
                    if(type0.equals(VERB_DEPONENT) || type0.equals(VERB_SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(VERB_DEPONENT) || type1.equals(VERB_SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                // Check that Irregular Verbs Have Mood = Indicative
                if(type0.equals(VERB_IRREGULAR) || type1.equals(VERB_IRREGULAR)){
                    mood = MOOD_INDICATIVE;
                } else {
                    do {
                        mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                    } while (mood.equals(MOOD_SUBJUNCTIVE));
                }

                // Special Verb Question List for Imperatives
                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 5:
                type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                mood = mRandomGenerator.getVerbMood();
                voice1 = mRandomGenerator.getVerbVoice();
                voice2 = voice1;


                // Allow VOICE_ACTIVE and VOICE_PASSIVE, but Checking for Deponent/Semi-Deponent
                if(voice1.equals(VOICE_PASSIVE)) {
                    if(type0.equals(VERB_DEPONENT) || type0.equals(VERB_SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(VERB_DEPONENT) || type1.equals(VERB_SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                // Check that Irregular Verbs Have Mood = Indicative
                if(type0.equals(VERB_IRREGULAR) || type1.equals(VERB_IRREGULAR)){
                    mood = MOOD_INDICATIVE;
                }

                // Special Verb Question List for Imperatives
                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(mood.equals(MOOD_SUBJUNCTIVE) && !number.equals(NUMBER_INFINITIVE)){
                    tenseList0 = mRandomGenerator.getSubjunctiveVerbTenseList();  // Restricted to non-Future Tenses
                    tenseList1 = mRandomGenerator.getSubjunctiveVerbTenseList();
                } else if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;
        }

        mCorrectVerbMood = mood;
        mCorrectVerbVoice = voice1;
        return mVerbQuestionList;
    }


    /**
     * makeImperativeQuestionList()
     * ----------------------------
     * A Separate Helper Method to Create a Question List for IMPERATIVES, given that there
     * are only 4 Imperatives for each Verb. So Need to have a special list to ensure full
     * population of 6 questions.
     * Note that Persons (1,2,3) and tenses are set to Null as they are not required
     * ALSO note that we have to add 2 Infinitive questions to the list as VERB_DEPONENT verbs do not
     * have passive IMPERATIVES.
     * @param idList - List of IDs
     * @return - List of Imperative Questions
     */
    @Override
    public List<Verb> makeImperativeQuestionList(List<Integer> idList){

        String type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
        String type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));

        List<Verb> imperativeQuestionList = new ArrayList<>();

        // Verbs for id0
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_ACTIVE));

        // can't have passive Imperative for Deponents and Semi_Deponents. Replace with Infinitive
        if(type0.equals(VERB_DEPONENT) || type0.equals(VERB_SEMI_DEPONENT)) {
            imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_INFINITIVE, TENSE_PERFECT, MOOD_INDICATIVE, VOICE_ACTIVE));
        } else {
            imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        }

        // Verbs for id1
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        if(type1.equals(VERB_DEPONENT) || type1.equals(VERB_SEMI_DEPONENT)) {  // can't passive Imperative
            imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_INFINITIVE, TENSE_FUTURE, MOOD_INDICATIVE, VOICE_ACTIVE));
        } else {
            imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        }

        return imperativeQuestionList;
    }


    /**
     * makeGameVerb()
     * --------------
     * Forms the correct Verb object (Regular, Deponent, Semi-Deponent, Irregular), given usual
     * verb arguments (person, number, etc.)
     * @param id
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return Verb object (Not the underlying sub classes).
     */
    @Override
    public Verb makeGameVerb(int id, String person, String number,
                             String tense, String mood, String voice){

        Verb gameVerb = null;
        String type = mDatabaseAccess.sqlVerbTypeQuery(id);  // Find out What Type is the Verb

        switch (type) {
            case VERB_REGULAR:
                VerbRegular verbRegular = (VerbRegular) mDatabaseAccess.sqlVerbListQuery(id);
                verbRegular.makeLatinVerb(mDatabaseAccess, person, number, tense,
                        mood, voice, Integer.toString(verbRegular.getLatin_ConjNum()));
                verbRegular.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbRegular;
                break;
            case VERB_DEPONENT:
                VerbDeponent verbDeponent = (VerbDeponent) mDatabaseAccess.sqlVerbListQuery(id);
                verbDeponent.makeLatinVerb(mDatabaseAccess, person, number, tense,
                        mood, voice, Integer.toString(verbDeponent.getLatin_ConjNum()));
                verbDeponent.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbDeponent;
                break;
            case VERB_SEMI_DEPONENT:
                VerbSemiDeponent verbSemiDeponent = (VerbSemiDeponent) mDatabaseAccess.sqlVerbListQuery(id);
                verbSemiDeponent.makeLatinVerb(mDatabaseAccess, person, number, tense,
                        mood, voice, Integer.toString(verbSemiDeponent.getLatin_ConjNum()));
                verbSemiDeponent.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbSemiDeponent;
                break;
            case VERB_IRREGULAR:
                VerbIrregular verbIrregular = (VerbIrregular) mDatabaseAccess.sqlVerbListQuery(id);
                verbIrregular.makeLatinVerb(mDatabaseAccess, person, number, tense,
                        mood, voice, Integer.toString(verbIrregular.getLatin_ConjNum()));
                verbIrregular.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbIrregular;
                break;
        }
        return gameVerb;
    }

    /**
     * updateSkillLevel()
     * ------------------
     * updates the skillLevel of the student by processing the results of the Test
     * through the Item Response Theory Algo.
     *
     * If the student's updated theta is >+2, the skillLevel is increased
     * If the student's updated theta is <-2, the skillLevel is decreased.
     *
     * @return the updated skill level of the student.
     */
    @Override
    public int updateSkillLevel(List<Answer> answerList){

        double c = 1/6;    // Number of Questions
        double lambda = 0.5;    // Discrimination

        List<Item> itemList = new ArrayList<>();

        for(Answer answer : answerList){   // go through answer list
            double alpha = answer.difficulty - 3.0;
            int mark = answer.correct;
            Item item = new Item(c, mTheta, alpha, lambda, mark); // convert each answer to IRT Item
            itemList.add(item);  // Build Item List
        }

       mTheta = ItemResponseTheory.calcNewTheta(itemList, mTheta); // Calc new Theta.

        if(mTheta > 2 && mSkillLevel < 5)
            mSkillLevel = mSkillLevel + 1;
        else if (mTheta < -2 && mSkillLevel > 1)
            mSkillLevel = mSkillLevel - 1;

        return mSkillLevel;
    }


    /**
     * calcStatistics()
     * ----------------
     *
     * Calcs the Statistics for the % of Correct Answers in the Current Quiz and Running (Historical) Score
     * @param list - List of Answers from the Quiz
     * @return map storing statistics of Current Game and and of all games.
     */
    @Override
    public Map<String, Integer> calcStatistics(List<Answer> list){

        int conj1 = 0;
        int conj2 = 0;
        int conj3 = 0;
        int conj4 = 0;

        int present = 0;
        int imperfect = 0;
        int future = 0;
        int perfect = 0;
        int pluperfect = 0;
        int futurePerfect = 0;

        int indicative = 0;
        int subjunctive = 0;
        int imperative = 0;

        int active = 0;
        int passive = 0;

        int total = 0;

        int conj1Tally = 0;
        int conj2Tally = 0;
        int conj3Tally = 0;
        int conj4Tally = 0;

        int presentTally = 0;
        int imperfectTally = 0;
        int futureTally = 0;
        int perfectTally = 0;
        int pluperfectTally = 0;
        int futurePerfectTally = 0;

        int indicativeTally = 0;
        int subjunctiveTally = 0;
        int imperativeTally = 0;

        int activeTally = 0;
        int passiveTally = 0;



        int numQuizQuestions = list.size();
        int conj1perc;
        int conj2perc;
        int conj3perc;
        int conj4perc;

        int presentPerc;
        int imperfectPerc;
        int futurePerc;
        int perfectPerc;
        int pluperfectPerc;
        int futPerfectPerc;

        int indicativePerc;
        int imperativePerc;
        int subjunctivePerc;

        int totalPerc;



        int activerPerc;
        int passivePerc;

        int conj1percHist;
        int conj2percHist;
        int conj3percHist;
        int conj4percHist;

        int presentPercHist;
        int imperfectPercHist;
        int futurePercHist;
        int perfectPercHist;
        int pluperfectPercHist;
        int futPerfectPercHist;

        int indicativePercHist;
        int imperativePercHist;
        int subjunctivePercHist;

        int activePercHist;
        int passivePercHist;

        int totalPercHist;

        Map<String, Integer> mapStatistics = new HashMap<>();


        // Tally Data
        // ----------
        for(Answer ans : list){
            Verb verb = ans.verb;
            if(ans.correct == 1)
                total++;  //  total Correct
            switch(verb.getLatin_ConjNum()) {
                case 1:
                    if(ans.correct == 1)
                        conj1++;
                    conj1Tally++;
                    break;
                case 2:
                    if(ans.correct == 1)
                        conj2++;
                    conj2Tally++;
                    break;
                case 3:
                    if(ans.correct == 1)
                        conj3++;
                    conj3Tally++;
                    break;
                case 4:
                    if(ans.correct == 1)
                        conj4++;
                    conj4Tally++;
                    break;
                default:
                    if(ans.correct == 1)
                        conj3++;  // For Alternatives of the Conj 3rd
                    conj3Tally++;
                    break;
            }

            switch (verb.getTense()) {
                case TENSE_PRESENT:
                    if(ans.correct == 1)
                        present++;
                    presentTally++;
                    break;
                case TENSE_IMPERFECT:
                    if(ans.correct == 1)
                        imperfect++;
                    imperfectTally++;
                    break;
                case TENSE_FUTURE:
                    if(ans.correct == 1)
                        future++;
                    futureTally++;
                    break;
                case TENSE_PERFECT:
                    if(ans.correct == 1)
                        perfect++;
                    perfectTally++;
                    break;
                case TENSE_PLUPERFECT:
                    if(ans.correct == 1)
                        pluperfect++;
                    pluperfectTally++;
                    break;
                case TENSE_FUTURE_PERFECT:
                    if(ans.correct == 1)
                        futurePerfect++;
                    futurePerfectTally++;
                    break;
            }

            switch (verb.getMood()) {
                case MOOD_INDICATIVE:
                    if(ans.correct == 1)
                        indicative++;
                    indicativeTally++;
                    break;
                case MOOD_IMPERATIVE:
                    if(ans.correct == 1)
                        imperative++;
                    imperativeTally++;
                    break;
                case MOOD_SUBJUNCTIVE:
                    if(ans.correct == 1)
                        subjunctive++;
                    subjunctiveTally++;
                    break;
            }

            switch (verb.getVoice()) {
                case VOICE_ACTIVE:
                    if(ans.correct == 1)
                        active++;
                    activeTally++;
                    break;
                case VOICE_PASSIVE:
                    if(ans.correct == 1)
                        passive++;
                    passiveTally++;
                    break;
            }
        }


        // Calc Current Quiz Results
        // -------------------------
        conj1perc = (conj1Tally>0) ? conj1*100/conj1Tally : 0;
        conj2perc = (conj2Tally>0) ? conj2*100/conj2Tally : 0;
        conj3perc = (conj3Tally>0) ? conj3*100/conj3Tally : 0;
        conj4perc = (conj4Tally>0) ? conj4*100/conj4Tally : 0;

        presentPerc = (presentTally>0) ? present*100/presentTally : 0;
        imperfectPerc = (imperfectTally>0) ? imperfect*100/imperfectTally : 0;
        futurePerc = (futureTally>0) ? future*100/futureTally: 0;
        perfectPerc = (perfectTally>0) ? perfect*100/perfectTally : 0;
        pluperfectPerc = (pluperfectTally>0) ? pluperfect*100/pluperfectTally : 0;
        futPerfectPerc = (futureTally>0) ? futurePerfect*100/futureTally : 0;

        indicativePerc = (indicativeTally>0) ? indicative*100/indicativeTally : 0;
        subjunctivePerc = (subjunctiveTally>0) ? subjunctive*100/subjunctiveTally : 0;
        imperativePerc = (imperativeTally>0) ? imperative*100/imperativeTally : 0;

        activerPerc = (activeTally>0) ? active*100/activeTally : 0;
        passivePerc = (passiveTally>0) ? passive*100/passiveTally : 0;

        totalPerc = total*100/numQuizQuestions;


        // Insert Current Quiz Scores Into Map
        // -----------------------------------
        mapStatistics.put(CONJ1, conj1perc );
        mapStatistics.put(CONJ2, conj2perc );
        mapStatistics.put(CONJ3, conj3perc );
        mapStatistics.put(CONJ4, conj4perc );

        mapStatistics.put( TENSE_PRESENT, presentPerc );
        mapStatistics.put( TENSE_IMPERFECT, imperfectPerc );
        mapStatistics.put( TENSE_FUTURE, futurePerc );
        mapStatistics.put( TENSE_PERFECT, perfectPerc );
        mapStatistics.put( TENSE_PLUPERFECT, pluperfectPerc );
        mapStatistics.put( TENSE_FUTURE_PERFECT, futPerfectPerc );

        mapStatistics.put( MOOD_INDICATIVE, indicativePerc );
        mapStatistics.put( MOOD_SUBJUNCTIVE, subjunctivePerc );
        mapStatistics.put( MOOD_IMPERATIVE, imperativePerc );

        mapStatistics.put( VOICE_ACTIVE, activerPerc );
        mapStatistics.put( VOICE_PASSIVE, passivePerc );

        mapStatistics.put(VERB_TOTAL, totalPerc);

        // Calc Total Historical Scores and Update in Map
        // ----------------------------------------------
        conj1percHist = calcHistoryStatistics(CONJ1_SCORE, CONJ1_TALLY, conj1, conj1Tally);
        mapStatistics.put(CONJ1_HIST_PERC, conj1percHist);

        conj2percHist = calcHistoryStatistics(CONJ2_SCORE, CONJ2_TALLY, conj2, conj2Tally);
        mapStatistics.put(CONJ2_HIST_PERC, conj2percHist);

        conj3percHist = calcHistoryStatistics(CONJ3_SCORE, CONJ3_TALLY, conj3, conj3Tally);
        mapStatistics.put(CONJ3_HIST_PERC, conj3percHist);

        conj4percHist = calcHistoryStatistics(CONJ4_SCORE, CONJ4_TALLY, conj4, conj4Tally);
        mapStatistics.put(CONJ4_HIST_PERC, conj4percHist);

        presentPercHist = calcHistoryStatistics(PRESENT_SCORE, PRESENT_TALLY, present, presentTally);
        mapStatistics.put(TENSE_PRESENT_HIST_PERC, presentPercHist);

        imperfectPercHist = calcHistoryStatistics(IMPERFECT_SCORE, IMPERFECT_TALLY, imperfect, imperfectTally);
        mapStatistics.put(TENSE_IMPERFECT_HIST_PERC, imperfectPercHist);

        futurePercHist = calcHistoryStatistics(FUTURE_SCORE, FUTURE_TALLY, future, futureTally);
        mapStatistics.put(TENSE_FUTURE_HIST_PERC, futurePercHist);

        perfectPercHist = calcHistoryStatistics(PERFECT_SCORE, PERFECT_TALLY, perfect, perfectTally);
        mapStatistics.put(TENSE_PERFECT_HIST_PERC, perfectPercHist);

        pluperfectPercHist = calcHistoryStatistics(PLUPERFECT_SCORE, PLUPERFECT_TALLY, pluperfect, pluperfectTally);
        mapStatistics.put(TENSE_PLUPERFECT_HIST_PERC, pluperfectPercHist);

        futPerfectPercHist = calcHistoryStatistics(FUT_PERFECT_SCORE, FUT_PERFECT_TALLY, futurePerfect, futurePerfectTally);
        mapStatistics.put(TENSE_FUTURE_PERFECT_HIST_PERC, futPerfectPercHist);

        indicativePercHist = calcHistoryStatistics(INDICATIVE_SCORE, INDICATIVE_TALLY, indicative, indicativeTally);
        mapStatistics.put(MOOD_INDICATIVE_HIST_PERC, indicativePercHist);

        subjunctivePercHist = calcHistoryStatistics(SUBJUNCTIVE_SCORE, SUBJUNCTIVE_TALLY, subjunctive, subjunctiveTally);
        mapStatistics.put(MOOD_SUBJUNCTIVE_HIST_PERC, subjunctivePercHist);

        imperativePercHist = calcHistoryStatistics(IMPERATIVE_SCORE, IMPERATIVE_TALLY, imperative, imperativeTally);
        mapStatistics.put(MOOD_IMPERATIVE_HIST_PERC, imperativePercHist);

        activePercHist = calcHistoryStatistics(ACTIVE_SCORE, ACTIVE_TALLY, active, activeTally);
        mapStatistics.put(VOICE_ACTIVE_HIST_PERC, activePercHist);

        passivePercHist = calcHistoryStatistics(PASSIVE_SCORE, PASSIVE_TALLY, passive, passiveTally);
        mapStatistics.put(VOICE_PASSIVE_HIST_PERC, passivePercHist);

        totalPercHist = calcHistoryStatistics(VERB_TOTAL_SCORE, VERB_TOTAL_TALLY, total, numQuizQuestions);
        mapStatistics.put(VERB_TOTAL_HIST_PERC, totalPercHist);

        return mapStatistics;
    }


    /**
     * calcHistoryStatistics()
     * -----------------------
     * Helper method for calcStatistics.
     * 1) Retrieves Historical Score and Tally from Meta Table
     * 2) Updates MetaTable with Updated Score and Tally
     *
     * @param dbHistScore - KEY for Score
     * @param dbHistTally - KEY for Tally
     * @param currentScore - The Score of The Current Game for this type of verb
     * @param numQuizQuestions - Number of Quiz Questions.
     */
    @Override
    public int calcHistoryStatistics(String dbHistScore, String dbHistTally, int currentScore, int numQuizQuestions){

        int totalScore = mDatabaseAccess.sqlMetaQuery(dbHistScore);  // Get Historical Score
        int tally = mDatabaseAccess.sqlMetaQuery(dbHistTally); // Get Histortical Tally of Questions

        mDatabaseAccess.sqlMeta_Insertion(dbHistScore, totalScore + currentScore);  // Update Database of Historical Score
        mDatabaseAccess.sqlMeta_Insertion(dbHistTally, tally + numQuizQuestions); // Update Database of Historical Tally
        return (tally + numQuizQuestions > 0) ? ((totalScore + currentScore)*100)/(tally + numQuizQuestions) : 0 ;  // Calc New Historical %
    }



    // Getters/Setters
    // ---------------

    @Override
    public List<Verb> getVerbQuestionList() {
        return mVerbQuestionList;
    }
    @Override
    public Verb getCorrectVerb() {
        return mCorrectVerb;
    }
    @Override
    public void setCorrectVerb(Verb correctVerb) {
        mCorrectVerb = correctVerb;
    }
    @Override
    public int getCorrectVerbDifficulty() {
        return mCorrectVerbDifficulty;
    }
    @Override
    public int getCorrectVerbIndex() {
        return mCorrectVerbIndex;
    }
    @Override
    public String getCorrectVerbMood() {
        return mCorrectVerbMood;
    }
    @Override
    public void setCorrectVerbMood(String correctVerbMood) {
        mCorrectVerbMood = correctVerbMood;
    }
    @Override
    public String getCorrectVerbVoice() {
        return mCorrectVerbVoice;
    }
    @Override
    public void setCorrectVerbVoice(String correctVerbVoice) {
        mCorrectVerbVoice = correctVerbVoice;
    }
    @Override
    public int getQuestionNumber() {
        return mQuestionNumber;
    }
    @Override
    public void setQuestionNumber(int questionNumber) {
        mQuestionNumber = questionNumber;
    }
    @Override
    public Map<String, Integer> getStatMap() {
        return mStatMap;
    }
}
