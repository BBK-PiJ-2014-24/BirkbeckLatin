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
public class LatinNoun_InstrumentTests_2nd_Male_Declension {


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
    String englishNoun;


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

        nominative = "amicus";
        genitive = "amici";
        genitivePlural = null;
        latinNounStem = "amic";
        englishNoun = "friend";

        mNounRegular = new NounRegular(id, databaseAccess);
            mNounRegular.setId(id);
            mNounRegular.setType(typeNoun);
            mNounRegular.setDeclension(declension2);
            mNounRegular.setGender(genderMale);
            mNounRegular.setNominative(nominative);
            mNounRegular.setGenitive(genitive);
            mNounRegular.setGenitivePlural(genitivePlural);
            mNounRegular.setLatinNounStem(latinNounStem);
            mNounRegular.setEnglishNounSingular(englishNoun);

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
    public void testMakeNoun_2nd_Declension_Male_Singular() throws Exception {

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("us", mNounRegular.getLatinNounEnding());
        assertEquals("amicus", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("um", mNounRegular.getLatinNounEnding());
        assertEquals("amicum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("i", mNounRegular.getLatinNounEnding());
        assertEquals("amici", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("o", mNounRegular.getLatinNounEnding());
        assertEquals("amico", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("o", mNounRegular.getLatinNounEnding());
        assertEquals("amico", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("e", mNounRegular.getLatinNounEnding());
        assertEquals("amice", mNounRegular.getLatinNoun());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNoun_2nd_Declension_Male_Plural()  - 2nd Declension, Male, Plural
     * ========================================
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */
    @Test
    public void testMakeNoun_2nd_Declension_Male_Plural() throws Exception {

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("i", mNounRegular.getLatinNounEnding());
        assertEquals("amici", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("os", mNounRegular.getLatinNounEnding());
        assertEquals("amicos", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("orum", mNounRegular.getLatinNounEnding());
        assertEquals("amicorum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("is", mNounRegular.getLatinNounEnding());
        assertEquals("amicis", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("is", mNounRegular.getLatinNounEnding());
        assertEquals("amicis", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("amic", mNounRegular.getLatinNounStem());
        assertEquals("i", mNounRegular.getLatinNounEnding());
        assertEquals("amici", mNounRegular.getLatinNoun());
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
