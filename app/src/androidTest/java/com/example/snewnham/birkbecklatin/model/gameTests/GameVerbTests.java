package com.example.snewnham.birkbecklatin.model.gameTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGame;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGameImpl;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.verbs.Answer;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES FOR 1st COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class GameVerbTests {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;
    RandomGenerator randomGenerator;

    int id_Regular;  // id for Regular
    int id_Deponent;  // id for Deponent
    int id_SemiDeponent;  // id for Semi Deponent
    int id_Irregular; // id for Irregular

    VerbGameImpl verbGame1;
    VerbGameImpl verbGame2;
    VerbGameImpl verbGame3;
    VerbGameImpl verbGame4;
    VerbGameImpl verbGame5;
    VerbGameImpl verbGameSkill;
    VerbGame verbGameIncorrect;

    VerbRegular mVerbRegular;

    int skillLevel1;
    int skillLevel2;
    int skillLevel3;
    int skillLevel4;

    private final static String TENSE_PRESENT = "Present";
    private final static String TENSE_IMPERFECT = "Imperfect";
    private final static String TENSE_FUTURE = "Future";
    private final static String TENSE_PERFECT = "Perfect";
    private final static String TENSE_PLUPERFECT = "Pluperfect";
    private final static String TENSE_FUTURE_PERFECT = "Future Perfect";

    private final static String VOICE_ACTIVE = "Active";
    private final static String VOICE_PASSIVE = "Passive";

    private final static String MOOD_INDICATIVE = "Indicative";
    private final static String MOOD_IMPERATIVE = "Imperative";
    private final static String MOOD_SUBJUNCTIVE = "Subjunctive";


    String person1;
    String person2;
    String person3;
    String personNull;

    String numberSingular;
    String numberPlural;
    String numberInfinitive;

    String moodIndicative;
    String moodSubjunctive;
    String moodImperative;

    String voiceActive;
    String voicePassive;

    String tensePresent;
    String tenseImPerfect;
    String tenseFuture;
    String tensePerfect;
    String tensePluperfect;
    String tenseFuturePerfect;
    String tenseNull;

    String conjNum1;
    String conjNum2;
    String conjNum3;
    String conjNum4;
    String conjNull;

    private static final int CONJNUM1_2 = 2;
    private static final int CONJNUM1_4 = 40;

    int correct;
    boolean restricted;


    // CONSTANTS FOR KEYS IN DATABASE and StatisticsMap
    //-------------------------------------------------

    private static final String CONJNUM1_SCORE = "ConjScore1";  // Historical Score of Correct Con# Questions
    private static final String CONJNUM2_SCORE = "ConjScore2";  // Key for Meta Table in DB
    private static final String CONJNUM3_SCORE = "ConjScore3";
    private static final String CONJNUM4_SCORE = "ConjScore4";

    private final String CONJ1_TALLY = "ConjTally1";  // Tally of All Conj# Questions Asked
    private final String CONJ2_TALLY = "ConjTally2";  // Key for Meta Table in DB
    private final String CONJ3_TALLY = "ConjTally3";
    private final String CONJ4_TALLY = "ConjTally4";

    private final String CONJNUM1_HIST_PERC = "Conj1_Hist%";  // % of Correctly Answered Conj# Questions
    private final String CONJNUM2_HIST_PERC = "Conj2_Hist%";  // Key For statisticsMap
    private final String CONJNUM3_HIST_PERC = "Conj3_Hist%";
    private final String CONJNUM4_HIST_PERC = "Conj4_Hist%";


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


    private final static String TENSE_PRESENT_HIST = "Present_Hist%";    // % of Correctly Answered Tense Questions
    private final static String TENSE_IMPERFECT_HIST = "Imperfect_Hist%";  // Key For statisticsMap
    private final static String TENSE_FUTURE_HIST = "Future_Hist%";
    private final static String TENSE_PERFECT_HIST = "Perfect_Hist%";
    private final static String TENSE_PLUPERFECT_HIST = "Pluperfect_Hist%";
    private final static String TENSE_FUTURE_PERFECT_HIST = "Future Perfect_Hist%";

    private final String INDICATIVE_SCORE = "IndicativeScore";    // Historical Score of Correct Mood Questions
    private final String SUBJUNCTIVE_SCORE = "SubjunctiveScore";  // Key for Meta Table in DB
    private final String IMPERATIVE_SCORE = "ImperativeScore";

    private final String INDICATIVE_TALLY = "IndicativeTally";  // Tally of All Mood Questions Asked
    private final String SUBJUNCTIVE_TALLY = "SubjunctiveTally";   // Key for Meta Table in DB
    private final String IMPERATIVE_TALLY = "ImperativeTally";

    private final static String MOOD_INDICATIVE_HIST = "Indicative_Hist%";   // % of Correctly Answered Mood Questions
    private final static String MOOD_IMPERATIVE_HIST = "Imperative_Hist%";   // Key For statisticsMap
    private final static String MOOD_SUBJUNCTIVE_HIST = "Subjunctive_Hist%";

    private final String ACTIVE_SCORE = "ActiveScore";    // Historical Score of Correct Voice Questions
    private final String PASSIVE_SCORE = "PassiveScore";  // Key for Meta Table in DB

    private final String ACTIVE_TALLY = "ActiveTally";    // Tally of All Voice Questions Asked
    private final String PASSIVE_TALLY = "PassiveTally";  // Key for Meta Table in DB

    private final static String VOICE_ACTIVE_HIST = "Active_Hist%";   // % of Correctly Answered Voice Questions
    private final static String VOICE_PASSIVE_HIST = "Passive_Hist%";  // Key For statisticsMap


    private final static String TOTAL_SCORE = "TotalScore";  // Historical Score of ALL Correct Questions
    private final static String TOTAL_TALLY = "TotalTally";  // Tally of All Correct Questions Asked
    private final static String TOTAL_HIST = "Total_Hist%";  // Key For statisticsMap




    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);  // Reset ASKED = 0

        randomGenerator = new RandomGenerator(databaseAccess);


        verbGame1 = new VerbGameImpl(databaseAccess, 1); // Verb Skill 1
        verbGame2 = new VerbGameImpl(databaseAccess, 2);
        verbGame3 = new VerbGameImpl(databaseAccess, 3);
        verbGame4 = new VerbGameImpl(databaseAccess, 4);
        verbGame5 = new VerbGameImpl(databaseAccess, 5);

        verbGameSkill = new VerbGameImpl(databaseAccess, 1); // Verb Skill 1
        verbGameIncorrect = new VerbGameImpl(databaseAccess,1);

        id_Regular = 1;
        id_Deponent = 8;
        id_SemiDeponent = 9;
        id_Irregular = 10;
        mVerbRegular = new VerbRegular(id_Regular, databaseAccess);

        skillLevel1 = 1;
        skillLevel2 = 2;
        skillLevel3 = 3;
        skillLevel4 = 4;

        mVerbRegular.setLatin_Type("Regular");
        mVerbRegular.setLatin_ConjNum(1);

        mVerbRegular.setLatin_Present("amo");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("amare");
        mVerbRegular.setLatin_Perfect("amavi");
        mVerbRegular.setLatin_Participle("amatus");

        mVerbRegular.setLatin_Present_Stem("am");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("ama");
        mVerbRegular.setLatin_Infinitive_PassiveStem("amar");
        mVerbRegular.setLatin_Present_SubjuncStem("ame");
        mVerbRegular.setLatin_Perfect_Stem("amav");
        mVerbRegular.setLatin_Participle_Stem("amat");

        mVerbRegular.setEnglish_Infinitive("love");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("loves");
        mVerbRegular.setEnglish_Perfect("loved");
        mVerbRegular.setEnglish_Participle("loving");

        // makeLatinWord Arguments
        // -----------------------

        person1 = "1st";
        person2 = "2nd";
        person3 = "3rd";
        personNull = null;

        numberSingular = "Singular";
        numberPlural = "Plural";
        numberInfinitive = "Infinitive";

        moodIndicative = "Indicative";
        moodSubjunctive = "Subjunctive";
        moodImperative = "Imperative";

        voiceActive = "Active";
        voicePassive = "Passive";

        tensePresent = "Present";
        tenseImPerfect = "Imperfect";
        tenseFuture = "Future";
        tensePerfect = "Perfect";
        tensePluperfect = "Pluperfect";
        tenseFuturePerfect = "Future Perfect";
        tenseNull = null;

        conjNum1 = "1";
        conjNum2 = "2";
        conjNum3 = "3";
        conjNum4 = "4";
        conjNull = null;

        correct = 1;
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }


    /**
     * testMakeGameVerb_Regular()
     * ==========================
     * test if MakeGameVerb Can Make The Right Type of Verb - Regular.
     * @throws Exception
     */
    @Test
    public void testMakeGameVerb_Regular() throws Exception {

        Verb verb = verbGame1.makeGameVerb(id_Regular, person3, numberSingular, tensePresent,
                                            moodIndicative, voiceActive);
        String latinWord = verb.getLatinVerb();
        assertEquals("Regular Latin Verb", "portat", latinWord );

        String englishWord = verb.getEnglishVerb();
        assertEquals("Regular English Verb", "he/she carries", englishWord );
    }



    /**
     * testMakeGameVerb_Deponent()
     * ==========================
     * test if MakeGameVerb Can Make The Right Type of Verb - Deponent.
     * @throws Exception
     */
    @Test
    public void testMakeGameVerb_Deponent() throws Exception {

        Verb verb = verbGame1.makeGameVerb(id_Deponent, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive);
        String latinWord = verb.getLatinVerb();
        assertEquals("Deponent Latin Verb", "visus est", latinWord );

        String englishWord = verb.getEnglishVerb();
        assertEquals("Deponent English Verb", "he/she has seemed", englishWord );
    }


    /**
     * testMakeGameVerb_SemiDeponent()
     * ===============================
     * test if MakeGameVerb Can Make The Right Type of Verb - SemiDeponent.
     * @throws Exception
     */
    @Test
    public void testMakeGameVerb_SemiDeponent() throws Exception {

        Verb verb1 = verbGame4.makeGameVerb(id_SemiDeponent, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive);
        String latinWord1 = verb1.getLatinVerb();
        assertEquals("Semi Deponent Latin Verb (Present)", "gaudet", latinWord1 );

        String englishWord1 = verb1.getEnglishVerb();
        assertEquals("Semi Deponent English Verb (Present)", "he/she rejoices", englishWord1 );


        Verb verb2 = verbGame4.makeGameVerb(id_SemiDeponent, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive);
        String latinWord2 = verb2.getLatinVerb();
        assertEquals("Semi Deponent Latin Verb (Present)", "gavisus est", latinWord2 );

        String englishWord2 = verb2.getEnglishVerb();
        assertEquals("Semi Deponent English Verb (Present)", "he/she has rejoiced", englishWord2 );


        Verb verb3 = verbGame5.makeGameVerb(id_SemiDeponent, person3, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive);
        String latinWord3 = verb3.getLatinVerb();
        assertEquals("Semi Deponent Latin Verb (Present)", "gavisus esse", latinWord3 );

        String englishWord3 = verb3.getEnglishVerb();
        assertEquals("Semi Deponent English Verb (Present)", "to have rejoiced", englishWord3 );
    }

    /**
     * testMakeGameVerb_Deponent()
     * ==========================
     * test if MakeGameVerb Can Make The Right Type of Verb - Deponent.
     * @throws Exception
     */

    @Test
    public void testMakeGameVerb_Irregular() throws Exception {

        Verb verb = verbGame1.makeGameVerb(id_Irregular, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive);
        String latinWord = verb.getLatinVerb();
        assertEquals("Deponent Latin Verb", "est", latinWord );

        String englishWord = verb.getEnglishVerb();
        assertEquals("Deponent English Verb", "he/she is", englishWord );
    }

    /**
     * testMakeImperativeQuestionList()
     * --------------------------------
     * Test makeImperativeQuestionList() can make a question for just Imperatives
     *
     * @throws Exception
     */
    @Test
    public void testMakeImperativeQuestionList() throws Exception {

        List<Integer> imperativeIDs = new ArrayList<>();
        imperativeIDs.add(8);
        imperativeIDs.add(9);

        List<Verb> list = verbGame1.makeImperativeQuestionList(imperativeIDs);
        Verb v0 = list.get(0);
        Verb v1 = list.get(1);
        Verb v2 = list.get(2);
        Verb v3 = list.get(3);
        Verb v4 = list.get(4);
        Verb v5 = list.get(5);

        assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
        assertEquals(v1.getId(), v2.getId());

        assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
        assertEquals(v4.getId(), v5.getId());

        assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
        assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

        assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
        assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.
        int x = 5;

    }

    /**
     * testGetVerbQuestions() - Skill 1
     * ----------------------
     * Tests the List of Verb Questions Meet the Criteria of Skill 1
     *
     * @throws Exception
     */
    @Test
    public void testGetVerbQuestions_Skill1() throws Exception {

        List<Verb> list = null;
        for (int i = 0; i < 5; i++) {
            restricted = true;
            List<Integer> idPairList = randomGenerator.getRandomVerbIDpair(CONJNUM1_2, correct, restricted);
//            List<Integer> idPairList = new ArrayList<>();
//            idPairList.add(10);
//            idPairList.add(7);
            list = verbGame1.getVerbQuestionSet(idPairList);

            Verb v0 = list.get(0);
            Verb v1 = list.get(1);
            Verb v2 = list.get(2);
            Verb v3 = list.get(3);
            Verb v4 = list.get(4);
            Verb v5 = list.get(5);

            assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
            assertEquals(v1.getId(), v2.getId());

            assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
            assertEquals(v4.getId(), v5.getId());

            assertTrue(v0.getLatin_ConjNum() <= 2);  // Tests Conj 1-2;
            assertTrue(v1.getLatin_ConjNum() <= 2);

            assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
            assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

            assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
            assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.

            list.removeAll(list);
         }
    }

    /**
     * testGetVerbQuestions() - Skill 2
     * ----------------------
     * Tests the List of Verb Questions Meet the Criteria of Skill 2
     *
     * @throws Exception
     */
    @Test
    public void testGetVerbQuestions_Skill2() throws Exception {
        List<Verb> list = null;
        for (int i = 0; i < 5; i++) {
            restricted = true;
            List<Integer> idPairList = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, correct, restricted);
            list = verbGame1.getVerbQuestionSet(idPairList);
            Verb v0 = list.get(0);
            Verb v1 = list.get(1);
            Verb v2 = list.get(2);
            Verb v3 = list.get(3);
            Verb v4 = list.get(4);
            Verb v5 = list.get(5);

            assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
            assertEquals(v1.getId(), v2.getId());

            assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
            assertEquals(v4.getId(), v5.getId());

            assertTrue(v0.getLatin_ConjNum() <= 4);  // Tests Conj 1-4;
            assertTrue(v1.getLatin_ConjNum() <= 4);

            assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
            assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

            assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
            assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.

            list.removeAll(list);
        }
    }


    /**
     * testGetVerbQuestions() - Skill 3
     * ----------------------
     * Tests the List of Verb Questions Meet the Criteria of Skill 3
     *
     * @throws Exception
     */
    @Test
    public void testGetVerbQuestions_Skill3() throws Exception {

        List<Verb> list = null;
        for (int i = 0; i < 5; i++) {
            restricted = true;
            List<Integer> idPairList = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, correct, restricted);
            list = verbGame1.getVerbQuestionSet(idPairList);
            Verb v0 = list.get(0);
            Verb v1 = list.get(1);
            Verb v2 = list.get(2);
            Verb v3 = list.get(3);
            Verb v4 = list.get(4);
            Verb v5 = list.get(5);

            assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
            assertEquals(v1.getId(), v2.getId());

            assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
            assertEquals(v4.getId(), v5.getId());

            assertTrue(v0.getLatin_ConjNum() <= 4);  // Tests Conj 1-4;
            assertTrue(v1.getLatin_ConjNum() <= 4);

            assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
            assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

            assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
            assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.

            list.removeAll(list);
        }
    }

    /**
     * testGetVerbQuestions() - Skill 4
     * ----------------------
     * Tests the List of Verb Questions Meet the Criteria of Skill 4
     *
     * @throws Exception
     */
    @Test
    public void testGetVerbQuestions_Skill4() throws Exception {

        List<Verb> list = null;
        Map<String, Integer> map = new HashMap<>();


        for(int i=0; i<3; i++) {  // limited checks as sqlite cannot cope with multiple queries
            restricted = false;
            List<Integer> idPairList = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, correct, restricted);
            list = verbGame1.getVerbQuestionSet(idPairList);
            Verb v0 = list.get(0);
            Verb v1 = list.get(1);
            Verb v2 = list.get(2);
            Verb v3 = list.get(3);
            Verb v4 = list.get(4);
            Verb v5 = list.get(5);

            assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
            assertEquals(v1.getId(), v2.getId());

            assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
            assertEquals(v4.getId(), v5.getId());

            assertTrue(v0.getLatin_ConjNum() <= 4);  // Tests Conj 1-4;
            assertTrue(v1.getLatin_ConjNum() <= 4);

            assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
            assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

            assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
            assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.

           list.removeAll(list);

        }
    }


    /**
     * testGetVerbQuestions() - Skill 5
     * ----------------------
     * Tests the List of Verb Questions Meet the Criteria of Skill 4
     *
     * @throws Exception
     */
    @Test
    public void testGetVerbQuestions_Skill5() throws Exception {

        List<Verb> list = null;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <3; i++) {
            restricted = false;
            List<Integer> idPairList = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, correct, restricted);
            list = verbGame1.getVerbQuestionSet(idPairList);
            Verb v0 = list.get(0);
            Verb v1 = list.get(1);
            Verb v2 = list.get(2);
            Verb v3 = list.get(3);
            Verb v4 = list.get(4);
            Verb v5 = list.get(5);

            assertEquals(v0.getId(), v1.getId());   // Tests Qu 0-2 have same Verb ID
            assertEquals(v1.getId(), v2.getId());

            assertEquals(v3.getId(), v4.getId());    // Tests Qu 3-5 have same Verb ID
            assertEquals(v4.getId(), v5.getId());

            assertTrue(v0.getLatin_ConjNum() <= 4);  // Tests Conj 1-4;
            assertTrue(v1.getLatin_ConjNum() <= 4);

            assertFalse(v0.getLatinVerb().equals(v1.getLatinVerb()));  // Tests Qu 0-2 have Diff.
            assertFalse(v1.getLatinVerb().equals(v2.getLatinVerb()));  // verb endings.

            assertFalse(v3.getLatinVerb().equals(v4.getLatinVerb()));  // Tests Qu 3-5 have Diff.
            assertFalse(v4.getLatinVerb().equals(v5.getLatinVerb()));  // verb endings.

            list.removeAll(list);
        }
    }


    /**
     * testDetermineQuestionDifficulty()
     * ---------------------------------
     *
     * Tests determineQuestionDifficulty() to see if it can detect the correct Difficulty level of
     * a question.
     *
     */
    @Test
    public void testDetermineQuestionDifficulty(){

        int id1 = 1;
        verbGame5.setCorrectVerbMood(moodSubjunctive);
        Verb v5 =  verbGame5.makeGameVerb(id1, person1, numberSingular,tensePresent, moodSubjunctive, voiceActive );
        int diff5 = verbGame5.determineQuestionDifficulty();
        assertEquals("Difficulty 5", 5, diff5);

        Verb v4 = verbGame4.makeGameVerb(id_Deponent, person1, numberSingular,tensePresent, moodImperative, voiceActive);
        verbGame4.setCorrectVerb(v4);
        verbGame4.setCorrectVerbMood(moodImperative);
        int diff4 = verbGame4.determineQuestionDifficulty();
        assertEquals("Difficulty 4", 4, diff4);

        Verb v3 = verbGame3.makeGameVerb(id_Regular, person1, numberSingular,tensePresent, moodIndicative, voicePassive);
        verbGame3.setCorrectVerb(v3);
        verbGame3.setCorrectVerbMood(moodImperative);
        verbGame3.setCorrectVerbVoice(voicePassive);
        int diff3 = verbGame3.determineQuestionDifficulty();
        assertEquals("Difficulty 3", 3, diff3);

        Verb v2 = verbGame2.makeGameVerb(4, person1, numberSingular,tensePresent, moodIndicative, voiceActive);
        verbGame2.setCorrectVerb(v2);
        verbGame2.setCorrectVerbMood(moodIndicative);
        verbGame2.setCorrectVerbVoice(voiceActive);
        int diff2 = verbGame2.determineQuestionDifficulty();
        assertEquals("Difficulty 2", 2, diff2);

        Verb v1 = verbGame1.makeGameVerb(id_Irregular, person1, numberSingular,tensePresent, moodIndicative, voiceActive);
        verbGame1.setCorrectVerb(v1);
        verbGame1.setCorrectVerbMood(moodIndicative);
        verbGame1.setCorrectVerbVoice(voiceActive);
        int diff1 = verbGame1.determineQuestionDifficulty();
        assertEquals("Difficulty 1", 1, diff1);

        Verb v11 = verbGame1.makeGameVerb(2, person1, numberSingular,tensePresent, moodIndicative, voiceActive);
        verbGame1.setCorrectVerb(v11);
        verbGame1.setCorrectVerbMood(moodIndicative);
        verbGame1.setCorrectVerbVoice(voiceActive);
        int diff11 = verbGame1.determineQuestionDifficulty();
        assertEquals("Difficulty 1", 1, diff11);


    }


    // ---------------------------------VERB CORRECT ---------------------------------------------
//
//    /**
//     * testRandomVerbCorrectTable()
//     * ------------------------------
//     * Test for random selection of a verb_id from the IncorrectVerb Table.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testRandomVerbIncorrectTable() throws Exception {
//
//        int skillLevel = 5;
//        int id1 = 1;
//        Verb verb1 = databaseAccess.sqlVerbListQuery(id1);
//        int id2 = 2;
//        Verb verb2 = databaseAccess.sqlVerbListQuery(id2);
//        int id3 = 8;
//        Verb verb3 = databaseAccess.sqlVerbListQuery(id3);
//        int id4 = 10;
//        Verb verb4 = databaseAccess.sqlVerbListQuery(id4);
//
//        int randomSims = 800;
//
//        // Reset the table
//        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
//        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
//
//        // load the table
//        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.CORRECT, 0);
//
//        List<Integer> inCorrectList = databaseAccess.getVerbIDList(CONJNUM1_4, 0, false);
//        int numVerbs = inCorrectList.size();
//
//        int sample = randomSims / numVerbs;
//        float toleranceFactor = 0.2f;
//        int toleranceForSample = (int) (sample * toleranceFactor);
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0; i<randomSims; i++) {
//            List<Integer> list = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, 0, false);
//            int ans = list.get(0);
//            if (!map.containsKey(ans))
//                map.put(ans, 1);
//            else
//                map.put(ans, map.get(ans) + 1);
//        }
//
//        int x = 5;
//        assertThat("Num verbId_1 Simulations", map.get(id1), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_1 Simulations", map.get(id1), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_2 Simulations", map.get(id2), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_2 Simulations", map.get(id2), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_3 Simulations", map.get(id3), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_3 Simulations", map.get(id3), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_4 Simulations", map.get(id4), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_4 Simulations", map.get(id4), lessThan(sample + toleranceForSample));
//    }
//

////
////    @Test
////    public void testAddToTheIncorrectVerbTable(){
////
////        VerbGame.Answer ans1 = verbGameIncorrect.new Answer(1,1,1);
////        VerbGame.Answer ans2 = verbGameIncorrect.new Answer(2,0,1);
////        VerbGame.Answer ans8 = verbGameIncorrect.new Answer(8,0,1);
////        VerbGame.Answer ans10 = verbGameIncorrect.new Answer(10,1,1);
////
////        List<VerbGame.Answer> answerList = new ArrayList<>();
////        answerList.add(ans1);
////        answerList.add(ans2);
////        answerList.add(ans8);
////        answerList.add(ans10);
////
////        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
////        int count = verbGameIncorrect.addToTheIncorrectVerbTable(answerList);
////
////        assertEquals(2, count);
////
////    }

    /**
     * testUpdateSkillLevel()
     * ----------------------
     * Test that skill level can be changed after IRT update
     */
    @Test
    public void testUpdateSkillLevel(){

        List<Answer> answerList = new ArrayList<>();

        Answer ans1 = new Answer(1,1,1);
        Answer ans2 = new Answer(2,1,1);
        Answer ans3 = new Answer(3,1,1);
        Answer ans4 = new Answer(4,1,1);
        Answer ans5 = new Answer(5,1,1);
        Answer ans6 = new Answer(6,1,1);
        Answer ans7 = new Answer(7,1,1);
        Answer ans8 = new Answer(8,1,1);
        Answer ans9 = new Answer(9,1,1);
        Answer ans10 = new Answer(10,1,1);
        Answer ans11 = new Answer(11,1,1);
        Answer ans12 = new Answer(12,1,1);
        Answer ans13 = new Answer(13,1,1);
        Answer ans14 = new Answer(14,1,1);
        Answer ans15 = new Answer(15,1,1);
        Answer ans16 = new Answer(16,1,1);
        Answer ans17 = new Answer(17,1,1);
        Answer ans18 = new Answer(18,1,1);
        Answer ans19 = new Answer(19,1,1);
        Answer ans20 = new Answer(20,1,1);

        answerList.add(ans1);
        answerList.add(ans2);
        answerList.add(ans3);
        answerList.add(ans4);
        answerList.add(ans5);
        answerList.add(ans6);
        answerList.add(ans7);
        answerList.add(ans8);
        answerList.add(ans9);
        answerList.add(ans10);
        answerList.add(ans11);
        answerList.add(ans12);
        answerList.add(ans13);
        answerList.add(ans14);
        answerList.add(ans15);
        answerList.add(ans16);
        answerList.add(ans17);
        answerList.add(ans18);
        answerList.add(ans19);
        answerList.add(ans20);

        int newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        assertEquals(2, newSkillLevel);  // Full Marks -> SKillLevel Up!

        for(Answer ans : answerList){  // Change to All Wrong Marks
            ans.correct = 0;
        }

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        assertEquals(1, newSkillLevel);  // ALL WRONG -> SKillLevel Down!

        for(int i=0; i<15; i++){    // 75% Correct
            Answer ans = answerList.get(i);
            ans.correct = 1;
        }

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        ans16.correct = 1;
        ans17.correct = 1;

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        ans18.correct = 1;

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        ans19.correct = 1;
        ans20.correct = 1;

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        assertEquals(3, newSkillLevel); // 75% Correct -> SKillLevel Up!

    }


    /**
     * testCalcHistoryStatistics()
     * ---------------------------
     * Test calcHistoryStatistics() to see if it can generate the correct Historical % statistic
     * @throws Exception
     */
    @Test
    public void testCalcHistoryStatistics() throws Exception{

        databaseAccess.sqlMeta_Insertion(PRESENT_SCORE, 0);  // RESET for TESTs
        databaseAccess.sqlMeta_Insertion(PRESENT_TALLY,0);

        int currentScore1 = 10;
        int numQuizQuestions1=10;
        int rightAns1 = (currentScore1*100)/numQuizQuestions1;

        int ansPercent = verbGame1.calcHistoryStatistics(PRESENT_SCORE, PRESENT_TALLY, currentScore1, numQuizQuestions1);

        assertEquals( rightAns1, ansPercent );

        int currentScore2 = 5;
        int numQuizQuestions2=10;
        int rightAns2 = ((currentScore1+currentScore2)*100)/(numQuizQuestions1+numQuizQuestions2);

        ansPercent = verbGame1.calcHistoryStatistics(PRESENT_SCORE, PRESENT_TALLY, currentScore2, numQuizQuestions2);

        assertEquals(rightAns2, ansPercent );

        }


    /**
     * testCalcStatistics()
     * --------------------
     * Test calcStatistics() so that it can correctly supply all statistics
     * both latest Quiz and Running Total;
     * @throws Exception
     */
    @Test
    public void testCalcStatistics() throws Exception{

        databaseAccess.sqlMeta_Reset(); // RESET

        List<Answer> ansList = new ArrayList<>();

        Verb verb1 = verbGame5.makeGameVerb(1, person1, numberSingular, tensePresent, moodIndicative, voiceActive);
        Answer ans1 = new Answer(verb1.getId(), 1, 1, verb1);

        Verb verb2 = verbGame5.makeGameVerb(2, person1, numberSingular, tenseImPerfect, moodIndicative, voiceActive);
        Answer ans2 = new Answer(verb2.getId(), 1, 1, verb2);

        Verb verb3 = verbGame5.makeGameVerb(3, person1, numberSingular, tenseFuture, moodIndicative, voiceActive);
        Answer ans3 = new Answer(verb3.getId(), 1, 1, verb3);

        Verb verb4 = verbGame5.makeGameVerb(4, person1, numberSingular, tensePresent, moodIndicative, voiceActive);
        Answer ans4 = new Answer(verb4.getId(), 1, 1, verb4);

        Verb verb5 = verbGame5.makeGameVerb(5, person1, numberSingular, tenseImPerfect, moodIndicative, voiceActive);
        Answer ans5 = new Answer(verb5.getId(), 1, 1, verb5);

        Verb verb6 = verbGame5.makeGameVerb(6, person1, numberSingular, tenseFuture, moodIndicative, voiceActive);
        Answer ans6 = new Answer(verb6.getId(), 1, 1, verb6);

        Verb verb7 = verbGame5.makeGameVerb(7, person1, numberSingular, tensePresent, moodSubjunctive, voiceActive);
        Answer ans7 = new Answer(verb7.getId(), 1, 1, verb7);

        Verb verb8 = verbGame5.makeGameVerb(8, person1, numberSingular, tenseImPerfect, moodSubjunctive, voiceActive);
        Answer ans8 = new Answer(verb8.getId(), 1, 1, verb8);

        Verb verb9 = verbGame5.makeGameVerb(9, person1, numberSingular, tenseFuture, moodSubjunctive, voicePassive);
        Answer ans9 = new Answer(verb9.getId(), 1, 1, verb9);

        Verb verb10 = verbGame5.makeGameVerb(10, person1, numberSingular, tenseFuture, moodSubjunctive, voicePassive);
        Answer ans10 = new Answer(verb10.getId(), 1, 1, verb10);

        Verb verb11 = verbGame5.makeGameVerb(1, person1, numberSingular, tensePresent, moodIndicative, voiceActive);
        Answer ans11 = new Answer(verb1.getId(), 0, 0, verb11);

        Verb verb12 = verbGame5.makeGameVerb(2, person1, numberSingular, tenseImPerfect, moodIndicative, voiceActive);
        Answer ans12 = new Answer(verb2.getId(), 0, 0, verb12);

        Verb verb13 = verbGame5.makeGameVerb(3, person1, numberSingular, tenseFuture, moodIndicative, voiceActive);
        Answer ans13 = new Answer(verb3.getId(), 0, 0, verb13);

        Verb verb14 = verbGame5.makeGameVerb(4, person1, numberSingular, tensePresent, moodIndicative, voiceActive);
        Answer ans14 = new Answer(verb4.getId(), 0, 0, verb14);

        Verb verb15 = verbGame5.makeGameVerb(5, person1, numberSingular, tenseImPerfect, moodIndicative, voiceActive);
        Answer ans15 = new Answer(verb5.getId(), 0, 0, verb15);

        Verb verb16 = verbGame5.makeGameVerb(6, person1, numberSingular, tenseFuture, moodIndicative, voiceActive);
        Answer ans16 = new Answer(verb6.getId(), 0, 0, verb16);

        Verb verb17 = verbGame5.makeGameVerb(7, person1, numberSingular, tensePresent, moodSubjunctive, voiceActive);
        Answer ans17 = new Answer(verb7.getId(), 0, 0, verb17);

        Verb verb18 = verbGame5.makeGameVerb(8, person1, numberSingular, tenseImPerfect, moodSubjunctive, voiceActive);
        Answer ans18 = new Answer(verb8.getId(), 0, 0, verb18);

        Verb verb19 = verbGame5.makeGameVerb(9, person1, numberSingular, tenseFuture, moodSubjunctive, voicePassive);
        Answer ans19 = new Answer(verb9.getId(), 0, 0, verb19);

        Verb verb20 = verbGame5.makeGameVerb(10, person1, numberSingular, tenseFuture, moodSubjunctive, voicePassive);
        Answer ans20 = new Answer(verb10.getId(), 0, 0, verb20);



        ansList.add(ans1);
        ansList.add(ans2);
        ansList.add(ans3);
        ansList.add(ans4);
        ansList.add(ans5);
        ansList.add(ans6);
        ansList.add(ans7);
        ansList.add(ans8);
        ansList.add(ans9);
        ansList.add(ans10);
        ansList.add(ans11);
        ansList.add(ans12);
        ansList.add(ans13);
        ansList.add(ans14);
        ansList.add(ans15);
        ansList.add(ans16);
        ansList.add(ans17);
        ansList.add(ans18);
        ansList.add(ans19);
        ansList.add(ans20);

        Map<String, Integer> map = verbGame5.calcStatistics(ansList);


        assertEquals((int)map.get(TENSE_PRESENT), 50);
        assertEquals((int)map.get(TENSE_IMPERFECT), 50);
        assertEquals((int)map.get(TENSE_FUTURE), 50);
        assertEquals((int)map.get(MOOD_INDICATIVE), 50);
        assertEquals((int)map.get(MOOD_SUBJUNCTIVE), 50);
        assertEquals((int)map.get(VOICE_ACTIVE), 50);
        assertEquals((int)map.get(VOICE_PASSIVE), 50);

        assertEquals((int)map.get(TENSE_PRESENT_HIST), 50);
        assertEquals((int)map.get(TENSE_IMPERFECT_HIST), 50);
        assertEquals((int)map.get(TENSE_FUTURE_HIST), 50);
        assertEquals((int)map.get(MOOD_INDICATIVE_HIST), 50);
        assertEquals((int)map.get(MOOD_SUBJUNCTIVE_HIST), 50);
        assertEquals((int)map.get(VOICE_ACTIVE_HIST), 50);
        assertEquals((int)map.get(VOICE_PASSIVE_HIST), 50);

    }

    /**
     * testRunVerbQuestion()
     * ---------------------
     * Test if Game Go Through 20 Question Rounds
     * @throws Exception
     */
    @Test
    public void testRunVerbQuestion() throws Exception{

        for(int i=0; i<10; i++) {

            // 1
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 2
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 3
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 4
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 5
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 6
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 7
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 8
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 9
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 10
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 11
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 12
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 13
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 14
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 15
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 16
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 17
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 18
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 19
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);
            // 20
            verbGame1.runVerbGame();
            verbGame1.storeAnswer(0);

            databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
            databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
            verbGame1.setQuestionNumber(0);
        }
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }

}
