package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;

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
public class LatinNoun_InstrumentTests_Preposition {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    Preposition preposition;

    String typeNoun;
    String typePreposition;
    String latinPresposition;

    String englishNoun;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        typeNoun = "NounEtc";
        typePreposition = "Preposition";

        latinPresposition = "circum";
        englishNoun = "around";

        preposition = new Preposition(id, databaseAccess);
            preposition.setId(id);
            preposition.setType(typePreposition);
            preposition.setDeclension(0);  // SET DECLENSION
            preposition.setLatinWordStem(null);
            preposition.setLatinWordEnding(null);
            preposition.setLatinWord(latinPresposition);
            preposition.setEnglishWordSingular(englishNoun);

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
    public void testMakePreposition() throws Exception {

        preposition.makeLatinWord(databaseAccess, null, null);

        assertEquals(null, preposition.getLatinWordStem());
        assertEquals(null, preposition.getLatinWordEnding());
        assertEquals("circum", preposition.getLatinWord());
        assertEquals("", preposition.getCase());

    }

    /**
     * testEnglishPrespositionTranslation()
     * -------------------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishPrepositionTranslation(){
        assertEquals("around", preposition.getEnglishWordSingular() );

        preposition.makeEnglishWord(databaseAccess, "Plural");
        assertEquals("around", preposition.getEnglishWord());
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
