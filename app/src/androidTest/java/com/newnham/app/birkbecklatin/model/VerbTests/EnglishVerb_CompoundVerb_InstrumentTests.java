package com.newnham.app.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ENGLISH COMPOUND VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerb_CompoundVerb_InstrumentTests {

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

        mVerbRegular.setLatin_Type("Regular");
        mVerbRegular.setLatin_ConjNum(2);

        mVerbRegular.setLatin_Present("taceo");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("tacere");
        mVerbRegular.setLatin_Perfect("tacui");
        mVerbRegular.setLatin_Participle("tacitus");

        mVerbRegular.setLatin_Present_Stem("tac");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("tace");
        mVerbRegular.setLatin_Infinitive_PassiveStem("tacer");
        mVerbRegular.setLatin_Present_SubjuncStem("tacea");
        mVerbRegular.setLatin_Perfect_Stem("tacu");
        mVerbRegular.setLatin_Participle_Stem("tacit");

        mVerbRegular.setEnglish_Infinitive("be silent");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("silent");
        mVerbRegular.setEnglish_Perfect("silent");
        mVerbRegular.setEnglish_Participle("silent");

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" am ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I am silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) are silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" is ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she is silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we are silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) are silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they are silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" was being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I was being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" was being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she was being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they were being silent", mVerbRegular.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will be silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" has been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she has been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they have been silent", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they had been silent", mVerbRegular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will have been silent", mVerbRegular.getEnglishVerb());

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" am being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I am being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" are being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) are being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" is being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she is being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" are being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we are being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" are being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) are being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" are being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they are being silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" was being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I was being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" was being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she was being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) were being silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they were being silent", mVerbRegular.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will be silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" has been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she has been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they have been silent", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) had been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they had been silent", mVerbRegular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will have been silent", mVerbRegular.getEnglishVerb());

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May I be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May I be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(s) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(s) be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May he/she be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May he/she be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("Let us be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("Let us be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(pl) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(pl) be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May they be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May they be silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would be silent", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they may have been silent", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would have been silent", mVerbRegular.getEnglishVerb());
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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May I be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May I be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(s) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(s) be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May he/she be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May he/she be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("Let us be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("Let us be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(pl) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(pl) be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May they be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May they be silent", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would be silent", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) may have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they may have been silent", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would have been silent", mVerbRegular.getEnglishVerb());
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

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be going to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be going to be silent", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to have been silent", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be going to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("silent", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be going to be silent", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbImperative()  - MOOD_IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("be silent", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("be silent", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("be silent", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("be silent", mVerbRegular.getEnglishVerb());

    }


}
