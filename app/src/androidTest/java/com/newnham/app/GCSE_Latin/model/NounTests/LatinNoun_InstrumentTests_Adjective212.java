package com.newnham.app.GCSE_Latin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.Adjective;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADJECTIVES FOR ALL 212 DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective212 {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    Adjective adjective;

    int declension212;

    String genderMale = "m";
    String genderFemale = "f";
    String genderNeuter = "n";

    String typeNoun;
    String typePreposition;
    String latin_Preposition;

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

    String nominativeAdjective;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        declension212 = 212;
        typeNoun = "NounEtc";
        typePreposition = "Preposition";

        latin_Preposition = null;

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";

        nominative = "bonus";
        genitive = "boni";
        genitivePlural = "bonorum";
        latinNounStem = "bon";
        nominativeAdjective = null;
        englishNounSingular = "good";
        englishNounPlural = "good";



        adjective = new Adjective(id, databaseAccess);
            adjective.setId(id);
            adjective.setType(typePreposition);
            adjective.setDeclension(declension212);  // SET DECLENSION
            adjective.setGender(genderMale);       // SET GENDER
            adjective.setNominative(nominative);
            adjective.setLatinAdjectiveStem(latinNounStem);
            adjective.setEnglishAdjective(englishNounPlural);
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    // ================================  SINGULAR, MALE  =============================================

    /** testGetGenitive()
     *  -----------------
     *  test the getter getGenitive().
     */
    @Test
    public void testGetGenitive(){
        String gen = adjective.getGenitive();
        assertEquals("Test Get Genitive", "", gen);
    }


    /**
     * testMakeAdjectiveSingular()  - Singular, Male
     * ==========================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularMale() throws Exception {

        adjective.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("us", adjective.getLatinWordEnding());
        assertEquals("bonus", adjective.getLatinWord());
        assertEquals(caseNominative, adjective.getCase());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("um", adjective.getLatinWordEnding());
        assertEquals("bonum", adjective.getLatinWord());
        assertEquals(caseAccusative, adjective.getCase());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("boni", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("o", adjective.getLatinWordEnding());
        assertEquals("bono", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("o", adjective.getLatinWordEnding());
        assertEquals("bono", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("us", adjective.getLatinWordEnding());
        assertEquals("bonus", adjective.getLatinWord());
    }


    // ==============================  PLURAL, MALE  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Male
     * =============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralMale() throws Exception {

        adjective.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("boni", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("os", adjective.getLatinWordEnding());
        assertEquals("bonos", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("bonorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("boni", adjective.getLatinWord());
    }


    // ================================  SINGULAR, FEMALE  =============================================

    /**
     * testMakeAdjectiveSingular()  - Singular, Female
     * ===============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularFemale() throws Exception {

        adjective.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjective.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("am", adjective.getLatinWordEnding());
        assertEquals("bonam", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("bonae", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("bonae", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());
    }


    // ==============================  PLURAL, FEMALE  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Female
     * =============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralFemale() throws Exception {

        adjective.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjective.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("bonae", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("as", adjective.getLatinWordEnding());
        assertEquals("bonas", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("arum", adjective.getLatinWordEnding());
        assertEquals("bonarum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("bonae", adjective.getLatinWord());
    }

    // ================================  SINGULAR, NEUTER  =============================================

    /**
     * testMakeAdjectiveSingular()  - Singular, Neuter
     * ===============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularNeuter() throws Exception {

        adjective.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjective.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("um", adjective.getLatinWordEnding());
        assertEquals("bonum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("um", adjective.getLatinWordEnding());
        assertEquals("bonum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("boni", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("o", adjective.getLatinWordEnding());
        assertEquals("bono", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("o", adjective.getLatinWordEnding());
        assertEquals("bono", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("um", adjective.getLatinWordEnding());
        assertEquals("bonum", adjective.getLatinWord());
    }


    // ==============================  PLURAL, NEUTER  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Neuter
     * =============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralNeuter() throws Exception {

        adjective.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjective.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("bonorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("bonis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("bon", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("bona", adjective.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishWordPlural();
        assertEquals("good", adjective.getEnglishWordSingular() );
        assertEquals("good", adjective.getEnglishWordPlural() );

        adjective.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("good", adjective.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
