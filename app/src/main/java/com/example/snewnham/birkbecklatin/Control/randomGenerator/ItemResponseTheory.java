package com.example.snewnham.birkbecklatin.Control.randomGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by snewnham on 05/12/2016.
 */

public class ItemResponseTheory {

    public ItemResponseTheory(){

    }


    /**
     * calcProbTheta() - Calculates an student's prob of answering
     * ---------------   a Item (question) correctly, given the
     *                   student's ability (Theta)
     *                   and the difficulty of the question.
     * @param c - guessing parameter - prob of correct guess from multiple choice.
     * @param lambda - discrimination parameter -the Item's(question's) ability to discern ability.
     * @param theta - the examinee's ability
     * @param alpha - the difficulty question
     * @return Prob(Theta) = [0,1]
     */
    public static double calcProbTheta(double c, double lambda,double theta, double alpha ){

        return  c + ((1-c)*(1/(1 + Math.exp(-lambda*(theta - alpha)))));
    }


    /**
     * calcNewTheta()
     * --------------
     * Calculates a newly updated Theta (the student's ability), given new
     * question's results. Border Cases are confined to [-3,+3] for
     * (ALL INCORRECT items, ALL CORRECT items).
     *
     * @param list - List of Items
     * Note that an item object contains:
     *      theta - Theta Before Update - the examinee's ability
     *      mark - Correct/Incorrect Answer [wrong: 0, right: +1]
     *      alpha - difficulty of question
     *      c - guessing parameter
     *      lambda - discrimination parameter
     * @return the updated theta.
     */
    public static double calcNewTheta(List<Item> list) {

        double tolerance = 0.05;
        double adjustedTheta = 100;  // Dummy High Level
        double c;
        double theta = 0;  // Dummy initial setting
        double alpha;
        double lambda;
        int mark;
        double probTheta;
        double lambdaSq;
        double nominatorSum = 0;
        double denominatorSum = 0;
        int sumMark = 0;

        // Check First For Boundary Conditions
        for(Item item : list){
            sumMark = sumMark + item.getMark();
        }
        if(sumMark == 0)
            return -3;        // FULL MARKS
        else if (sumMark == list.size())
            return 3;         // ZERO MARKS
        else {


            while (Math.abs(adjustedTheta - theta) > tolerance) {

                for (Item item : list) {
                    c = item.getC();
                    theta = item.getTheta();
                    alpha = item.getAlpha();
                    lambda = item.getLambda();
                    mark = item.getMark();
                    probTheta = calcProbTheta(c, lambda, theta, alpha); // Calc Pr(theta)
                    lambdaSq = lambda * lambda;

                    nominatorSum = nominatorSum + (lambda * (mark - probTheta));
                    denominatorSum = denominatorSum + (lambdaSq * probTheta * (1 - probTheta));
                }

                adjustedTheta = theta + (nominatorSum / denominatorSum);
                nominatorSum = 0;    // Reset Aggregators to Zero.
                denominatorSum = 0;

                for (Item item : list) {
                    item.setTheta(adjustedTheta);  // reset theta to newly updated theta
                }                                  // for next iteration loop.


            }

            return adjustedTheta;
        }
    }






}
