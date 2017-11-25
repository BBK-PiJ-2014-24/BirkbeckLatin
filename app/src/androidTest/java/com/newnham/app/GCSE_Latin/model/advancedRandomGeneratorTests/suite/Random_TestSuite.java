package com.newnham.app.GCSE_Latin.model.advancedRandomGeneratorTests.suite;

import com.newnham.app.GCSE_Latin.model.advancedRandomGeneratorTests.AdvancedNounRandomGeneratorTests;
import com.newnham.app.GCSE_Latin.model.advancedRandomGeneratorTests.AdvancedVerbRandomGeneratorTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TESTS SUITE FOR RANDOM GENERATORS.
 * Created by snewnham on 02/26/17.
 */

// Runs all unit tests.
@RunWith(Suite.class)

@Suite.SuiteClasses({AdvancedNounRandomGeneratorTests.class,
                     AdvancedVerbRandomGeneratorTests.class,})


public class Random_TestSuite {}
