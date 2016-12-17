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

    private final static String VOICE_ACTIVE = "Active";
    private final static String VOICE_PASSIVE = "Passive";

    private final static String MOOD_INDICATIVE = "Indicative";
    private final static String MOOD_IMPERATIVE = "Imperative";
    private final static String MOOD_SUBJUNCTIVE = "Subjunctive";


    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel;
    private List<Verb> mVerbQuestionList;

    private Verb correctVerb;


    // Constructor
    // -----------
    public VerbGame(DatabaseAccess databaseAccess, int skillLevel){
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
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

    }


    /**
     * getVerbQuestions()
     * ------------------
     *
     * @return
     */
    public List<Verb> getVerbQuestions(){

        String person = null;
        String number = null;
        String voice = null;
        String mood = null;
        List<Integer> idList;
        List<String> tenseList0; // list of random tenses
        List<String> tenseList1;
        int conjNum1_2 = 2;
        int conjNum1_4 = 4;

        switch(mSkillLevel){
            case 1:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_2); // Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice = VOICE_ACTIVE;
                mood = MOOD_INDICATIVE;

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_PRESENT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_IMPERFECT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, TENSE_FUTURE, mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_PRESENT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_IMPERFECT, mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, TENSE_FUTURE, mood, voice));
                break;
            case 2:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice = VOICE_ACTIVE;
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice));
                break;
            case 3:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();

                voice = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice));
                break;
            case 4:
                idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice));
                break;



        }

        return mVerbQuestionList;
    }


    /**
     * makeGameVerb()
     * --------------
     * Forms the correct Verb object (Regular, Deponent, Semi-Deponent, Irregular), given usual
     * verb arguments (person, number, etc.)
     * @param id
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return Verb object (Not the underlying sub classes).
     */
    public Verb makeGameVerb(int id, String person, String number,
                             String tense, String mood, String voice){

        Verb gameVerb = null;
        String type = mDatabaseAccess.sqlVerbTypeQuery(id);  // Find out What Type is the Verb

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
