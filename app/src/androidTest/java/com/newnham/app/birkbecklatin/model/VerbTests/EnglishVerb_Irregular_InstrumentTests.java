package com.newnham.app.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.verbs.VerbIrregular;

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

    // ==========================  VOICE_ACTIVE, MOOD_INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - TENSE_PRESENT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I prefer", mVerbIrregular.getEnglishVerb());

        assertEquals(tensePresent, mVerbIrregular.getTense());
        assertEquals(moodIndicative, mVerbIrregular.getMood());
        assertEquals(voiceActive, mVerbIrregular.getVoice());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefers", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she prefers", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they prefer", mVerbIrregular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" was ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I was preferring", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" were ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) were preferring", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" was ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she was preferring", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" were ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we were preferring", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" were ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) were preferring", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" were ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferring", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they were preferring", mVerbIrregular.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" shall ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I shall prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" will ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) will prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" will ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she will prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" shall ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we shall prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" will ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) will prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" will ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they will prefer", mVerbIrregular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" has ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she has preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they have preferred", mVerbIrregular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I had preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) had preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she had preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we had preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) had preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" had ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they had preferred", mVerbIrregular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" shall have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I shall have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" will have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) will have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" will have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she will have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" shall have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we shall have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" will have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) will have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" will have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they will have preferred", mVerbIrregular.getEnglishVerb());

    }

    // ==========================  VOICE_PASSIVE, MOOD_INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveIndicative()  - TENSE_PRESENT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }
// ==========================  VOICE_ACTIVE, MOOD_SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - TENSE_PRESENT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("May I ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("May I prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("May you(s) ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("May you(s) prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("May he/she ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("May he/she prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("Let us ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("Let us prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("May you(pl) ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("May you(pl) prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("May they ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("May they prefer", mVerbIrregular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I would prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) would prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she would prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we would prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) would prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" would ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they would prefer", mVerbIrregular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I may have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) may have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she may have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we may have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) may have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" may have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they may have preferred", mVerbIrregular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("I would have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(s) would have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("he/she would have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("we would have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("you(pl) would have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbIrregular.getEnglishPerson());
        assertEquals(" would have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("they would have preferred", mVerbIrregular.getEnglishVerb());
    }


    // ==========================  VOICE_PASSIVE, MOOD_SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - TENSE_PRESENT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());
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

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("to ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("prefer", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("to prefer", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", mVerbIrregular.getEnglishPerson());
        assertEquals("to have ", mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals("preferred", mVerbIrregular.getEnglishVerbEnding());
        assertEquals("to have preferred", mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());


        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }

    /**
     * testMakeVerbImperative()  - MOOD_IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());


        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());


        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());


        mVerbIrregular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals(null, mVerbIrregular.getEnglishPerson());
        assertEquals(null, mVerbIrregular.getEnglishAuxiliaryVerb());
        assertEquals(null, mVerbIrregular.getEnglishVerbEnding());
        assertEquals(null, mVerbIrregular.getEnglishVerb());

    }


}
