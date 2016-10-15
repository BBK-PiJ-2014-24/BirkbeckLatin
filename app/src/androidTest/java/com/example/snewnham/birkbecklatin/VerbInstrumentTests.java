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
 * TESTS FOR CREATING VERBS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class VerbInstrumentTests {


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


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    /**
     * testMakeVerbWordPresentActiveIndicative()  - PRESENT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }

    /**
     * testMakeVerbWordImperfectActiveIndicative()  - IMPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }



    /**
     * testMakeVerbWordFutureActiveIndicative()  - FUTURE TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }


    /**
     * testMakeVerbWordPerfectActiveIndicative()  - PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }


    /**
     * testMakeVerbWordPluperfectActiveIndicative()  - PLUPERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }



    /**
     * testMakeVerbWordFuturePerfectActiveIndicative()  - FUTURE-PERFECT TENSE, ACTIVE, INDICATIVE
     * =========================================
     * test Verb Class that It Can build Correct Latin Verb and English Translation.
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

        // assertEquals("he warns", verb.getEnglishVerb);

    }




}
