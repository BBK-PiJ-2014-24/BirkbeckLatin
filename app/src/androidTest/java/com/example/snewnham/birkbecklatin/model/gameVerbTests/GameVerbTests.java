package com.example.snewnham.birkbecklatin.model.gameVerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGame;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
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

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.lessThan;
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

    int id_Regular;  // id for Regular
    int id_Deponent;  // id for Deponent
    int id_SemiDeponent;  // id for Semi Deponent
    int id_Irregular; // id for Irregular

    VerbGame verbGame1;
    VerbGame verbGame2;
    VerbGame verbGame3;
    VerbGame verbGame4;
    VerbGame verbGame5;
    VerbGame verbGameSkill;
    VerbGame verbGameIncorrect;

    VerbRegular mVerbRegular;

    int skillLevel1;
    int skillLevel2;
    int skillLevel3;
    int skillLevel4;

    private final static String REGULAR = "Regular";
    private final static String DEPONENT = "Deponent";
    private final static String SEMI_DEPONENT = "Semi Deponent";
    private final static String IRREGULAR = "Irregular";


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


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        verbGame1 = new VerbGame(databaseAccess, 1); // Verb Skill 1
        verbGame2 = new VerbGame(databaseAccess, 2);
        verbGame3 = new VerbGame(databaseAccess, 3);
        verbGame4 = new VerbGame(databaseAccess, 4);
        verbGame5 = new VerbGame(databaseAccess, 5);

        verbGameSkill = new VerbGame(databaseAccess, 1); // Verb Skill 1
        verbGameIncorrect = new VerbGame(databaseAccess,1);

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

            List<Integer> idList = verbGame1.getVerbIDs();
            list = verbGame1.getVerbQuestions(idList);
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
            List<Integer> idList = verbGame2.getVerbIDs();
            list = verbGame2.getVerbQuestions(idList);
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
            List<Integer> idList = verbGame3.getVerbIDs();
            list = verbGame3.getVerbQuestions(idList);
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
            List<Integer> idList = verbGame4.getVerbIDs();
            list = verbGame4.getVerbQuestions(idList);
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
            List<Integer> idList = verbGame5.getVerbIDs();
            list = verbGame5.getVerbQuestions(idList);
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


    // ---------------------------------VERB INCORRECT ---------------------------------------------

    /**
     * testRandomVerbIncorrectTable()
     * ------------------------------
     * Test for random selection of a verb_id from the IncorrectVerb Table.
     *
     * @throws Exception
     */
    @Test
    public void testRandomVerbIncorrectTable() throws Exception {

        int skillLevel = 5;
        int id1 = 1;
        Verb verb1 = databaseAccess.sqlVerbListQuery(id1);
        int id2 = 2;
        Verb verb2 = databaseAccess.sqlVerbListQuery(id2);
        int id3 = 8;
        Verb verb3 = databaseAccess.sqlVerbListQuery(id3);
        int id4 = 10;
        Verb verb4 = databaseAccess.sqlVerbListQuery(id4);

        int randomSims = 800;

        // load the table
        databaseAccess.sqlIncorrectVerb_Reset();
        databaseAccess.sqlIncorrectVerb_Insert(verb1);
        databaseAccess.sqlIncorrectVerb_Insert(verb2);
        databaseAccess.sqlIncorrectVerb_Insert(verb3);
        databaseAccess.sqlIncorrectVerb_Insert(verb4);
        int numVerbs = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE);


        int sample = randomSims / numVerbs;
        float toleranceFactor = 0.2f;
        int toleranceForSample = (int) (sample * toleranceFactor);


        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<randomSims; i++) {
            List<Integer> list = verbGame5.getIncorrectVerbIDs();
            int ans = list.get(0);
            if (!map.containsKey(ans))
                map.put(ans, 1);
            else
                map.put(ans, map.get(ans) + 1);

        }
        int x = 5;
        assertThat("Num verbId_1 Simulations", map.get(id1), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_1 Simulations", map.get(id1), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_2 Simulations", map.get(id2), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_2 Simulations", map.get(id2), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_3 Simulations", map.get(id3), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_3 Simulations", map.get(id3), lessThan(sample + toleranceForSample));

        assertThat("Num verbId_4 Simulations", map.get(id4), greaterThan(sample - toleranceForSample));
        assertThat("Num verbId_4 Simulations", map.get(id4), lessThan(sample + toleranceForSample));

    }



    @Test
    public void testAddToTheIncorrectVerbTable(){

        VerbGame.Answer ans1 = verbGameIncorrect.new Answer(1,1,1);
        VerbGame.Answer ans2 = verbGameIncorrect.new Answer(2,0,1);
        VerbGame.Answer ans8 = verbGameIncorrect.new Answer(8,0,1);
        VerbGame.Answer ans10 = verbGameIncorrect.new Answer(10,1,1);

        List<VerbGame.Answer> answerList = new ArrayList<>();
        answerList.add(ans1);
        answerList.add(ans2);
        answerList.add(ans8);
        answerList.add(ans10);

        databaseAccess.sqlIncorrectVerb_Reset();
        int count = verbGameIncorrect.addToTheIncorrectVerbTable(answerList);

        assertEquals(2, count);

    }

    /**
     * testUpdateSkillLevel()
     * ----------------------
     * Test that skill level can be changed after IRT update
     */
    @Test
    public void testUpdateSkillLevel(){

        List<VerbGame.Answer> answerList = new ArrayList<>();

        VerbGame.Answer ans1 = verbGameSkill.new Answer(1,1,1);
        VerbGame.Answer ans2 = verbGameSkill.new Answer(2,1,1);
        VerbGame.Answer ans3 = verbGameSkill.new Answer(3,1,1);
        VerbGame.Answer ans4 = verbGameSkill.new Answer(4,1,1);
        VerbGame.Answer ans5 = verbGameSkill.new Answer(5,1,1);
        VerbGame.Answer ans6 = verbGameSkill.new Answer(6,1,1);
        VerbGame.Answer ans7 = verbGameSkill.new Answer(7,1,1);
        VerbGame.Answer ans8 = verbGameSkill.new Answer(8,1,1);
        VerbGame.Answer ans9 = verbGameSkill.new Answer(9,1,1);
        VerbGame.Answer ans10 = verbGameSkill.new Answer(10,1,1);
        VerbGame.Answer ans11 = verbGameSkill.new Answer(11,1,1);
        VerbGame.Answer ans12 = verbGameSkill.new Answer(12,1,1);
        VerbGame.Answer ans13 = verbGameSkill.new Answer(13,1,1);
        VerbGame.Answer ans14 = verbGameSkill.new Answer(14,1,1);
        VerbGame.Answer ans15 = verbGameSkill.new Answer(15,1,1);
        VerbGame.Answer ans16 = verbGameSkill.new Answer(16,1,1);
        VerbGame.Answer ans17 = verbGameSkill.new Answer(17,1,1);
        VerbGame.Answer ans18 = verbGameSkill.new Answer(18,1,1);
        VerbGame.Answer ans19 = verbGameSkill.new Answer(19,1,1);
        VerbGame.Answer ans20 = verbGameSkill.new Answer(20,1,1);

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

        for(VerbGame.Answer ans : answerList){  // Change to All Wrong Marks
            ans.correct = 0;
        }

        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);

        assertEquals(1, newSkillLevel);  // ALL WRONG -> SKillLevel Down!

        for(int i=0; i<15; i++){    // 75% Correct
            VerbGame.Answer ans = answerList.get(i);
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

    @Test
    public void testRunVerbQuestion() throws Exception{

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

        verbGame1.runVerbQuestion();
        verbGame1.storeAnswer(0);

    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }

}
