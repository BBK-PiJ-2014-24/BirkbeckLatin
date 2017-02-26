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
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES, 3rd COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_3rd_io_Conj {


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
    String conjNum31;
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
        mVerbRegular.setLatin_ConjNum(31);

        mVerbRegular.setLatin_Present("capio");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("capere");
        mVerbRegular.setLatin_Perfect("cepi");
        mVerbRegular.setLatin_Participle("captus");

        mVerbRegular.setLatin_Present_Stem("cap");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("cape");
        mVerbRegular.setLatin_Infinitive_PassiveStem("cap");
        mVerbRegular.setLatin_Present_SubjuncStem("capia");
        mVerbRegular.setLatin_Perfect_Stem("cep");
        mVerbRegular.setLatin_Participle_Stem("capt");

        mVerbRegular.setEnglish_Infinitive("take, capture");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("takes, captures");
        mVerbRegular.setEnglish_Perfect("took, captured");
        mVerbRegular.setEnglish_Participle("taking, capturing");

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
        conjNum31 = "31";
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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("io", mVerbRegular.getLatinEnding());
        assertEquals("capio", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("is", mVerbRegular.getLatinEnding());
        assertEquals("capis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("capit", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("capimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("itis", mVerbRegular.getLatinEnding());
        assertEquals("capitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iunt", mVerbRegular.getLatinEnding());
        assertEquals("capiunt", mVerbRegular.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebam", mVerbRegular.getLatinEnding());
        assertEquals("capiebam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebas", mVerbRegular.getLatinEnding());
        assertEquals("capiebas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebat", mVerbRegular.getLatinEnding());
        assertEquals("capiebat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebamus", mVerbRegular.getLatinEnding());
        assertEquals("capiebamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebatis", mVerbRegular.getLatinEnding());
        assertEquals("capiebatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebant", mVerbRegular.getLatinEnding());
        assertEquals("capiebant", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - TENSE_FUTURE TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iam", mVerbRegular.getLatinEnding());
        assertEquals("capiam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ies", mVerbRegular.getLatinEnding());
        assertEquals("capies", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iet", mVerbRegular.getLatinEnding());
        assertEquals("capiet", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iemus", mVerbRegular.getLatinEnding());
        assertEquals("capiemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ietis", mVerbRegular.getLatinEnding());
        assertEquals("capietis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ient", mVerbRegular.getLatinEnding());
        assertEquals("capient", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("cepi", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("isti", mVerbRegular.getLatinEnding());
        assertEquals("cepisti", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("cepit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("cepimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("istis", mVerbRegular.getLatinEnding());
        assertEquals("cepistis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erunt", mVerbRegular.getLatinEnding());
        assertEquals("ceperunt", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eram", mVerbRegular.getLatinEnding());
        assertEquals("ceperam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eras", mVerbRegular.getLatinEnding());
        assertEquals("ceperas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erat", mVerbRegular.getLatinEnding());
        assertEquals("ceperat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eramus", mVerbRegular.getLatinEnding());
        assertEquals("ceperamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eratis", mVerbRegular.getLatinEnding());
        assertEquals("ceperatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erant", mVerbRegular.getLatinEnding());
        assertEquals("ceperant", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - TENSE_FUTURE-TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("ero", mVerbRegular.getLatinEnding());
        assertEquals("cepero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("ceperis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("ceperit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("ceperimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("ceperitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("ceperint", mVerbRegular.getLatinVerb());
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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ior", mVerbRegular.getLatinEnding());
        assertEquals("capior", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("caperis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("itur", mVerbRegular.getLatinEnding());
        assertEquals("capitur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("imur", mVerbRegular.getLatinEnding());
        assertEquals("capimur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("imini", mVerbRegular.getLatinEnding());
        assertEquals("capimini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iuntur", mVerbRegular.getLatinEnding());
        assertEquals("capiuntur", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebar", mVerbRegular.getLatinEnding());
        assertEquals("capiebar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebaris", mVerbRegular.getLatinEnding());
        assertEquals("capiebaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebatur", mVerbRegular.getLatinEnding());
        assertEquals("capiebatur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebamur", mVerbRegular.getLatinEnding());
        assertEquals("capiebamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebamini", mVerbRegular.getLatinEnding());
        assertEquals("capiebamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iebantur", mVerbRegular.getLatinEnding());
        assertEquals("capiebantur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - TENSE_FUTURE TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iar", mVerbRegular.getLatinEnding());
        assertEquals("capiar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ieris", mVerbRegular.getLatinEnding());
        assertEquals("capieris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ietur", mVerbRegular.getLatinEnding());
        assertEquals("capietur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iemur", mVerbRegular.getLatinEnding());
        assertEquals("capiemur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("iemini", mVerbRegular.getLatinEnding());
        assertEquals("capiemini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("ientur", mVerbRegular.getLatinEnding());
        assertEquals("capientur", mVerbRegular.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us sum", mVerbRegular.getLatinEnding());
        assertEquals("captus sum", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us es", mVerbRegular.getLatinEnding());
        assertEquals("captus es", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us est", mVerbRegular.getLatinEnding());
        assertEquals("captus est", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i sumus", mVerbRegular.getLatinEnding());
        assertEquals("capti sumus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i estis", mVerbRegular.getLatinEnding());
        assertEquals("capti estis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i sunt", mVerbRegular.getLatinEnding());
        assertEquals("capti sunt", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us eram", mVerbRegular.getLatinEnding());
        assertEquals("captus eram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us eras", mVerbRegular.getLatinEnding());
        assertEquals("captus eras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us erat", mVerbRegular.getLatinEnding());
        assertEquals("captus erat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i eramus", mVerbRegular.getLatinEnding());
        assertEquals("capti eramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i eratis", mVerbRegular.getLatinEnding());
        assertEquals("capti eratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i erant", mVerbRegular.getLatinEnding());
        assertEquals("capti erant", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - TENSE_FUTURE-TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us ero", mVerbRegular.getLatinEnding());
        assertEquals("captus ero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us eris", mVerbRegular.getLatinEnding());
        assertEquals("captus eris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us erit", mVerbRegular.getLatinEnding());
        assertEquals("captus erit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i erimus", mVerbRegular.getLatinEnding());
        assertEquals("capti erimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i eritis", mVerbRegular.getLatinEnding());
        assertEquals("capti eritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i erunt", mVerbRegular.getLatinEnding());
        assertEquals("capti erunt", mVerbRegular.getLatinVerb());

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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("capiam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("capias", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("capiat", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("capiamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("capiatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("capiant", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("caperem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("caperes", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("caperet", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("caperemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("caperetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("caperent", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erim", mVerbRegular.getLatinEnding());
        assertEquals("ceperim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("ceperis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("ceperit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("ceperimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("ceperitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("ceperint", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_ACTIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("issem", mVerbRegular.getLatinEnding());
        assertEquals("cepissem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("isses", mVerbRegular.getLatinEnding());
        assertEquals("cepisses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("isset", mVerbRegular.getLatinEnding());
        assertEquals("cepisset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("issemus", mVerbRegular.getLatinEnding());
        assertEquals("cepissemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("issetis", mVerbRegular.getLatinEnding());
        assertEquals("cepissetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum31);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("issent", mVerbRegular.getLatinEnding());
        assertEquals("cepissent", mVerbRegular.getLatinVerb());

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


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("capiar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("capiaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("capiatur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("capiamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("capiamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capia", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("capiantur", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - TENSE_IMPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("caperer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("capereris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("caperetur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("caperemur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("caperemini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("caperentur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - TENSE_PERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us sim", mVerbRegular.getLatinEnding());
        assertEquals("captus sim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us sis", mVerbRegular.getLatinEnding());
        assertEquals("captus sis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us sit", mVerbRegular.getLatinEnding());
        assertEquals("captus sit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i simus", mVerbRegular.getLatinEnding());
        assertEquals("capti simus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i sitis", mVerbRegular.getLatinEnding());
        assertEquals("capti sitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i sint", mVerbRegular.getLatinEnding());
        assertEquals("capti sint", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - TENSE_PLUPERFECT TENSE, VOICE_PASSIVE, MOOD_SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us essem", mVerbRegular.getLatinEnding());
        assertEquals("captus essem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us esses", mVerbRegular.getLatinEnding());
        assertEquals("captus esses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us esset", mVerbRegular.getLatinEnding());
        assertEquals("captus esset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i essemus", mVerbRegular.getLatinEnding());
        assertEquals("capti essemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i essetis", mVerbRegular.getLatinEnding());
        assertEquals("capti essetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum31);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("i essent", mVerbRegular.getLatinEnding());
        assertEquals("capti essent", mVerbRegular.getLatinVerb());
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

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("capere", mVerbRegular.getLatinStem());
        assertEquals( "", mVerbRegular.getLatinEnding());
        assertEquals("capere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("cep", mVerbRegular.getLatinStem());
        assertEquals("isse", mVerbRegular.getLatinEnding());
        assertEquals("cepisse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("urus esse", mVerbRegular.getLatinEnding());
        assertEquals("capturus esse", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals("cap", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("capi", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("us esse", mVerbRegular.getLatinEnding());
        assertEquals("captus esse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals("capt", mVerbRegular.getLatinStem());
        assertEquals("um iri", mVerbRegular.getLatinEnding());
        assertEquals("captum iri", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - MOOD_IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("cape", mVerbRegular.getLatinStem());
        assertEquals("", mVerbRegular.getLatinEnding());
        assertEquals("cape", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("cape", mVerbRegular.getLatinStem());
        assertEquals("te", mVerbRegular.getLatinEnding());
        assertEquals("capete", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("cape", mVerbRegular.getLatinStem());
        assertEquals("re", mVerbRegular.getLatinEnding());
        assertEquals("capere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("cape", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("capemini", mVerbRegular.getLatinVerb());

    }

}
