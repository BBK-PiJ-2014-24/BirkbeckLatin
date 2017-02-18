package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADVERBS FOR ALL 212 DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adverb {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    String gender;
    int declension;
    String latinAdverbStem;
    String latinAdverb;
    String englishAdverb;
    String englishAdverbComparative;
    String englishAdverbSuperlative;
    Adverb adverb;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        int id = 1;
        gender = "m";
        declension = 212;
        latinAdverbStem = "laet";
        latinAdverb = "laete";
        englishAdverb = "happily";
        englishAdverbComparative = "more happily";
        englishAdverbSuperlative = "very happily";

        adverb = new Adverb(id, databaseAccess);
            adverb.setId(id);
            adverb.setGender(gender);
            adverb.setLatinAdverbStem(latinAdverbStem);  // SET DECLENSION
            adverb.setLatinAdverb(latinAdverb);       // SET GENDER
            adverb.setEnglishAdverb(englishAdverb);
            adverb.setEnglishAdverbComparative(englishAdverbComparative);
            adverb.setEnglishAdverbSuperlative(englishAdverbSuperlative);
    }
    
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    // ================================  SINGULAR, MALE  =============================================

    /**
     * testMakeAdverbSingular()
     * ========================
     * test Adverb Class that It Can build Correct Latin Adverb.
     * @throws Exception
     */

    @Test
    public void testMakeAdverbSingularMale() throws Exception {

        adverb.makeLatinWord(databaseAccess, null, null);

        assertEquals("laet", adverb.getLatinWordStem());
        assertEquals("laete", adverb.getLatinWord());
        assertEquals("", adverb.getCase());
    }


    /**
     * testEnglishAdverbTranslation()
     * ----------------------------
     * Test to get the English Adverb
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        adverb.makeEnglishWord(databaseAccess, null);
        String s = adverb.getEnglishWordPlural();
        assertEquals("happily", adverb.getEnglishWordSingular() );
        assertEquals("happily", adverb.getEnglishWordPlural() );

        adverb.makeEnglishWord(databaseAccess, "Plural");
        assertEquals("happily", adverb.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
