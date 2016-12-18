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

    private final static String NUMBER_SINGULAR = "Singular";
    private final static String NUMBER_PLURAL = "Plural";
    private final static String NUMBER_INFINITIVE = "Infinitive";

    private final static String PERSON1 = "1st";
    private final static String PERSON2 = "2nd";
    private final static String PERSON3 = "3rd";

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
        String voice1 = null;
        String voice2 = null;

        String mood = null;
        List<Integer> idList;
        List<String> tenseList0; // list of random tenses
        List<String> tenseList1;
        int conjNum1_2 = 2;
        int conjNum1_4 = 4;
        int esse_ID = 10;  // Need to check that Esse Verbs Are only Active.

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

                voice1 = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent or Esse Verb
                voice2 = voice1;
                if(voice1.equals(VOICE_PASSIVE)) {
                    String type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                    String type2 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type2.equals(DEPONENT) || type2.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 4:
                idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice1 = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent
                voice2 = voice1;
                if(voice1.equals(VOICE_PASSIVE)) {
                    String type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                    String type2 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type2.equals(DEPONENT) || type2.equals(SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 5:
                idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice1 = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent
                voice2 = voice1;
                if(voice1.equals(VOICE_PASSIVE)) {
                    String type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                    String type2 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type2.equals(DEPONENT) || type2.equals(SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative IF AN INFINITIVE
                tenseList0 = mRandomGenerator.getVerbTenseList();
                tenseList1 = mRandomGenerator.getVerbTenseList();

                // Alter MOOD Arguments for Infinitive - Cannot Have Number: Infinitive AND Mood: Subjunctive
                if(number.equals(NUMBER_INFINITIVE) ) {  // OR Number: Infinitive AND Mood: Imperative
                   mood = MOOD_INDICATIVE;
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;
        }

        return mVerbQuestionList;
    }


    /**
     * makeImperativeQuestionList()
     * ----------------------------
     * A Separate Helper Method to Create a Question List for IMPERATIVES, given that there
     * are only 4 Imperatives for each Verb. So Need to have a special list to ensure full
     * population of 6 questions.
     * Note that Persons (1,2,3) and tenses are set to Null as they are not required
     * @param idList - List of IDs
     * @return - List of Imperative Questions
     */
    public List<Verb> makeImperativeQuestionList(List<Integer> idList){
        List<Verb> imperativeQuestionList = new ArrayList<>();

        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));


        return imperativeQuestionList;
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
