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
 * TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES, COJUGATIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerbInstrumentTests {


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
        verb = new Verb(id, databaseAccess);

        verb.setLatin_Type("Regular");
        verb.setLatin_ConjNum(2);

        verb.setLatin_Present("moneo");        // Participle Parts
        verb.setLatin_Infinitive("monere");
        verb.setLatin_Perfect("monui");
        verb.setLatin_Participle("monitus");

        verb.setLatin_Present_Stem("mon");     // Stems
        verb.setLatin_Infinitive_Stem("mone");
        verb.setLatin_Infinitive_PassiveStem("moner");
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
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveIndicative() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                            moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("eo", verb.getLatinEnding());
        assertEquals("moneo", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("es", verb.getLatinEnding());
        assertEquals("mones", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("et", verb.getLatinEnding());
        assertEquals("monet", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("emus", verb.getLatinEnding());
        assertEquals("monemus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("etis", verb.getLatinEnding());
        assertEquals("monetis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ent", verb.getLatinEnding());
        assertEquals("monent", verb.getLatinVerb());
    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebam", verb.getLatinEnding());
        assertEquals("monebam", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebas", verb.getLatinEnding());
        assertEquals("monebas", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebat", verb.getLatinEnding());
        assertEquals("monebat", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebamus", verb.getLatinEnding());
        assertEquals("monebamus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebatis", verb.getLatinEnding());
        assertEquals("monebatis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebant", verb.getLatinEnding());
        assertEquals("monebant", verb.getLatinVerb());

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFutureActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebo", verb.getLatinEnding());
        assertEquals("monebo", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebis", verb.getLatinEnding());
        assertEquals("monebis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebit", verb.getLatinEnding());
        assertEquals("monebit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebimus", verb.getLatinEnding());
        assertEquals("monebimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebitis", verb.getLatinEnding());
        assertEquals("monebitis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebunt", verb.getLatinEnding());
        assertEquals("monebunt", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("i", verb.getLatinEnding());
        assertEquals("monui", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("isti", verb.getLatinEnding());
        assertEquals("monuisti", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("it", verb.getLatinEnding());
        assertEquals("monuit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("imus", verb.getLatinEnding());
        assertEquals("monuimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("istis", verb.getLatinEnding());
        assertEquals("monuistis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erunt", verb.getLatinEnding());
        assertEquals("monuerunt", verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eram", verb.getLatinEnding());
        assertEquals("monueram", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eras", verb.getLatinEnding());
        assertEquals("monueras", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erat", verb.getLatinEnding());
        assertEquals("monuerat", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eramus", verb.getLatinEnding());
        assertEquals("monueramus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eratis", verb.getLatinEnding());
        assertEquals("monueratis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erant", verb.getLatinEnding());
        assertEquals("monuerant", verb.getLatinVerb());

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectActiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("ero", verb.getLatinEnding());
        assertEquals("monuero", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eris", verb.getLatinEnding());
        assertEquals("monueris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erit", verb.getLatinEnding());
        assertEquals("monuerit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erimus", verb.getLatinEnding());
        assertEquals("monuerimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eritis", verb.getLatinEnding());
        assertEquals("monueritis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erint", verb.getLatinEnding());
        assertEquals("monuerint", verb.getLatinVerb());
    }

// ============================== PASSIVE, INDICATIVE  =============================================

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveIndicative() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("eor", verb.getLatinEnding());
        assertEquals("moneor", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("eris", verb.getLatinEnding());
        assertEquals("moneris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("etur", verb.getLatinEnding());
        assertEquals("monetur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("emur", verb.getLatinEnding());
        assertEquals("monemur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("emini", verb.getLatinEnding());
        assertEquals("monemini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("entur", verb.getLatinEnding());
        assertEquals("monentur", verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebar", verb.getLatinEnding());
        assertEquals("monebar", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebaris", verb.getLatinEnding());
        assertEquals("monebaris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebatur", verb.getLatinEnding());
        assertEquals("monebatur", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebamur", verb.getLatinEnding());
        assertEquals("monebamur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebamini", verb.getLatinEnding());
        assertEquals("monebamini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebantur", verb.getLatinEnding());
        assertEquals("monebantur", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePassiveIndicative()  - FUTURE TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebor", verb.getLatinEnding());
        assertEquals("monebor", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("eberis", verb.getLatinEnding());
        assertEquals("moneberis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebitur", verb.getLatinEnding());
        assertEquals("monebitur", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebimur", verb.getLatinEnding());
        assertEquals("monebimur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebimini", verb.getLatinEnding());
        assertEquals("monebimini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("mon", verb.getLatinStem());
        assertEquals("ebuntur", verb.getLatinEnding());
        assertEquals("monebuntur", verb.getLatinVerb());
    }



    /**
     * testMakeVerbWordPerfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us sum", verb.getLatinEnding());
        assertEquals("monitus sum", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us es", verb.getLatinEnding());
        assertEquals("monitus es", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us est", verb.getLatinEnding());
        assertEquals("monitus est", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i sumus", verb.getLatinEnding());
        assertEquals("moniti sumus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i estis", verb.getLatinEnding());
        assertEquals("moniti estis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i sunt", verb.getLatinEnding());
        assertEquals("moniti sunt", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PERFECT TENSE, PASSIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us eram", verb.getLatinEnding());
        assertEquals("monitus eram", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us eras", verb.getLatinEnding());
        assertEquals("monitus eras", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us erat", verb.getLatinEnding());
        assertEquals("monitus erat", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i eramus", verb.getLatinEnding());
        assertEquals("moniti eramus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i eratis", verb.getLatinEnding());
        assertEquals("moniti eratis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i erant", verb.getLatinEnding());
        assertEquals("moniti erant", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordFuturePerfectPassiveIndicative()  - FUTURE-PERFECT TENSE, PASSIVE, INDICATIVE
     * ================================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordFuturePerfectPassiveIndicative() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us ero", verb.getLatinEnding());
        assertEquals("monitus ero", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us eris", verb.getLatinEnding());
        assertEquals("monitus eris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us erit", verb.getLatinEnding());
        assertEquals("monitus erit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i erimus", verb.getLatinEnding());
        assertEquals("moniti erimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i eritis", verb.getLatinEnding());
        assertEquals("moniti eritis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i erunt", verb.getLatinEnding());
        assertEquals("moniti erunt", verb.getLatinVerb());

    }

    // ======================= ACTIVE, SUBJUNCTIVE ==================================


    /**
     * testMakeVerbWordPresentActiveSubjunctive()  - PRESENT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentActiveSubjunctive() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("m", verb.getLatinEnding());
        assertEquals("moneam", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("s", verb.getLatinEnding());
        assertEquals("moneas", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("t", verb.getLatinEnding());
        assertEquals("moneat", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("mus", verb.getLatinEnding());
        assertEquals("moneamus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("tis", verb.getLatinEnding());
        assertEquals("moneatis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("nt", verb.getLatinEnding());
        assertEquals("moneant", verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectActiveSubjunctive()  - IMPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("m", verb.getLatinEnding());
        assertEquals("monerem", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("s", verb.getLatinEnding());
        assertEquals("moneres", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("t", verb.getLatinEnding());
        assertEquals("moneret", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("mus", verb.getLatinEnding());
        assertEquals("moneremus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("tis", verb.getLatinEnding());
        assertEquals("moneretis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("nt", verb.getLatinEnding());
        assertEquals("monerent", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectActiveSubjunctive()  - PERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erim", verb.getLatinEnding());
        assertEquals("monuerim", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eris", verb.getLatinEnding());
        assertEquals("monueris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erit", verb.getLatinEnding());
        assertEquals("monuerit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erimus", verb.getLatinEnding());
        assertEquals("monuerimus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("eritis", verb.getLatinEnding());
        assertEquals("monueritis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("erint", verb.getLatinEnding());
        assertEquals("monuerint", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectActiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("issem", verb.getLatinEnding());
        assertEquals("monuissem", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("isses", verb.getLatinEnding());
        assertEquals("monuisses", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("isset", verb.getLatinEnding());
        assertEquals("monuisset", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("issemus", verb.getLatinEnding());
        assertEquals("monuissemus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("issetis", verb.getLatinEnding());
        assertEquals("monuissetis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum2);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("issent", verb.getLatinEnding());
        assertEquals("monuissent", verb.getLatinVerb());

    }

// ======================= PASSIVE, SUBJUNCTIVE =========================


    /**
     * testMakeVerbWordPresentPassiveSubjunctive()  - PRESENT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPresentPassiveSubjunctive() throws Exception {


        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("r", verb.getLatinEnding());
        assertEquals("monear", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("ris", verb.getLatinEnding());
        assertEquals("monearis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("tur", verb.getLatinEnding());
        assertEquals("moneatur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("mur", verb.getLatinEnding());
        assertEquals("moneamur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("moneamini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monea", verb.getLatinStem());
        assertEquals("ntur", verb.getLatinEnding());
        assertEquals("moneantur", verb.getLatinVerb());

    }

    /**
     * testMakeVerbWordImperfectPassiveSubjunctive()  - IMPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("r", verb.getLatinEnding());
        assertEquals("monerer", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("ris", verb.getLatinEnding());
        assertEquals("monereris", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("tur", verb.getLatinEnding());
        assertEquals("moneretur", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("mur", verb.getLatinEnding());
        assertEquals("moneremur", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("moneremini", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monere", verb.getLatinStem());
        assertEquals("ntur", verb.getLatinEnding());
        assertEquals("monerentur", verb.getLatinVerb());
    }


    /**
     * testMakeVerbWordPerfectPassiveSubjunctive()  - PERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPerfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us sim", verb.getLatinEnding());
        assertEquals("monitus sim", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us sis", verb.getLatinEnding());
        assertEquals("monitus sis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us sit", verb.getLatinEnding());
        assertEquals("monitus sit", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i simus", verb.getLatinEnding());
        assertEquals("moniti simus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i sitis", verb.getLatinEnding());
        assertEquals("moniti sitis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i sint", verb.getLatinEnding());
        assertEquals("moniti sint", verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordPluperfectPassiveIndicative()  - PLUPERFECT TENSE, PASSIVE, SUBJUNCTIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordPluperfectPassiveSubjunctive() throws Exception {

        verb.makeLatinVerb(databaseAccess, person1, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us essem", verb.getLatinEnding());
        assertEquals("monitus essem", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us esses", verb.getLatinEnding());
        assertEquals("monitus esses", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us esset", verb.getLatinEnding());
        assertEquals("monitus esset", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i essemus", verb.getLatinEnding());
        assertEquals("moniti essemus", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i essetis", verb.getLatinEnding());
        assertEquals("moniti essetis", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum2);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("i essent", verb.getLatinEnding());
        assertEquals("moniti essent", verb.getLatinVerb());
    }



    // =========================== INFINITIVE, IMPERATIVE =======================================


    /**
     * testMakeVerbWordInfinitive()  - INFINITIVE
     * ==========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordInfinitive() throws Exception {

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voiceActive, conjNull);

        assertEquals("monere", verb.getLatinStem());
        assertEquals( "", verb.getLatinEnding());
        assertEquals("monere", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);

        assertEquals("monu", verb.getLatinStem());
        assertEquals("isse", verb.getLatinEnding());
        assertEquals("monuisse", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("urus esse", verb.getLatinEnding());
        assertEquals("moniturus esse", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        assertEquals("moner", verb.getLatinStem());
        assertEquals("i", verb.getLatinEnding());
        assertEquals("moneri", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("us esse", verb.getLatinEnding());
        assertEquals("monitus esse", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

        assertEquals("monit", verb.getLatinStem());
        assertEquals("um iri", verb.getLatinEnding());
        assertEquals("monitum iri", verb.getLatinVerb());

    }


    /**
     * testMakeVerbWordImperative()  - IMPERATIVE
     * ==========================================
     * test Verb Class that It Can build Correct Latin Verb.
     * @throws Exception
     */

    @Test
    public void testMakeVerbWordImperative() throws Exception {

        verb.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("mone", verb.getLatinStem());
        assertEquals("", verb.getLatinEnding());
        assertEquals("mone", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        assertEquals("mone", verb.getLatinStem());
        assertEquals("te", verb.getLatinEnding());
        assertEquals("monete", verb.getLatinVerb());


        verb.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("mone", verb.getLatinStem());
        assertEquals("re", verb.getLatinEnding());
        assertEquals("monere", verb.getLatinVerb());

        verb.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

        assertEquals("mone", verb.getLatinStem());
        assertEquals("mini", verb.getLatinEnding());
        assertEquals("monemini", verb.getLatinVerb());

    }

}
