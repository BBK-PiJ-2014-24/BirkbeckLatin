package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.VerbIrregular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ENGLISH VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerb_Irregular_InstrumentTests {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbIrregular mVerbEsse;

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

    // ==========================  ACTIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("am", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I am", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("are", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) are", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("is", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she is", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("are", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we are", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("are", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) are", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("are", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they are", mVerbEsse.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" was ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I was ", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" were ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) were ", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" was ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she was ", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" were ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we were ", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" were ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) were ", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" were ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they were ", mVerbEsse.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" shall ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I shall be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" will ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) will be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" will ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she will be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" shall ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we shall be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" will ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) will be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" will ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they will be", mVerbEsse.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" has ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she has been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they have been", mVerbEsse.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I had been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) had been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she had been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we had been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) had been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" had ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they had been", mVerbEsse.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" shall have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I shall have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" will have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) will have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" will have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she will have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" shall have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we shall have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" will have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) will have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" will have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they will have been", mVerbEsse.getEnglishVerb());

    }

    // ==========================  PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }
// ==========================  ACTIVE, SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("May I ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("May I be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("May you(s) ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("May you(s) be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("May he/she ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("May he/she be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("Let us ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("Let us be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("May you(pl) ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("May you(pl) be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("May they ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("May they be", mVerbEsse.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I would be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) would be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she would be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we would be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) would be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" would ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they would be", mVerbEsse.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I may have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) may have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she may have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we may have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) may have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" may have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they may have been", mVerbEsse.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("I would have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(s) would have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("he/she would have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("we would have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("you(pl) would have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbEsse.getEnglishPerson());
        assertEquals(" would have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("they would have been", mVerbEsse.getEnglishVerb());
    }


    // ==========================  PASSIVE, SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());
    }


    //============================= INFINITIVES, IMPERATIVES ==============================================


    /**
     * testMakeVerbInfinitive()  - INFINITIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("to ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("to be", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("to have ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("been", mVerbEsse.getEnglishVerbEnding());
        assertEquals("to have been", mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("to be going to ", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("to be going to be", mVerbEsse.getEnglishVerb());


        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }

    /**
     * testMakeVerbImperative()  - IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("be", mVerbEsse.getEnglishVerb());


        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbEsse.getEnglishPerson());
        assertEquals("", mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals("be", mVerbEsse.getEnglishVerbEnding());
        assertEquals("be", mVerbEsse.getEnglishVerb());


        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());


        mVerbEsse.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals(null, mVerbEsse.getEnglishPerson());
        assertEquals(null, mVerbEsse.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbEsse.getEnglishVerbEnding());
        assertEquals(null, mVerbEsse.getEnglishVerb());

    }


}
