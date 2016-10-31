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
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_2nd_Conj {


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
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("eo", mVerbRegular.getLatinEnding());
        assertEquals("moneo", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("es", mVerbRegular.getLatinEnding());
        assertEquals("mones", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("et", mVerbRegular.getLatinEnding());
        assertEquals("monet", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("emus", mVerbRegular.getLatinEnding());
        assertEquals("monemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("etis", mVerbRegular.getLatinEnding());
        assertEquals("monetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ent", mVerbRegular.getLatinEnding());
        assertEquals("monent", mVerbRegular.getLatinVerb());
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
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebam", mVerbRegular.getLatinEnding());
        assertEquals("monebam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebas", mVerbRegular.getLatinEnding());
        assertEquals("monebas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebat", mVerbRegular.getLatinEnding());
        assertEquals("monebat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebamus", mVerbRegular.getLatinEnding());
        assertEquals("monebamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebatis", mVerbRegular.getLatinEnding());
        assertEquals("monebatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebant", mVerbRegular.getLatinEnding());
        assertEquals("monebant", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebo", mVerbRegular.getLatinEnding());
        assertEquals("monebo", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebis", mVerbRegular.getLatinEnding());
        assertEquals("monebis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebit", mVerbRegular.getLatinEnding());
        assertEquals("monebit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebimus", mVerbRegular.getLatinEnding());
        assertEquals("monebimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebitis", mVerbRegular.getLatinEnding());
        assertEquals("monebitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebunt", mVerbRegular.getLatinEnding());
        assertEquals("monebunt", mVerbRegular.getLatinVerb());
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
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("monui", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("isti", mVerbRegular.getLatinEnding());
        assertEquals("monuisti", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("it", mVerbRegular.getLatinEnding());
        assertEquals("monuit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("imus", mVerbRegular.getLatinEnding());
        assertEquals("monuimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("istis", mVerbRegular.getLatinEnding());
        assertEquals("monuistis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erunt", mVerbRegular.getLatinEnding());
        assertEquals("monuerunt", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eram", mVerbRegular.getLatinEnding());
        assertEquals("monueram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eras", mVerbRegular.getLatinEnding());
        assertEquals("monueras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erat", mVerbRegular.getLatinEnding());
        assertEquals("monuerat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eramus", mVerbRegular.getLatinEnding());
        assertEquals("monueramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eratis", mVerbRegular.getLatinEnding());
        assertEquals("monueratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erant", mVerbRegular.getLatinEnding());
        assertEquals("monuerant", mVerbRegular.getLatinVerb());

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
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("ero", mVerbRegular.getLatinEnding());
        assertEquals("monuero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("monueris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("monuerit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("monuerimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("monueritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("monuerint", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("eor", mVerbRegular.getLatinEnding());
        assertEquals("moneor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("moneris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("etur", mVerbRegular.getLatinEnding());
        assertEquals("monetur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("emur", mVerbRegular.getLatinEnding());
        assertEquals("monemur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("emini", mVerbRegular.getLatinEnding());
        assertEquals("monemini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("entur", mVerbRegular.getLatinEnding());
        assertEquals("monentur", mVerbRegular.getLatinVerb());

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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebar", mVerbRegular.getLatinEnding());
        assertEquals("monebar", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebaris", mVerbRegular.getLatinEnding());
        assertEquals("monebaris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebatur", mVerbRegular.getLatinEnding());
        assertEquals("monebatur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebamur", mVerbRegular.getLatinEnding());
        assertEquals("monebamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebamini", mVerbRegular.getLatinEnding());
        assertEquals("monebamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebantur", mVerbRegular.getLatinEnding());
        assertEquals("monebantur", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebor", mVerbRegular.getLatinEnding());
        assertEquals("monebor", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("eberis", mVerbRegular.getLatinEnding());
        assertEquals("moneberis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebitur", mVerbRegular.getLatinEnding());
        assertEquals("monebitur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebimur", mVerbRegular.getLatinEnding());
        assertEquals("monebimur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebimini", mVerbRegular.getLatinEnding());
        assertEquals("monebimini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", mVerbRegular.getLatinStem());
        assertEquals("ebuntur", mVerbRegular.getLatinEnding());
        assertEquals("monebuntur", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us sum", mVerbRegular.getLatinEnding());
        assertEquals("monitus sum", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us es", mVerbRegular.getLatinEnding());
        assertEquals("monitus es", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us est", mVerbRegular.getLatinEnding());
        assertEquals("monitus est", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i sumus", mVerbRegular.getLatinEnding());
        assertEquals("moniti sumus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i estis", mVerbRegular.getLatinEnding());
        assertEquals("moniti estis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i sunt", mVerbRegular.getLatinEnding());
        assertEquals("moniti sunt", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us eram", mVerbRegular.getLatinEnding());
        assertEquals("monitus eram", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us eras", mVerbRegular.getLatinEnding());
        assertEquals("monitus eras", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us erat", mVerbRegular.getLatinEnding());
        assertEquals("monitus erat", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i eramus", mVerbRegular.getLatinEnding());
        assertEquals("moniti eramus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i eratis", mVerbRegular.getLatinEnding());
        assertEquals("moniti eratis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i erant", mVerbRegular.getLatinEnding());
        assertEquals("moniti erant", mVerbRegular.getLatinVerb());
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
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us ero", mVerbRegular.getLatinEnding());
        assertEquals("monitus ero", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us eris", mVerbRegular.getLatinEnding());
        assertEquals("monitus eris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us erit", mVerbRegular.getLatinEnding());
        assertEquals("monitus erit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i erimus", mVerbRegular.getLatinEnding());
        assertEquals("moniti erimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i eritis", mVerbRegular.getLatinEnding());
        assertEquals("moniti eritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i erunt", mVerbRegular.getLatinEnding());
        assertEquals("moniti erunt", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("moneam", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("moneas", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("moneat", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("moneamus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("moneatis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("moneant", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("m", mVerbRegular.getLatinEnding());
        assertEquals("monerem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("s", mVerbRegular.getLatinEnding());
        assertEquals("moneres", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("t", mVerbRegular.getLatinEnding());
        assertEquals("moneret", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("mus", mVerbRegular.getLatinEnding());
        assertEquals("moneremus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("tis", mVerbRegular.getLatinEnding());
        assertEquals("moneretis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("nt", mVerbRegular.getLatinEnding());
        assertEquals("monerent", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erim", mVerbRegular.getLatinEnding());
        assertEquals("monuerim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eris", mVerbRegular.getLatinEnding());
        assertEquals("monueris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erit", mVerbRegular.getLatinEnding());
        assertEquals("monuerit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erimus", mVerbRegular.getLatinEnding());
        assertEquals("monuerimus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("eritis", mVerbRegular.getLatinEnding());
        assertEquals("monueritis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("erint", mVerbRegular.getLatinEnding());
        assertEquals("monuerint", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("issem", mVerbRegular.getLatinEnding());
        assertEquals("monuissem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("isses", mVerbRegular.getLatinEnding());
        assertEquals("monuisses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("isset", mVerbRegular.getLatinEnding());
        assertEquals("monuisset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("issemus", mVerbRegular.getLatinEnding());
        assertEquals("monuissemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("issetis", mVerbRegular.getLatinEnding());
        assertEquals("monuissetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("issent", mVerbRegular.getLatinEnding());
        assertEquals("monuissent", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("monear", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("monearis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("moneatur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("moneamur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("moneamini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("moneantur", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("r", mVerbRegular.getLatinEnding());
        assertEquals("monerer", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("ris", mVerbRegular.getLatinEnding());
        assertEquals("monereris", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("tur", mVerbRegular.getLatinEnding());
        assertEquals("moneretur", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("mur", mVerbRegular.getLatinEnding());
        assertEquals("moneremur", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("moneremini", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals("ntur", mVerbRegular.getLatinEnding());
        assertEquals("monerentur", mVerbRegular.getLatinVerb());
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
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us sim", mVerbRegular.getLatinEnding());
        assertEquals("monitus sim", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us sis", mVerbRegular.getLatinEnding());
        assertEquals("monitus sis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us sit", mVerbRegular.getLatinEnding());
        assertEquals("monitus sit", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i simus", mVerbRegular.getLatinEnding());
        assertEquals("moniti simus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i sitis", mVerbRegular.getLatinEnding());
        assertEquals("moniti sitis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i sint", mVerbRegular.getLatinEnding());
        assertEquals("moniti sint", mVerbRegular.getLatinVerb());

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
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us essem", mVerbRegular.getLatinEnding());
        assertEquals("monitus essem", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us esses", mVerbRegular.getLatinEnding());
        assertEquals("monitus esses", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us esset", mVerbRegular.getLatinEnding());
        assertEquals("monitus esset", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i essemus", mVerbRegular.getLatinEnding());
        assertEquals("moniti essemus", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i essetis", mVerbRegular.getLatinEnding());
        assertEquals("moniti essetis", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("i essent", mVerbRegular.getLatinEnding());
        assertEquals("moniti essent", mVerbRegular.getLatinVerb());
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

        assertEquals("monere", mVerbRegular.getLatinStem());
        assertEquals( "", mVerbRegular.getLatinEnding());
        assertEquals("monere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("monu", mVerbRegular.getLatinStem());
        assertEquals("isse", mVerbRegular.getLatinEnding());
        assertEquals("monuisse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("urus esse", mVerbRegular.getLatinEnding());
        assertEquals("moniturus esse", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals("moner", mVerbRegular.getLatinStem());
        assertEquals("i", mVerbRegular.getLatinEnding());
        assertEquals("moneri", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("us esse", mVerbRegular.getLatinEnding());
        assertEquals("monitus esse", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals("monit", mVerbRegular.getLatinStem());
        assertEquals("um iri", mVerbRegular.getLatinEnding());
        assertEquals("monitum iri", mVerbRegular.getLatinVerb());

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

        assertEquals("mone", mVerbRegular.getLatinStem());
        assertEquals("", mVerbRegular.getLatinEnding());
        assertEquals("mone", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("mone", mVerbRegular.getLatinStem());
        assertEquals("te", mVerbRegular.getLatinEnding());
        assertEquals("monete", mVerbRegular.getLatinVerb());


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("mone", mVerbRegular.getLatinStem());
        assertEquals("re", mVerbRegular.getLatinEnding());
        assertEquals("monere", mVerbRegular.getLatinVerb());

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("mone", mVerbRegular.getLatinStem());
        assertEquals("mini", mVerbRegular.getLatinEnding());
        assertEquals("monemini", mVerbRegular.getLatinVerb());

    }

}
