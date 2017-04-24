package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN NOUNS WITH ONLY SINGULAR MEANINGS e.g. Proper Nouns like Jupiter.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Singular_Restricted_Nouns {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    NounRegular mNounRegular;

    String typeNoun;
    String pronoun;

    String genderMale;
    String genderFemale;
    String genderNeuter;

    int declension1;
    int declension2;
    int declension3;
    int declension4;
    int declension5;

    String numberSingular;
    String numberPlural;

    String caseNominative;
    String caseAccusative;
    String caseGenitive;
    String caseDative;
    String caseAblative;
    String caseVocative;

    String nominative;
    String genitive;
    String genitivePlural;
    String latinNounStem;
    String englishNoun;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 1;
        typeNoun = "NounEtc";
        pronoun = "NounRegular";

        genderMale = "m";
        genderFemale = "f";
        genderNeuter = "n";

        declension1 = 1;
        declension2 = 2;
        declension3 = 3;
        declension4 = 4;
        declension5 = 5;

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";

        nominative = "Jupiter";
        genitive = "Jovis";
        latinNounStem = "Jov";
        englishNoun = "Jupiter";

        mNounRegular = new NounRegular(id, databaseAccess);
            mNounRegular.setId(id);
            mNounRegular.setType(typeNoun);
            mNounRegular.setDeclension(declension3);  // SET DECLENSION
            mNounRegular.setGender(genderMale);       // SET GENDER
            mNounRegular.setNominative(nominative);
            mNounRegular.setGenitive(genitive);
            mNounRegular.setLatinWordStem(latinNounStem);
            mNounRegular.setEnglishWordSingular(englishNoun);
            mNounRegular.setEnglishWordPlural(null);

    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }


    // ================================  SINGULAR  =============================================

    /**
     * testMakeNoun_5th_Declension_Male_Singular()  - 5th Declension, Male, Singular
     * ===========================================
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */

    @Test
    public void testMakeNoun_OnlySingular_Singular() throws Exception {

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("", mNounRegular.getLatinWordEnding());
        assertEquals("Jupiter", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("em", mNounRegular.getLatinWordEnding());
        assertEquals("Jovem", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("Jovis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("i", mNounRegular.getLatinWordEnding());
        assertEquals("Jovi", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("e", mNounRegular.getLatinWordEnding());
        assertEquals("Jove", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("", mNounRegular.getLatinWordEnding());
        assertEquals("Jupiter", mNounRegular.getLatinWord());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNoun_5th_Declension_Female_Plural()  - 5th Declension, Male, Plural
     * ========================================
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */
    @Test
    public void testMakeNoun_OnlySingular_Plural() throws Exception {

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("", mNounRegular.getLatinWordEnding());
        assertEquals("Jupiter", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("em", mNounRegular.getLatinWordEnding());
        assertEquals("Jovem", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("Jovis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("i", mNounRegular.getLatinWordEnding());
        assertEquals("Jovi", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("e", mNounRegular.getLatinWordEnding());
        assertEquals("Jove", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("Jov", mNounRegular.getLatinWordStem());
        assertEquals("", mNounRegular.getLatinWordEnding());
        assertEquals("Jupiter", mNounRegular.getLatinWord());
    }

    @Test
    public void testEnglishWords() throws Exception {

        mNounRegular.makeEnglishWord(databaseAccess, numberSingular);
        assertEquals(englishNoun, mNounRegular.getEnglishWord());

        mNounRegular.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals(englishNoun, mNounRegular.getEnglishWord());

    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
