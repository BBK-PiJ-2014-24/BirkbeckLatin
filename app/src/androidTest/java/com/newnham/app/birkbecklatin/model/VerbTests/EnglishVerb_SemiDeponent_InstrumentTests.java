package com.newnham.app.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.verbs.VerbSemiDeponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING ENGLISH VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 15/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EnglishVerb_SemiDeponent_InstrumentTests {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    int id;
    VerbSemiDeponent verbSemiDeponent;
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

        id = 3;
        verbSemiDeponent = new VerbSemiDeponent(id);
        verbSemiDeponent.setLatin_Type("Semi Deponent");
        verbSemiDeponent.setLatin_ConjNum(2);

        verbSemiDeponent.setLatin_Present("gaudeo");        // Participle Parts
        verbSemiDeponent.setLatin_Infinitive("gaudere");
        verbSemiDeponent.setLatin_Perfect(null);
        verbSemiDeponent.setLatin_Participle("gavisus");

        verbSemiDeponent.setLatin_Present_Stem("gaud");     // Stems
        verbSemiDeponent.setLatin_Present_SubjuncStem("gaudea");
        verbSemiDeponent.setLatin_Infinitive_Stem("gaude");
        verbSemiDeponent.setLatin_Infinitive_PassiveStem("gauder");
        verbSemiDeponent.setLatin_Perfect_Stem(null);
        verbSemiDeponent.setLatin_Participle_Stem("gavis");

        verbSemiDeponent.setEnglish_Infinitive("rejoice");    // English
        verbSemiDeponent.setEnglish_Present_3rdPerson("rejoices");
        verbSemiDeponent.setEnglish_Perfect("rejoiced");
        verbSemiDeponent.setEnglish_Participle("rejoicing");

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

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoices", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she rejoices", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they rejoice", verbSemiDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" was ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I was rejoicing", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" were ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) were rejoicing", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" was ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she was rejoicing", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" were ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we were rejoicing", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" were ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) were rejoicing", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" were ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoicing", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they were rejoicing", verbSemiDeponent.getEnglishVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" shall ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I shall rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) will rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she will rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" shall ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we shall rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) will rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they will rejoice", verbSemiDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" has ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she has rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they have rejoiced", verbSemiDeponent.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I had rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) had rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she had rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we had rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) had rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" had ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they had rejoiced", verbSemiDeponent.getEnglishVerb());
    }


    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" shall have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I shall have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) will have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she will have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" shall have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we shall have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) will have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" will have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they will have rejoiced", verbSemiDeponent.getEnglishVerb());

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

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordImperfectPassiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }



    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );
    }



    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseFuturePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

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

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("May I ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("May I rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("May you(s) ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("May you(s) rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("May he/she ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("May he/she rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("Let us ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("Let us rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("May you(pl) ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("May you(pl) rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("May they ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("May they rejoice", verbSemiDeponent.getEnglishVerb());

    }


    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I would rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) would rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she would rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we would rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) would rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they would rejoice", verbSemiDeponent.getEnglishVerb());

    }

    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I may have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) may have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she may have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we may have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) may have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" may have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they may have rejoiced", verbSemiDeponent.getEnglishVerb());
    }



    /**
     * testMakeVerbWordPluperfectActiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("I", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("I would have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(s)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(s) would have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("he/she", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("he/she would have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("we", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("we would have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("you(pl)", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("you(pl) would have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voiceActive);

        assertEquals("they", verbSemiDeponent.getEnglishPerson());
        assertEquals(" would have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("they would have rejoiced", verbSemiDeponent.getEnglishVerb());
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

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePresent, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }


    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );;

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tenseImPerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }

    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePerfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );
    }



    /**
     * testMakeVerbWordPluperfectPassiveSubjunctive()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberSingular,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person1, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person2, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, person3, numberPlural,
                tensePluperfect, moodSubjunctive, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );
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

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("to ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("to rejoice", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("to have ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoiced", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("to have rejoiced", verbSemiDeponent.getEnglishVerb());

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("to be going to ", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("to be going to rejoice", verbSemiDeponent.getEnglishVerb());


        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePresent, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tensePerfect, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberInfinitive,
                tenseFuture, moodIndicative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }

    /**
     * testMakeVerbImperative()  - MOOD_IMPERATIVE
     * ========================
     * test VerbRegular Class that It Can build Correct ENGLISH VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerb());


        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voiceActive);

        assertEquals("", verbSemiDeponent.getEnglishPerson());
        assertEquals("", verbSemiDeponent.getEnglishAuxiliaryVerb());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerbEnding());
        assertEquals("rejoice", verbSemiDeponent.getEnglishVerb());


        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberSingular,
                tenseNull, moodImperative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );


        verbSemiDeponent.makeEnglishVerb(databaseAccess, personNull, numberPlural,
                tenseNull, moodImperative, voicePassive);

        assertEquals( null, verbSemiDeponent.getEnglishPerson() );
        assertEquals( null, verbSemiDeponent.getEnglishAuxiliaryVerb() );
        assertEquals( null, verbSemiDeponent.getEnglishVerbEnding() );
        assertEquals( null, verbSemiDeponent.getEnglishVerb() );

    }


}
