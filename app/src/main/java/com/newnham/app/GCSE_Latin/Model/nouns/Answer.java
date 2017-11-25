package com.newnham.app.GCSE_Latin.Model.nouns;

/**
 * Created by snewnham on 08/02/2017.
 */


/**
 * RESULT - Inner Class
 * --------------------
 * A Container Class that contains the Results for a Question
 * id - NounEtc ID
 * answer - Correct 1, Incorrect 0
 * difficulty -  RSI Question Difficulty Classification
 * NounEtc - the Correct NounEtc
 */
public class Answer {

    // Fields
    // ------
    public String type;
    public int id;
    public int correct;
    public int difficulty;
    public NounEtc noun;

    // Constructor
    // -----------
    public Answer(String type, int id, int correct, int difficulty){
        this.type = type;
        this.id = id;
        this.correct = correct;
        this.difficulty = difficulty;
    }

    public Answer(String type, int id, int correct, int difficulty, NounEtc noun){
        this.type = type;
        this.id = id;
        this.correct = correct;
        this.difficulty = difficulty;
        this.noun = noun;
    }
}