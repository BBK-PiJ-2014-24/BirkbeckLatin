package com.newnham.app.GCSE_Latin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.AdverbComparative;

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
public class LatinNoun_InstrumentTests_AdverbComparative {


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
    AdverbComparative adverbComparative;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        int id = 1;
        gender = "m";
        declension = 212;
        latinAdverbStem = "laet";
        latinAdverbEnding = "ius";
        latinAdverb = "laete";
        englishAdverb = "happily";
        englishAdverbComparative = "more happily";
        englishAdverbSuperlative = "very happily";
        
        adverbComparative = new AdverbComparative(id, databaseAccess);
            adverbComparative.setId(id);
            adverbComparative.setDeclension(declension);
            adverbComparative.setGender(gender);
            adverbComparative.setLatinWordStem(latinAdverbStem);
            adverbComparative.setLatinWordEnding(latinAdverbEnding);
            adverbComparative.setLatinAdverb(latinAdverb);
            adverbComparative.setEnglishAdverb(englishAdverb);
            adverbComparative.setEnglishAdverbComparative(englishAdverbComparative);
            adverbComparative.setEnglishAdverbSuperlative(englishAdverbSuperlative);
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
    public void testMakeAdverbComparative() throws Exception {

        adverbComparative.makeLatinWord(databaseAccess, null, null);

        assertEquals("laet", adverbComparative.getLatinWordStem());
        assertEquals("ius", adverbComparative.getLatinWordEnding());
        assertEquals("laetius", adverbComparative.getLatinWord());
        assertEquals("", adverbComparative.getCase());

    }

    /**
     * testEnglishAdverbComparative()
     * ----------------------------
     * Test to get the English Adverb
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{

        adverbComparative.makeEnglishWord(databaseAccess, "Plural");
        String s = adverbComparative.getEnglishWordPlural();

        assertEquals("more happily", adverbComparative.getEnglishWordSingular() );
        assertEquals("more happily", adverbComparative.getEnglishWordPlural() );

        adverbComparative.makeEnglishWord(databaseAccess, "Plural");
        assertEquals("more happily", adverbComparative.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
