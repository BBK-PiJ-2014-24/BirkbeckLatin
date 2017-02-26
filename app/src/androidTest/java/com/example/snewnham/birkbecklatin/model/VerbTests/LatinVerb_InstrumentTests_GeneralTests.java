package com.example.snewnham.birkbecklatin.model.VerbTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * GENERAL TESTS FOR CREATING LATIN VERBS FOR ALL PERSONS, MOODS, VOICES
 * Using Acccess to DB.
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class LatinVerb_InstrumentTests_GeneralTests {

    private static final String TAG = "VERB_GENERAL_TESTS";

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;

    RandomGenerator mRandomGenerator;

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

    String present;       // Participle Parts
    String Infinitive;
    String Perfect;
    String Participle;

    String present_Stem;     // Stems
    String infinitive_Stem;
    String infinitive_PassiveStem;
    String present_SubjuncStem;
    String perfect_Stem;
    String participle_Stem;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        mRandomGenerator = new RandomGenerator(databaseAccess);

        id = 1;
        mVerbRegular = (VerbRegular) databaseAccess.sqlVerbListQuery(id);



        present = "amo";        // Participle Parts
        Infinitive = "amare";
        Perfect =  "amavi";
        Participle = "amatus";

        present_Stem = "am";     // Stems
        infinitive_Stem = "ama";
        infinitive_PassiveStem = "amar";
        present_SubjuncStem = "ame";
        perfect_Stem = "amav";
        participle_Stem ="amat";



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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voiceActive, conjNum1);

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


        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voiceActive, conjNum1);


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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voiceActive, conjNum1);

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


        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodIndicative, voicePassive, conjNum1);
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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodIndicative, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuture,
                moodIndicative, voicePassive, conjNum1);
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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodIndicative, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodIndicative, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseFuturePerfect,
                moodIndicative, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voiceActive, conjNum1);
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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voiceActive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePresent,
                moodSubjunctive, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tenseImPerfect,
                moodSubjunctive, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePerfect,
                moodSubjunctive, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberSingular, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);


        mVerbRegular.makeLatinVerb(databaseAccess, person1, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person2, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

        mVerbRegular.makeLatinVerb(databaseAccess, person3, numberPlural, tensePluperfect,
                moodSubjunctive, voicePassive, conjNum1);

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

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voiceActive, conjNull);


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voiceActive, conjNull);


        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePresent,
                moodIndicative, voicePassive, conjNull);

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tensePerfect,
                moodIndicative, voicePassive, conjNull);

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberInfinitive, tenseFuture,
                moodIndicative, voicePassive, conjNull);

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

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voiceActive, conjNull);

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberSingular, tenseNull,
                moodImperative, voicePassive, conjNull);

        mVerbRegular.makeLatinVerb(databaseAccess, personNull, numberPlural, tenseNull,
                moodImperative, voicePassive, conjNull);

    }

    @Test
    public void testRandomPerson() throws Exception{

            for(int i=0; i<30; i++) {
                String person = mRandomGenerator.getVerbPerson();
                mVerbRegular.makeLatinVerb(databaseAccess, person, numberSingular, tensePresent,
                        moodIndicative, voiceActive, Integer.toString(mVerbRegular.getLatin_ConjNum()));
            }
    }

    @Test
    public void testRandomNumber() throws Exception{

        for(int i=0; i<30; i++) {
            String number = mRandomGenerator.getVerbNumber();
            mVerbRegular.makeLatinVerb(databaseAccess, person1, number, tensePresent,
                    moodIndicative, voiceActive, Integer.toString(mVerbRegular.getLatin_ConjNum()));
        }
    }


    @Test
    public void testRandomTense() throws Exception{

        for(int i=0; i<80; i++) {
            String tense = mRandomGenerator.getVerbTense();
            mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tense,
                    moodIndicative, voiceActive, Integer.toString(mVerbRegular.getLatin_ConjNum()));
        }
    }


    @Test
    public void testRandomMood() throws Exception{

        for(int i=0; i<30; i++) {
            String mood = mRandomGenerator.getVerbMood();
            mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                    mood, voiceActive, Integer.toString(mVerbRegular.getLatin_ConjNum()));
        }
    }


    @Test
    public void testRandomVoice() throws Exception{

        for(int i=0; i<30; i++) {
            String voice = mRandomGenerator.getVerbVoice();
            mVerbRegular.makeLatinVerb(databaseAccess, person1, numberSingular, tensePresent,
                    moodIndicative, voice, Integer.toString(mVerbRegular.getLatin_ConjNum()));
        }
    }

    @Test
    public void totalRandomVerb() throws Exception{

//        for(int i=0; i<300; i++){
//            String person = mRandomGenerator.getVerbPerson();
//            String number = mRandomGenerator.getVerbNumber();
//            String tense = mRandomGenerator.getVerbTense();
//            String mood = mRandomGenerator.getVerbMood();
//            String voice = mRandomGenerator.getVerbVoice();
//            Log.i(TAG, "person: " + person + "number: " + number + "tense: " + tense
//                      + "mood: " + mood + "voice: " + voice, new Exception());
//
//            mVerbRegular.makeLatinVerb(databaseAccess, person1, numberInfinitive, tenseImPerfect,
//                    moodIndicative, voiceActive, Integer.toString(mVerbRegular.getLatin_ConjNum()));
//
//            Log.i(TAG, "person: " + person + "number: " + number + "tense: " + tense
//                    + "mood: " + mood + "voice: " + voice, new Exception());
//        }

    }



}
