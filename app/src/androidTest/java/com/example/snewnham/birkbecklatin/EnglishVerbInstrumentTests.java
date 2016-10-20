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
 * TESTS FOR CREATING ENGLISH VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerbInstrumentTests {

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

        verb.setLatin_Type("Regular");
        verb.setLatin_ConjNum(2);

        verb.setLatin_Present("moneo");        // Participle Parts
        verb.setLatin_Infinitive("monere");
        verb.setLatin_Perfect("monui");
        verb.setLatin_Participle("monitus");

        verb.setLatin_Present_Stem("mon");     // Stems
        verb.setLatin_Infinitive_Stem("moner");
        verb.setLatin_Infinitive_StemMod("monea");
        verb.setLatin_Perfect_Stem("monu");
        verb.setLatin_Participle_Stem("monit");

        verb.setEnglish_Infinitive("warn, advise");    // English
        verb.setEnglish_Present_3rdPerson("warns, advises");
        verb.setEnglish_Perfect("warned, advised");
        verb.setEnglish_Participle("warning, advising");

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
        moodImperative = "Subjunctive";

        voiceActive = "Active";
        voicePassive = "Passive";

        tensePresent = "Present";
        tenseImPerfect = "Imperfect";
        tenseFuture = "Future";
        tensePerfect = "Perfect";
        tensePluperfect = "Pluperfect";
        tenseFuturePerfect = "Future Perfect";

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
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("I warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(s) warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warns, advises", verb.getEnglishVerbEnding());
        assertEquals("he/she warns, advises", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("we warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(pl) warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("they warn, advise", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" was ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("I was warning, advising", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" were ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("you(s) were warning, advising", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" was ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("he/she was warning, advising", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" were ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("we were warning, advising", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" were ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("you(pl) were warning, advising", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" were ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warning, advising", verb.getEnglishVerbEnding());
        assertEquals("they were warning, advising", verb.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" shall ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("I shall warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" will ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(s) will warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" will ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("he/she will warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" shall ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("we shall warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" will ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(pl) will warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" will ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("they will warn, advise", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" has ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she has warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they have warned, advised", verb.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I had warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) had warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she had warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we had warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) had warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" had ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they had warned, advised", verb.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" shall have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I shall have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" will have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) will have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" will have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she will have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" shall have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we shall have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" will have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) will have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they will have warned, advised", verb.getEnglishVerb());

    }

    // ==========================  PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" am ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I am warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" are ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) are warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" is ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she is warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" are ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we are warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" are ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) are warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" are ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they are warned, advised", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" was being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I was being warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" were being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) were being warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" was being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she was being warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" were being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we were being warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" were being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) were being warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" were being ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they were being warned, advised", verb.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" shall be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I shall be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" will be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) will be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" will be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she will be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" shall be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we shall be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" will be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) will be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" will be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they will be warned, advised", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" has been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she has been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they have been warned, advised", verb.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I had been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) had been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she had been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we had been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) had been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" had been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they had been warned, advised", verb.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" shall have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I shall have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" will have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) will have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" will have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she will have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" shall have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we shall have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" will have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) will have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" will have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they will have been warned, advised", verb.getEnglishVerb());

    }
// ==========================  ACTIVE, SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May I ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("May I warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May you(s) ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("May you(s) warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May he/she ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("May he/she warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("Let us ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("Let us warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May you(pl) ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("May you(pl) warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May they ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("May they warn, advise", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("I would warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(s) would warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("he/she would warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("we would warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("you(pl) would warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" would ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("they would warn, advise", verb.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I may have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) may have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she may have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we may have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) may have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" may have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they may have warned, advised", verb.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I would have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) would have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she would have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we would have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) would have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" would have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they would have warned, advised", verb.getEnglishVerb());
    }


    // ==========================  PASSIVE, SUBJUNCTIVE  =============================================

    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May I be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("May I be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May you(s) be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("May you(s) be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May he/she be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("May he/she be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("Let us be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("Let us be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May you(pl) be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("May you(pl) be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("May they be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("May they be warned, advised", verb.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I would be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) would be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she would be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we would be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) would be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" would be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they would be warned, advised", verb.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I may have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) may have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she may have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we may have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) may have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" may have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they may have been warned, advised", verb.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("I", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("I would have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(s)", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(s) would have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("he/she", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("he/she would have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("we", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("we would have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("you(pl)", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("you(pl) would have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals("they", verb.getEnglishPerson());
        assertEquals(" would have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("they would have been warned, advised", verb.getEnglishVerb());
    }


    //============================= INFINITIVES ==============================================


    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - INFINITIVE
     * =========================================
     * test Verb Class that It Can build Correct ENGLISH Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("to warn, advise", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to have ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("to have warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to be going to ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warn, advise", verb.getEnglishVerbEnding());
        assertEquals("to be going to warn, advise", verb.getEnglishVerb());


        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("to be warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to have been ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("to have been warned, advised", verb.getEnglishVerb());

        verb.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals("", verb.getEnglishPerson());
        assertEquals("to be going to be ", verb.getEnglishAuxiliaryVerb());
        assertEquals("warned, advised", verb.getEnglishVerbEnding());
        assertEquals("to be going to be warned, advised", verb.getEnglishVerb());

    }


}
