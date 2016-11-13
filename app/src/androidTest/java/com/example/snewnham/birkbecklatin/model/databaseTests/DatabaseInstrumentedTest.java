package com.example.snewnham.birkbecklatin.model.databaseTests;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.example.snewnham.birkbecklatin.Model.database.DbSchema.VerbListTable.*;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseInstrumentedTest {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    String person1;
    String person2;
    String person3;
    String personNull;

    String numberSingular;
    String numberPlural;
    String numberInfinitive;

    String moodIndicative;
    String moodSubjunctive;
    String moodImperative;

    String voiceActive;
    String voicePassive;

    String tensePresent;
    String tenseImPerfect;
    String tenseFuture;
    String tensePerfect;
    String tensePluperfect;
    String tenseFuturePerfect;
    String tenseNull;

    String conjNum1;
    String conjNum2;
    String conjNum3;
    String conjNum4;
    String conjNull;

    int noun_id;
    String noun_Type;
    int noun_Declension;
    String noun_Gender;
    String noun_Nominative;
    String noun_Geninitive;
    String noun_Geninitive_Plural;
    String noun_Latin_Noun_Stem;
    String noun_Latin_Preposition;
    String noun_Latin_Nominative_Adjective;
    String noun_English_Noun_Singular;
    String noun_English_Noun_Plural;
    String noun_number;
    String noun_Latin_Case;

    int adjectiveId;
    String adjectiveType;
    int adjectiveDeclension;
    String adjectiveNominative;
    String adjectiveNominativeNeuter;
    String adjectiveLatinAdjectiveStem;
    String adjectiveEnglishAdjective;
    String adjectiveLatinComparative;
    String adjectiveEnglishComparative;
    String adjectiveLatinSuperlative;
    String adjectiveEnglishSuperlative;

    int prepositionId;
    String prepositionLatin;
    String prepositionEnglish;

    int conjunctionId;
    String conjunctionLatin;
    String conjunctionEnglish;



    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        // VERB FIELDS
        // -----------
        person1 = "1st";
        person2 = "2nd";
        person3 = "3rd";
        personNull = null;

        numberSingular = "Singular";
        numberPlural = "Plural";
        numberInfinitive = "Infinitive";

        moodIndicative = "Indicative";
        moodSubjunctive = "Subjunctive";
        moodImperative = "Imperative";

        voiceActive = "Active";
        voicePassive = "Passive";

        tensePresent = "Present";
        tenseImPerfect = "Imperfect";
        tenseFuture = "Future";
        tensePerfect = "Perfect";
        tensePluperfect = "Pluperfect";
        tenseFuturePerfect = "Future Perfect";
        tenseNull = null;

        conjNum1 = "1";
        conjNum2 = "2";
        conjNum3 = "3";
        conjNum4 = "4";
        conjNull = null;


    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    /**
     * testDBAccess()
     * --------------
     * Test General database access with basic sql queries
     * @throws Exception
     */
    @Test
    public void testDBAccess() throws Exception {
        String table = VERB_LIST_TABLE;
        String[] column = new String[]{Cols.LATIN_INFINITIVE};
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{"2"};

        Cursor cursor = databaseAccess.sqlQuery(table, column, whereClause, whereArgs  );
        cursor.moveToFirst();
        String ans = cursor.getString(0);
        assertEquals("monere", ans);

        String table1 = "Noun_Declension";
        String[] column1 = new String[]{"Gender"};
        String whereClause1 = "_id=?";
        String[] whereArgs1 = new String[]{"2"};

        Cursor cursor1 = databaseAccess.sqlQuery(table1, column1, whereClause1, whereArgs1  );
        cursor1.moveToFirst();
        String ans1 = cursor1.getString(0);
        assertEquals("f", ans1);

        String table2 = DbSchema.NounDeclensionTable.NOUN_DECLENSION_TABLE;
        String[] column2 = new String[]{DbSchema.NounDeclensionTable.Cols.CASE};
        String whereClause2 = "_id=?";
        String[] whereArgs2 = new String[]{"2"};

        Cursor cursor2 = databaseAccess.sqlQuery(table2, column2, whereClause2, whereArgs2  );
        cursor2.moveToFirst();
        String ans2 = cursor2.getString(0);
        assertEquals("Accusative", ans2);


    }

    @Test
    public void testDBAccess2() throws Exception {
        String table = VERB_LIST_TABLE;
        String[] column = null;
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{"2"};


        Cursor cursor = databaseAccess.sqlQuery(table, column, whereClause, whereArgs  );
        cursor.moveToFirst();
        String answer = cursor.getString(cursor.getColumnIndex(Cols.LATIN_INFINITIVE));
        cursor.close();

        assertEquals("monere", answer);
    }


    /**
     * testDatabaseToVerb()
     * -------------------
     * Tests whether we can convert from VerbListCursor db table to VerbRegular object
     * @throws Exception
     */

    @Test
    public void testDatabaseToVerb() throws Exception {

        // test answers
        // ------------
        int id = 2;
        String latin_Type = "Regular";
        int latin_ConjNum = 2;

        String latin_Present = "moneo";        // Participle Parts
        String latin_Infinitive = "monere";
        String latin_Perfect = "monui";
        String latin_Participle = "monitus";

        String latin_Present_Stem = "mon";     // Stems
        String latin_Present_SubjuncStem = "monea";
        String latin_Infinitive_Stem = "mone";
        String latin_Infinitive_PassiveStem = "moner";
        String latin_Perfect_Stem = "monu";
        String latin_Participle_Stem = "monit";

        String english_Infinitive = "warn, advise";    // English
        String english_Present_3rdPerson = "warns, advises";
        String english_Perfect = "warned, advised";
        String english_Participle = "warning, advising";

        // Run Query
        // ---------
        Verb verbRegular = databaseAccess.sqlVerbListQuery(id);


        // test the VerbRegular Fields
        // --------------------
        assertEquals( id, verbRegular.getId() );
        assertEquals( latin_Type, verbRegular.getLatin_Type() );
        assertEquals( latin_ConjNum, verbRegular.getLatin_ConjNum());

        assertEquals( latin_Present, verbRegular.getLatin_Present() );   // Priciple Parts
        assertEquals( latin_Infinitive, verbRegular.getLatin_Infinitive() );
        assertEquals( latin_Perfect, verbRegular.getLatin_Perfect() );
        assertEquals( latin_Participle, verbRegular.getLatin_Participle() );

        assertEquals( latin_Present_Stem, verbRegular.getLatin_Present_Stem() );    // Stems
        assertEquals( latin_Present_SubjuncStem, verbRegular.getLatin_Present_SubjuncStem() );
        assertEquals( latin_Infinitive_Stem, verbRegular.getLatin_Infinitive_Stem() );
        assertEquals( latin_Infinitive_PassiveStem, verbRegular.getLatin_Infinitive_PassiveStem() );
        assertEquals( latin_Perfect_Stem, verbRegular.getLatin_Perfect_Stem() );
        assertEquals( latin_Participle_Stem, verbRegular.getLatin_Participle_Stem() );

        assertEquals( english_Infinitive, verbRegular.getEnglish_Infinitive() );     // English
        assertEquals( english_Present_3rdPerson, verbRegular.getEnglish_Present_3rdPerson() );
        assertEquals( english_Perfect, verbRegular.getEnglish_Perfect() );
        assertEquals( english_Participle, verbRegular.getEnglish_Participle() );

    }

    /**
     * testLatinVerbStem()
     * ===================
     * Test sqlVerbStemQuery to select the correct stem for a latin verbSemiDeponent
     */
    @Test
    public void testLatinVerbStem() {

        String stem1 = databaseAccess.sqlVerbStemQuery(numberSingular, moodIndicative,
                                                voiceActive, tensePresent);
        String ans1 = "Present";
        assertEquals(ans1, stem1);


        // TEST IMPERATIVE
        String stem2 = databaseAccess.sqlVerbStemQuery(numberSingular, moodImperative,
                                               voiceActive, tenseNull);
        String ans2 = "Infinitive_Stem";
        assertEquals(ans2, stem2);
    }


    /**
     * testLatinVerbEnding()
     * ==========================
     * Test sqlVerbConjugationQuery to select the correct ENDING for a latin verbSemiDeponent
     */
    @Test
    public void testLatinVerbEnding() {

        String conj1 = "eramus";

        String latinEnding1 = databaseAccess.sqlVerbEndingQuery(person1, numberPlural,
                                            moodIndicative, voiceActive, tensePluperfect, conjNum1);
        assertEquals(conj1, latinEnding1);


        // TEST INFINITIVE
        String latinEnding2 = databaseAccess.sqlVerbEndingQuery(person2, numberInfinitive,
                                        moodIndicative, voiceActive, tensePresent, conjNull);
        String conj2 = null;

        assertEquals(conj2, latinEnding2);


        // TEST IMPERATIVE
        String latinEnding3 = databaseAccess.sqlVerbEndingQuery(personNull, numberSingular,
                            moodImperative, voiceActive, tenseNull, conjNull);
        String conj3 = null;

        assertEquals(conj3, latinEnding3);

    }


    /**
     * testLatinIrregularVerb()
     * =======================
     * test sql query for IrregularVerb
     */
    @Test
    public void testLatinIrregularVerb(){

        String irregularVerb = "esse";

        String query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, person2, numberSingular,
                                                    moodIndicative, voiceActive, tensePerfect);
        assertEquals("fuisti", query);


        // TEST INFINITIVE
        query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, personNull, numberInfinitive,
                                                    moodIndicative, voiceActive, tensePerfect);
        assertEquals("fuisse", query);

        // TEST IMPERATIVE
        query = databaseAccess.sqlLatinIrregularVerb(irregularVerb, personNull, numberPlural,
                moodImperative, voiceActive, tensePerfect);
        assertEquals("este", query);


    }
    // =================== ENGLISH VERB TESTS ==================================================

    /**
     * testEnglishPersonTable()
     * ========================
     * Test testEnglishPersonTable to select the correct English Person.
     */
    @Test
    public void testEnglishPersonTable() {

        String ans = "he/she";

        String engPerson = databaseAccess.sqlEngPersonQuery(person3, numberSingular);
        assertEquals(ans, engPerson );
    }

    /**
     * testEnglishAuxiliaryVerbTable()
     * ===============================
     * Test testEnglishAuxiliaryVerbTable to select the correct English Auxiliary VerbRegular.
     */
    @Test
    public void testEnglishAuxiliaryVerbTable() {

        String engAuxVerb1 = databaseAccess.sqlEngAuxVerbQuery(person2, numberSingular,
                moodSubjunctive, voiceActive, tensePluperfect);

        String ans1 = " would have ";
        assertEquals(ans1, engAuxVerb1 );

        // TEST IMPERATIVE
        String engAuxVerb2 = databaseAccess.sqlEngAuxVerbQuery(personNull, numberSingular,
                moodImperative, voicePassive, tenseNull);

        String ans2 = "be ";
        assertEquals(ans2, engAuxVerb2 );

    }


    /**
     * testEnglishVerbEndingTable()
     * =============================
     * Test testEnglish_Verb_Table to select the English VerbRegular with the correct Ending
     */
    @Test
    public void testEnglishVerbEndingTable() {

        String guessEngVerbEnding1 = databaseAccess.sqlEngVerbEnding(numberSingular, tensePresent,
                            moodIndicative, voiceActive);

        String ans1 = "English_Infinitive";
        assertEquals(ans1, guessEngVerbEnding1 );

        String guessEngVerbEnding2 = databaseAccess.sqlEngVerbEnding(numberPlural, tenseNull,
                moodImperative, voiceActive);

        String ans2 = "English_Infinitive";
        assertEquals(ans2, guessEngVerbEnding2 );
    }


    /**
     * testEnglishIrregularESSEVerb()
     * ============================
     * Test to select an Irregular English Verb, 'To Be / ESSE'
     */

    @Test
    public void testEnglishIrregularESSEVerb() {

        String irregularVerb = "esse";

        String guessEngIrregVerb = databaseAccess.sqlEnglishIrregularESSEVerb(irregularVerb, person3, numberSingular, tensePresent,
                                                                     moodIndicative, voiceActive);
        assertEquals("is", guessEngIrregVerb);

        // Infinitive
        guessEngIrregVerb = databaseAccess.sqlEnglishIrregularESSEVerb(irregularVerb, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive);
        assertEquals("be", guessEngIrregVerb);

    }

    // ============================== NOUN TESTS ==================================================


    /**
     * testNounList()
     * ==============
     * Test sql query on NounListTable using the NounListCursor.
     */
    @Test
    public void testNounList() {

        // NOUN FIELDS
        // -----------
        noun_id = 2;
        noun_Type = "Noun";
        noun_Declension = 2;
        noun_Gender = "m";
        noun_Nominative = "amicus";
        noun_Geninitive = "amici";
        noun_Geninitive_Plural = null;
        noun_Latin_Noun_Stem = "amic";
        noun_English_Noun_Singular = "friend";
        noun_English_Noun_Plural = "friends";

        // Run Query
        // ---------
        NounRegular noun = databaseAccess.sqlNounListQuery(noun_id);

        // test the VerbRegular Fields
        // --------------------
        assertEquals( noun_id, noun.getId() );
        assertEquals( noun_Type, noun.getType() );
        assertEquals( noun_Declension, noun.getDeclension() );
        assertEquals( noun_Gender, noun.getGender() );
        assertEquals( noun_Nominative, noun.getNominative() );
        assertEquals( noun_Geninitive, noun.getGenitive() );
        assertEquals( noun_Geninitive_Plural, noun.getGenitivePlural() );
        assertEquals( noun_Latin_Noun_Stem, noun.getLatinWordStem() );
        assertEquals( noun_English_Noun_Singular, noun.getEnglishWordSingular() );
        assertEquals( noun_English_Noun_Plural, noun.getEnglishWordPlural() );
    }


    /**
     * testNounIrregularQuery()
     * ------------------------
     * test a sql query for an irregular noun, Possessives, Pronouns etc.
     */
    @Test
    public void testNounIrregularQuery() throws Exception{

        String nounIrregular = "hic";
        noun_Gender = "m";
        noun_number = "Singular";
        noun_Latin_Case = "Accusative";

        // Run Query
        // ---------
        String query = databaseAccess.sqlNounIrregularQuery(nounIrregular, noun_Gender, noun_number, noun_Latin_Case);

        assertEquals("hunc", query);
    }


    /**
     * testAdjectivelist()
     * -------------------
     * TEST SQL Query on Adjective List Table
     * @throws Exception
     */
    @Test
    public void testAdjectiveList() throws Exception {

        // Adjective FIELDS
        // -----------
        adjectiveId = 2;
        adjectiveType = "Adjective";
        adjectiveDeclension = 212;
        adjectiveNominative = "longus";
        adjectiveNominativeNeuter = null;
        adjectiveLatinAdjectiveStem = "long";
        adjectiveEnglishAdjective = "long";
        adjectiveLatinComparative = "longior";
        adjectiveEnglishComparative = "longer";
        adjectiveLatinSuperlative = "longissim";
        adjectiveEnglishSuperlative = "longest";

        // Run Query
        // ---------
        Adjective adjective = databaseAccess.sqlAdjectiveListQuery(adjectiveId);

        assertEquals( adjectiveId, adjective.getId() );
        assertEquals( adjectiveType, adjective.getType() );
        assertEquals( adjectiveDeclension, adjective.getDeclension() );
        assertEquals( adjectiveNominative, adjective.getNominative() );
        assertEquals( adjectiveNominativeNeuter, adjective.getNominative_Neuter() );
        assertEquals( adjectiveLatinAdjectiveStem, adjective.getLatinAdjectiveStem() );
        assertEquals( adjectiveEnglishAdjective, adjective.getEnglishAdjective() );
        assertEquals( adjectiveLatinComparative, adjective.getLatinComparative() );
        assertEquals( adjectiveEnglishComparative, adjective.getEnglishComparative() );
        assertEquals( adjectiveLatinSuperlative, adjective.getLatinSuperlative() );
        assertEquals( adjectiveEnglishSuperlative, adjective.getEnglishSuperlative() );
    }



    /**
     * testAdjectiveEndingQuery()
     * --------------------------
     * test a sql query for an Adjective.
     */

    @Test
    public void testAdjectiveEndingQuery(){

        noun_Declension = 212;
        noun_Gender = "m";
        noun_number = "Singular";
        noun_Latin_Case = "Accusative";

        // Run Query
        // ---------

        String query = databaseAccess.sqlAdjectiveEnding(Integer.toString(noun_Declension), noun_Gender, noun_number, noun_Latin_Case);

        assertEquals("um", query);
    }


    /**
     * testPrepositionListQuery()
     * --------------------------
     * test the sql query on Preposition_List table.
     */
    @Test
    public void testPrepositionListQuery(){

        prepositionId = 10;
        prepositionLatin = "trans";
        prepositionEnglish = "across";

        // Run Query
        // ---------
        Preposition preposition = databaseAccess.sqlPrepositionListQuery(prepositionId);

        assertEquals(prepositionId, preposition.getId());
        assertEquals(prepositionLatin, preposition.getLatinWord());
        assertEquals(prepositionEnglish, preposition.getEnglishWordPlural());

    }


    /**
     * testConjunctionListQuery()
     * --------------------------
     * test the sql query on Conjunction_List table.
     */
    @Test
    public void testConjunctionListQuery(){

        conjunctionId = 3;
        conjunctionLatin = "tamen";
        conjunctionEnglish = "however";

        // Run Query
        // ---------
        Conjunction conjunction = databaseAccess.sqlConjunctionListQuery(conjunctionId);

        assertEquals(conjunctionId, conjunction.getId());
        assertEquals(conjunctionLatin, conjunction.getLatinWord());
        assertEquals(conjunctionEnglish, conjunction.getEnglishWordPlural());

    }


    @After
    public void breakDown() {
        databaseAccess.close();
    }


}
