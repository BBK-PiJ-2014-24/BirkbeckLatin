package com.example.snewnham.birkbecklatin.model.NounTests.suite;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_1st_Fem_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_2nd_Male_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_2nd_Neuter_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_3rd_Fem_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_3rd_Male_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_3rd_Neuter_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_4th_Female_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_5th_Male_Declension;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_AdjComparative;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Adjective212;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Adjective333;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Adjective333b;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Adverb;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_AdverbComparative;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_AdverbSuperlative;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Conjunction;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Irregular;
import com.example.snewnham.birkbecklatin.model.NounTests.LatinNoun_InstrumentTests_Preposition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS SUITE FOR CREATING LATIN NOUNS FOR ALL DECLENSIONS, GENDERS and CASES.
 * Created by snewnham on 02/26/17.
 */


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)

@Suite.SuiteClasses({LatinNoun_InstrumentTests_1st_Fem_Declension.class,
        LatinNoun_InstrumentTests_2nd_Male_Declension.class,
        LatinNoun_InstrumentTests_2nd_Neuter_Declension.class,
        LatinNoun_InstrumentTests_3rd_Fem_Declension.class,
        LatinNoun_InstrumentTests_3rd_Male_Declension.class,
        LatinNoun_InstrumentTests_3rd_Neuter_Declension.class,
        LatinNoun_InstrumentTests_4th_Female_Declension.class,
        LatinNoun_InstrumentTests_5th_Male_Declension.class,
        LatinNoun_InstrumentTests_Irregular.class,
        LatinNoun_InstrumentTests_Adjective212.class,
        LatinNoun_InstrumentTests_Adjective333.class,
        LatinNoun_InstrumentTests_Adjective333b.class,
        LatinNoun_InstrumentTests_AdjComparative.class,
        LatinNoun_InstrumentTests_AdverbSuperlative.class,
        LatinNoun_InstrumentTests_Adverb.class,
        LatinNoun_InstrumentTests_AdverbSuperlative.class,
        LatinNoun_InstrumentTests_AdverbComparative.class,
        LatinNoun_InstrumentTests_Conjunction.class,
        LatinNoun_InstrumentTests_Preposition.class})


public class LatinNoun_TestSuite {}
