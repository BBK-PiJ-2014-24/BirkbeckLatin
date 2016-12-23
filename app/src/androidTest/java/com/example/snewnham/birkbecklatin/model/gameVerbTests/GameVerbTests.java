package com.example.snewnham.birkbecklatin.model.gameVerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGame;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
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

    int id_Regular;  // id for Regular
    int id_Deponent;  // id for Deponent
    int id_SemiDeponent;  // id for Semi Deponent
    int id_Irregular; // id for Irregular

    VerbGame verbGame1;
    VerbGame verbGame2;
    VerbGame verbGame3;
    VerbGame verbGame4;
    VerbGame verbGame5;


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

            list = verbGame1.getVerbQuestions();
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
            list = verbGame2.getVerbQuestions();
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
            list = verbGame3.getVerbQuestions();
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
            list = verbGame4.getVerbQuestions();
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
            list = verbGame5.getVerbQuestions();
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

    @After
    public void breakDown() {
        databaseAccess.close();
    }

}
