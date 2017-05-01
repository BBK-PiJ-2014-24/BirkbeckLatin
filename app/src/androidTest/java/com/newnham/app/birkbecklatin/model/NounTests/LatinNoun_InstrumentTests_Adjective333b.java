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
 * TESTS FOR CREATING ADJECTIVES FOR ALL 333 DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective333b {


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

    String nominativeNeuter;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        declension333 = 333;
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

        nominative = "ingens";
        genitive = "ingentis";
        genitivePlural = "ingentium";
        latinNounStem = "ingent";
        nominativeNeuter = "ingens";
        englishNounSingular = "huge";
        englishNounPlural = "huge";



        adjective = new Adjective(id, databaseAccess);
        adjective.setId(id);
        adjective.setType(typePreposition);
        adjective.setDeclension(declension333);  // SET DECLENSION
        adjective.setGender(genderMale);       // SET GENDER
        adjective.setNominative(nominative);
        adjective.setNominative_Neuter(nominativeNeuter);
        adjective.setLatinAdjectiveStem(latinNounStem);
        adjective.setEnglishAdjective(englishNounPlural);
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    // ================================  SINGULAR, MALE  =============================================

    /**
     * testMakeAdjectiveSingular()  - Singular, Male
     * ===============================
     * test NounEtc Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularMale() throws Exception {

        adjective.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("em", adjective.getLatinWordEnding());
        assertEquals("ingentem", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("ingentis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());
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

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("ingentium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());
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

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("em", adjective.getLatinWordEnding());
        assertEquals("ingentem", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("ingentis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());
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

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("ingentium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("es", adjective.getLatinWordEnding());
        assertEquals("ingentes", adjective.getLatinWord());
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

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("is", adjective.getLatinWordEnding());
        assertEquals("ingentis", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("i", adjective.getLatinWordEnding());
        assertEquals("ingenti", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("", adjective.getLatinWordEnding());
        assertEquals("ingens", adjective.getLatinWord());
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

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("ingentia", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("ingentia", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ium", adjective.getLatinWordEnding());
        assertEquals("ingentium", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ibus", adjective.getLatinWordEnding());
        assertEquals("ingentibus", adjective.getLatinWord());

        adjective.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinWordStem());
        assertEquals("ia", adjective.getLatinWordEnding());
        assertEquals("ingentia", adjective.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishWordPlural();
        assertEquals("huge", adjective.getEnglishWordSingular() );
        assertEquals("huge", adjective.getEnglishWordPlural() );
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
