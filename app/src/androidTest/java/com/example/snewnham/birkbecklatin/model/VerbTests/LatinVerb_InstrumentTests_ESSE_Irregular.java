package com.example.snewnham.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbIrregular;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES, 3rd COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_ESSE_Irregular {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbRegular mVerbEsse;

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
        mVerbEsse = new VerbIrregular(id, databaseAccess);

        mVerbEsse.setLatin_Type("Irregular");

        mVerbEsse.setLatin_Present("sum");        // Participle Parts
        mVerbEsse.setLatin_Infinitive("esse");
        mVerbEsse.setLatin_Perfect("fui");
        mVerbEsse.setLatin_Participle("futurus");


        mVerbEsse.setEnglish_Infinitive("be");    // English
        mVerbEsse.setEnglish_Present_3rdPerson("is");
        mVerbEsse.setEnglish_Perfect("been");
        mVerbEsse.setEnglish_Participle("being");

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

    // ==========================  VOICE_ACTIVE, MOOD_INDICATIVE  ================================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - TENSE_PRESENT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum4);

        assertEquals("sum", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("es", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("est", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("sumus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("estis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("sunt", mVerbEsse.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eram", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eras", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("erat", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eramus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eratis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("erant", mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("ero", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eris", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("erit", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("erimus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("eritis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("erunt", mVerbEsse.getLatinVerb());
    }

    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fui", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuisti", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuit", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuimus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuistis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerunt", mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueram", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueras", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerat", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueramus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueratis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerant", mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - TENSE_FUTURE-TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuero", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueris", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerit", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerimus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fueritis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("fuerint", mVerbEsse.getLatinVerb());
    }

// ============================== VOICE_PASSIVE, MOOD_INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - TENSE_PRESENT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }

    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }

    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE-TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

    }

    // ======================= VOICE_ACTIVE, MOOD_SUBJUNCTIVE ==================================

    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - TENSE_PRESENT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("sim", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("sis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("sit", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("simus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("sitis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("sint", mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("essem", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("esses", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("esset", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("essemus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("essetis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("essent", mVerbEsse.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuerim", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fueris", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuerit", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuerimus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fueritis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuerint", mVerbEsse.getLatinVerb());
    }

    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuissem", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuisses", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuisset", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuissemus", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuissetis", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("fuissent", mVerbEsse.getLatinVerb());

    }

// ======================= VOICE_PASSIVE, MOOD_SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - TENSE_PRESENT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbEsse.getLatinVerb());
    }

    // =========================== INFINITIVE, MOOD_IMPERATIVE =======================================

    /**
     * testMakeVerbWordInfinitive()  - INFINITIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("esse", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("fuisse", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("futurus esse", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbEsse.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - MOOD_IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("es, esto", mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("este", mVerbEsse.getLatinVerb());


        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbEsse.getLatinVerb());

        mVerbEsse.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbEsse.getLatinVerb());

    }

}
