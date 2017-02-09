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
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES FOR 1st COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_1st_Conj {


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
        mVerbRegular.setLatin_ConjNum(1);

        mVerbRegular.setLatin_Present("amo");        // Participle Parts
        mVerbRegular.setLatin_Infinitive("amare");
        mVerbRegular.setLatin_Perfect("amavi");
        mVerbRegular.setLatin_Participle("amatus");

        mVerbRegular.setLatin_Present_Stem("am");     // Stems
        mVerbRegular.setLatin_Infinitive_Stem("ama");
        mVerbRegular.setLatin_Infinitive_PassiveStem("amar");
        mVerbRegular.setLatin_Present_SubjuncStem("ame");
        mVerbRegular.setLatin_Perfect_Stem("amav");
        mVerbRegular.setLatin_Participle_Stem("amat");

        mVerbRegular.setEnglish_Infinitive("love");    // English
        mVerbRegular.setEnglish_Present_3rdPerson("loves");
        mVerbRegular.setEnglish_Perfect("loved");
        mVerbRegular.setEnglish_Participle("loving");

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


    // ==========================  ACTIVE, INDICATIVE  ================================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("o", mVerbRegular.getLatinEnding());
        assertEquals("amo", mVerbRegular.getLatinVerb());

        assertEquals(tensePresent, mVerbRegular.getTense());
        assertEquals(moodIndicative, mVerbRegular.getMood());
        assertEquals(voiceActive, mVerbRegular.getVoice());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("as", mVerbRegular.getLatinEnding());
        assertEquals("amas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("at", mVerbRegular.getLatinEnding());
        assertEquals("amat", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("amus", mVerbRegular.getLatinEnding());
        assertEquals("amamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("atis", mVerbRegular.getLatinEnding());
        assertEquals("amatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("ant", mVerbRegular.getLatinEnding());
        assertEquals("amant", mVerbRegular.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abam", mVerbRegular.getLatinEnding());
        assertEquals("amabam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abas", mVerbRegular.getLatinEnding());
        assertEquals("amabas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abat", mVerbRegular.getLatinEnding());
        assertEquals("amabat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abamus", mVerbRegular.getLatinEnding());
        assertEquals("amabamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abatis", mVerbRegular.getLatinEnding());
        assertEquals("amabatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abant", mVerbRegular.getLatinEnding());
        assertEquals("amabant", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abo", mVerbRegular.getLatinEnding());
        assertEquals("amabo", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abis", mVerbRegular.getLatinEnding());
        assertEquals("amabis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abit", mVerbRegular.getLatinEnding());
        assertEquals("amabit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abimus", mVerbRegular.getLatinEnding());
        assertEquals("amabimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abitis", mVerbRegular.getLatinEnding());
        assertEquals("amabitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abunt", mVerbRegular.getLatinEnding());
        assertEquals("amabunt", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("amavi", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("isti", mVerbRegular.getLatinEnding());
        assertEquals("amavisti", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("amavit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("amavimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("istis", mVerbRegular.getLatinEnding());
        assertEquals("amavistis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erunt", mVerbRegular.getLatinEnding());
        assertEquals("amaverunt", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eram", mVerbRegular.getLatinEnding());
        assertEquals("amaveram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eras", mVerbRegular.getLatinEnding());
        assertEquals("amaveras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erat", mVerbRegular.getLatinEnding());
        assertEquals("amaverat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eramus", mVerbRegular.getLatinEnding());
        assertEquals("amaveramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eratis", mVerbRegular.getLatinEnding());
        assertEquals("amaveratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erant", mVerbRegular.getLatinEnding());
        assertEquals("amaverant", mVerbRegular.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("ero", mVerbRegular.getLatinEnding());
        assertEquals("amavero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("amaveris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("amaverit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("amaverimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("amaveritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("amaverint", mVerbRegular.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("or", mVerbRegular.getLatinEnding());
        assertEquals("amor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("aris", mVerbRegular.getLatinEnding());
        assertEquals("amaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("atur", mVerbRegular.getLatinEnding());
        assertEquals("amatur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("amur", mVerbRegular.getLatinEnding());
        assertEquals("amamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("amini", mVerbRegular.getLatinEnding());
        assertEquals("amamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("antur", mVerbRegular.getLatinEnding());
        assertEquals("amantur", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abar", mVerbRegular.getLatinEnding());
        assertEquals("amabar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abaris", mVerbRegular.getLatinEnding());
        assertEquals("amabaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abatur", mVerbRegular.getLatinEnding());
        assertEquals("amabatur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abamur", mVerbRegular.getLatinEnding());
        assertEquals("amabamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abamini", mVerbRegular.getLatinEnding());
        assertEquals("amabamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abantur", mVerbRegular.getLatinEnding());
        assertEquals("amabantur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abor", mVerbRegular.getLatinEnding());
        assertEquals("amabor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("aberis", mVerbRegular.getLatinEnding());
        assertEquals("amaberis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abitur", mVerbRegular.getLatinEnding());
        assertEquals("amabitur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abimur", mVerbRegular.getLatinEnding());
        assertEquals("amabimur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abimini", mVerbRegular.getLatinEnding());
        assertEquals("amabimini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("am", mVerbRegular.getLatinStem());
        assertEquals("abuntur", mVerbRegular.getLatinEnding());
        assertEquals("amabuntur", mVerbRegular.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us sum", mVerbRegular.getLatinEnding());
        assertEquals("amatus sum", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us es", mVerbRegular.getLatinEnding());
        assertEquals("amatus es", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us est", mVerbRegular.getLatinEnding());
        assertEquals("amatus est", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i sumus", mVerbRegular.getLatinEnding());
        assertEquals("amati sumus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i estis", mVerbRegular.getLatinEnding());
        assertEquals("amati estis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i sunt", mVerbRegular.getLatinEnding());
        assertEquals("amati sunt", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us eram", mVerbRegular.getLatinEnding());
        assertEquals("amatus eram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us eras", mVerbRegular.getLatinEnding());
        assertEquals("amatus eras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us erat", mVerbRegular.getLatinEnding());
        assertEquals("amatus erat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i eramus", mVerbRegular.getLatinEnding());
        assertEquals("amati eramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i eratis", mVerbRegular.getLatinEnding());
        assertEquals("amati eratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i erant", mVerbRegular.getLatinEnding());
        assertEquals("amati erant", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us ero", mVerbRegular.getLatinEnding());
        assertEquals("amatus ero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us eris", mVerbRegular.getLatinEnding());
        assertEquals("amatus eris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us erit", mVerbRegular.getLatinEnding());
        assertEquals("amatus erit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i erimus", mVerbRegular.getLatinEnding());
        assertEquals("amati erimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i eritis", mVerbRegular.getLatinEnding());
        assertEquals("amati eritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i erunt", mVerbRegular.getLatinEnding());
        assertEquals("amati erunt", mVerbRegular.getLatinVerb());

    }

    // ======================= ACTIVE, SUBJUNCTIVE ==================================


    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("amem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("ames", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("amet", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("amemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("ametis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("ament", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("amarem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("amares", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("amaret", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("amaremus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("amaretis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("amarent", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erim", mVerbRegular.getLatinEnding());
        assertEquals("amaverim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("amaveris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("amaverit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("amaverimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("amaveritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("amaverint", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("issem", mVerbRegular.getLatinEnding());
        assertEquals("amavissem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("isses", mVerbRegular.getLatinEnding());
        assertEquals("amavisses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("isset", mVerbRegular.getLatinEnding());
        assertEquals("amavisset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("issemus", mVerbRegular.getLatinEnding());
        assertEquals("amavissemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("issetis", mVerbRegular.getLatinEnding());
        assertEquals("amavissetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("issent", mVerbRegular.getLatinEnding());
        assertEquals("amavissent", mVerbRegular.getLatinVerb());

    }

// ======================= PASSIVE, SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("amer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("ameris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("ametur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("amemur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("amemini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("ame", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("amentur", mVerbRegular.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("amarer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("amareris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("amaretur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("amaremur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("amaremini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("amarentur", mVerbRegular.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us sim", mVerbRegular.getLatinEnding());
        assertEquals("amatus sim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us sis", mVerbRegular.getLatinEnding());
        assertEquals("amatus sis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us sit", mVerbRegular.getLatinEnding());
        assertEquals("amatus sit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i simus", mVerbRegular.getLatinEnding());
        assertEquals("amati simus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i sitis", mVerbRegular.getLatinEnding());
        assertEquals("amati sitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i sint", mVerbRegular.getLatinEnding());
        assertEquals("amati sint", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us essem", mVerbRegular.getLatinEnding());
        assertEquals("amatus essem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us esses", mVerbRegular.getLatinEnding());
        assertEquals("amatus esses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us esset", mVerbRegular.getLatinEnding());
        assertEquals("amatus esset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i essemus", mVerbRegular.getLatinEnding());
        assertEquals("amati essemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i essetis", mVerbRegular.getLatinEnding());
        assertEquals("amati essetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("i essent", mVerbRegular.getLatinEnding());
        assertEquals("amati essent", mVerbRegular.getLatinVerb());
    }



    // =========================== INFINITIVE, IMPERATIVE =======================================


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

        assertEquals("amare", mVerbRegular.getLatinStem());
        assertEquals( "", mVerbRegular.getLatinEnding());
        assertEquals("amare", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("amav", mVerbRegular.getLatinStem());
        assertEquals("isse", mVerbRegular.getLatinEnding());
        assertEquals("amavisse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("urus esse", mVerbRegular.getLatinEnding());
        assertEquals("amaturus esse", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals("amar", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("amari", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("us esse", mVerbRegular.getLatinEnding());
        assertEquals("amatus esse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals("amat", mVerbRegular.getLatinStem());
        assertEquals("um iri", mVerbRegular.getLatinEnding());
        assertEquals("amatum iri", mVerbRegular.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test VerbRegular Class that It Can build Correct Latin VerbRegular.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("ama", mVerbRegular.getLatinStem());
        assertEquals("", mVerbRegular.getLatinEnding());
        assertEquals("ama", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("ama", mVerbRegular.getLatinStem());
        assertEquals("te", mVerbRegular.getLatinEnding());
        assertEquals("amate", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("ama", mVerbRegular.getLatinStem());
        assertEquals("re", mVerbRegular.getLatinEnding());
        assertEquals("amare", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("ama", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("amamini", mVerbRegular.getLatinVerb());

    }

}
