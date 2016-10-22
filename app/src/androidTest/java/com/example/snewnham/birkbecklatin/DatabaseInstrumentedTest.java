package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.example.snewnham.birkbecklatin.Model.DbSchema.VerbListTable.*;
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



    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

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
    }

    @Test
    public void testDBAccess2() throws Exception {
        String table = VERB_LIST_TABLE;
        String[] column = null;
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{"2"};


        Cursor cursor = databaseAccess.sqlQuery(table, column, whereClause, whereArgs  );
        cursor.moveToFirst();
        String answer = cursor.getString(cursor.getColumnIndex(Cols.LATIN_INFINITIVE));
        cursor.close();

        assertEquals("monere", answer);
    }


    /**
     * testDatabaseToVerb()
     * -------------------
     * Tests whether we can convert from VerbList db table to Verb object
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
        String latin_Infinitive_Stem = "mone";
        String latin_Infinitive_StemMod = "monea";
        String latin_Perfect_Stem = "monu";
        String latin_Participle_Stem = "monit";

        String english_Infinitive = "warn, advise";    // English
        String english_Present_3rdPerson = "warns, advises";
        String english_Perfect = "warned, advised";
        String english_Participle = "warning, advising";

        // Run Query
        // ---------
        Verb verb = databaseAccess.sqlVerbQuery(id);


        // test the Verb Fields
        // --------------------
        assertEquals( id, verb.getId());
        assertEquals( latin_Type, verb.getLatin_Type() );
        assertEquals( latin_ConjNum, verb.getLatin_ConjNum());

        assertEquals( latin_Present, verb.getLatin_Present() );   // Priciple Parts
        assertEquals( latin_Infinitive, verb.getLatin_Infinitive() );
        assertEquals( latin_Perfect, verb.getLatin_Perfect() );
        assertEquals( latin_Participle, verb.getLatin_Participle() );

        assertEquals( latin_Present_Stem, verb.getLatin_Present_Stem() );    // Stems
        assertEquals( latin_Infinitive_Stem, verb.getLatin_Infinitive_Stem() );
        assertEquals( latin_Infinitive_StemMod, verb.getLatin_Infinitive_StemMod() );
        assertEquals( latin_Perfect_Stem, verb.getLatin_Perfect_Stem() );
        assertEquals( latin_Participle_Stem, verb.getLatin_Participle_Stem() );

        assertEquals( english_Infinitive, verb.getEnglish_Infinitive() );     // English
        assertEquals( english_Present_3rdPerson, verb.getEnglish_Present_3rdPerson() );
        assertEquals( english_Perfect, verb.getEnglish_Perfect() );
        assertEquals( english_Participle, verb.getEnglish_Participle() );

    }

    /**
     * testLatinVerbStem()
     * ===================
     * Test sqlVerbStemQuery to select the correct stem for a latin verb
     */
    @Test
    public void testLatinVerbStem() {

        String ans1 = "Present";

        String stem1 = databaseAccess.sqlVerbStemQuery(numberSingular, moodIndicative,
                                                voiceActive, tensePresent);
        assertEquals(ans1, stem1);

        String ans2 = "Infinitive_Stem";

        String stem2 = databaseAccess.sqlVerbStemQuery(numberSingular, moodImperative,
                                               voiceActive, tenseNull);
        assertEquals(ans2, stem2);
    }


    /**
     * testLatinVerbEnding()
     * ==========================
     * Test sqlVerbConjugationQuery to select the correct ENDING for a latin verb
     */
    @Test
    public void testLatinVerbEnding() {

        String conj1 = "eramus";

        String latinEnding1 = databaseAccess.sqlVerbEndingQuery(person1, numberPlural,
                                            moodIndicative, voiceActive, tensePluperfect, conjNum1);
        assertEquals(conj1, latinEnding1);


        String id2 = "100";    // TEST INFINITIVE

        String conj2 = null;

        String latinEnding2 = databaseAccess.sqlVerbEndingQuery(person2, numberInfinitive,
                                        moodIndicative, voiceActive, tensePresent, conjNull);
        assertEquals(conj2, latinEnding2);


        String id3 = "100";    // TEST IMPERATIVE

        String conj3 = null;

        String latinEnding3 = databaseAccess.sqlVerbEndingQuery(personNull, numberSingular,
                            moodImperative, voiceActive, tenseNull, conjNull);
        assertEquals(conj3, latinEnding3);

    }


    /**
     * testEnglishAuxiliaryVerbTable()
     * ===============================
     * Test testEnglishAuxiliaryVerbTable to select the correct English Auxiliary Verb.
     */
    @Test
    public void testEnglishAuxiliaryVerbTable() {

        String ans = " would have ";

        String engAuxVerb = databaseAccess.sqlEngAuxVerbQuery(person2, numberSingular,
                                moodSubjunctive, voiceActive, tensePluperfect);
        assertEquals(ans, engAuxVerb );
    }

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
     * testEnglishVerbEndingTable()
     * =============================
     * Test testEnglish_Verb_Table to select the English Verb with the correct Ending
     */
    @Test
    public void testEnglishVerbEndingTable() {

        String ans = "English_Infinitive";

        String guessEngVerbEnding = databaseAccess.sqlEngVerbEnding(numberSingular, tensePresent,
                            moodIndicative, voiceActive);
        assertEquals(ans, guessEngVerbEnding );

    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }




}
