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
     * testDatabaseToVerb
     * --------
     * Tests whether we can convert from VerbList db table to Verb object
     * @throws Exception
     */

    @Test
    public void testDatabaseToVerb() throws Exception {
        int mId = 2;
        int mLatin_ConjNum = 2;
        String mLatin_Present = "moneo";
        String mLatin_Infinitive = "monere";
        String mLatin_Participle = "monitus";
        String mLatin_Present_Stem = "monui";
        String mLatin_Infinitive_Stem = "mon";
        String mLatin_Infinitive_StemMod = "monea";
        String mLatin_Perfect_Stem = "monu";
        String mLatin_Participle_Stem = "monit";
        String mEnglish_Infinitive = "warn/advise";
        String mEnglish_Present_3rdPerson = "warns/advises";
        String mEnglish_Perfect = "warned/advised";
        String mEnglish_Participle = "warning/advising";


        Verb verb = databaseAccess.sqlVerbQuery( int id );
        assertEquals( mId, verb.getId);
        assertEquals( mLatin_Present, verb.getLatin_Present() );
        assertEquals( mLatin_Infinitive, verb.getLatin_Infinitive() );
        assertEquals( mLatin_Participle, verb.getLatin_Participle() );
        assertEquals( mLatin_Present_Stem, verb.getLatin_Participle() );
        assertEquals( mLatin_Infinitive_Stem, verb.getLatin_Infinitive_Stem() );
        assertEquals( mLatin_Infinitive_StemMod, verb.getLatin_Infinitive_StemMod() );
        assertEquals( mLatin_Perfect_Stem, verb.getLatin_Perfect_Stem() );
        assertEquals( mLatin_Participle_Stem, verb.getLatin_Participle_Stem() );
        assertEquals( mEnglish_Infinitive, verb.getEnglish_Infinitive() );
        assertEquals( mEnglish_Present_3rdPerson, verb.getEnglish_Present_3rdPerson() );
        assertEquals( mEnglish_Perfect, verb.getEnglish_Perfect() );
        assertEquals( mEnglish_Participle, verb.getEnglish_Participle() );


    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }




}
