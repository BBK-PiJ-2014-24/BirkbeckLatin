package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.VerbSemiDeponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN SEMI DEPONENT VERBS FOR ALL PERSONS, MOODS, VOICES, CONJUGATIONS
 * Created by snewnham on 23/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinSemiDeponentVerbInstrumentTests {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbSemiDeponent verbSemiDeponent;

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


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        id = 2;
        verbSemiDeponent= new VerbSemiDeponent(id, databaseAccess);

        verbSemiDeponent.setLatin_Type("Semi Deponent");
        verbSemiDeponent.setLatin_ConjNum(2);

        verbSemiDeponent.setLatin_Present("gaudeo");        // Participle Parts
        verbSemiDeponent.setLatin_Infinitive("gaudere");
        verbSemiDeponent.setLatin_Perfect(null);
        verbSemiDeponent.setLatin_Participle("gavisus");

        verbSemiDeponent.setLatin_Present_Stem("gaud");     // Stems
        verbSemiDeponent.setLatin_Present_SubjuncStem("gaudea");
        verbSemiDeponent.setLatin_Infinitive_Stem("gaude");
        verbSemiDeponent.setLatin_Infinitive_PassiveStem("gauder");
        verbSemiDeponent.setLatin_Perfect_Stem(null);
        verbSemiDeponent.setLatin_Participle_Stem("gavis");

        verbSemiDeponent.setEnglish_Infinitive("rejoice");    // English
        verbSemiDeponent.setEnglish_Present_3rdPerson("rejoices");
        verbSemiDeponent.setEnglish_Perfect("rejoiced");
        verbSemiDeponent.setEnglish_Participle("rejoicing");

        // makeLatinWord Arguments
        // -----------------------

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


    // ==========================  ACTIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("eo", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeo", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("es", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudes", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("et", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudet", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("emus", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudemus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("etis", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudetis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ent", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudent", verbSemiDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebam", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebam", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebas", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebas", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebat", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebat", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebamus", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebamus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebatis", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebatis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebant", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebant", verbSemiDeponent.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebo", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebo", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebis", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebit", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebit", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebimus", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebimus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebitis", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebitis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gaud", verbSemiDeponent.getLatinStem());
        assertEquals("ebunt", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudebunt", verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us sum", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus sum", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us es", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus es", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us est", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus est", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i sumus", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi sumus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i estis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi estis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i sunt", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi sunt", verbSemiDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us eram", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus eram", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us eras", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus eras", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us erat", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus erat", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i eramus", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi eramus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i eratis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi eratis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i erant", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi erant", verbSemiDeponent.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us ero", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus ero", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us eris", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus eris", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us erit", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus erit", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i erimus", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi erimus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i eritis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi eritis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i erunt", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi erunt", verbSemiDeponent.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

    }

    // ======================= ACTIVE, SUBJUNCTIVE ==================================


    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("m", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeam", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("s", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeas", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("t", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeat", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("mus", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeamus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("tis", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeatis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudea", verbSemiDeponent.getLatinStem());
        assertEquals("nt", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudeant", verbSemiDeponent.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("m", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderem", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("s", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderes", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("t", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderet", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("mus", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderemus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("tis", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderetis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("nt", verbSemiDeponent.getLatinEnding());
        assertEquals("gauderent", verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us sim", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus sim", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us sis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus sis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us sit", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus sit", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i simus", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi simus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i sitis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi sitis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i sint", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi sint", verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us essem", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus essem", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us esses", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus esses", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us esset", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus esset", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i essemus", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi essemus", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i essetis", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi essetis", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("i essent", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisi essent", verbSemiDeponent.getLatinVerb());

    }

// ======================= PASSIVE, SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());;

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());
    }



    // =========================== INFINITIVE, IMPERATIVE =======================================


    /**
     * testMakeVerbWordInfinitive()  - INFINITIVE
     * ==========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("gaudere", verbSemiDeponent.getLatinStem());
        assertEquals("", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudere", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("us esse", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisus esse", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("gavis", verbSemiDeponent.getLatinStem());
        assertEquals("urus esse", verbSemiDeponent.getLatinEnding());
        assertEquals("gavisurus esse", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build the Correct Semi Deponent Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("gaude", verbSemiDeponent.getLatinStem());
        assertEquals("", verbSemiDeponent.getLatinEnding());
        assertEquals("gaude", verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("gaude", verbSemiDeponent.getLatinStem());
        assertEquals("te", verbSemiDeponent.getLatinEnding());
        assertEquals("gaudete", verbSemiDeponent.getLatinVerb());


        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

        verbSemiDeponent.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verbSemiDeponent.getLatinStem());
        assertEquals(null, verbSemiDeponent.getLatinEnding());
        assertEquals(null, verbSemiDeponent.getLatinVerb());

    }

}
