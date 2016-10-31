package com.example.snewnham.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ENGLISH VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerb_Regular_InstrumentTests {

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

        mVerbRegular.setLatin_Present("moneo");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("monere");
        mVerbRegular.setLatin_Perfect("monui");
        mVerbRegular.setLatin_Participle("monitus");

        mVerbRegular.setLatin_Present_Stem("mon");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("mone");
        mVerbRegular.setLatin_Infinitive_PassiveStem("moner");
        mVerbRegular.setLatin_Present_SubjuncStem("monea");
        mVerbRegular.setLatin_Perfect_Stem("monu");
        mVerbRegular.setLatin_Participle_Stem("monit");

        mVerbRegular.setEnglish_Infinitive("warn, advise");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("warns, advises");
        mVerbRegular.setEnglish_Perfect("warned, advised");
        mVerbRegular.setEnglish_Participle("warning, advising");

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warns, advises", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she warns, advises", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they warn, advise", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" was ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I was warning, advising", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" were ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) were warning, advising", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" was ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she was warning, advising", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" were ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we were warning, advising", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" were ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) were warning, advising", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" were ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they were warning, advising", mVerbRegular.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will warn, advise", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" has ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she has warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they have warned, advised", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I had warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) had warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she had warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we had warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) had warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" had ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they had warned, advised", mVerbRegular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will have warned, advised", mVerbRegular.getEnglishVerb());

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" am ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I am warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) are warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" is ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she is warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we are warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) are warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" are ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they are warned, advised", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I was being warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) were being warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" was being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she was being warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we were being warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) were being warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" were being ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they were being warned, advised", mVerbRegular.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will be warned, advised", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" has been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she has been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they have been warned, advised", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, INDICATIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I had been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) had been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she had been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we had been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) had been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" had been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they had been warned, advised", mVerbRegular.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE PERFECT TENSE, PASSIVE, INDICATIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I shall have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) will have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she will have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" shall have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we shall have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) will have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" will have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they will have been warned, advised", mVerbRegular.getEnglishVerb());

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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May I ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May I warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(s) ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(s) warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May he/she ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May he/she warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("Let us ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("Let us warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(pl) ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(pl) warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May they ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May they warn, advise", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would warn, advise", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I may have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) may have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she may have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we may have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) may have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" may have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they may have warned, advised", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would have warned, advised", mVerbRegular.getEnglishVerb());
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

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May I be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May I be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(s) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(s) be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May he/she be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May he/she be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("Let us be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("Let us be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May you(pl) be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May you(pl) be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("May they be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("May they be warned, advised", mVerbRegular.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would be warned, advised", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I may have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) may have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she may have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we may have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) may have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" may have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they may have been warned, advised", mVerbRegular.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
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
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("I would have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(s) would have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("he/she would have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("we", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("we would have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("you(pl) would have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("they", mVerbRegular.getEnglishPerson());
        assertEquals(" would have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("they would have been warned, advised", mVerbRegular.getEnglishVerb());
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
        assertEquals("to ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to warn, advise", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to have ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to have warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be going to ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be going to warn, advise", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to have been ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to have been warned, advised", mVerbRegular.getEnglishVerb());

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("to be going to be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("to be going to be warned, advised", mVerbRegular.getEnglishVerb());

    }

    /**
     * testMakeVerbImperative()  - IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerbEnding());
        assertEquals("warn, advise", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("be warned, advised", mVerbRegular.getEnglishVerb());


        mVerbRegular.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals("", mVerbRegular.getEnglishPerson());
        assertEquals("be ", mVerbRegular.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", mVerbRegular.getEnglishVerbEnding());
        assertEquals("be warned, advised", mVerbRegular.getEnglishVerb());

    }


}
