package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;



import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbDeponent;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbIrregular;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbSemiDeponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snewnham on 10/12/2016.
 */

public class VerbGame {


    // Fields
    // ------

    private final static int NUM_CHOICES = 6; // 1 Correct Verb, 5 Incorrect Verbs
    private final static String REGULAR = "Regular";
    private final static String DEPONENT = "Deponent";
    private final static String SEMI_DEPONENT = "Semi Deponent";
    private final static String IRREGULAR = "Irregular";

    private final static String TENSE_PRESENT = "Present";
    private final static String TENSE_IMPERFECT = "Imperfect";
    private final static String TENSE_FUTURE = "Future";
    private final static String TENSE_PERFECT = "Perfect";
    private final static String TENSE_PLUPERFECT = "Pluperfect";
    private final static String TENSE_FUTURE_PERFECT = "Future Perfect";

    private final static String VOICE_ACTIVE = "Indicative";
    private final static String VOICE_PASSIVE = "Passive";

    private final static String MOOD_INDICATIVE = "Active";




    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel;
    private List<Verb> mVerbQuestionList;

    private Verb correctVerb;


    // Constructor
    // -----------
    public VerbGame(DatabaseAccess databaseAccess, int skillLevel){
        mRandomGenerator = new RandomGenerator();
        mDatabaseAccess = databaseAccess;
        mSkillLevel = skillLevel;
        mVerbQuestionList = new ArrayList<>();
    }


    /**
     * runGame
     * -------
     *
     *
     */
    public void runGame(){

        int id = 0;
        String person = null;
        String number = null;
        String voice = null;
        String mood = null;

        int esse_id = 10;
        String conj = "4";
        String type = IRREGULAR;
        String tense = mRandomGenerator.getVerbTense();

        switch(mSkillLevel){
            case 1:
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                while((Integer.parseInt(conj) <= 2 && type.equals(REGULAR)) || id == esse_id){
                    conj = mDatabaseAccess.sqlVerbConjQuery(id);
                    type = mDatabaseAccess.sqlVerbTypeQuery(id);
                }
                voice = VOICE_ACTIVE;
                mood = MOOD_INDICATIVE;

                mVerbQuestionList.add(makeGameVerb(type, id, person, number, TENSE_PRESENT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(type, id, person, number, TENSE_IMPERFECT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(type, id, person, number, TENSE_FUTURE, mood, voice));


        }

        Verb correctVerb = makeGameVerb(type, id, person, number, tense, mood, voice);


    }


    /**
     * makeGameVerb()
     * --------------
     * Forms the correct Verb object (Regular, Deponent, Semi-Deponent, Irregular), given usual
     * verb arguments (person, number, etc.)
     * @param type
     * @param id
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return Verb object (Not the underlying sub classes).
     */
    public Verb makeGameVerb(String type, int id, String person, String number,
                             String tense, String mood, String voice){

        Verb gameVerb = null;
        switch (type) {
            case REGULAR:
                VerbRegular verbRegular = (VerbRegular) mDatabaseAccess.sqlVerbListQuery(id);
                verbRegular.makeLatinVerb(mDatabaseAccess,person, number, tense,
                        mood, voice, Integer.toString(verbRegular.getLatin_ConjNum()));
                verbRegular.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbRegular;
                break;
            case DEPONENT:
                VerbDeponent verbDeponent = (VerbDeponent) mDatabaseAccess.sqlVerbListQuery(id);
                verbDeponent.makeLatinVerb(mDatabaseAccess,person, number, tense,
                        mood, voice, Integer.toString(verbDeponent.getLatin_ConjNum()));
                verbDeponent.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbDeponent;
                break;
            case SEMI_DEPONENT:
                VerbSemiDeponent verbSemiDeponent = (VerbSemiDeponent) mDatabaseAccess.sqlVerbListQuery(id);
                verbSemiDeponent.makeLatinVerb(mDatabaseAccess,person, number, tense,
                        mood, voice, Integer.toString(verbSemiDeponent.getLatin_ConjNum()));
                verbSemiDeponent.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbSemiDeponent;
                break;
            case IRREGULAR:
                VerbIrregular verbIrregular = (VerbIrregular) mDatabaseAccess.sqlVerbListQuery(id);
                verbIrregular.makeLatinVerb(mDatabaseAccess,person, number, tense,
                        mood, voice, Integer.toString(verbIrregular.getLatin_ConjNum()));
                verbIrregular.makeEnglishVerb(mDatabaseAccess, person, number, tense,
                        mood, voice);
                gameVerb = verbIrregular;
                break;
        }
        return gameVerb;
    }



}
