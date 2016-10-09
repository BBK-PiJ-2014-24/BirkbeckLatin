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
public class ExampleInstrumentedTest {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
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
        String latin_Infinitive_Stem = "moner";
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

        // test input + answers
        // --------------------
        String number1 = "Singular";
        String mood1 = "Indicative";
        String voice1 = "Active";
        String tense1 = "Present";
        String ans1 = "Present";

        String stem1 = databaseAccess.sqlVerbStemQuery(number1, mood1, voice1, tense1);
        assertEquals(ans1, stem1);


        String number2 = "Singular";
        String mood2 = "Imperative";
        String voice2 = "Active";
        String tense2 = "Imperative";
        String ans2 = "Present";

        String stem2 = databaseAccess.sqlVerbStemQuery(number2, mood2, voice2, tense2);
        assertEquals(ans2, stem2);
    }


    /**
     * testLatinVerbConjugation()
     * ==========================
     * Test sqlVerbConjugationQuery to select the correct ENDING for a latin verb
     */
    @Test
    public void testLatinVerbConjugation() {

        // test input + answers
        // --------------------
        String id1 = "100";
        String person1 = "1st";
        String number1 = "Plural";
        String mood1 = "Indicative";
        String voice1 = "Active";
        String tense1 = "Pluperfect";
        String conjnum1 = "1";
        String conj1 = "eramus";

        String latinEnding = databaseAccess.sqlVerbEndingQuery(person1, number1, mood1, voice1, tense1, conjnum1);
        assertEquals(conj1, latinEnding);
    }


    /**
     * testEnglishAuxiliaryVerbTable()
     * ===============================
     * Test testEnglishAuxiliaryVerbTable to select the correct English Auxiliary Verb.
     */
    @Test
    public void testEnglishAuxiliaryVerbTable() {

        // test input + answers
        // --------------------
        String id1 = "100";
        String person1 = "2nd";
        String number1 = "Singular";
        String mood1 = "Subjunctive";
        String voice1 = "Active";
        String tense1 = "Pluperfect";
        String ans = "would have";

        String engAuxVerb = databaseAccess.sqlEngAuxVerbQuery(person1, number1, mood1, voice1, tense1);
        assertEquals(ans, engAuxVerb );
    }



    @After
    public void breakDown() {
        databaseAccess.close();
    }




}
