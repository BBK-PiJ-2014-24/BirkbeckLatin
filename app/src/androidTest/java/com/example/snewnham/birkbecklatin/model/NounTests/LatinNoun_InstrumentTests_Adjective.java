package com.example.snewnham.birkbecklatin.model.NounTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ADJECTIVES FOR ALL DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinNoun_InstrumentTests_Adjective {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;

    Adjective adjective;

    int declension212;
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


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open(); // OPEN THE DATABASE


        id = 2;
        declension212 = 212;
        typeNoun = "Noun";
        typePreposition = "Preposition";

        latin_Other = "circum";
        englishNoun = "around";

        caseNominative = "Nominative";
        caseAccusative = "Accusative";
        caseGenitive = "Genitive";
        caseDative = "Dative";
        caseAblative = "Ablative";
        caseVocative = "Vocative";

        numberSingular = "Singular";
        numberPlural = "Plural";



        adjective = new Adjective(id, databaseAccess);
            adjective.setId(id);
            adjective.setType(typePreposition);
            adjective.setDeclension(0);  // SET DECLENSION
            adjective.setGender(null);       // SET GENDER
            adjective.setNominative(null);
            adjective.setGenitive(null);
            adjective.setGenitivePlural(null);
            adjective.setLatinNounStem(null);
            adjective.setLatin_Other(latin_Other);
            adjective.setEnglishNounSingular(englishNoun);

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
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */

    @Test
    public void testMakeNounIrregularSingular() throws Exception {

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseNominative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("hic", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAccusative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("hunc", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseGenitive);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("huius", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseDative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("huic", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseAblative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("hoc", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberSingular, caseVocative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals(null, adjective.getLatinNoun());
    }


    // ==============================  PLURAL  =============================================


    /**
     * testMakeNounIrregularPlural()  - Plural
     * =============================
     * test Noun Class that It Can build Correct Latin Noun.
     * @throws Exception
     */
    @Test
    public void testMakeNounIrregularPlural() throws Exception {

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseNominative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("hi", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAccusative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("hos", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseGenitive);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("horum", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseDative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("his", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseAblative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals("his", adjective.getLatinNoun());

        adjective.makeLatinNoun(databaseAccess, numberPlural, caseVocative);

        assertEquals(null, adjective.getLatinNounStem());
        assertEquals(null, adjective.getLatinNounEnding());
        assertEquals(null, adjective.getLatinNoun());
    }

    /**
     * testEnglishNounTranslation()
     * ----------------------------
     * Test to get the English Noun
     */
    @Test
    public void testEnglishNounTranslation() throws Exception{
        assertEquals("this", adjective.getEnglishNounSingular() );
        assertEquals("these", adjective.getEnglishNounPlural() );
    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
