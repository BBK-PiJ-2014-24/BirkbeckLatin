package com.example.snewnham.birkbecklatin;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.ItemResponseTheory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class BasicItemResponseTheoryJunitTests {


    // Fields
    // ------

    double c;    // guess parameter

    double lambda;
    double theta1;    // ability parameter
    double theta2;
    double theta3;
    double theta4;
    double theta5;
    double theta6;
    double theta7;

    double alpha1;    // Item difficulty parameter


    @Before
    public void setUp() {

        c = 0.2;  // i.e. 5 multiple choice questions

        lambda = 1.3;  // discrimination parameter.

        theta1 = -3; // ability parameter
        theta2 = -2;
        theta3 = -1;
        theta4 = 0;
        theta5 = 1;
        theta6 = 2;
        theta7 = 3;

        alpha1 = 1.5;   //difficulty parameter.

    }


    /**
     * testCalcProbTheta()
     * --------------------
     * Tests the calcProbTheta() works correctly. That is test that the method can calc
     * prob(theta); Test along the Item Characteristic Curve(ICC), i.e., vartying theta
     * whilst alpha is fixed.
     * @throws Exception
     */
    @Test
    public void testCalcProbTheta() throws Exception {

        double guessProb1 = ItemResponseTheory.calcProbTheta(c, lambda, theta1, alpha1);
        double guessProb2 = ItemResponseTheory.calcProbTheta(c, lambda, theta2, alpha1);
        double guessProb3 = ItemResponseTheory.calcProbTheta(c, lambda, theta3, alpha1);
        double guessProb4 = ItemResponseTheory.calcProbTheta(c, lambda, theta4, alpha1);
        double guessProb5 = ItemResponseTheory.calcProbTheta(c, lambda, theta5, alpha1);
        double guessProb6 = ItemResponseTheory.calcProbTheta(c, lambda, theta6, alpha1);
        double guessProb7 = ItemResponseTheory.calcProbTheta(c, lambda, theta7, alpha1);

        double ans1 = 0.2;
        double ans2 = 0.21;
        double ans3 = 0.23;
        double ans4 = 0.3;
        double ans5 = 0.47;
        double ans6 = 0.73;
        double ans7 = 0.9;

        double tolerance = 0.005;

        assertTrue("Prob(theta1)", Math.abs(guessProb1 - ans1)< tolerance);
        assertTrue("Prob(theta2)", Math.abs(guessProb2 - ans2) < tolerance);
        assertTrue("Prob(theta3)", Math.abs(guessProb3 - ans3) < tolerance);
        assertTrue("Prob(theta4)", Math.abs(guessProb4 - ans4) < tolerance);
        assertTrue("Prob(theta5)", Math.abs(guessProb5 - ans5) < tolerance);
        assertTrue("Prob(theta6)", Math.abs(guessProb6 - ans6) < tolerance);
        assertTrue("Prob(theta7)", Math.abs(guessProb7 - ans7) < tolerance);


    }


}