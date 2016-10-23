package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.VerbRegular;

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
    VerbRegular mVerbRegular;

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
        mVerbRegular = new VerbRegular(id, databaseAccess);

        mVerbRegular.setLatin_Type("Deponent");
        mVerbRegular.setLatin_ConjNum(2);

        mVerbRegular.setLatin_Present("videor");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("videri");
        mVerbRegular.setLatin_Perfect(null);
        mVerbRegular.setLatin_Participle("visus");

        mVerbRegular.setLatin_Present_Stem("vide");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("vide");
        mVerbRegular.setLatin_Infinitive_PassiveStem("vider");
        mVerbRegular.setLatin_Infinitive_StemMod(null);
        mVerbRegular.setLatin_Perfect_Stem(null);
        mVerbRegular.setLatin_Participle_Stem("vis");

        mVerbRegular.setEnglish_Infinitive("seem");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("seems");
        mVerbRegular.setEnglish_Perfect("seemed");
        mVerbRegular.setEnglish_Participle("seeming");

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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("or", mVerbRegular.getLatinEnding());
        assertEquals("videor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("videris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("videtur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("videmur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("videmini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("videntur", mVerbRegular.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bar", mVerbRegular.getLatinEnding());
        assertEquals("videbar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("baris", mVerbRegular.getLatinEnding());
        assertEquals("videbaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("batur", mVerbRegular.getLatinEnding());
        assertEquals("videbatur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bamur", mVerbRegular.getLatinEnding());
        assertEquals("videbamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bamini", mVerbRegular.getLatinEnding());
        assertEquals("videbamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bantur", mVerbRegular.getLatinEnding());
        assertEquals("videbantur", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bor", mVerbRegular.getLatinEnding());
        assertEquals("videbor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("beris", mVerbRegular.getLatinEnding());
        assertEquals("videberis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bitur", mVerbRegular.getLatinEnding());
        assertEquals("videbitur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bimur", mVerbRegular.getLatinEnding());
        assertEquals("videbimur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("bimini", mVerbRegular.getLatinEnding());
        assertEquals("videbimini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("buntur", mVerbRegular.getLatinEnding());
        assertEquals("videbuntur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us sum", mVerbRegular.getLatinEnding());
        assertEquals("visus sum", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us es", mVerbRegular.getLatinEnding());
        assertEquals("visus es", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us et", mVerbRegular.getLatinEnding());
        assertEquals("visus et", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("visi sumus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("visi estis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("visi sunt", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us eram", mVerbRegular.getLatinEnding());
        assertEquals("visus eram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us eras", mVerbRegular.getLatinEnding());
        assertEquals("visus eras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us erat", mVerbRegular.getLatinEnding());
        assertEquals("us erat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i eramus", mVerbRegular.getLatinEnding());
        assertEquals("visi eramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i eratis", mVerbRegular.getLatinEnding());
        assertEquals("visi eratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i erant", mVerbRegular.getLatinEnding());
        assertEquals("visi erant", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us ero", mVerbRegular.getLatinEnding());
        assertEquals("visus ero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us eris", mVerbRegular.getLatinEnding());
        assertEquals("visus eris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us erit", mVerbRegular.getLatinEnding());
        assertEquals("visus erit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i erimus", mVerbRegular.getLatinEnding());
        assertEquals("visi erimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i eritis", mVerbRegular.getLatinEnding());
        assertEquals("visi eritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i erint", mVerbRegular.getLatinEnding());
        assertEquals("visi erunt", mVerbRegular.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("videar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("videaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("videatur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("videamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("videamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videa", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("videantur", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("viderer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("videreris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("moneret", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("videremur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("videremini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("videre", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("viderentur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us sim", mVerbRegular.getLatinEnding());
        assertEquals("visus sim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us sis", mVerbRegular.getLatinEnding());
        assertEquals("visus sis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us sit", mVerbRegular.getLatinEnding());
        assertEquals("visus sit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i simus", mVerbRegular.getLatinEnding());
        assertEquals("visi simus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i sitis", mVerbRegular.getLatinEnding());
        assertEquals("visi sitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i sint", mVerbRegular.getLatinEnding());
        assertEquals("visi sint", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us essem", mVerbRegular.getLatinEnding());
        assertEquals("visus essem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us esses", mVerbRegular.getLatinEnding());
        assertEquals("visus esses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("us esset", mVerbRegular.getLatinEnding());
        assertEquals("visu esset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i essemus", mVerbRegular.getLatinEnding());
        assertEquals("visi essemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i essetis", mVerbRegular.getLatinEnding());
        assertEquals("visi essetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("i essent", mVerbRegular.getLatinEnding());
        assertEquals("visi essent", mVerbRegular.getLatinVerb());

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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());
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

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("videri", mVerbRegular.getLatinStem());
        assertEquals("", mVerbRegular.getLatinEnding());
        assertEquals("videri", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("um esse", mVerbRegular.getLatinEnding());
        assertEquals("visum esse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("vis", mVerbRegular.getLatinStem());
        assertEquals("urum esse", mVerbRegular.getLatinEnding());
        assertEquals("visurum esse", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("re", mVerbRegular.getLatinEnding());
        assertEquals("videre", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("vide", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("videmini", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbRegular.getLatinStem());
        assertEquals(null, mVerbRegular.getLatinEnding());
        assertEquals(null, mVerbRegular.getLatinVerb());

    }

}
