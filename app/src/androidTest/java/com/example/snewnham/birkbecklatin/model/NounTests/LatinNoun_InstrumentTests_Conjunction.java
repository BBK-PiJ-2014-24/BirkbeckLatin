package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
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
public class LatinNoun_InstrumentTests_Conjunction {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    Conjunction conjunction;

    String typeNoun;
    String typePreposition;
    String typeConjunction;
    String latin_Other;

    String englishNoun;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        typeNoun = "Noun";
        typePreposition = "Preposition";

        latin_Other = "tamen";
        englishNoun = "however";

        conjunction = new Conjunction(id, databaseAccess);
            conjunction.setId(id);
            conjunction.setType(typeConjunction);
            conjunction.setDeclension(0);  // SET DECLENSION
            conjunction.setGender(null);       // SET GENDER
            conjunction.setNominative(null);
            conjunction.setGenitive(null);
            conjunction.setGenitivePlural(null);
            conjunction.setLatinNounStem(null);
            conjunction.setLatin_Other(latin_Other);
            conjunction.setEnglishNoun(englishNoun);
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
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */

    @Test
    public void testMakeConjunction() throws Exception {

        conjunction.makeLatinNoun(databaseAccess, null, null);

        assertEquals(null, conjunction.getLatinNounStem());
        assertEquals(null, conjunction.getLatinNounEnding());
        assertEquals("tamen", conjunction.getLatinNoun());
    }

    /**
     * testEnglishPrespositionTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishConjunctionTranslation(){
        assertEquals("however", conjunction.getEnglishNoun() );
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
