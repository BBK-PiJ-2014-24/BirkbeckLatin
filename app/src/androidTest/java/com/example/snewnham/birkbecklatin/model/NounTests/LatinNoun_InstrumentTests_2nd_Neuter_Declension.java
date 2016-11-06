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
public class LatinNoun_InstrumentTests_2nd_Neuter_Declension {


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


        id = 2;
        typeNoun = "Noun";
        pronoun = "Pronoun";

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

        nominative = "bellum";
        genitive = "belli";
        genitivePlural = null;
        latinNounStem = "bell";
        englishNoun = "war";

        mNounRegular = new NounRegular(id, databaseAccess);
            mNounRegular.setId(id);
            mNounRegular.setType(typeNoun);
            mNounRegular.setDeclension(declension2);  // SET DECLENSION
            mNounRegular.setGender(genderNeuter);    //  SET GENDER
            mNounRegular.setNominative(nominative);
            mNounRegular.setGenitive(genitive);
            mNounRegular.setGenitivePlural(genitivePlural);
            mNounRegular.setLatinNounStem(latinNounStem);
            mNounRegular.setEnglishNoun(englishNoun);
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

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("um", mNounRegular.getLatinNounEnding());
        assertEquals("bellum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("um", mNounRegular.getLatinNounEnding());
        assertEquals("bellum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("i", mNounRegular.getLatinNounEnding());
        assertEquals("belli", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("o", mNounRegular.getLatinNounEnding());
        assertEquals("bello", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("o", mNounRegular.getLatinNounEnding());
        assertEquals("bello", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("um", mNounRegular.getLatinNounEnding());
        assertEquals("bellum", mNounRegular.getLatinNoun());
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

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("a", mNounRegular.getLatinNounEnding());
        assertEquals("bella", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("a", mNounRegular.getLatinNounEnding());
        assertEquals("bella", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("orum", mNounRegular.getLatinNounEnding());
        assertEquals("bellorum", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("is", mNounRegular.getLatinNounEnding());
        assertEquals("bellis", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("is", mNounRegular.getLatinNounEnding());
        assertEquals("bellis", mNounRegular.getLatinNoun());

        mNounRegular.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("bell", mNounRegular.getLatinNounStem());
        assertEquals("a", mNounRegular.getLatinNounEnding());
        assertEquals("bella", mNounRegular.getLatinNoun());
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
