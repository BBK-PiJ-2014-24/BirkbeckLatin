package com.example.snewnham.birkbecklatin.model.databaseTests;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.example.snewnham.birkbecklatin.Model.database.DbSchema.VerbListTable.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
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

        assertEquals(10, answer);
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
        assertEquals( incorrect, verbRegular.getIncorrect() );

    }


    @Test
    public void testGetVerbIDList() throws Exception{

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

        databaseAccess.sqlIncorrectVerb_Reset(Cols.INCORRECT);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id1, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id1, 0);
        boolean testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id1, 0);
        boolean testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id1, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);


        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id2, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id2, 0);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id2, 1);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id2, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id3, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id3, 1);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id3, 0);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id3, 1);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id4, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id4, 1);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id4, 1);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id4, 1);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id5, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id5, 0);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id5, 0);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id5, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id6, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id6, 0);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id6, 1);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id6, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id7, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id7, 1);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id7, 0);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id7, 1);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id8, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id8, 0);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id8, 1);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id8, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id9, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id9, 1);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id9, 0);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id9, 1);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id10, 0);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id10, 0);
        testINCORRECT = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id10, 0);
        testANSWER = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id10, 0);
        assertTrue(testINCORRECT);
        assertTrue(testANSWER);

        List<Integer> list;

        list = databaseAccess.getVerbIDList(conjNum1_2,0,true);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_2,1,true);
        assertThat(list, hasItems(2));


        list = databaseAccess.getVerbIDList(conjNum1_2,0,false);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_2,1,false);
        assertThat(list, hasItems(2));


        list = databaseAccess.getVerbIDList(conjNum1_4,0,true);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_4,1,true);
        assertThat(list, hasItems(2,6));


        list = databaseAccess.getVerbIDList(conjNum1_4,0,false);
        assertThat(list, hasItems(1,5,10));
        list = databaseAccess.getVerbIDList(conjNum1_4,1,false);
        assertThat(list, hasItems(2,6,8));

        databaseAccess.sqlIncorrectVerb_Reset(Cols.INCORRECT);
        databaseAccess.sqlIncorrectVerb_Reset(Cols.ASKED);

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


        // TEST IMPERATIVE
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


        // TEST IMPERATIVE
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

        // TEST IMPERATIVE
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

        databaseAccess.sqlIncorrectVerb_Reset(Cols.INCORRECT);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id1, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id2, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id3, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.INCORRECT, id4, 1); // for test of duplication

        boolean testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id1, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id2, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id3, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id4, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1

        verb1.setIncorrect(1);  // YOU MUST UPDATE THE VERB OBJECT MANUALLY
        verb2.setIncorrect(1);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setIncorrect(1);
        verb4.setIncorrect(1);

        assertEquals(1, verb1.getIncorrect());  // Test retrieve a Incorrect = 1 given the verbid
        assertEquals(1, verb2.getIncorrect());
        assertEquals(1, verb3.getIncorrect());
        assertEquals(1, verb4.getIncorrect());

        databaseAccess.sqlIncorrectVerb_Reset(Cols.INCORRECT);

        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id1, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id2, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id3, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.INCORRECT, id4, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0

        verb1.setIncorrect(0);  // YOU MUST SET THE VERB OBJECT MANUALLY
        verb2.setIncorrect(0);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setIncorrect(0);
        verb4.setIncorrect(0);

        assertEquals(0, verb1.getIncorrect());  // Test retrieve a Incorrect = 0 given the verbid
        assertEquals(0, verb2.getIncorrect());
        assertEquals(0, verb3.getIncorrect());
        assertEquals(0, verb4.getIncorrect());
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

        databaseAccess.sqlIncorrectVerb_Reset(Cols.ASKED);

        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id1, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id2, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id3, 1);
        databaseAccess.sqlIncorrectVerb_Insert(Cols.ASKED, id4, 1); // for test of duplication

        boolean testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id1, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id2, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id3, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id4, 1);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 1

        verb1.setAsked(1);  // YOU MUST UPDATE THE VERB OBJECT MANUALLY
        verb2.setAsked(1);  // SO THAT IT IS CONSISTENT WITH DATABASE
        verb3.setAsked(1);
        verb4.setAsked(1);

        assertEquals(1, verb1.getAsked());  // Test retrieve a Incorrect = 1 given the verbid
        assertEquals(1, verb2.getAsked());
        assertEquals(1, verb3.getAsked());
        assertEquals(1, verb4.getAsked());

        databaseAccess.sqlIncorrectVerb_Reset(Cols.ASKED);

        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id1, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id2, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id3, 0);
        assertTrue(testInsertionTrue);  // Test Entry Insertion for Incorrect = 0
        testInsertionTrue = databaseAccess.sqlIncorrectVerb_TestInsertion(Cols.ASKED, id4, 0);
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

        // TEST IMPERATIVE
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

        Verb verb1 = databaseAccess.sqlVerbListQuery(1);
        Verb verb2 = databaseAccess.sqlVerbListQuery(5);
        Verb verb3 = databaseAccess.sqlVerbListQuery(7);

        List<Verb> verbList = new ArrayList<>();
        verbList.add(verb1);
        verbList.add(verb2);
        verbList.add(verb3);

        List<Verb> verbListQuery = databaseAccess.getVerbConjugationList(Integer.parseInt(conjNum1));

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
        noun_Type = "Noun";
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
        NounRegular noun = databaseAccess.sqlNounListQuery(noun_id);

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
     * testNounIrregularQuery()
     * ------------------------
     * test a sql query for an irregular noun, Possessives, Pronouns etc.
     */
    @Test
    public void testNounIrregularQuery() throws Exception{

        String nounIrregular = "hic";
        noun_Gender = "m";
        noun_number = "Singular";
        noun_Latin_Case = "Accusative";

        // Run Query
        // ---------
        String query = databaseAccess.sqlNounIrregularQuery(nounIrregular, noun_Gender, noun_number, noun_Latin_Case);

        assertEquals("hunc", query);
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
        adjectiveId = 2;
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

        prepositionId = 10;
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

        conjunctionId = 3;
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
     * testAdverbListQuery()
     * --------------------------
     * test the sql query on Adverb_List table.
     */
    @Test
    public void testAdverbListQuery(){

        adverbId = 1;
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
     * testIncorrectLatinNounTable() - Tests general access to the IncorrectLatinNounEtc Table
     * =============================
     * Test sqlIncorrectNounEtcTable - add, delete, retrieve, reset, testInsertion
     */
    @Test
    public void testIncorrectLatinNoun(){

        String noun = "NOUN";
        String irregularNoun = "IRREGULAR_NOUN";
        String adjective = "ADJECTIVE";
        String conjunction = "CONJUNCTION";
        String preposition = "PREPOSITION";

        int nounId1 = 10;
        int nounId2 = 20;
        int nounId3 = 30;
        int nounId4 = 40;


        databaseAccess.sqlIncorrectNounEtc_Reset();

        int originalSize = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);

        databaseAccess.sqlIncorrectNounEtc_Insert(noun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId3);
        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId3);  // test for duplication

        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun, nounId3);
        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun, nounId3);  // test for duplication

        boolean testInsertionTrue = databaseAccess.sqlIncorrectNounEtc_TestInsertion(noun, nounId3);
        assertTrue(testInsertionTrue);  // Test Entry Insertion in Table - TRUE
        boolean testInsertionFalse = databaseAccess.sqlIncorrectNounEtc_TestInsertion(noun, nounId4);
        assertFalse(testInsertionFalse);  // Test Entry Insertion in Table - FALSE


        int newSize = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
        assertEquals(6, newSize - originalSize);  // Test the size of table has increased by 6.


        int nounId = databaseAccess.sqlIncorrectNounEtc_GetId(3);
        assertEquals(nounId3, nounId);  // Test retrieve a verbId given the id (of the table)
        String nounType = databaseAccess.sqlIncorrectNounEtc_GetType(3);
        assertEquals(noun, nounType);  // Test retrieve a verbId given the id (of the table)

        int nounNull = databaseAccess.sqlIncorrectNounEtc_GetId(100);
        assertEquals(-1, nounNull);  // Test for a NULL retrieve for a id NOT in the table

        databaseAccess.sqlIncorrectNounEtc_Delete(noun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Delete(noun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Delete(noun, nounId3);
        databaseAccess.sqlIncorrectNounEtc_Delete(noun, nounId3);  // test for duplication

        databaseAccess.sqlIncorrectNounEtc_Delete(irregularNoun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Delete(irregularNoun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Delete(irregularNoun, nounId3);
        databaseAccess.sqlIncorrectNounEtc_Delete(irregularNoun, nounId3);  // test for duplication

        int postDeleteSize = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
        assertEquals(originalSize, postDeleteSize); // Test delete a verbId given the id

        databaseAccess.sqlIncorrectNounEtc_Insert(noun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Insert(noun, nounId3);

        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun ,nounId1);
        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun, nounId2);
        databaseAccess.sqlIncorrectNounEtc_Insert(irregularNoun, nounId3);

        int ReinsertionSize = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
        assertEquals(6, ReinsertionSize - postDeleteSize);  // RETEST the size of table has increased by 3.

        databaseAccess.sqlIncorrectNounEtc_Reset();
        int postResetSize = databaseAccess.sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
        assertEquals(0, postResetSize); // Test RESET has cleared all records.

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

        int size = databaseAccess.sqlTableCountQuery(DbSchema.Meta_Table.META_TABLE);

        assertEquals(2, size);  // Check Insertion

        int valueGuess = databaseAccess.sqlMetaQuery(key);

        assertEquals(value, valueGuess);

    }






    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
