package com.newnham.app.birkbecklatin.Model.verbs;

/**
 * Created by snewnham on 08/02/2017.
 */

/**
 * RESULT - Inner Class
 * --------------------
 * A Container Class that contains the Results for a Question
 * id - Verb ID
 * answer - Correct 1, Incorrect 0
 * difficulty -  RSI Question Difficulty Classification
 * verb - the Correct Verb
 */
public class Answer {
    // Fields
    // ------
    public int id;
    public int correct;
    public int difficulty;
    public Verb verb;

    // Constructor
    // -----------
    public Answer(int id, int correct, int difficulty){
        this.id = id;
        this.correct = correct;
        this.difficulty = difficulty;
    }

    public Answer(int id, int correct, int difficulty, Verb verb){
        this.id = id;
        this.correct = correct;
        this.difficulty = difficulty;
        this.verb = verb;
    }
}