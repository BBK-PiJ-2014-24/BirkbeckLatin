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
 * TESTS FOR CREATING LATIN NOUNS FOR ALL DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Irregular {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    NounRegular mNounRegular;

    String typeNoun;
    String pronoun;

    String genderMale = "m";
    String genderFemale = "f";

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
    String englishNounSingular;
    String getEnglishNounPlural;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        typeNoun = "Noun";
        pronoun = "Pronoun";

        genderMale = "m";
        genderFemale = "f";

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

        nominative = null;
        genitive = null;
        genitivePlural = null;
        latinNounStem = null;
        englishNounSingular = "this";
        getEnglishNounPlural = "these";

        mNounRegular = new NounRegular(id, databaseAccess);
            mNounRegular.setId(id);
            mNounRegular.setType(typeNoun);
            mNounRegular.setDeclension(declension1);  // SET DECLENSION
            mNounRegular.setGender(genderFemale);       // SET GENDER
            mNounRegular.setNominative(nominative);
            mNounRegular.setGenitive(genitive);
            mNounRegular.setGenitivePlural(genitivePlural);
            mNounRegular.setLatinNounStem(latinNounStem);
            mNounRegular.setEnglishNounSingular(englishNounSingular);
            mNounRegular.setEnglishNounSingular(getEnglishNounPlural);
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
    public void testMakeNoun_1st_Declension_Fem_Singular() throws Exception {

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("hic", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("hunc", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("huius", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("huic", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("hoc", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals(null, mNounRegular.getLatinNoun());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNoun_2nd_Declension_Male_Plural()  - 2nd Declension, Male, Plural
     * ========================================
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */
    @Test
    public void testMakeNoun_1st_Declension_Fem_Plural() throws Exception {

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("hi", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("hos", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("horum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("his", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals("his", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, mNounRegular.getLatinNounStem());
        assertEquals(null, mNounRegular.getLatinNounEnding());
        assertEquals(null, mNounRegular.getLatinNoun());
    }

    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishNounTranslation(){
        assertEquals("this", mNounRegular.getEnglishNounSingular() );
        assertEquals("these", mNounRegular.getEnglishNounPlural() );
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
