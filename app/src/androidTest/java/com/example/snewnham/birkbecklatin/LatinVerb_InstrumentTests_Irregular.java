package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.VerbIrregular;
import com.example.snewnham.birkbecklatin.Model.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES, 3rd COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_Irregular {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbIrregular mVerbIrregular;

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
        mVerbIrregular = new VerbIrregular(id, databaseAccess);

        mVerbIrregular.setLatin_Type("Irregular");

        mVerbIrregular.setLatin_Present("malo");        // Participle Parts
        mVerbIrregular.setLatin_Infinitive("malle");
        mVerbIrregular.setLatin_Perfect("malle");
        mVerbIrregular.setLatin_Participle("malui");


        mVerbIrregular.setEnglish_Infinitive("prefer");    // English
        mVerbIrregular.setEnglish_Present_3rdPerson("prefers");
        mVerbIrregular.setEnglish_Perfect("preferred");
        mVerbIrregular.setEnglish_Participle("preferring");

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

    // ==========================  ACTIVE, INDICATIVE  ================================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum4);

        assertEquals("malo", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("mavis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("mavult", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malumus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malvultis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malunt", mVerbIrregular.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebam", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebas", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebat", mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebamus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebatis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malebant", mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malam", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("males", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malet", mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malemus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maletis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malent", mVerbIrregular.getLatinVerb());
    }

    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malui", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluisti", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluit", mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluimus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluistis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerunt", mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueram", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueras", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerat", mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueramus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueratis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerant", mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluero", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueris", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerit", mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerimus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("malueritis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum4);

        assertEquals("maluerint", mVerbIrregular.getLatinVerb());
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


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }

    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }

    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

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


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malim", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malit", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malimus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malitis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malint", mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("mallem", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malles", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("mallet", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("mallemus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malletis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("mallent", mVerbIrregular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluerim", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malueris", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluerit", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluerimus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("malueritis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluerint", mVerbIrregular.getLatinVerb());
    }

    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluissem", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluisses", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluisset", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluissemus", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluissetis", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum4);

        assertEquals("maluissent", mVerbIrregular.getLatinVerb());

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


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum4);

        assertEquals(null, mVerbIrregular.getLatinVerb());
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

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("malle", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("maluisse", mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());


        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

        mVerbIrregular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals(null, mVerbIrregular.getLatinVerb());

    }

}
