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

    String nominativeAdjective;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        declension333 = 333;
        typeNoun = "Noun";
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
        nominativeAdjective = "ingens";
        englishNounSingular = "huge";
        englishNounPlural = "huge";



        adjective = new Adjective(id, databaseAccess);
            adjective.setId(id);
            adjective.setType(typePreposition);
            adjective.setDeclension(declension333);  // SET DECLENSION
            adjective.setGender(genderMale);       // SET GENDER
            adjective.setNominative(nominative);
            adjective.setGenitive(genitive);
            adjective.setGenitivePlural(genitivePlural);
            adjective.setLatinNounStem(latinNounStem);
            adjective.setLatin_Preposition(latin_Preposition);
            adjective.setLatin_Nominative_Adjective(nominativeAdjective);
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("em", adjective.getLatinNounEnding());
        assertEquals("ingentem", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("ingentis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("ingentium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("em", adjective.getLatinNounEnding());
        assertEquals("ingentem", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("ingentis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("ingentium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("es", adjective.getLatinNounEnding());
        assertEquals("ingentes", adjective.getLatinNoun());
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("is", adjective.getLatinNounEnding());
        assertEquals("ingentis", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("i", adjective.getLatinNounEnding());
        assertEquals("ingenti", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("", adjective.getLatinNounEnding());
        assertEquals("ingens", adjective.getLatinNoun());
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

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("ingentia", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("ingentia", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ium", adjective.getLatinNounEnding());
        assertEquals("ingentium", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ibus", adjective.getLatinNounEnding());
        assertEquals("ingentibus", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals("ingent", adjective.getLatinNounStem());
        assertEquals("ia", adjective.getLatinNounEnding());
        assertEquals("ingentia", adjective.getLatinNoun());
    }


    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        String s = adjective.getEnglishNounPlural();
        assertEquals("huge", adjective.getEnglishNounSingular() );
        assertEquals("huge", adjective.getEnglishNounPlural() );
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
