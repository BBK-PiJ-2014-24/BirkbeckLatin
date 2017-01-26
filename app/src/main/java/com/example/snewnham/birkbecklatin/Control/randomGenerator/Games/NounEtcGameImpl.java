package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snewnham on 20/01/2017.
 */

public class NounEtcGameImpl implements NounEtcGame {


    // Fields
    // ------
    private final int TIME_FOR_INCORRECT_QUESTION = 3;

    private final static String NOUN_SKILL_LEVEL = "Noun_Skill_Level";
    private final static String NOUN_THETA = "Noun_Theta";

    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<Verb> mVerbQuestionList;  // List of 6 Verbs for a Multiple Choice Questions
    private List<VerbGame.Answer> mAnswerList;
    private int mQuestionNumber;
    private Verb mCorrectNounEtc;
    private int mCorrectNounEtcIndex;
    private int mCorrectNounEtcDifficulty;


    // Constructor
    // -----------
    public NounEtcGameImpl(DatabaseAccess databaseAccess, int skillLevel){
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = skillLevel;
        mTheta = skillLevel - 3.0;
        mVerbQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 0;
        mCorrectNounEtc = null;
        mCorrectNounEtcIndex = 100;
        mCorrectNounEtcDifficulty = 100;
    }

    public NounEtcGameImpl(DatabaseAccess databaseAccess){
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = mDatabaseAccess.sqlMetaQuery(NOUN_SKILL_LEVEL);  // Access From Database
        mTheta = mDatabaseAccess.sqlMetaQuery(NOUN_THETA);
        mVerbQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 0;
        mCorrectNounEtc = null;
        mCorrectNounEtcIndex = 100;
        mCorrectNounEtcDifficulty = 100;
    }



    // TODO getNounEtcQuestions() -> generates 6x random NounEtc type, id, given skillLevel

    // TODO storeAnswer()

    // TODO endGame()

    // TODO determineQuestionDifficulty()

    // TODO makeGameNounEtc()  -> makes a Generic NounEtc (id, )

    // TODO updateSkillLevel()

}
