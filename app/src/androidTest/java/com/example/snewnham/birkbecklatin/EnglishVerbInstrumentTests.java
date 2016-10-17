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

    String numberSingular;
    String numberPlural;

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

        numberSingular = "Singular";
        numberPlural = "Plural";

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
    }

    // ==========================  ACTIVE, INDICATIVE  ================================================

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




}
