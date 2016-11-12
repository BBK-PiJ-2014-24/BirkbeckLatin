package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.NounIrregular;
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
    NounIrregular nounIrregular;

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
    String englishNounPlural;


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

        nominative = "hic";
        genitive = null;
        genitivePlural = null;
        latinNounStem = null;
        englishNounSingular = "this";
        englishNounPlural = "these";

        nounIrregular = new NounIrregular(id, databaseAccess);
            nounIrregular.setId(id);
            nounIrregular.setType(typeNoun);
            nounIrregular.setDeclension(declension1);  // SET DECLENSION
            nounIrregular.setGender(genderMale);       // SET GENDER
            nounIrregular.setNominative(nominative);
            nounIrregular.setGenitive(genitive);
            nounIrregular.setGenitivePlural(genitivePlural);
            nounIrregular.setLatinNounStem(latinNounStem);
            nounIrregular.setEnglishNounSingular(englishNounSingular);
            nounIrregular.setEnglishNounPlural(englishNounPlural);
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }


    // ================================  SINGULAR  =============================================

    /**
     * testMakeNounIrregularSingular()
     * ===============================
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */

    @Test
    public void testMakeNounIrregularSingular() throws Exception {

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("hic", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("hunc", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("huius", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("huic", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("hoc", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals(null, nounIrregular.getLatinNoun());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNounIrregularPlural()  - Plural
     * =============================
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */
    @Test
    public void testMakeNounIrregularPlural() throws Exception {

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("hi", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("hos", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("horum", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("his", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals("his", nounIrregular.getLatinNoun());

        nounIrregular.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, nounIrregular.getLatinNounStem());
        assertEquals(null, nounIrregular.getLatinNounEnding());
        assertEquals(null, nounIrregular.getLatinNoun());
    }

    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        assertEquals("this", nounIrregular.getEnglishNounSingular() );
        assertEquals("these", nounIrregular.getEnglishNounPlural() );
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
