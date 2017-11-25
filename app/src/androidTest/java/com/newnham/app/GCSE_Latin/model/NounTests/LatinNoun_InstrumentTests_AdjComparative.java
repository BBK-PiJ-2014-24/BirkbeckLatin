package com.newnham.app.GCSE_Latin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.AdjectiveComparative;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING COMPARATIVE ADJECTIVES FOR ALL GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_AdjComparative {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    AdjectiveComparative adjectiveComparative;

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
    String latinComparative;
    String englishComparative;


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

        nominative = "longus";
        genitive = "longi";
        genitivePlural = null;
        latinNounStem = "long";
        nominativeNeuter = "longum";
        englishNounSingular = "long";
        englishNounPlural = "long";

        latinComparative = "longior";
        englishComparative = "more longer";

        adjectiveComparative = new AdjectiveComparative(id, databaseAccess);
        adjectiveComparative.setId(id);
        adjectiveComparative.setType(typeAdjective);
        adjectiveComparative.setDeclension(declension333);  // SET DECLENSION
        adjectiveComparative.setGender(genderMale);       // SET GENDER
        adjectiveComparative.setNominative(nominative);
        adjectiveComparative.setLatinAdjectiveStem(latinNounStem);
        adjectiveComparative.setNominative_Neuter(nominativeNeuter);
        adjectiveComparative.setEnglishAdjective(englishNounPlural);
        adjectiveComparative.setLatinComparativeStem(latinComparative);
        adjectiveComparative.setEnglishComparative(englishComparative);
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

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals( null, adjectiveComparative.getLatinWordEnding());
        assertEquals("longior", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("em", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiorem", adjectiveComparative.getLatinWord());
        assertEquals(caseAccusative, adjectiveComparative.getCase());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("is", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioris", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("i", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiori", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("e", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiore", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals(null, adjectiveComparative.getLatinWordEnding());
        assertEquals("longior", adjectiveComparative.getLatinWord());
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

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("um", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiorum", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());
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

        adjectiveComparative.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals(null, adjectiveComparative.getLatinWordEnding());
        assertEquals("longior", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("em", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiorem", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("is", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioris", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("i", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiori", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("e", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiore", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals( null, adjectiveComparative.getLatinWordEnding());
        assertEquals("longior", adjectiveComparative.getLatinWord());
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

        adjectiveComparative.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("um", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiorum", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("es", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiores", adjectiveComparative.getLatinWord());
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

        adjectiveComparative.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ius", adjectiveComparative.getLatinWordEnding());
        assertEquals("longius", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ius", adjectiveComparative.getLatinWordEnding());
        assertEquals("longius", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("is", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioris", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("i", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiori", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("e", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiore", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ius", adjectiveComparative.getLatinWordEnding());
        assertEquals("longius", adjectiveComparative.getLatinWord());
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

        adjectiveComparative.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("a", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiora", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("a", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiora", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("um", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiorum", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("ibus", adjectiveComparative.getLatinWordEnding());
        assertEquals("longioribus", adjectiveComparative.getLatinWord());

        adjectiveComparative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longior", adjectiveComparative.getLatinWordStem());
        assertEquals("a", adjectiveComparative.getLatinWordEnding());
        assertEquals("longiora", adjectiveComparative.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjectiveComparative.getEnglishWordPlural();
        assertEquals("more longer", adjectiveComparative.getEnglishWordSingular() );
        assertEquals("more longer", adjectiveComparative.getEnglishWordPlural() );

        adjectiveComparative.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("more longer", adjectiveComparative.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
