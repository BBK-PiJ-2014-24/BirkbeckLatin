package com.newnham.app.GCSE_Latin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.Conjunction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN NOUNS FOR ALL DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Conjunction {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    Conjunction conjunction;
    String typeNoun;
    String latinConjunction;
    String englishNoun;




    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        typeNoun = "NounEtc";
        latinConjunction = "tamen";
        englishNoun = "however";

        conjunction = new Conjunction(id, databaseAccess);
            conjunction.setId(id);
            conjunction.setLatinWordStem(null);
            conjunction.setLatinWordEnding(null);
            conjunction.setLatinWord(latinConjunction);
            conjunction.setEnglishWordSingular(englishNoun);
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }


    // ================================  SINGULAR  =============================================

    /**
     * testMakeNoun_2nd_Declension_Male_Singular()  - 2nd Declension, Male, Singular
     * ===========================================
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */

    @Test
    public void testMakeConjunction() throws Exception {

        conjunction.makeLatinWord(databaseAccess, null, null);

        assertEquals(null, conjunction.getLatinWordStem());
        assertEquals(null, conjunction.getLatinWordEnding());
        assertEquals("tamen", conjunction.getLatinWord());
        assertEquals("", conjunction.getCase());
    }

    /**
     * testEnglishConjunctionTranslation()
     * -----------------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishConjunctionTranslation(){
        assertEquals("however", conjunction.getEnglishWordSingular() );

        conjunction.makeEnglishWord(databaseAccess, "Plural");
        assertEquals("however", conjunction.getEnglishWord());
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
