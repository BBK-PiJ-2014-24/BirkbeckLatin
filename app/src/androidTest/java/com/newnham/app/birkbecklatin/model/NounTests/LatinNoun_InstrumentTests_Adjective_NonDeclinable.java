package com.newnham.app.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.nouns.Adjective;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADJECTIVES WHICH ARE NON-DECLINABLE
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective_NonDeclinable {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    Adjective adjective;

    int declension0;

    String genderMale = "m";
    String genderFemale = "f";
    String genderNeuter = "n";

    String typeNoun;
    String typeAdjective;
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
        declension0 = 0;
        typeNoun = "NounEtc";
        typeAdjective = "Adjective";

        latin_Preposition = null;

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";

        nominative = "tot";
        genitive = null;
        genitivePlural = "";
        latinNounStem = null;
        nominativeAdjective = null;
        englishNounSingular = "so many";
        englishNounPlural = "so many";



        adjective = new Adjective(id, databaseAccess);
            adjective.setId(id);
            adjective.setType(typeAdjective);
            adjective.setDeclension(declension0);  // SET DECLENSION
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());


        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
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

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, adjective.getLatinWordStem());
        assertEquals(null, adjective.getLatinWordEnding());
        assertEquals("tot", adjective.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishWordPlural();
        assertEquals("so many", adjective.getEnglishWordSingular() );
        assertEquals("so many", adjective.getEnglishWordPlural() );

        adjective.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("so many", adjective.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
