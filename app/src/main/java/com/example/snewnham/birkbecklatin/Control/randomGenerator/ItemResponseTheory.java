package com.example.snewnham.birkbecklatin.Control.randomGenerator;

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

}
