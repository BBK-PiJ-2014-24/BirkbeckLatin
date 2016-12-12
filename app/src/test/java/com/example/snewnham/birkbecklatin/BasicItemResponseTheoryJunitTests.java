package com.example.snewnham.birkbecklatin;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Item;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.ItemResponseTheory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * testCalcNewTheta()
     * ------------------
     * Test calcNewTheta() can update the new theta value after processing a list of items.
     * @throws Exception
     */

    @Test
    public void testCalcNewTheta() throws Exception{

        int c = 0;

        int mark1 = 1;  // response
        int mark2 = 0;
        int mark3 = 1;

        double alpha1 = -1;   // difficulty
        double alpha2 = 0;
        double alpha3 = 1;

        double lambda1 = 1.0;   // discrimination
        double lambda2 = 1.2;
        double lambda3 = 0.8;

        double tolerance = 0.0005;
        double answerTheta = 0.3249;

        double originalTheta = 1;


        Item item1 = new Item(c, theta5, alpha1, lambda1, mark1);
        Item item2 = new Item(c, theta5, alpha2, lambda2, mark2);
        Item item3 = new Item(c, theta5, alpha3, lambda3, mark3);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);


        double newTheta = ItemResponseTheory.calcNewTheta( itemList );
        int x = 5;

        assertTrue("calcTheta", Math.abs(newTheta - answerTheta)< tolerance);
    }



    /**
     * testCalcNewTheta()
     * ------------------
     * Test calcNewTheta() can update the new theta value after processing a list of ALL CORRECT items.
     * @throws Exception
     */

    @Test
    public void testMaxExtremeCalcNewTheta() throws Exception{

        int c = 0;

        int mark1 = 1;  // response

        double alpha1 = -1;   // difficulty

        double lambda1 = 1.0;   // discrimination

        Item item1 = new Item(c, theta5, alpha1, lambda1, mark1);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);    // ALL CORRECT ANSWERS
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);

        double newTheta = ItemResponseTheory.calcNewTheta( itemList );

        assertEquals("test ALL CORRECT", 3.0,newTheta,0.1);
    }


    /**
     * testCalcNewTheta()
     * ------------------
     * Test calcNewTheta() can update the new theta value after processing a list of ALL WRONG items.
     * @throws Exception
     */

    @Test
    public void testMinExtremeCalcNewTheta() throws Exception{

        int c = 0;

        int mark2 = 0;  // response

        double alpha1 = -1;   // difficulty

        double lambda1 = 1.0;   // discrimination

        Item item2 = new Item(c, theta5, alpha1, lambda1, mark2);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item2);    // ALL CORRECT ANSWERS
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);

        double newTheta = ItemResponseTheory.calcNewTheta( itemList );

        assertEquals("test ALL WRONG", -3.0,newTheta,0.1);
    }

    @Test
    public void testExponential() throws Exception {

        double lambda = 0.5;
        List<Double> list = new ArrayList<>();

        for(int i=0; i<100; i++) {
            double u = Math.random();
            double x = -(1 / lambda) * Math.log(u);
            list.add(x);
        }

        int ww = 5;

    }






}