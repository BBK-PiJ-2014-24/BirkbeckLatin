package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADJECTIVES THAT ARE RESTRICTED TO PLURAL MEANING, e.g. "FEW"
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective_RestrictPlurals {


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
        typePreposition = "Adjective";

        latin_Preposition = null;

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";

        nominative = "pauci";
        genitive = "";
        genitivePlural = "";
        latinNounStem = "pauc";
        nominativeAdjective = null;
        englishNounSingular = "few";
        englishNounPlural = "few";



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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("pauci", adjective.getLatinWord());
        assertEquals(caseNominative, adjective.getCase());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("os", adjective.getLatinWordEnding());
        assertEquals("paucos", adjective.getLatinWord());
        assertEquals(caseAccusative, adjective.getCase());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("paucorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("pauci", adjective.getLatinWord());
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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("pauci", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("os", adjective.getLatinWordEnding());
        assertEquals("paucos", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("paucorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("pauci", adjective.getLatinWord());
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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("paucae", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("as", adjective.getLatinWordEnding());
        assertEquals("paucas", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("arum", adjective.getLatinWordEnding());
        assertEquals("paucarum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("paucae", adjective.getLatinWord());
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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("paucae", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("as", adjective.getLatinWordEnding());
        assertEquals("paucas", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("arum", adjective.getLatinWordEnding());
        assertEquals("paucarum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("ae", adjective.getLatinWordEnding());
        assertEquals("paucae", adjective.getLatinWord());
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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("paucorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());
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

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("orum", adjective.getLatinWordEnding());
        assertEquals("paucorum", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("paucis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("pauc", adjective.getLatinWordStem());
        assertEquals("a", adjective.getLatinWordEnding());
        assertEquals("pauca", adjective.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishWordPlural();
        assertEquals("few", adjective.getEnglishWordSingular() );
        assertEquals("few", adjective.getEnglishWordPlural() );

        adjective.makeEnglishWord(databaseAccess, numberSingular);
        assertEquals("few", adjective.getEnglishWord());

        adjective.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("few", adjective.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
