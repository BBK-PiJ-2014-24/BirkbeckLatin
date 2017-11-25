package com.newnham.app.GCSE_Latin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.verbs.VerbDeponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ENGLISH VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerb_DeponentInstrumentTests {

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

    // ==========================  VOICE_ACTIVE, MOOD_INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - TENSE_PRESENT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("I seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seems", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she seems", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("we seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("they seem", verbDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" was ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("I was seeming", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" were ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) were seeming", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" was ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she was seeming", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" were ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("we were seeming", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" were ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) were seeming", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" were ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seeming", verbDeponent.getEnglishVerbEnding());
        assertEquals("they were seeming", verbDeponent.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" shall ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("I shall seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" will ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) will seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" will ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she will seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" shall ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("we shall seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" will ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) will seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" will ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("they will seem", verbDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("I have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" has ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she has seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("we have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("they have seemed", verbDeponent.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("I had seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) had seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she had seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("we had seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) had seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" had ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("they had seemed", verbDeponent.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" shall have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("I shall have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" will have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) will have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" will have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she will have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" shall have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("we shall have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" will have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) will have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("they will have seemed", verbDeponent.getEnglishVerb());

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

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

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

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("May I ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("May I seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("May you(s) ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("May you(s) seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("May he/she ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("May he/she seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("Let us ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("Let us seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("May you(pl) ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("May you(pl) seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("May they ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("May they seem", verbDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("I would seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) would seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she would seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("we would seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) would seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" would ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("they would seem", verbDeponent.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("I may have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) may have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she may have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("we may have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) may have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" may have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("they may have seemed", verbDeponent.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("I would have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(s) would have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("he/she would have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("we would have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) would have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbDeponent.getEnglishPerson());
        assertEquals(" would have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("they would have seemed", verbDeponent.getEnglishVerb());
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

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );;

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );
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

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("to ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("to seem", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("to have ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seemed", verbDeponent.getEnglishVerbEnding());
        assertEquals("to have seemed", verbDeponent.getEnglishVerb());

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("to be going to ", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("to be going to seem", verbDeponent.getEnglishVerb());


        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }

    /**
     * testMakeVerbImperative()  - MOOD_IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("seem", verbDeponent.getEnglishVerb());


        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", verbDeponent.getEnglishPerson());
        assertEquals("", verbDeponent.getEnglishAuxiliaryVerb());
        assertEquals("seem", verbDeponent.getEnglishVerbEnding());
        assertEquals("seem", verbDeponent.getEnglishVerb());


        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );


        verbDeponent.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals( null, verbDeponent.getEnglishPerson() );
        assertEquals( null, verbDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbDeponent.getEnglishVerb() );

    }


}
