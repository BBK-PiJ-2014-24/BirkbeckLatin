package com.newnham.app.birkbecklatin.model.VerbTests.suite;

import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_CompoundVerb_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_DeponentInstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_ESSE_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_Irregular_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_Regular_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.EnglishVerb_SemiDeponent_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_Deponent_InstrumentTests;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_1st_Conj;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_2nd_Conj;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_3rd_Conj;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_3rd_io_Conj;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_4th_Conj;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_ESSE_Irregular;
import com.newnham.app.birkbecklatin.model.VerbTests.LatinVerb_InstrumentTests_GeneralTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TESTS SUITE FOR CREATING LATIN VERBS FOR ALL CONJUGATIONS.
 * Created by snewnham on 02/26/17.
 */

// Runs all unit tests.
@RunWith(Suite.class)

@Suite.SuiteClasses({EnglishVerb_DeponentInstrumentTests.class,
        EnglishVerb_ESSE_InstrumentTests.class,
        EnglishVerb_Irregular_InstrumentTests.class,
        EnglishVerb_Regular_InstrumentTests.class,
        EnglishVerb_SemiDeponent_InstrumentTests.class,
        EnglishVerb_CompoundVerb_InstrumentTests.class,
        LatinVerb_Deponent_InstrumentTests.class,
        LatinVerb_InstrumentTests_1st_Conj.class,
        LatinVerb_InstrumentTests_2nd_Conj.class,
        LatinVerb_InstrumentTests_3rd_Conj.class,
        LatinVerb_InstrumentTests_3rd_io_Conj.class,
        LatinVerb_InstrumentTests_4th_Conj.class,
        LatinVerb_InstrumentTests_ESSE_Irregular.class,
        LatinVerb_InstrumentTests_GeneralTests.class})


public class LatinVerb_TestSuite {}
