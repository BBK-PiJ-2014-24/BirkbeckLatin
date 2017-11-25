package com.newnham.app.GCSE_Latin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.NounRegular;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN NOUNS WITH ONLY PLURAL MEANINGS e.g. Troops.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Plural_Restricted_Nouns {


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

        nominative = "copiae";
        genitive = "copiarum";
        latinNounStem = "copi";
        englishNoun = "forces, troops";

        mNounRegular = new NounRegular(id, databaseAccess);
            mNounRegular.setId(id);
            mNounRegular.setType(typeNoun);
            mNounRegular.setDeclension(declension1);  // SET DECLENSION
            mNounRegular.setGender(genderFemale);       // SET GENDER
            mNounRegular.setNominative(nominative);
            mNounRegular.setGenitive(genitive);
            mNounRegular.setLatinWordStem(latinNounStem);
            mNounRegular.setEnglishWordSingular(null);
            mNounRegular.setEnglishWordPlural(englishNoun);

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
    public void testMakeNoun_OnlyPlurals_Singular() throws Exception {

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("ae", mNounRegular.getLatinWordEnding());
        assertEquals("copiae", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("as", mNounRegular.getLatinWordEnding());
        assertEquals("copias", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("arum", mNounRegular.getLatinWordEnding());
        assertEquals("copiarum", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("copiis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("copiis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("ae", mNounRegular.getLatinWordEnding());
        assertEquals("copiae", mNounRegular.getLatinWord());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNoun_5th_Declension_Female_Plural()  - 5th Declension, Male, Plural
     * ========================================
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */
    @Test
    public void testMakeNoun_OnlyPlurals_Plural() throws Exception {

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("ae", mNounRegular.getLatinWordEnding());
        assertEquals("copiae", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("as", mNounRegular.getLatinWordEnding());
        assertEquals("copias", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("arum", mNounRegular.getLatinWordEnding());
        assertEquals("copiarum", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("copiis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("is", mNounRegular.getLatinWordEnding());
        assertEquals("copiis", mNounRegular.getLatinWord());

        mNounRegular.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("copi", mNounRegular.getLatinWordStem());
        assertEquals("ae", mNounRegular.getLatinWordEnding());
        assertEquals("copiae", mNounRegular.getLatinWord());
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
