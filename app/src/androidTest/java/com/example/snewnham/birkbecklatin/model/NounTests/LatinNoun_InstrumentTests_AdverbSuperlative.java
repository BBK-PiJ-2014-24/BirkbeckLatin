package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbComparative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbSuperlative;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADVERBS FOR ALL GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_AdverbSuperlative {


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
    String latinAdverbEnding;
    AdverbSuperlative adverbSuperlative;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        int id = 1;
        gender = "m";
        declension = 212;
        latinAdverbStem = "laet";
        latinAdverbEnding = "issime";
        latinAdverb = "laete";
        englishAdverb = "happily";
        englishAdverbComparative = "very happily";
        englishAdverbSuperlative = "very happily";
        
        adverbSuperlative = new AdverbSuperlative(id, databaseAccess);
            adverbSuperlative.setId(id);
            adverbSuperlative.setDeclension(declension);
            adverbSuperlative.setGender(gender);
            adverbSuperlative.setLatinWordStem(latinAdverbStem);
            adverbSuperlative.setLatinWordEnding(latinAdverbEnding);
            adverbSuperlative.setLatinAdverb(latinAdverb);
            adverbSuperlative.setEnglishAdverb(englishAdverb);
            adverbSuperlative.setEnglishAdverbComparative(englishAdverbComparative);
            adverbSuperlative.setEnglishAdverbSuperlative(englishAdverbSuperlative);
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    // ================================  SINGULAR, MALE  =============================================

    /**
     * testMakeAdverbComparative()
     * ========================
     * test Adverb Class that It Can build Correct Latin Adverb.
     * @throws Exception
     */

    @Test
    public void testMakeAdverbSuperlative() throws Exception {

        adverbSuperlative.makeLatinWord(databaseAccess, null, null);

        assertEquals("laet", adverbSuperlative.getLatinWordStem());
        assertEquals("issime", adverbSuperlative.getLatinWordEnding());
        assertEquals("laetissime", adverbSuperlative.getLatinWord());
        assertEquals("", adverbSuperlative.getCase());
    }


    /**
     * testEnglishAdverbComparative()
     * ----------------------------
     * Test to get the English Adverb
     */
    @Test
    public void testEnglishSuperlativeTranslation() throws Exception{

        adverbSuperlative.makeEnglishWord(databaseAccess, null);

        String s = adverbSuperlative.getEnglishWordPlural();
        assertEquals("very happily", adverbSuperlative.getEnglishWordSingular() );
        assertEquals("very happily", adverbSuperlative.getEnglishWordPlural() );

        assertEquals("very happily", adverbSuperlative.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
