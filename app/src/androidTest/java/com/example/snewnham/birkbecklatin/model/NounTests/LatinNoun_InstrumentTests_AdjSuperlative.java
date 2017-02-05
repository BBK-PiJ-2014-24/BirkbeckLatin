package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.AdjectiveComparative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdjectiveSuperlative;

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
public class LatinNoun_InstrumentTests_AdjSuperlative {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    AdjectiveSuperlative adjectiveSuperlative;

    int declension1;
    int declension2;

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

    String latinSuperlativeStem;
    String latinSuperlative;
    String englishSuperlative;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        declension1 = 1;
        declension2 = 2;
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

        latinSuperlativeStem = "longissim";
        englishSuperlative = "longest";

        adjectiveSuperlative = new AdjectiveSuperlative(id, databaseAccess);
        adjectiveSuperlative.setId(id);
        adjectiveSuperlative.setType(typeAdjective);
        adjectiveSuperlative.setGender(genderMale);       // SET GENDER
        adjectiveSuperlative.setNominative(nominative);
        adjectiveSuperlative.setLatinAdjectiveStem(latinNounStem);
        adjectiveSuperlative.setNominative_Neuter(nominativeNeuter);
        adjectiveSuperlative.setEnglishAdjective(englishNounPlural);
        adjectiveSuperlative.setLatinSuperlativeStem(latinSuperlativeStem);
        adjectiveSuperlative.setEnglishSuperlative(englishSuperlative);
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

        adjectiveSuperlative.setGender(genderMale);   // SET GENDER
        adjectiveSuperlative.setDeclension(declension2);  // SET DECLENSION

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals( "us", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimus", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("um", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("i", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimi", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("o", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimo", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("o", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimo", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("e", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissime", adjectiveSuperlative.getLatinWord());
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

        adjectiveSuperlative.setGender(genderMale);   // SET GENDER
        adjectiveSuperlative.setDeclension(declension2);  // SET DECLENSION

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("i", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimi", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("os", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimos", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("orum", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimorum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("i", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimi", adjectiveSuperlative.getLatinWord());
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


        adjectiveSuperlative.setDeclension(declension1);  // SET DECLENSION
        adjectiveSuperlative.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("am", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimam", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("ae", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimae", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("ae", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimae", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals( "a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());
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

        adjectiveSuperlative.setGender(genderFemale);   // SET GENDER TO FEMALE
        adjectiveSuperlative.setDeclension(declension1);  // SET DECLENSION

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("ae", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimae", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("as", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimas", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("arum", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimarum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("ae", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimae", adjectiveSuperlative.getLatinWord());
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

        adjectiveSuperlative.setGender(genderNeuter);   // SET GENDER TO NEUTER
        adjectiveSuperlative.setDeclension(declension2);  // SET DECLENSION

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("um", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("um", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("i", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimi", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("o", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimo", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("o", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimo", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberSingular, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("um", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimum", adjectiveSuperlative.getLatinWord());
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

        adjectiveSuperlative.setGender(genderNeuter);   // SET GENDER TO NEUTER
        adjectiveSuperlative.setDeclension(declension2);  // SET DECLENSION

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseNominative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAccusative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseGenitive);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("orum", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimorum", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseDative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseAblative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("is", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissimis", adjectiveSuperlative.getLatinWord());

        adjectiveSuperlative.makeLatinWord(databaseAccess, numberPlural, caseVocative);

        assertEquals("longissim", adjectiveSuperlative.getLatinWordStem());
        assertEquals("a", adjectiveSuperlative.getLatinWordEnding());
        assertEquals("longissima", adjectiveSuperlative.getLatinWord());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English NounEtc
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjectiveSuperlative.getEnglishWordPlural();
        assertEquals("longest", adjectiveSuperlative.getEnglishWordSingular() );
        assertEquals("longest", adjectiveSuperlative.getEnglishWordPlural() );

        adjectiveSuperlative.makeEnglishWord(databaseAccess, numberPlural);
        assertEquals("longest", adjectiveSuperlative.getEnglishWord());
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
