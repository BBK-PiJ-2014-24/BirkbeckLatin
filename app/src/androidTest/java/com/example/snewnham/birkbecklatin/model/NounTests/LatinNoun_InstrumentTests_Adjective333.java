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

    String typeNoun;
    String typePreposition;
    String latin_Other;

    String englishNoun;

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
        declension333 = 333;
        typeNoun = "Noun";
        typePreposition = "Preposition";

        latin_Other = null;

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
        englishNounSingular = "brave, strong";
        englishNounPlural = "brave, strong";



        adjective = new Adjective(id, databaseAccess);
            adjective.setId(id);
            adjective.setType(typePreposition);
            adjective.setDeclension(declension333);  // SET DECLENSION
            adjective.setGender(genderMale);       // SET GENDER
            adjective.setNominative(nominative);
            adjective.setGenitive(genitive);
            adjective.setGenitivePlural(genitivePlural);
            adjective.setLatinNounStem(latinNounStem);
            adjective.setLatin_Preposition(latin_Other);
            adjective.setEnglishNounSingular(englishNounSingular);
            adjective.setEnglishNounPlural(englishNounPlural);
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
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularMale() throws Exception {

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("em", adjective.getLatinNounEnding());
        assertEquals("fortem", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());
    }


    // ==============================  PLURAL, MALE  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Male
     * =============================
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralMale() throws Exception {

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("fortium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());
    }


    // ================================  SINGULAR, FEMALE  =============================================

    /**
     * testMakeAdjectiveSingular()  - Singular, Female
     * ===============================
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularFemale() throws Exception {

        adjective.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("em", adjective.getLatinNounEnding());
        assertEquals("fortem", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());
    }


    // ==============================  PLURAL, FEMALE  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Female
     * =============================
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralFemale() throws Exception {

        adjective.setGender(genderFemale);   // SET GENDER TO FEMALE

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("fortium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("fortes", adjective.getLatinNoun());
    }

    // ================================  SINGULAR, NEUTER  =============================================

    /**
     * testMakeAdjectiveSingular()  - Singular, Neuter
     * ===============================
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeAdjectiveSingularNeuter() throws Exception {

        adjective.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("e", adjective.getLatinNounEnding());
        assertEquals("forte", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("e", adjective.getLatinNounEnding());
        assertEquals("forte", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("fortis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("forti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("e", adjective.getLatinNounEnding());
        assertEquals("forte", adjective.getLatinNoun());
    }


    // ==============================  PLURAL, NEUTER  =============================================


    /**
     * testMakeAdjectivePlural()  - Plural, Neuter
     * =============================
     * test Noun Class that It Can build Correct Latin Adjective.
     * @throws Exception
     */
    @Test
    public void testMakeAdjectivePluralNeuter() throws Exception {

        adjective.setGender(genderNeuter);   // SET GENDER TO NEUTER

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("fortia", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("fortia", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("fortium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("fortibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("fort", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("fortia", adjective.getLatinNoun());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishNounPlural();
        assertEquals("brave, strong", adjective.getEnglishNounSingular() );
        assertEquals("brave, strong", adjective.getEnglishNounPlural() );
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
