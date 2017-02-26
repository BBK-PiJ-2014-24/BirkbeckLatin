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
public class LatinVerb_InstrumentTests_3rd_Conj {


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
        mVerbRegular.setLatin_ConjNum(3);

        mVerbRegular.setLatin_Present("rego");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("regere");
        mVerbRegular.setLatin_Perfect("rexi");
        mVerbRegular.setLatin_Participle("rectus");

        mVerbRegular.setLatin_Present_Stem("reg");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("rege");
        mVerbRegular.setLatin_Infinitive_PassiveStem("reg");
        mVerbRegular.setLatin_Present_SubjuncStem("rega");
        mVerbRegular.setLatin_Perfect_Stem("rex");
        mVerbRegular.setLatin_Participle_Stem("rect");

        mVerbRegular.setEnglish_Infinitive("rule");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("rules");
        mVerbRegular.setEnglish_Perfect("ruled");
        mVerbRegular.setEnglish_Participle("ruling");

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
                            moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("o", mVerbRegular.getLatinEnding());
        assertEquals("rego", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("is", mVerbRegular.getLatinEnding());
        assertEquals("regis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("regit", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("regimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("itis", mVerbRegular.getLatinEnding());
        assertEquals("regitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("unt", mVerbRegular.getLatinEnding());
        assertEquals("regunt", mVerbRegular.getLatinVerb());
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
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebam", mVerbRegular.getLatinEnding());
        assertEquals("regebam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebas", mVerbRegular.getLatinEnding());
        assertEquals("regebas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebat", mVerbRegular.getLatinEnding());
        assertEquals("regebat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebamus", mVerbRegular.getLatinEnding());
        assertEquals("regebamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebatis", mVerbRegular.getLatinEnding());
        assertEquals("regebatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebant", mVerbRegular.getLatinEnding());
        assertEquals("regebant", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("am", mVerbRegular.getLatinEnding());
        assertEquals("regam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("es", mVerbRegular.getLatinEnding());
        assertEquals("reges", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("et", mVerbRegular.getLatinEnding());
        assertEquals("reget", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("emus", mVerbRegular.getLatinEnding());
        assertEquals("regemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("etis", mVerbRegular.getLatinEnding());
        assertEquals("regetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ent", mVerbRegular.getLatinEnding());
        assertEquals("regent", mVerbRegular.getLatinVerb());
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
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("rexi", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("isti", mVerbRegular.getLatinEnding());
        assertEquals("rexisti", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("rexit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("reximus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("istis", mVerbRegular.getLatinEnding());
        assertEquals("rexistis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erunt", mVerbRegular.getLatinEnding());
        assertEquals("rexerunt", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eram", mVerbRegular.getLatinEnding());
        assertEquals("rexeram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eras", mVerbRegular.getLatinEnding());
        assertEquals("rexeras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erat", mVerbRegular.getLatinEnding());
        assertEquals("rexerat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eramus", mVerbRegular.getLatinEnding());
        assertEquals("rexeramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eratis", mVerbRegular.getLatinEnding());
        assertEquals("rexeratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erant", mVerbRegular.getLatinEnding());
        assertEquals("rexerant", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("ero", mVerbRegular.getLatinEnding());
        assertEquals("rexero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("rexeris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("rexerit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("rexerimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("rexeritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("rexerint", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("or", mVerbRegular.getLatinEnding());
        assertEquals("regor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("regeris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("itur", mVerbRegular.getLatinEnding());
        assertEquals("regitur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("imur", mVerbRegular.getLatinEnding());
        assertEquals("regimur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("imini", mVerbRegular.getLatinEnding());
        assertEquals("regimini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("untur", mVerbRegular.getLatinEnding());
        assertEquals("reguntur", mVerbRegular.getLatinVerb());

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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebar", mVerbRegular.getLatinEnding());
        assertEquals("regebar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebaris", mVerbRegular.getLatinEnding());
        assertEquals("regebaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebatur", mVerbRegular.getLatinEnding());
        assertEquals("regebatur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebamur", mVerbRegular.getLatinEnding());
        assertEquals("regebamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebamini", mVerbRegular.getLatinEnding());
        assertEquals("regebamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ebantur", mVerbRegular.getLatinEnding());
        assertEquals("regebantur", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("ar", mVerbRegular.getLatinEnding());
        assertEquals("regar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("regeris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("etur", mVerbRegular.getLatinEnding());
        assertEquals("regetur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("emur", mVerbRegular.getLatinEnding());
        assertEquals("regemur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("emini", mVerbRegular.getLatinEnding());
        assertEquals("regemini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("entur", mVerbRegular.getLatinEnding());
        assertEquals("regentur", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us sum", mVerbRegular.getLatinEnding());
        assertEquals("rectus sum", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us es", mVerbRegular.getLatinEnding());
        assertEquals("rectus es", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us est", mVerbRegular.getLatinEnding());
        assertEquals("rectus est", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i sumus", mVerbRegular.getLatinEnding());
        assertEquals("recti sumus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i estis", mVerbRegular.getLatinEnding());
        assertEquals("recti estis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i sunt", mVerbRegular.getLatinEnding());
        assertEquals("recti sunt", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us eram", mVerbRegular.getLatinEnding());
        assertEquals("rectus eram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us eras", mVerbRegular.getLatinEnding());
        assertEquals("rectus eras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us erat", mVerbRegular.getLatinEnding());
        assertEquals("rectus erat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i eramus", mVerbRegular.getLatinEnding());
        assertEquals("recti eramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i eratis", mVerbRegular.getLatinEnding());
        assertEquals("recti eratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i erant", mVerbRegular.getLatinEnding());
        assertEquals("recti erant", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us ero", mVerbRegular.getLatinEnding());
        assertEquals("rectus ero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us eris", mVerbRegular.getLatinEnding());
        assertEquals("rectus eris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us erit", mVerbRegular.getLatinEnding());
        assertEquals("rectus erit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i erimus", mVerbRegular.getLatinEnding());
        assertEquals("recti erimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i eritis", mVerbRegular.getLatinEnding());
        assertEquals("recti eritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i erunt", mVerbRegular.getLatinEnding());
        assertEquals("recti erunt", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("regam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("regas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("regat", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("regamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("regatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("regant", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("regerem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("regeres", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("regeret", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("regeremus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("regeretis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("regerent", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erim", mVerbRegular.getLatinEnding());
        assertEquals("rexerim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("rexeris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("rexerit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("rexerimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("rexeritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("rexerint", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("issem", mVerbRegular.getLatinEnding());
        assertEquals("rexissem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("isses", mVerbRegular.getLatinEnding());
        assertEquals("rexisses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("isset", mVerbRegular.getLatinEnding());
        assertEquals("rexisset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("issemus", mVerbRegular.getLatinEnding());
        assertEquals("rexissemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("issetis", mVerbRegular.getLatinEnding());
        assertEquals("rexissetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum3);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("issent", mVerbRegular.getLatinEnding());
        assertEquals("rexissent", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("regar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("regaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("regatur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("regamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("regamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rega", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("regantur", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("regerer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("regereris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("regeretur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("regeremur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("regeremini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("regerentur", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us sim", mVerbRegular.getLatinEnding());
        assertEquals("rectus sim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us sis", mVerbRegular.getLatinEnding());
        assertEquals("rectus sis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us sit", mVerbRegular.getLatinEnding());
        assertEquals("rectus sit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i simus", mVerbRegular.getLatinEnding());
        assertEquals("recti simus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i sitis", mVerbRegular.getLatinEnding());
        assertEquals("recti sitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i sint", mVerbRegular.getLatinEnding());
        assertEquals("recti sint", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us essem", mVerbRegular.getLatinEnding());
        assertEquals("rectus essem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us esses", mVerbRegular.getLatinEnding());
        assertEquals("rectus esses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us esset", mVerbRegular.getLatinEnding());
        assertEquals("rectus esset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i essemus", mVerbRegular.getLatinEnding());
        assertEquals("recti essemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i essetis", mVerbRegular.getLatinEnding());
        assertEquals("recti essetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum3);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("i essent", mVerbRegular.getLatinEnding());
        assertEquals("recti essent", mVerbRegular.getLatinVerb());
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

        assertEquals("regere", mVerbRegular.getLatinStem());
        assertEquals( "", mVerbRegular.getLatinEnding());
        assertEquals("regere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("rex", mVerbRegular.getLatinStem());
        assertEquals("isse", mVerbRegular.getLatinEnding());
        assertEquals("rexisse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("urus esse", mVerbRegular.getLatinEnding());
        assertEquals("recturus esse", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals("reg", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("regi", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("us esse", mVerbRegular.getLatinEnding());
        assertEquals("rectus esse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals("rect", mVerbRegular.getLatinStem());
        assertEquals("um iri", mVerbRegular.getLatinEnding());
        assertEquals("rectum iri", mVerbRegular.getLatinVerb());

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

        assertEquals("rege", mVerbRegular.getLatinStem());
        assertEquals("", mVerbRegular.getLatinEnding());
        assertEquals("rege", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("rege", mVerbRegular.getLatinStem());
        assertEquals("te", mVerbRegular.getLatinEnding());
        assertEquals("regete", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("rege", mVerbRegular.getLatinStem());
        assertEquals("re", mVerbRegular.getLatinEnding());
        assertEquals("regere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("rege", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("regemini", mVerbRegular.getLatinVerb());

    }

}
