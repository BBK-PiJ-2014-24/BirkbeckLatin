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
        String table = VERBTABLE;
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
        String table = VERBTABLE;
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
        int id = 2;
        int latin_ConjNum = 2;
        // test answers
        // ------------
        String latin_Present = "moneo";
        String latin_Infinitive = "monere";
        String latin_Perfect = "monui";
        String latin_Participle = "monitus";
        String latin_Present_Stem = "monui";
        String latin_Infinitive_Stem = "mon";
        String latin_Infinitive_StemMod = "monea";
        String latin_Perfect_Stem = "monu";
        String latin_Participle_Stem = "monit";
        String english_Infinitive = "warn/advise";
        String english_Present_3rdPerson = "warns/advises";
        String english_Perfect = "warned/advised";
        String english_Participle = "warning/advising";


        // test the Verb Fields
        // --------------------
        assertEquals( id, verb.getId());
        assertEquals( latin_ConjNum, verb.getLatin_ConjNum());
        assertEquals( latin_Present, verb.getLatin_Present() );
        assertEquals( latin_Infinitive, verb.getLatin_Infinitive() );
        assertEquals( latin_Perfect, verb.getLatin_Perfect() );
        assertEquals( latin_Participle, verb.getLatin_Participle() );
        assertEquals( latin_Present_Stem, verb.getLatin_Participle() );
        assertEquals( latin_Infinitive_Stem, verb.getLatin_Infinitive_Stem() );
        assertEquals( latin_Infinitive_StemMod, verb.getLatin_Infinitive_StemMod() );
        assertEquals( latin_Perfect_Stem, verb.getLatin_Perfect_Stem() );
        assertEquals( latin_Participle_Stem, verb.getLatin_Participle_Stem() );
        assertEquals( english_Infinitive, verb.getEnglish_Infinitive() );
        assertEquals( english_Present_3rdPerson, verb.getEnglish_Present_3rdPerson() );
        assertEquals( english_Perfect, verb.getEnglish_Perfect() );
        assertEquals( english_Participle, verb.getEnglish_Participle() );


    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }




}
