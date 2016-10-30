package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.VerbDeponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN DEPONENT VERBS FOR ALL PERSONS, MOODS, VOICES, CONJUGATIONS
 * Created by snewnham on 22/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_Deponent_InstrumentTests {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbDeponent verbDeponent;

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
        verbDeponent = new VerbDeponent(id, databaseAccess);

        verbDeponent.setLatin_Type("Deponent");
        verbDeponent.setLatin_ConjNum(2);

        verbDeponent.setLatin_Present("videor");        // Participle Parts
        verbDeponent.setLatin_Infinitive("videri");
        verbDeponent.setLatin_Perfect(null);
        verbDeponent.setLatin_Participle("visus");

        verbDeponent.setLatin_Present_Stem("vid");     // Stems
        verbDeponent.setLatin_Present_SubjuncStem("videa");
        verbDeponent.setLatin_Infinitive_Stem("vide");
        verbDeponent.setLatin_Infinitive_PassiveStem("vider");
        verbDeponent.setLatin_Perfect_Stem(null);
        verbDeponent.setLatin_Participle_Stem("vis");

        verbDeponent.setEnglish_Infinitive("seem");    // English
        verbDeponent.setEnglish_Present_3rdPerson("seems");
        verbDeponent.setEnglish_Perfect("seemed");
        verbDeponent.setEnglish_Participle("seeming");

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
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("eor", verbDeponent.getLatinEnding());
        assertEquals("videor", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("eris", verbDeponent.getLatinEnding());
        assertEquals("videris", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("etur", verbDeponent.getLatinEnding());
        assertEquals("videtur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("emur", verbDeponent.getLatinEnding());
        assertEquals("videmur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("emini", verbDeponent.getLatinEnding());
        assertEquals("videmini", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("entur", verbDeponent.getLatinEnding());
        assertEquals("videntur", verbDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebar", verbDeponent.getLatinEnding());
        assertEquals("videbar", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebaris", verbDeponent.getLatinEnding());
        assertEquals("videbaris", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebatur", verbDeponent.getLatinEnding());
        assertEquals("videbatur", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebamur", verbDeponent.getLatinEnding());
        assertEquals("videbamur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebamini", verbDeponent.getLatinEnding());
        assertEquals("videbamini", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebantur", verbDeponent.getLatinEnding());
        assertEquals("videbantur", verbDeponent.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebor", verbDeponent.getLatinEnding());
        assertEquals("videbor", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("eberis", verbDeponent.getLatinEnding());
        assertEquals("videberis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebitur", verbDeponent.getLatinEnding());
        assertEquals("videbitur", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebimur", verbDeponent.getLatinEnding());
        assertEquals("videbimur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebimini", verbDeponent.getLatinEnding());
        assertEquals("videbimini", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vid", verbDeponent.getLatinStem());
        assertEquals("ebuntur", verbDeponent.getLatinEnding());
        assertEquals("videbuntur", verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us sum", verbDeponent.getLatinEnding());
        assertEquals("visus sum", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us es", verbDeponent.getLatinEnding());
        assertEquals("visus es", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us est", verbDeponent.getLatinEnding());
        assertEquals("visus est", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i sumus", verbDeponent.getLatinEnding());
        assertEquals("visi sumus", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i estis", verbDeponent.getLatinEnding());
        assertEquals("visi estis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i sunt", verbDeponent.getLatinEnding());
        assertEquals("visi sunt", verbDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us eram", verbDeponent.getLatinEnding());
        assertEquals("visus eram", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us eras", verbDeponent.getLatinEnding());
        assertEquals("visus eras", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us erat", verbDeponent.getLatinEnding());
        assertEquals("visus erat", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i eramus", verbDeponent.getLatinEnding());
        assertEquals("visi eramus", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i eratis", verbDeponent.getLatinEnding());
        assertEquals("visi eratis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i erant", verbDeponent.getLatinEnding());
        assertEquals("visi erant", verbDeponent.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us ero", verbDeponent.getLatinEnding());
        assertEquals("visus ero", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us eris", verbDeponent.getLatinEnding());
        assertEquals("visus eris", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us erit", verbDeponent.getLatinEnding());
        assertEquals("visus erit", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i erimus", verbDeponent.getLatinEnding());
        assertEquals("visi erimus", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i eritis", verbDeponent.getLatinEnding());
        assertEquals("visi eritis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i erunt", verbDeponent.getLatinEnding());
        assertEquals("visi erunt", verbDeponent.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

    }

    // ======================= ACTIVE, SUBJUNCTIVE ==================================


    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("r", verbDeponent.getLatinEnding());
        assertEquals("videar", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("ris", verbDeponent.getLatinEnding());
        assertEquals("videaris", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("tur", verbDeponent.getLatinEnding());
        assertEquals("videatur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("mur", verbDeponent.getLatinEnding());
        assertEquals("videamur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("mini", verbDeponent.getLatinEnding());
        assertEquals("videamini", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", verbDeponent.getLatinStem());
        assertEquals("ntur", verbDeponent.getLatinEnding());
        assertEquals("videantur", verbDeponent.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("r", verbDeponent.getLatinEnding());
        assertEquals("viderir", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("ris", verbDeponent.getLatinEnding());
        assertEquals("videriris", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("tur", verbDeponent.getLatinEnding());
        assertEquals("videritur", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("mur", verbDeponent.getLatinEnding());
        assertEquals("viderimur", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("mini", verbDeponent.getLatinEnding());
        assertEquals("viderimini", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videri", verbDeponent.getLatinStem());
        assertEquals("ntur", verbDeponent.getLatinEnding());
        assertEquals("viderintur", verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us sim", verbDeponent.getLatinEnding());
        assertEquals("visus sim", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us sis", verbDeponent.getLatinEnding());
        assertEquals("visus sis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us sit", verbDeponent.getLatinEnding());
        assertEquals("visus sit", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i simus", verbDeponent.getLatinEnding());
        assertEquals("visi simus", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i sitis", verbDeponent.getLatinEnding());
        assertEquals("visi sitis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i sint", verbDeponent.getLatinEnding());
        assertEquals("visi sint", verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us essem", verbDeponent.getLatinEnding());
        assertEquals("visus essem", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us esses", verbDeponent.getLatinEnding());
        assertEquals("visus esses", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us esset", verbDeponent.getLatinEnding());
        assertEquals("visus esset", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i essemus", verbDeponent.getLatinEnding());
        assertEquals("visi essemus", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i essetis", verbDeponent.getLatinEnding());
        assertEquals("visi essetis", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("i essent", verbDeponent.getLatinEnding());
        assertEquals("visi essent", verbDeponent.getLatinVerb());

    }

// ======================= PASSIVE, SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);
        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());
    }



    // =========================== INFINITIVE, IMPERATIVE =======================================


    /**
     * testMakeVerbWordInfinitive()  - INFINITIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vider", verbDeponent.getLatinStem());
        assertEquals("i", verbDeponent.getLatinEnding());
        assertEquals("videri", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("us esse", verbDeponent.getLatinEnding());
        assertEquals("visus esse", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", verbDeponent.getLatinStem());
        assertEquals("um iri", verbDeponent.getLatinEnding());
        assertEquals("visum iri", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", verbDeponent.getLatinStem());
        assertEquals("re", verbDeponent.getLatinEnding());
        assertEquals("videre", verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", verbDeponent.getLatinStem());
        assertEquals("mini", verbDeponent.getLatinEnding());
        assertEquals("videmini", verbDeponent.getLatinVerb());


        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

        verbDeponent.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, verbDeponent.getLatinStem());
        assertEquals(null, verbDeponent.getLatinEnding());
        assertEquals(null, verbDeponent.getLatinVerb());

    }

}
