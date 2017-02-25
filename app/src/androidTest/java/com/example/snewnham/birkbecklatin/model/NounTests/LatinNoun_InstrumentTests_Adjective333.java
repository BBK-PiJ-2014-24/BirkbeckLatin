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
 * TESTS FOR CREATING ADJECTIVES FOR ALL 333 DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective333 {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    Adjective adjective;

    int declension333;

    String genderMale = "m";
    String genderFemale = "f";
    String genderNeuter = "n";

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

    String nominativeNeuter;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE

        id = 2;
        declension333 = 333;
        typeAdjective = "NounEtc";

        latin_Preposition = null;

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";

        nominative = "fortis";
        genitive = "fortis";
        genitivePlural = "fortium";
        latinNounStem = "fort";
        nominativeNeuter = "forte";
        englishNounSingular = "brave, strong";
        englishNounPlural = "brave, strong";

        adjective = new Adjective(id, databaseAccess);
        adjective.setId(id);
        adjective.setType(typeAdjective);
        adjective.setDeclension(declension333);  // SET DECLENSION
        adjective.setGender(genderMale);       // SET GENDER
        adjective.setNominative(nominative);
        adjective.setLatinAdjectiveStem(latinNounStem);
        adjective.setNominative_Neuter(nominativeNeuter);
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
        assertEquals("Test Get Genitive", "fortis" , gen);
    }


    /**
     * testMakeAdjectiveSingular()  - Singular, Male
     * ===============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularMale() throws Exception {

        adjective.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("em", adjective.getLatinWordEnding());
        assertEquals("fortem", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());
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

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("fortium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());
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

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("em", adjective.getLatinWordEnding());
        assertEquals("fortem", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());
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

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("fortium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("fortes", adjective.getLatinWord());
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

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("e", adjective.getLatinWordEnding());
        assertEquals("forte", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("e", adjective.getLatinWordEnding());
        assertEquals("forte", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("fortis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("forti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("e", adjective.getLatinWordEnding());
        assertEquals("forte", adjective.getLatinWord());
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

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("fortia", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("fortia", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("fortium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("fortibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("fortia", adjective.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishWordPlural();
        assertEquals("brave, strong", adjective.getEnglishWordSingular() );
        assertEquals("brave, strong", adjective.getEnglishWordPlural() );
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
