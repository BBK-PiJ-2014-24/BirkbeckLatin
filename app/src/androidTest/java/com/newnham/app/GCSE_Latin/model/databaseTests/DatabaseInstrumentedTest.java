package com.newnham.app.GCSE_Latin.model.databaseTests;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.database.DbSchema;
import com.newnham.app.GCSE_Latin.Model.nouns.Adjective;
import com.newnham.app.GCSE_Latin.Model.nouns.Adverb;
import com.newnham.app.GCSE_Latin.Model.nouns.Conjunction;
import com.newnham.app.GCSE_Latin.Model.nouns.NounEtc;
import com.newnham.app.GCSE_Latin.Model.nouns.NounRegular;
import com.newnham.app.GCSE_Latin.Model.nouns.Preposition;
import com.newnham.app.GCSE_Latin.Model.verbs.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLENSION1;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENDER_FEMALE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOMINATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_IRREGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_REGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_SKILL_LEVEL;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_THETA;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NUMBER_SINGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PREPOSITION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TRANSLATION_DIRECTION;
import static com.newnham.app.GCSE_Latin.Model.database.DbSchema.VerbListTable.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseInstrumentedTest {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

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

    int noun_id;
    String noun_Type;
    int noun_Declension;
    String noun_Gender;
    String noun_Nominative;
    String noun_Geninitive;
    String noun_Geninitive_Plural;
    String noun_Latin_Noun_Stem;
    String noun_Latin_Preposition;
    String noun_Latin_Nominative_Adjective;
    String noun_English_Noun_Singular;
    String noun_English_Noun_Plural;
    String noun_number;
    String noun_Latin_Case;

    int adjectiveId;
    String adjectiveType;
    int adjectiveDeclension;
    String adjectiveNominative;
    String adjectiveNominativeNeuter;
    String adjectiveLatinAdjectiveStem;
    String adjectiveEnglishAdjective;
    String adjectiveLatinComparative;
    String adjectiveEnglishComparative;
    String adjectiveLatinSuperlative;
    String adjectiveEnglishSuperlative;

    int prepositionId;
    String prepositionLatin;
    String prepositionEnglish;

    int conjunctionId;
    String conjunctionLatin;
    String conjunctionEnglish;

    int adverbId;
    int adverbDeclension;
    String adverbLatinAdverb;
    String adverbLatinAdverbStem;
    String adverbEnglishAdverb;
    String adverbEnglishComparative;
    String adverbEnglishSuperlative;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        // VERB FIELDS
        // -----------
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
     * testDBAccess()
     * --------------
     * Test General database access to various Tables with basic sql queries
     * @throws Exception
     */
    @Test
    public void testDBAccess() throws Exception {
        String table = VERB_LIST_TABLE;
        String[] column = new String[]{Cols.LATIN_INFINITIVE};
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{"2"};

        Cursor cursor = databaseAccess.sqlQuery(table, column, whereClause, whereArgs  );
        cursor.moveToFirst();
        String ans = cursor.getString(0);
        assertEquals("monere", ans);

        String table1 = "Noun_Declension";
        String[] column1 = new String[]{"Gender"};
        String whereClause1 = "_id=?";
        String[] whereArgs1 = new String[]{"2"};

        Cursor cursor1 = databaseAccess.sqlQuery(table1, column1, whereClause1, whereArgs1  );
        cursor1.moveToFirst();
        String ans1 = cursor1.getString(0);
        assertEquals("f", ans1);

        String table2 = DbSchema.NounDeclensionTable.NOUN_DECLENSION_TABLE;
        String[] column2 = new String[]{DbSchema.NounDeclensionTable.Cols.CASE};
        String whereClause2 = "_id=?";
        String[] whereArgs2 = new String[]{"2"};

        Cursor cursor2 = databaseAccess.sqlQuery(table2, column2, whereClause2, whereArgs2  );
        cursor2.moveToFirst();
        String ans2 = cursor2.getString(0);
        assertEquals("Accusative", ans2);

        String table3 = DbSchema.AdverbListTable.ADVERB_TABLE;
        String[] column3 = new String[]{DbSchema.AdverbListTable.Cols._id};
        String whereClause3 = "_id=?";
        String[] whereArgs3 = new String[]{"2"};

        Cursor cursor3 = databaseAccess.sqlQuery(table3, column3, whereClause3, whereArgs3  );
        cursor3.moveToFirst();
        String ans3 = cursor3.getString(0);
        assertEquals("2", ans3);

    }


    /**
     * Test to determine the size of any particular table
     * @throws Exception
     */
    @Test
    public void testTableSize() throws Exception {

        String table = VERB_LIST_TABLE;

        int answer = databaseAccess.sqlTableCountQuery(table);

        assertEquals(198, answer);
    }


    // --------------------------------- VERBS ------------------------------------------
    /**
     * testSqlVerbTypeQuery()
     * ----------------------
     * Test sqlVerbTypeQuery() which can detect the Type of Verb given _id in Verb_List
     * @throws Exception
     */
    @Test
    public void testSqlVerbTypeQuery() throws Exception {

        int id7 = 7;
        int id8 = 8;
        int id9 = 9;
        int id10 = 10;

        String regular = "Regular";
        String deponent = "Deponent";
        String semideponent = "Semi Deponent";
        String irregular = "Irregular";

        String ans7 = databaseAccess.sqlVerbTypeQuery(id7);
        String ans8 = databaseAccess.sqlVerbTypeQuery(id8);
        String ans9 = databaseAccess.sqlVerbTypeQuery(id9);
        String ans10 = databaseAccess.sqlVerbTypeQuery(id10);

        assertEquals("test Regular Type", regular, ans7);
        assertEquals("test Deponent Type", deponent, ans8);
        assertEquals("test Semi Deponent Type", semideponent, ans9);
        assertEquals("test Irregular Type", irregular, ans10);
    }


    /**
     * testGetVerbIDConjugationList()
     * ------------------------------
     * Tests the list from getVerbIDConjugationList() containing Verb IDs of just Conj 1+2 and the Esse Verb.
     * This is Used for Selecting Verbs for Skill Level 1 in the Verb Game.
     * TEST USES HAMCREST
     * @throws Exception
     */
    @Test
    public void testGetVerbIDConjugationList() throws Exception {
        List<Integer> list = databaseAccess.getVerbIDConjugationList(2);
        assertThat(1, isIn(list));
        assertThat(2, isIn(list));
        assertThat(10, isIn(list));
       // assertThat(list, containsInAnyOrder(1,2,10));
    }


    /**
     * testDatabaseToVerb()
     * -------------------
     * Tests whether we can convert from VerbListCursor db table to VerbRegular object
     * @throws Exception
     */

    @Test
    public void testDatabaseToVerb() throws Exception {

        // test answers
        // ------------
        int id = 2;
        String latin_Type = "Regular";
        int latin_ConjNum = 2;

        String latin_Present = "moneo";        // Participle Parts
        String latin_Infinitive = "monere";
        String latin_Perfect = "monui";
        String latin_Participle = "monitus";

        String latin_Present_Stem = "mon";     // Stems
        String latin_Present_SubjuncStem = "monea";
        String latin_Infinitive_Stem = "mone";
        String latin_Infinitive_PassiveStem = "moner";
        String latin_Perfect_Stem = "monu";
        String latin_Participle_Stem = "monit";

        String english_Infinitive = "warn, advise";    // English
        String english_Present_3rdPerson = "warns, advises";
        String english_Perfect = "warned, advised";
        String english_Participle = "warning, advising";

        int answer = 0;
        int incorrect = 0;

        // Run Query
        // ---------
        Verb verbRegular = databaseAccess.sqlVerbListQuery(id);


        // test the VerbRegular Fields
        // --------------------
        assertEquals( id, verbRegular.getId() );
        assertEquals( latin_Type, verbRegular.getLatin_Type() );
        assertEquals( latin_ConjNum, verbRegular.getLatin_ConjNum());

        assertEquals( latin_Present, verbRegular.getLatin_Present() );   // Priciple Parts
        assertEquals( latin_Infinitive, verbRegular.getLatin_Infinitive() );
        assertEquals( latin_Perfect, verbRegular.getLatin_Perfect() );
        assertEquals( latin_Participle, verbRegular.getLatin_Participle() );

        assertEquals( latin_Present_Stem, verbRegular.getLatin_Present_Stem() );    // Stems
        assertEquals( latin_Present_SubjuncStem, verbRegular.getLatin_Present_SubjuncStem() );
        assertEquals( latin_Infinitive_Stem, verbRegular.getLatin_Infinitive_Stem() );
        assertEquals( latin_Infinitive_PassiveStem, verbRegular.getLatin_Infinitive_PassiveStem() );
        assertEquals( latin_Perfect_Stem, verbRegular.getLatin_Perfect_Stem() );
        assertEquals( latin_Participle_Stem, verbRegular.getLatin_Participle_Stem() );

        assertEquals( english_Infinitive, verbRegular.getEnglish_Infinitive() );     // English
        assertEquals( english_Present_3rdPerson, verbRegular.getEnglish_Present_3rdPerson() );
        assertEquals( english_Perfect, verbRegular.getEnglish_Perfect() );
        assertEquals( english_Participle, verbRegular.getEnglish_Participle() );

        assertEquals( answer, verbRegular.getAsked());
        assertEquals( incorrect, verbRegular.getCorrect() );

    }

    /**
     * testVerbListInsertion_Resets()
     * ------------------------------
     * Tests Insertions, Resets for CORRECT and ASKED Fields in
     * the Verb_List Table
     *
     * @throws Exception
     */
    @Test
    public void testVerbListInsertion_Resets() throws Exception{

        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        int id4 = 4;
        int id5 = 5;
        int id6 = 6;
        int id7 = 7;
        int id8 = 8;
        int id9 = 9;
        int id10 = 10;

        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        databaseAccess.sqlVerbList_Reset(Cols.CORRECT);

        databaseAccess.sqlVerbList_Insert(id1, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id1, Cols.CORRECT, 1);
        boolean testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.ASKED, 0);
        boolean testASKED = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);


        databaseAccess.sqlVerbList_Insert(id2, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id2, Cols.CORRECT, 0);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.ASKED, 0);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.CORRECT, 0);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id3, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id3, Cols.CORRECT, 1);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.ASKED, 1);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id4, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id4, Cols.CORRECT, 0);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.ASKED, 1);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.CORRECT, 0);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id5, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id5, Cols.CORRECT, 1);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id5, Cols.ASKED, 0);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id5, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id6, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id6, Cols.CORRECT, 0);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id6, Cols.ASKED, 0);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id6, Cols.CORRECT, 0);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id7, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id7, Cols.CORRECT, 1);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id7, Cols.ASKED, 1);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id7, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id8, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id8, Cols.CORRECT, 0);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id8, Cols.ASKED, 0);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id8, Cols.CORRECT, 0);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id9, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id9, Cols.CORRECT, 1);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id9, Cols.ASKED, 1);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id9, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        databaseAccess.sqlVerbList_Insert(id10, Cols.ASKED, 0);
        databaseAccess.sqlVerbList_Insert(id10, Cols.CORRECT, 1);
        testCORRECT = databaseAccess.sqlVerbList_TestInsertion(id10, Cols.ASKED, 0);
        testASKED = databaseAccess.sqlVerbList_TestInsertion(id10, Cols.CORRECT, 1);
        assertTrue(testCORRECT);
        assertTrue(testASKED);

        List<Integer> list;

        list = databaseAccess.getVerbIDList(conjNum1_2,1,true);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_2,0,true);
        assertThat(list, hasItems(2));


        list = databaseAccess.getVerbIDList(conjNum1_2,1,false);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_2,0,false);
        assertThat(list, hasItems(2));


        list = databaseAccess.getVerbIDList(conjNum1_4,1,true);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_4,0,true);
        assertThat(list, hasItems(2,6));


        list = databaseAccess.getVerbIDList(conjNum1_4,1,false);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_4,0,false);
        assertThat(list, hasItems(2,6,8));


        databaseAccess.sqlVerbList_AskedReset(1); // Reset ASKED Fields WHERE Corrects = 1
        list = databaseAccess.getVerbIDList(conjNum1_4, 1, false);
        assertThat(list, hasItems(1,3,5,7,9,10));

        databaseAccess.sqlVerbList_Reset(Cols.CORRECT);
        databaseAccess.sqlVerbList_Reset(Cols.ASKED);

    }


    /**
     * testAskedReset()
     * ----------------
     * Test to determine that sqlVerbList_AskedReset() resets ASKED = 0 for either
     * WHERE CORRECT = 0 or = 1
     *
     * @throws Exception
     */
    @Test
    public void testAskedReset() throws Exception{

        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        int id4 = 4;
        int id5 = 5;
        int id6 = 6;
        int id7 = 7;
        int id8 = 8;
        int id9 = 9;
        int id10 = 10;

        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);

        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id5, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id6, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id7, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id8, DbSchema.VerbListTable.Cols.CORRECT, 0);

        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id9, DbSchema.VerbListTable.Cols.CORRECT, 1);

        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id10, DbSchema.VerbListTable.Cols.CORRECT, 1);


        List<Integer> listCorrect = databaseAccess.getVerbIDList(conjNum1_4, 1, false);  // Correct List
        int countCorrect = listCorrect.size();
        List<Integer> listIncorrect = databaseAccess.getVerbIDList(conjNum1_4, 0, false); // IncorrectList
        int countIncorrect = listIncorrect.size();

        databaseAccess.sqlVerbList_AskedReset(1);  // Reset Asked=0, WHERE CORRECT = 1
        databaseAccess.sqlVerbList_AskedReset(0);  // Reset Asked=0, WHERE CORRECT = 0

        listCorrect = databaseAccess.getVerbIDList(conjNum1_4, 1, false);  // Correct List
        countCorrect = listCorrect.size();
        listIncorrect = databaseAccess.getVerbIDList(conjNum1_4, 0, false); // IncorrectList
        countIncorrect = listIncorrect.size();

        assertThat(countCorrect, greaterThan(1));
        assertThat(countIncorrect, greaterThan(1));

    }



    /**
     * testLatinVerbStem()
     * ===================
     * Test sqlVerbStemQuery to select the correct stem for a latin verbSemiDeponent
     */
    @Test
    public void testLatinVerbStem() {

        String stem1 = databaseAccess.sqlVerbStemQuery(numberSingular, moodIndicative,
                                                voiceActive, tensePresent);
        String ans1 = "Present";
        assertEquals(ans1, stem1);


        // TEST MOOD_IMPERATIVE
        String stem2 = databaseAccess.sqlVerbStemQuery(numberSingular, moodImperative,
                                               voiceActive, tenseNull);
        String ans2 = "Infinitive_Stem";
        assertEquals(ans2, stem2);
    }


    /**
     * testLatinVerbEnding()
     * ==========================
     * Test sqlVerbConjugationQuery to select the correct ENDING for a latin verbSemiDeponent
     */
    @Test
    public void testLatinVerbEnding() {

        String conj1 = "eramus";

        String latinEnding1 = databaseAccess.sqlVerbEndingQuery(person1, numberPlural,
                                            moodIndicative, voiceActive, tensePluperfect, conjNum1);
        assertEquals(conj1, latinEnding1);


        // TEST INFINITIVE
        String latinEnding2 = databaseAccess.sqlVerbEndingQuery(person2, numberInfinitive,
                                        moodIndicative, voiceActive, tensePresent, conjNull);
        String conj2 = null;

        assertEquals(conj2, latinEnding2);


        // TEST MOOD_IMPERATIVE
        String latinEnding3 = databaseAccess.sqlVerbEndingQuery(personNull, numberSingular,
                            moodImperative, voiceActive, tenseNull, conjNull);
        String conj3 = null;

        assertEquals(conj3, latinEnding3);

    }


    /**
     * testLatinIrregularVerb()
     * =======================
     * test sql query for IrregularVerb
     */
    @Test
    public void testLatinIrregularVerb(){

        String irregularVerb = "esse";

        String query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, person2, numberSingular,
                                                    moodIndicative, voiceActive, tensePerfect);
        assertEquals("fuisti", query);


        // TEST INFINITIVE
        query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, personNull, numberInfinitive,
                                                    moodIndicative, voiceActive, tensePerfect);
        assertEquals("fuisse", query);

        // TEST MOOD_IMPERATIVE
        query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, personNull, numberPlural,
                moodImperative, voiceActive, tensePerfect);
        assertEquals("este", query);

    }

    /**
     * testIncorrectLatinVerbTable() - Tests access to the Incorrect FIELD - Insert, Reset
     * =============================
     *
     */
    @Test
    public void testIncorrectLatinVerb(){

        int id1 = 1;
        Verb verb1 = databaseAccess.sqlVerbListQuery(id1);
        int id2 = 2;
        Verb verb2 = databaseAccess.sqlVerbListQuery(id2);
        int id3 = 8;
        Verb verb3 = databaseAccess.sqlVerbListQuery(id3);
        int id4 = 10;
        Verb verb4 = databaseAccess.sqlVerbListQuery(id4);

        databaseAccess.sqlVerbList_Reset(Cols.CORRECT);

        databaseAccess.sqlVerbList_Insert(id1, Cols.CORRECT, 0);
        databaseAccess.sqlVerbList_Insert(id2, Cols.CORRECT, 0);
        databaseAccess.sqlVerbList_Insert(id3, Cols.CORRECT, 0);
        databaseAccess.sqlVerbList_Insert(id4, Cols.CORRECT, 0); // for test of duplication

        boolean testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.CORRECT, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.CORRECT, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.CORRECT, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.CORRECT, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1

        verb1.setCorrect(0);  // YOU MUST UPDATE THE VERB OBJECT MANUALLY
        verb2.setCorrect(0);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setCorrect(0);
        verb4.setCorrect(0);

        assertEquals(0, verb1.getCorrect());  // Test retrieve a Incorrect = 1 given the verbid
        assertEquals(0, verb2.getCorrect());
        assertEquals(0, verb3.getCorrect());
        assertEquals(0, verb4.getCorrect());

        databaseAccess.sqlVerbList_Reset(Cols.CORRECT);

        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.CORRECT, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.CORRECT, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.CORRECT, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.CORRECT, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1

        verb1.setCorrect(1);  // YOU MUST SET THE VERB OBJECT MANUALLY
        verb2.setCorrect(1);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setCorrect(1);
        verb4.setCorrect(1);

        assertEquals(1, verb1.getCorrect());  // Test retrieve a Incorrect = 0 given the verbid
        assertEquals(1, verb2.getCorrect());
        assertEquals(1, verb3.getCorrect());
        assertEquals(1, verb4.getCorrect());
    }

    /**
     * testAskedLatinVerb() - Tests access to the ASKED FIELD - Insert, Reset
     * ====================
     * Test sqlIncorrectVerbTable
     */
    @Test
    public void testAskedLatinVerb(){

        int id1 = 1;
        Verb verb1 = databaseAccess.sqlVerbListQuery(id1);
        int id2 = 2;
        Verb verb2 = databaseAccess.sqlVerbListQuery(id2);
        int id3 = 8;
        Verb verb3 = databaseAccess.sqlVerbListQuery(id3);
        int id4 = 10;
        Verb verb4 = databaseAccess.sqlVerbListQuery(id4);

        databaseAccess.sqlVerbList_Reset(Cols.ASKED);

        databaseAccess.sqlVerbList_Insert(id1, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id2, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id3, Cols.ASKED, 1);
        databaseAccess.sqlVerbList_Insert(id4, Cols.ASKED, 1); // for test of duplication

        boolean testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.ASKED, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.ASKED, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.ASKED, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.ASKED, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1

        verb1.setAsked(1);  // YOU MUST UPDATE THE VERB OBJECT MANUALLY
        verb2.setAsked(1);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setAsked(1);
        verb4.setAsked(1);

        assertEquals(1, verb1.getAsked());  // Test retrieve a Incorrect = 1 given the verbid
        assertEquals(1, verb2.getAsked());
        assertEquals(1, verb3.getAsked());
        assertEquals(1, verb4.getAsked());

        databaseAccess.sqlVerbList_Reset(Cols.ASKED);

        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id1, Cols.ASKED, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id2, Cols.ASKED, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id3, Cols.ASKED, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlVerbList_TestInsertion(id4, Cols.ASKED, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0

        verb1.setAsked(0);  // YOU MUST SET THE VERB OBJECT MANUALLY
        verb2.setAsked(0);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setAsked(0);
        verb4.setAsked(0);

        assertEquals(0, verb1.getAsked());  // Test retrieve a Incorrect = 0 given the verbid
        assertEquals(0, verb2.getAsked());
        assertEquals(0, verb3.getAsked());
        assertEquals(0, verb4.getAsked());
    }

    // =================== ENGLISH VERB TESTS ==================================================

    /**
     * testEnglishPersonTable()
     * ========================
     * Test testEnglishPersonTable to select the correct English Person.
     */
    @Test
    public void testEnglishPersonTable() {

        String ans = "he/she";

        String engPerson = databaseAccess.sqlEngPersonQuery(person3, numberSingular);
        assertEquals(ans, engPerson );
    }

    /**
     * testEnglishAuxiliaryVerbTable()
     * ===============================
     * Test testEnglishAuxiliaryVerbTable to select the correct English Auxiliary VerbRegular.
     */
    @Test
    public void testEnglishAuxiliaryVerbTable() {

        String engAuxVerb1 = databaseAccess.sqlEngAuxVerbQuery(person2, numberSingular,
                moodSubjunctive, voiceActive, tensePluperfect);

        String ans1 = " would have ";
        assertEquals(ans1, engAuxVerb1 );

        // TEST MOOD_IMPERATIVE
        String engAuxVerb2 = databaseAccess.sqlEngAuxVerbQuery(personNull, numberSingular,
                moodImperative, voicePassive, tenseNull);

        String ans2 = "be ";
        assertEquals(ans2, engAuxVerb2 );

    }


    /**
     * testEnglishVerbEndingTable()
     * =============================
     * Test testEnglish_Verb_Table to select the English VerbRegular with the correct Ending
     */
    @Test
    public void testEnglishVerbEndingTable() {

        String guessEngVerbEnding1 = databaseAccess.sqlEngVerbEnding(numberSingular, tensePresent,
                            moodIndicative, voiceActive);

        String ans1 = "English_Infinitive";
        assertEquals(ans1, guessEngVerbEnding1 );

        String guessEngVerbEnding2 = databaseAccess.sqlEngVerbEnding(numberPlural, tenseNull,
                moodImperative, voiceActive);

        String ans2 = "English_Infinitive";
        assertEquals(ans2, guessEngVerbEnding2 );
    }


    /**
     * testEnglishIrregularESSEVerb()
     * ============================
     * Test to select an Irregular English Verb, 'To Be / ESSE'
     */

    @Test
    public void testEnglishIrregularESSEVerb() {

        String irregularVerb = "esse";

        String guessEngIrregVerb = databaseAccess.sqlEnglishIrregularESSEVerb(irregularVerb, person3, numberSingular, tensePresent,
                                                                     moodIndicative, voiceActive);
        assertEquals("is", guessEngIrregVerb);

        // Infinitive
        guessEngIrregVerb = databaseAccess.sqlEnglishIrregularESSEVerb(irregularVerb, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive);
        assertEquals("be", guessEngIrregVerb);

    }


    /**
     * s.
     * @throws Exception
     */
    @Test
    public void testListOfVerbObjects() throws Exception {

        Verb verb1 = databaseAccess.sqlVerbListQuery(4);
        Verb verb2 = databaseAccess.sqlVerbListQuery(16);
        Verb verb3 = databaseAccess.sqlVerbListQuery(24);
        Verb verb4 = databaseAccess.sqlVerbListQuery(40);
        Verb verb5 = databaseAccess.sqlVerbListQuery(44);
        Verb verb6 = databaseAccess.sqlVerbListQuery(52);
        Verb verb7 = databaseAccess.sqlVerbListQuery(75);
        Verb verb8 = databaseAccess.sqlVerbListQuery(93);
        Verb verb9 = databaseAccess.sqlVerbListQuery(114);
        Verb verb10 = databaseAccess.sqlVerbListQuery(128);
        Verb verb11 = databaseAccess.sqlVerbListQuery(131);
        Verb verb12 = databaseAccess.sqlVerbListQuery(147);
        Verb verb13 = databaseAccess.sqlVerbListQuery(167);
        Verb verb14 = databaseAccess.sqlVerbListQuery(173);

        List<Verb> verbList = new ArrayList<>();
        verbList.add(verb1);
        verbList.add(verb2);
        verbList.add(verb3);
        verbList.add(verb4);
        verbList.add(verb5);
        verbList.add(verb6);
        verbList.add(verb7);
        verbList.add(verb8);
        verbList.add(verb9);
        verbList.add(verb10);
        verbList.add(verb11);
        verbList.add(verb12);
        verbList.add(verb13);
        verbList.add(verb14);

        List<Verb> verbListQuery = databaseAccess.getVerbConjugationList(Integer.parseInt(conjNum4));

        assertEquals(verbList.size(), verbListQuery.size());
        assertEquals(verbList.get(1).getId(), verbListQuery.get(1).getId());
    }


    // ============================== NOUN TESTS ==================================================


    /**
     * testNounList()
     * ==============
     * Test sql query on NounListTable using the NounListCursor.
     */
    @Test
    public void testNounList() {

        // NOUN FIELDS
        // -----------
        noun_id = 2;
        noun_Type = "NounRegular";
        noun_Declension = 2;
        noun_Gender = "m";
        noun_Nominative = "amicus";
        noun_Geninitive = "amici";
        noun_Geninitive_Plural = null;
        noun_Latin_Noun_Stem = "amic";
        noun_English_Noun_Singular = "friend";
        noun_English_Noun_Plural = "friends";

        // Run Query
        // ---------
        NounRegular noun = databaseAccess.sqlNounListQuery(NOUN_REGULAR, noun_id);

        // test the VerbRegular Fields
        // --------------------
        assertEquals( noun_id, noun.getId() );
        assertEquals( noun_Type, noun.getType() );
        assertEquals( noun_Declension, noun.getDeclension() );
        assertEquals( noun_Gender, noun.getGender() );
        assertEquals( noun_Nominative, noun.getNominative() );
        assertEquals( noun_Geninitive, noun.getGenitive() );
        assertEquals( noun_Geninitive_Plural, noun.getGenitivePlural() );
        assertEquals( noun_Latin_Noun_Stem, noun.getLatinWordStem() );
        assertEquals( noun_English_Noun_Singular, noun.getEnglishWordSingular() );
        assertEquals( noun_English_Noun_Plural, noun.getEnglishWordPlural() );
    }

    /**
     * testGetNounDeclensionList()
     * ---------------------------
     * Test getNounDeclensionList() can return a list of all NounEtc from any sublist
     * table.
     */
    @Test
    public void testGetNounDeclensionList(){

        List<NounEtc> nounList = databaseAccess.getNounDeclensionList( NOUN_REGULAR, 4);

        // Regular Nouns
        List<Integer> idList = new ArrayList<>();
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
        assertThat(idList, containsInAnyOrder(6,43,49,181,182));

        // Irregular Noun
        idList.removeAll(idList); // Reset idList
        nounList = databaseAccess.getNounDeclensionList(NOUN_IRREGULAR, 0);
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
         assertThat(idList, containsInAnyOrder(14,15,16,17,46,87,91,92,94,96,112,
                 113,114,126,133,137,164,167,211,212,213,214));

        // Preposition
        idList.removeAll(idList); // Reset idList
        nounList = databaseAccess.getNounDeclensionList(PREPOSITION, 0);
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
        assertThat(idList, containsInAnyOrder(1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,21,22,23,24));

        // Conjunction
        idList.removeAll(idList); // Reset idList
        nounList = databaseAccess.getNounDeclensionList(CONJUNCTION, 0);
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
        assertThat(idList, containsInAnyOrder(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,25,26,27,28,29,30,31,32,33,34,35,
                36,37,38,39,40,41,42,43,44,45,46,47,48,49));

        // Adjective
        idList.removeAll(idList); // Reset idList
        nounList = databaseAccess.getNounDeclensionList(ADJECTIVE, 0);
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
        assertThat(idList, containsInAnyOrder(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,
                36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,
                56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72));
        // Adverb
        idList.removeAll(idList); // Reset idList
        nounList = databaseAccess.getNounDeclensionList(ADVERB, 0);
        for(NounEtc nounEtc : nounList){
            idList.add(nounEtc.getId());
        }
        assertThat(idList, containsInAnyOrder(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,
                36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,
                56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,
                76,77,78,79,80,81,82,83,84));
    }


    /**
     * testSqlNounEndingQuery()
     * ------------------------
     * Tests the the correct Ending of Nouns
     *
     * @throws Exception
     */
    @Test
    public void testSqlNounEndingQuery() throws Exception {

        String ans1 = databaseAccess.sqlNounEndingQuery(Integer.toString(DECLENSION1), NUMBER_SINGULAR, GENDER_FEMALE, NOMINATIVE);
        assertEquals(ans1, "a");
    }



    /**
     * testNounIrregularQuery()
     * ------------------------
     * test a sql query for an irregular noun, Possessives, Pronouns etc.
     */
    @Test
    public void testNounIrregularQuery() throws Exception{

        String nounIrregular = "Hic";
        noun_Gender = "m";
        noun_number = "Singular";
        noun_Latin_Case = "Accusative";

        // Run Query
        // ---------
        String query = databaseAccess.sqlNounIrregularQuery(nounIrregular, noun_number, noun_Latin_Case, noun_Gender);

        assertEquals("hunc", query);
    }

    /**
     * testSqlNounTypeCount
     * --------------------
     * Test if sqlNounTypeCount() can count
     */
    public void testSqlNounTypeCount() {

        int countRegular = databaseAccess.sqlNounTypeCount(NOUN_REGULAR);
        assertEquals("NOUN_REGULAR", 12 , countRegular);

        int countIrregular = databaseAccess.sqlNounTypeCount(NOUN_IRREGULAR);
        assertEquals("NOUN_REGULAR", 1 , countIrregular);


    }


    /**
     * testAdjectivelist()
     * -------------------
     * TEST SQL Query on Adjective List Table
     * @throws Exception
     */
    @Test
    public void testAdjectiveList() throws Exception {

        // Adjective FIELDS
        // -----------
        adjectiveId = 27;
        adjectiveType = "Adjective";
        adjectiveDeclension = 212;
        adjectiveNominative = "longus";
        adjectiveNominativeNeuter = null;
        adjectiveLatinAdjectiveStem = "long";
        adjectiveEnglishAdjective = "long";
        adjectiveLatinComparative = "longior";
        adjectiveEnglishComparative = "longer";
        adjectiveLatinSuperlative = "longissim";
        adjectiveEnglishSuperlative = "longest";

        // Run Query
        // ---------
        Adjective adjective = databaseAccess.sqlAdjectiveListQuery(adjectiveId);

        assertEquals( adjectiveId, adjective.getId() );
        assertEquals( adjectiveType, adjective.getType() );
        assertEquals( adjectiveDeclension, adjective.getDeclension() );
        assertEquals( adjectiveNominative, adjective.getNominative() );
        assertEquals( adjectiveNominativeNeuter, adjective.getNominative_Neuter() );
        assertEquals( adjectiveLatinAdjectiveStem, adjective.getLatinAdjectiveStem() );
        assertEquals( adjectiveEnglishAdjective, adjective.getEnglishAdjective() );
        assertEquals( adjectiveLatinComparative, adjective.getLatinComparativeStem() );
        assertEquals( adjectiveEnglishComparative, adjective.getEnglishComparative() );
        assertEquals( adjectiveLatinSuperlative, adjective.getLatinSuperlativeStem() );
        assertEquals( adjectiveEnglishSuperlative, adjective.getEnglishSuperlative() );
    }



    /**
     * testAdjectiveEndingQuery()
     * --------------------------
     * test a sql query for an Adjective.
     */

    @Test
    public void testAdjectiveEndingQuery(){

        noun_Declension = 212;
        noun_Gender = "m";
        noun_number = "Singular";
        noun_Latin_Case = "Accusative";

        // Run Query
        // ---------

        String query = databaseAccess.sqlAdjectiveEnding(Integer.toString(noun_Declension), noun_Gender, noun_number, noun_Latin_Case);

        assertEquals("um", query);
    }


    /**
     * testPrepositionListQuery()
     * --------------------------
     * test the sql query on Preposition_List table.
     */
    @Test
    public void testPrepositionListQuery(){

        prepositionId = 22;
        prepositionLatin = "trans";
        prepositionEnglish = "across";

        // Run Query
        // ---------
        Preposition preposition = databaseAccess.sqlPrepositionListQuery(prepositionId);

        assertEquals(prepositionId, preposition.getId());
        assertEquals(prepositionLatin, preposition.getLatinWord());
        assertEquals(prepositionEnglish, preposition.getEnglishWordPlural());

    }


    /**
     * testConjunctionListQuery()
     * --------------------------
     * test the sql query on Conjunction_List table.
     */
    @Test
    public void testConjunctionListQuery(){

        conjunctionId = 20;
        conjunctionLatin = "tamen";
        conjunctionEnglish = "however";

        // Run Query
        // ---------
        Conjunction conjunction = databaseAccess.sqlConjunctionListQuery(conjunctionId);

        assertEquals(conjunctionId, conjunction.getId());
        assertEquals(conjunctionLatin, conjunction.getLatinWord());
        assertEquals(conjunctionEnglish, conjunction.getEnglishWordPlural());

    }


    /**
     * testAdverbQuery()
     * ----------------
     * test the sql query on Adverb_List table.
     */
    @Test
    public void testAdverbQuery(){

        adverbId = 40;
        adverbDeclension = 212;
        adverbLatinAdverb = "laete";
        adverbLatinAdverbStem = "laet";
        adverbEnglishAdverb = "happily";
        adverbEnglishComparative = "more happily";
        adverbEnglishSuperlative = "very happily";

        // Run Query
        // ---------
        Adverb adverb = databaseAccess.sqlAdverbListQuery(adverbId);

        assertEquals(adverbId, adverb.getId());
        assertEquals(adverbDeclension, adverb.getDeclension());
        assertEquals(adverbLatinAdverb, adverb.getLatinAdverb());
        assertEquals(adverbLatinAdverbStem, adverb.getLatinAdverbStem());
        assertEquals(adverbEnglishAdverb, adverb.getEnglishAdverb());
        assertEquals(adverbEnglishComparative, adverb.getEnglishAdverbComparative());
        assertEquals(adverbEnglishSuperlative, adverb.getEnglishAdverbSuperlative());
    }

    /**
     * testSqlAdverbStem()
     * Test if Adverb has a Stem.
     * @throws Exception
     */
    @Test
    public void testSqlAdverbStem() throws Exception{

        int id_Stem = 1;
        int id_NoStem = 3;
        boolean ans = databaseAccess.sqlAdverbCheckStem(id_Stem);
        assertTrue(ans);
        ans = databaseAccess.sqlAdverbCheckStem(id_NoStem);
        assertTrue(ans);
    }

    /**
     * testNounIDLists()
     * -----------------
     * Tests getNounEtcIDlist() in order to check that the correct lists
     * are drawn under given argument constraints.
     *
     * @throws Exception
     */
    @Test
    public void testNounIDLists() throws Exception {

        String nounTable = DbSchema.NounListTable.NOUN_LIST_TABLE;
        String askedField = DbSchema.NounListTable.Cols.ASKED;
        String correctField = DbSchema.NounListTable.Cols.CORRECT;

        // Reset ASKED and CORRECT
        databaseAccess.sqlNounEtcTable_Reset(nounTable, askedField);
        databaseAccess.sqlNounEtcTable_Reset(nounTable, correctField);

        List<Integer> list = null;
        // Full Access WHERE CORRECT = 1
        list = databaseAccess.getNounEtcIDlist(nounTable, 1, false);
        assertThat(list, hasItems(1,2,3,4,5,6,7,8,9,10,11,12,13));

        // Restricted Access WHERE CORRECT = 1
        list = databaseAccess.getNounEtcIDlist(nounTable, 1, true);
        assertThat(list, hasItems(1,2,3,4,5,8,9,10,11,12,13));

        // Test After Set ID=1 to ASKED = 1;
        databaseAccess.sqlNounEtcTable_Insert(nounTable, 1, askedField, 1);
        list = databaseAccess.getNounEtcIDlist(nounTable, 1, false);
        assertThat(list, hasItems(2,3,4,5,6,7,8,9,10,11,12,13));

        // Reset ASKED and CORRECT
        databaseAccess.sqlNounEtcTable_Reset(nounTable, askedField);
        databaseAccess.sqlNounEtcTable_Reset(nounTable, correctField);

    }


    /**
     * testNounEtcInsertions()
     * ======================
     * Tests general access to FIELD and ASKED Updates to All NounEtc Tables
     */
    @Test
    public void testNounEtcInsertions(){

        String nounTable = DbSchema.NounListTable.NOUN_LIST_TABLE;
        String adjectiveTable = DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE;
        String adverbTable = DbSchema.AdverbListTable.ADVERB_TABLE;
        String conjunctionTable = DbSchema.ConjunctionListTable.CONJUNCTION_TABLE;
        String prepositionTable = DbSchema.PrepositionListTable.PREPOSITION_TABLE;

        String ASKED_FIELD = "Asked";
        String CORRECT_FIELD = "Correct";

        int nounId1 = 1;
        int nounId2 = 2;
        int nounId3 = 3;
        int nounId4 = 4;

        boolean testInsertOfAsked;
        boolean testInsertOfCorrect;

        // Initial Reset
        databaseAccess.sqlNounEtcTable_Reset(nounTable, ASKED_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(nounTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adverbTable, ASKED_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adverbTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adjectiveTable, ASKED_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adjectiveTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(conjunctionTable, ASKED_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(conjunctionTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(prepositionTable, ASKED_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(prepositionTable, CORRECT_FIELD);

        // Test INSERT for id1 in each type of NounEtc Table

        databaseAccess.sqlNounEtcTable_Insert(nounTable, nounId1, ASKED_FIELD, 1);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(nounTable, nounId1, ASKED_FIELD, 1 );
        testInsertOfCorrect = databaseAccess.sqlNounEtcTable_TestInsertion(nounTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        assertTrue(testInsertOfCorrect);

        databaseAccess.sqlNounEtcTable_Insert(adverbTable, nounId1, ASKED_FIELD, 1);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adverbTable, nounId1, ASKED_FIELD, 1 );
        testInsertOfCorrect = databaseAccess.sqlNounEtcTable_TestInsertion(adverbTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        assertTrue(testInsertOfCorrect);

        databaseAccess.sqlNounEtcTable_Insert(adjectiveTable, nounId1, ASKED_FIELD, 1);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adjectiveTable, nounId1, ASKED_FIELD, 1 );
        testInsertOfCorrect = databaseAccess.sqlNounEtcTable_TestInsertion(adjectiveTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        assertTrue(testInsertOfCorrect);

        databaseAccess.sqlNounEtcTable_Insert(conjunctionTable, nounId1, ASKED_FIELD, 1);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(conjunctionTable, nounId1, ASKED_FIELD, 1 );
        testInsertOfCorrect = databaseAccess.sqlNounEtcTable_TestInsertion(conjunctionTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        assertTrue(testInsertOfCorrect);

        databaseAccess.sqlNounEtcTable_Insert(prepositionTable, nounId1, ASKED_FIELD, 1);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(prepositionTable, nounId1, ASKED_FIELD, 1 );
        testInsertOfCorrect = databaseAccess.sqlNounEtcTable_TestInsertion(prepositionTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        assertTrue(testInsertOfCorrect);


        // Reset ASKED = 0 for All CORRECT = 0;
        databaseAccess.sqlNounEtcTable_AskedReset(nounTable, 1);
        databaseAccess.sqlNounEtcTable_AskedReset(adjectiveTable, 1);
        databaseAccess.sqlNounEtcTable_AskedReset(adverbTable, 1);
        databaseAccess.sqlNounEtcTable_AskedReset(conjunctionTable, 1);
        databaseAccess.sqlNounEtcTable_AskedReset(prepositionTable, 1);

        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(nounTable, nounId1, ASKED_FIELD, 0 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adjectiveTable, nounId1, ASKED_FIELD, 0 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adverbTable, nounId1, ASKED_FIELD, 0 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(conjunctionTable, nounId1, ASKED_FIELD, 0 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(prepositionTable, nounId1, ASKED_FIELD, 0 );
        assertTrue(testInsertOfAsked);

        // General Reset for ALL CORRECT FIELDS
        databaseAccess.sqlNounEtcTable_Reset(nounTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adjectiveTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(adverbTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(conjunctionTable, CORRECT_FIELD);
        databaseAccess.sqlNounEtcTable_Reset(prepositionTable, CORRECT_FIELD);

        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(nounTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adjectiveTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(adverbTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(conjunctionTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
        testInsertOfAsked = databaseAccess.sqlNounEtcTable_TestInsertion(prepositionTable, nounId1, CORRECT_FIELD, 1 );
        assertTrue(testInsertOfAsked);
    }


    // ----------------------------- META TABLE --------------------------------------


    /**
     *  testSqlMeta()
     *  -------------
     *  tests inserts and query of the Meta Table.
     */
    @Test
    public void testSqlMeta(){

        String key = "Verb_Skill_Level";
        int value = 3;
        databaseAccess.sqlMeta_Insertion(key,value);

        int valueGuess = databaseAccess.sqlMetaQuery(key);
        assertEquals(value, valueGuess);

        value = 1;
        databaseAccess.sqlMeta_Insertion(key,value);
        valueGuess = databaseAccess.sqlMetaQuery(key);
        assertEquals(value, valueGuess);
    }

    /**
     * testSqlMeta_Reset()
     * -------------------
     * Tests sqlMeta_Reset() can reset rows in MetaTable to Default values
     */
    @Test
    public void testSqlMeta_Reset(){


        final String PRESENT_TALLY = "PresentTally";
        int value = 10;


        databaseAccess.sqlMeta_Reset();

        databaseAccess.sqlMeta_Insertion(PRESENT_TALLY, value);
        int ans = databaseAccess.sqlMetaQuery(PRESENT_TALLY);
        assertEquals(value, ans);

        databaseAccess.sqlMeta_Reset();

        ans = databaseAccess.sqlMetaQuery(PRESENT_TALLY);
        assertEquals(0, ans);

        ans = databaseAccess.sqlMetaQuery(NOUN_SKILL_LEVEL);
        assertEquals(1, ans);

        ans = databaseAccess.sqlMetaQuery(NOUN_THETA);
        assertEquals(-2, ans);

        ans = databaseAccess.sqlMetaQuery(TRANSLATION_DIRECTION);
        assertEquals(0, ans);

    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
