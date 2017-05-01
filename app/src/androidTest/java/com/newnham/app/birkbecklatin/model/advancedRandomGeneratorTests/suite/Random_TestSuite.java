package com.newnham.app.birkbecklatin.model.advancedRandomGeneratorTests.suite;

import com.newnham.app.birkbecklatin.model.advancedRandomGeneratorTests.AdvancedNounRandomGeneratorTests;
import com.newnham.app.birkbecklatin.model.advancedRandomGeneratorTests.AdvancedVerbRandomGeneratorTests;

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
