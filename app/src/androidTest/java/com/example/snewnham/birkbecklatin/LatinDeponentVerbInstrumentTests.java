package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.Verb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN DEPONENT VERBS FOR ALL PERSONS, MOODS, VOICES, CONJUGATIONS
 * Created by snewnham on 22/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinDeponentVerbInstrumentTests {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    Verb verb;

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
        verb = new Verb(id, databaseAccess);

        verb.setLatin_Type("Deponent");
        verb.setLatin_ConjNum(2);

        verb.setLatin_Present("videor");        // Participle Parts
        verb.setLatin_Infinitive("videri");
        verb.setLatin_Perfect(null);
        verb.setLatin_Participle("visus");

        verb.setLatin_Present_Stem("vide");     // Stems
        verb.setLatin_Infinitive_Stem("vide");
        verb.setLatin_Infinitive_PassiveStem("vider");
        verb.setLatin_Infinitive_StemMod(null);
        verb.setLatin_Perfect_Stem(null);
        verb.setLatin_Participle_Stem("vis");

        verb.setEnglish_Infinitive("seem");    // English
        verb.setEnglish_Present_3rdPerson("seems");
        verb.setEnglish_Perfect("seemed");
        verb.setEnglish_Participle("seeming");

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
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("or", verb.getLatinEnding());
        assertEquals("videor", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("ris", verb.getLatinEnding());
        assertEquals("videris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("tur", verb.getLatinEnding());
        assertEquals("videtur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("mur", verb.getLatinEnding());
        assertEquals("videmur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("videmini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("ntur", verb.getLatinEnding());
        assertEquals("videntur", verb.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bar", verb.getLatinEnding());
        assertEquals("videbar", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("baris", verb.getLatinEnding());
        assertEquals("videbaris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("batur", verb.getLatinEnding());
        assertEquals("videbatur", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bamur", verb.getLatinEnding());
        assertEquals("videbamur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bamini", verb.getLatinEnding());
        assertEquals("videbamini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bantur", verb.getLatinEnding());
        assertEquals("videbantur", verb.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bor", verb.getLatinEnding());
        assertEquals("videbor", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("beris", verb.getLatinEnding());
        assertEquals("videberis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bitur", verb.getLatinEnding());
        assertEquals("videbitur", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bimur", verb.getLatinEnding());
        assertEquals("videbimur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("bimini", verb.getLatinEnding());
        assertEquals("videbimini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("buntur", verb.getLatinEnding());
        assertEquals("videbuntur", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us sum", verb.getLatinEnding());
        assertEquals("visus sum", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us es", verb.getLatinEnding());
        assertEquals("visus es", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us et", verb.getLatinEnding());
        assertEquals("visus et", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i", verb.getLatinEnding());
        assertEquals("visi sumus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i", verb.getLatinEnding());
        assertEquals("visi estis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i", verb.getLatinEnding());
        assertEquals("visi sunt", verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us eram", verb.getLatinEnding());
        assertEquals("visus eram", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us eras", verb.getLatinEnding());
        assertEquals("visus eras", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us erat", verb.getLatinEnding());
        assertEquals("us erat", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i eramus", verb.getLatinEnding());
        assertEquals("visi eramus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i eratis", verb.getLatinEnding());
        assertEquals("visi eratis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i erant", verb.getLatinEnding());
        assertEquals("visi erant", verb.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us ero", verb.getLatinEnding());
        assertEquals("visus ero", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us eris", verb.getLatinEnding());
        assertEquals("visus eris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us erit", verb.getLatinEnding());
        assertEquals("visus erit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i erimus", verb.getLatinEnding());
        assertEquals("visi erimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i eritis", verb.getLatinEnding());
        assertEquals("visi eritis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i erint", verb.getLatinEnding());
        assertEquals("visi erunt", verb.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }

    // ======================= ACTIVE, SUBJUNCTIVE ==================================


    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("r", verb.getLatinEnding());
        assertEquals("videar", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("ris", verb.getLatinEnding());
        assertEquals("videaris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("tur", verb.getLatinEnding());
        assertEquals("videatur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("mur", verb.getLatinEnding());
        assertEquals("videamur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("videamini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verb.getLatinStem());
        assertEquals("ntur", verb.getLatinEnding());
        assertEquals("videantur", verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("r", verb.getLatinEnding());
        assertEquals("viderer", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("ris", verb.getLatinEnding());
        assertEquals("videreris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("tur", verb.getLatinEnding());
        assertEquals("moneret", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("mur", verb.getLatinEnding());
        assertEquals("videremur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("videremini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", verb.getLatinStem());
        assertEquals("ntur", verb.getLatinEnding());
        assertEquals("viderentur", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us sim", verb.getLatinEnding());
        assertEquals("visus sim", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us sis", verb.getLatinEnding());
        assertEquals("visus sis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us sit", verb.getLatinEnding());
        assertEquals("visus sit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i simus", verb.getLatinEnding());
        assertEquals("visi simus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i sitis", verb.getLatinEnding());
        assertEquals("visi sitis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i sint", verb.getLatinEnding());
        assertEquals("visi sint", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us essem", verb.getLatinEnding());
        assertEquals("visus essem", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us esses", verb.getLatinEnding());
        assertEquals("visus esses", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("us esset", verb.getLatinEnding());
        assertEquals("visu esset", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i essemus", verb.getLatinEnding());
        assertEquals("visi essemus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i essetis", verb.getLatinEnding());
        assertEquals("visi essetis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("i essent", verb.getLatinEnding());
        assertEquals("visi essent", verb.getLatinVerb());

    }

// ======================= PASSIVE, SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());
    }



    // =========================== INFINITIVE, IMPERATIVE =======================================


    /**
     * testMakeVerbWordInfinitive()  - INFINITIVE
     * ==========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("videri", verb.getLatinStem());
        assertEquals("", verb.getLatinEnding());
        assertEquals("videri", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("um esse", verb.getLatinEnding());
        assertEquals("visum esse", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", verb.getLatinStem());
        assertEquals("urum esse", verb.getLatinEnding());
        assertEquals("visurum esse", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verb.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("re", verb.getLatinEnding());
        assertEquals("videre", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("videmini", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verb.getLatinStem());
        assertEquals(null, verb.getLatinEnding());
        assertEquals(null, verb.getLatinVerb());

    }

}
