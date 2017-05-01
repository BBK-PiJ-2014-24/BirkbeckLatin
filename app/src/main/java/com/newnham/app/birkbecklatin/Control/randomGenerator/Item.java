package com.newnham.app.birkbecklatin.Control.randomGenerator;

/**
 * Created by snewnham on 07/12/2016.
 * Container Object to hold data for an Item (i.e. Question) in the Item Response
 * Theory set up.
 *
 * mC - guessing parameter
 * mTheta - the examinee's ability
 * mAlpha - difficulty of question
 * mLambda - discrimination parameter
 * mMark - Correct/Incorrect Answer [wrong: 0, right: +1]
 */

public class Item {


    // Fields
    // ------
    private double mC;
    private double mTheta;
    private double mAlpha;
    private double mLambda;
    private int mMark;


    // Constructor
    // -----------
    public Item(double c, double theta, double alpha, double lambda, int mark) {
        mC = c;
        mTheta = theta;
        mAlpha = alpha;
        mLambda = lambda;
        mMark = mark;
    }

    // Getter/Setters
    // --------------
    public double getTheta() {
        return mTheta;
    }

    public void setTheta(double theta) {
        mTheta = theta;
    }

    public int getMark() {
        return mMark;
    }

    public double getAlpha() {
        return mAlpha;
    }

    public double getC() {
        return mC;
    }

    public double getLambda() {
        return mLambda;
    }
}
