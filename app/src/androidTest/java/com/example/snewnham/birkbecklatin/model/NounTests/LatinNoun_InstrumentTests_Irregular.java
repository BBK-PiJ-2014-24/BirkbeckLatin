package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.NounIrregular;

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
        typeNoun = "NounEtc";
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
            nounIrregular.setLatinWordStem(latinNounStem);
            nounIrregular.setEnglishWordSingular(englishNounSingular);
            nounIrregular.setEnglishWordPlural(englishNounPlural);
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
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */

    @Test
    public void testMakeNounIrregularSingular() throws Exception {

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("hic", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("hunc", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("huius", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("huic", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("hoc", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals(null, nounIrregular.getLatinWord());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNounIrregularPlural()  - Plural
     * =============================
     * test NounEtc Class that It Can build Correct Latin NounEtc.
     * @throws Exception
     */
    @Test
    public void testMakeNounIrregularPlural() throws Exception {

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("hi", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("hos", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("horum", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("his", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals("his", nounIrregular.getLatinWord());

        nounIrregular.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, nounIrregular.getLatinWordStem());
        assertEquals(null, nounIrregular.getLatinWordEnding());
        assertEquals(null, nounIrregular.getLatinWord());
    }

    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        assertEquals("this", nounIrregular.getEnglishWordSingular() );
        assertEquals("these", nounIrregular.getEnglishWordPlural() );

        nounIrregular.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("these", nounIrregular.getEnglishWord());
    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
