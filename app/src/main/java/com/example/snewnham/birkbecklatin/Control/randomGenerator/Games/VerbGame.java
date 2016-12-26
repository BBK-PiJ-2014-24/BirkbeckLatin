package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Item;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.ItemResponseTheory;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbDeponent;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbIrregular;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbRegular;
import com.example.snewnham.birkbecklatin.Model.verbs.VerbSemiDeponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private final static String ESSE = "esse";



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
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<Verb> mVerbQuestionList;
    private List<Answer> mAnswerList;
    private final int TIME_INCORRECT_QUESTION = 10;
    private int mQuestionNumber;
    private Verb mCorrectVerb;
    private int mCorrectVerbIndex;
    private int mCorrectVerbDifficulty;
    private String mCorrectVerbMood;
    private String mCorrectVerbVoice;



    // Constructor
    // -----------
    public VerbGame(DatabaseAccess databaseAccess, int skillLevel){
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = skillLevel;
        mTheta = skillLevel - 3.0;
        mVerbQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 1;
        mCorrectVerb = null;
        mCorrectVerbIndex = 100;
        mCorrectVerbDifficulty = 100;
        mCorrectVerbMood = null;
        mCorrectVerbVoice = null;


    }

    /**
     * runVerbQuestion()
     * -----------------
     * Generates a Question List of 6 Verbs, selects a correctVerb, shuffles the order of the list.
     *
     */
    public void runVerbQuestion(){

        List<Integer> idList = null;

        int incorrectTableSize = mDatabaseAccess.sqlTableCountQuery(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE);

        do{
            if(mQuestionNumber%TIME_INCORRECT_QUESTION == 0  && incorrectTableSize != 0)   // Time for Incorrect Question ...
                idList = getIncorrectVerbIDs();                                            // if the Incorrect Table is Not empty
            else
                idList = getVerbIDs();
        } while(repeatedQuestion(idList));  // repeat if the id has already been used in a question.

        mVerbQuestionList = getVerbQuestions(idList);  // generate question list

        Random rnd = new Random();
        int rndIndex = rnd.nextInt(3);
        mCorrectVerb = mVerbQuestionList.get(rndIndex); // Select rnd Verb from id1 as the correctVerb

        mVerbQuestionList = mRandomGenerator.shuffleVerbList(mVerbQuestionList); // shuffle Question List

        mCorrectVerbIndex = mVerbQuestionList.indexOf(mCorrectVerb); // find the index of the Correct Verb
                                                                     // in the shuffle list.

    }


    /**
     * checkAnswer()
     * -------------
     * Determines if the answer to a question is correct. Creates Answer object and adds to
     * Answer List
     * @param guessIndex  index of the Verb Selected by the student
     * @return If answer is correct/incorrect (1 or 0)
     */
    public int checkAnswer(int guessIndex){

        int ans = (guessIndex == mCorrectVerbIndex) ? 1 :0;  // determine correct/incorrect answer
        mCorrectVerbDifficulty = determineQuestionDifficulty(); // determine Difficulty of Question

        Answer answer = new Answer(mCorrectVerb.getId(), ans, mCorrectVerbDifficulty);  // Set Answer Object

        mAnswerList.add(answer); // Add to buffer mAnswer List

        return answer.correct;  // Return if answer is correct/incorrect
    }


    /**
     * determineQuestionDifficulty()
     * -----------------------------
     * Determines the skillLevel difficulty of the Correct Verb
     * @return difficulty 1- 5
     */
    public int determineQuestionDifficulty(){

        if(mCorrectVerbMood.equals(MOOD_SUBJUNCTIVE))
            return 5;
        else if(mCorrectVerb.getLatin_Type().equals(DEPONENT) || mCorrectVerb.getLatin_Type().equals(SEMI_DEPONENT) ||
                mCorrectVerb.getLatin_Type().equals(IRREGULAR) && !mCorrectVerb.getLatin_Infinitive().equals(ESSE))
            return 4;
        else if(mCorrectVerbVoice.equals(VOICE_PASSIVE))
            return 3;
        else if(mCorrectVerb.getLatin_ConjNum() > 2)
            return 2;
        else
            return 1;

    }



    /**
     * repeatedQuestion()
     * ------------------
     * Check the Answer List to see if the Verb Id1 has already been tested.
     * (Used in runVerbQuestion() )
     *
     * @param idList
     * @return
     */
    public boolean repeatedQuestion(List<Integer> idList){
        for(Answer answer : mAnswerList){
            int resultId = answer.id;
            if(resultId == idList.get(0))
                return true;
        }
        return false;

    }


    /**
     * getVerbIDs()
     * ------------
     * Generates a pair of Verb IDs given the Skill Level
     *
     * @return get Verb IDs
     */
    public List<Integer> getVerbIDs(){

        List<Integer> idList = null;
        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        switch(mSkillLevel) {
            case 1:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_2); // Conjs 1-2
                break;
            case 2:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs Conjs 1-4
                break;
            case 3:
                idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs Conjs 1-4
                break;
            case 4:
                idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs Conjs 1-4, Deponents, Semi-Dep, Irregular
                break;
            case 5:
                idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs  Conjs 1-4, Deponents, Semi-Dep, Irregular
                break;
        }
        return idList;
    }


    /**
     * getIncorrectVerbId()
     * --------------------
     * Generate a random verb_ID from the INCORRECT_VERB_TABLE and then find its
     * consecutive pair in the Verb_List Table
     *
     * @return List of a pair of verb_ids, one is from the incorrect table
     */
    public List<Integer> getIncorrectVerbIDs(){
        int conjNum1_2 = 2;
        int conjNum1_4 = 40;

        List<Integer> list = new ArrayList<>();

        int numVerbs = mDatabaseAccess.sqlTableCountQuery(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE);  // Count Number of Verbs in Table
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(numVerbs) + 1;  //

        int verbId1 = mDatabaseAccess.sqlIncorrectVerb_GetId(randomIndex);  // Select id from Incorrect Table
        list.add(verbId1);

        switch(mSkillLevel) {
            case 1:
                list = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_2, verbId1);
                break;
            case 2:
                list = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4, verbId1);
                break;
            case 3:
                list = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4, verbId1);
                break;
            case 4:
                list = mRandomGenerator.getUnrestrictedRandomVerbID(verbId1);
                break;
            case 5:
                list = mRandomGenerator.getUnrestrictedRandomVerbID(verbId1);
                break;
        }
        return list;
    }

    /**
     * getVerbQuestions()
     * ------------------
     *
     * Generates a list of 6 verb questions given the skill level of the student.
     * @return  a list of six Verb objects
     */
    public List<Verb> getVerbQuestions(List<Integer> idList){

        String person = null;
        String number = null;
        String voice = null;
        String voice1 = null;
        String voice2 = null;
        String type0 = null;
        String type1 = null;

        String mood = null;
       // List<Integer> idList;
        List<String> tenseList0; // list of random tenses
        List<String> tenseList1;
       // int conjNum1_2 = 2;
       // int conjNum1_4 = 4;
        int esse_ID = 10;  // Need to check that Esse Verbs Are only Active.

        switch(mSkillLevel){
            case 1:
                //idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_2); // Two Verb IDs
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
              //  idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice = VOICE_ACTIVE;
                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice));
                break;

            case 3:
              //  idList = mRandomGenerator.getRestrictedRandomVerbID(conjNum1_4); // Two Verb IDs
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();

                voice1 = mRandomGenerator.getVerbVoice(); // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent or Esse Verb
                voice2 = voice1;
                if(voice1.equals(VOICE_PASSIVE)) {
                    type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                    type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                    if(type0.equals(DEPONENT) || type0.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                do {
                    mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                } while (mood.equals(MOOD_SUBJUNCTIVE));

                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 4:
              //  idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs
                type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                voice1 = mRandomGenerator.getVerbVoice();
                voice2 = voice1;


                // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent
                if(voice1.equals(VOICE_PASSIVE)) {
                    if(type0.equals(DEPONENT) || type0.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                // Check that Irregular Verbs Have Mood = Indicative
                if(type0.equals(IRREGULAR) || type1.equals(IRREGULAR)){
                    mood = MOOD_INDICATIVE;
                } else {
                    do {
                        mood = mRandomGenerator.getVerbMood();   // Select only Indicative or Imperative
                    } while (mood.equals(MOOD_SUBJUNCTIVE));
                }

                // Special Verb Question List for Imperatives
                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;

            case 5:
              //  idList = mRandomGenerator.getUnrestrictedRandomVerbID();   // Unrestricted Two Verb IDs
                type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
                type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));
                person = mRandomGenerator.getVerbPerson();
                number = mRandomGenerator.getVerbNumber();
                mood = mRandomGenerator.getVerbMood();
                voice1 = mRandomGenerator.getVerbVoice();
                voice2 = voice1;


                // Allow ACTIVE and PASSIVE, but Checking for Deponent/Semi-Deponent
                if(voice1.equals(VOICE_PASSIVE)) {
                    if(type0.equals(DEPONENT) || type0.equals(SEMI_DEPONENT) || idList.get(0) == esse_ID)
                        voice1 = VOICE_ACTIVE;
                    if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT) || idList.get(1) == esse_ID)
                        voice2 = VOICE_ACTIVE;
                }

                // Check that Irregular Verbs Have Mood = Indicative
                if(type0.equals(IRREGULAR) || type1.equals(IRREGULAR)){
                    mood = MOOD_INDICATIVE;
                }

                // Special Verb Question List for Imperatives
                if(mood.equals(MOOD_IMPERATIVE)){        // Early Break if Imperative
                    mVerbQuestionList = makeImperativeQuestionList(idList);
                    break;
                }

                if(mood.equals(MOOD_SUBJUNCTIVE) && !number.equals(NUMBER_INFINITIVE)){
                    tenseList0 = mRandomGenerator.getSubjunctiveVerbTenseList();  // Restricted to non-Future Tenses
                    tenseList1 = mRandomGenerator.getSubjunctiveVerbTenseList();
                } else if(number.equals(NUMBER_INFINITIVE)) {   // Restrict Tenses for Infinitive
                    tenseList0 = mRandomGenerator.getInfinitiveVerbTenseList();
                    tenseList1 = mRandomGenerator.getInfinitiveVerbTenseList();
                } else {
                    tenseList0 = mRandomGenerator.getVerbTenseList();
                    tenseList1 = mRandomGenerator.getVerbTenseList();
                }

                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(0), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(1), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(0), person, number, tenseList0.get(2), mood, voice1));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(0), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(1), mood, voice2));
                mVerbQuestionList.add(makeGameVerb(idList.get(1), person, number, tenseList1.get(2), mood, voice2));
                break;
        }

        mCorrectVerbMood = mood;
        mCorrectVerbVoice = voice1;
        return mVerbQuestionList;
    }


    /**
     * makeImperativeQuestionList()
     * ----------------------------
     * A Separate Helper Method to Create a Question List for IMPERATIVES, given that there
     * are only 4 Imperatives for each Verb. So Need to have a special list to ensure full
     * population of 6 questions.
     * Note that Persons (1,2,3) and tenses are set to Null as they are not required
     * ALSO note that we have to add 2 Infinitive questions to the list as DEPONENT verbs do not
     * have passive IMPERATIVES.
     * @param idList - List of IDs
     * @return - List of Imperative Questions
     */
    public List<Verb> makeImperativeQuestionList(List<Integer> idList){

        String type0 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(0));
        String type1 = mDatabaseAccess.sqlVerbTypeQuery(idList.get(1));

        List<Verb> imperativeQuestionList = new ArrayList<>();

        // Verbs for id0
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_ACTIVE));

        // can't have passive Imperative for Deponents and Semi_Deponents. Replace with Infinitive
        if(type0.equals(DEPONENT) || type0.equals(SEMI_DEPONENT)) {
            imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_INFINITIVE, TENSE_PERFECT, MOOD_INDICATIVE, VOICE_ACTIVE));
        } else {
            imperativeQuestionList.add(makeGameVerb(idList.get(0), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        }

        // Verbs for id1
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_SINGULAR, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_ACTIVE));
        if(type1.equals(DEPONENT) || type1.equals(SEMI_DEPONENT)) {  // can't passive Imperative
            imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_INFINITIVE, TENSE_FUTURE, MOOD_INDICATIVE, VOICE_ACTIVE));
        } else {
            imperativeQuestionList.add(makeGameVerb(idList.get(1), null, NUMBER_PLURAL, null, MOOD_IMPERATIVE, VOICE_PASSIVE));
        }

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

    /**
     * updateSkillLevel()
     * ------------------
     * updates the skillLevel of the student by processing the results of the Test
     * through the Item Response Theory Algo.
     *
     * If the student's updated theta is >+2, the skillLevel is increased
     * If the student's updated theta is <-2, the skillLevel is decreased.
     *
     * @return the updated skill level of the student.
     */
    public int updateSkillLevel(List<Answer> answerList){

        double c = 1/6;    // Number of Questions
        double lambda = 0.5;    // Discrimination

        List<Item> itemList = new ArrayList<>();

        for(Answer answer : answerList){   // go through answer list
            double alpha = answer.difficulty - 3.0;
            int mark = answer.correct;
            Item item = new Item(c, mTheta, alpha, lambda, mark); // convert each answer to IRT Item
            itemList.add(item);  // Build Item List
        }

       mTheta = ItemResponseTheory.calcNewTheta(itemList); // Calc new Theta.

        if(mTheta > 2 && mSkillLevel < 5)
            mSkillLevel = mSkillLevel + 1;
        else if (mTheta < -2 && mSkillLevel > 1)
            mSkillLevel = mSkillLevel - 1;

        return mSkillLevel;
    }

    /**
     * addToTheIncorrectVerbTable()
     * ----------------------------
     * Adds the Incorrect Answers to the Incorrect Table and keeps a
     * tally of the number.
     *
     * @return the number of verbs added to the Incorrect Table
     */
    public int addToTheIncorrectVerbTable(List<Answer> answerList){
        int count = 0;
        List<Integer> incorrectList = new ArrayList<>();

        for(Answer answer : answerList){  // select the ID's of all Incorrect Verb Answers
           if(answer.correct == 0){
               incorrectList.add(answer.id);
               count++;
           }
        }

        for(Integer id : incorrectList){    // convert ids to verbs add to table
            Verb verb = mDatabaseAccess.sqlVerbListQuery(id);
            mDatabaseAccess.sqlIncorrectVerb_Insert(verb);
        }
        return count;
    }

    // Getters/Setters
    // ---------------

    public List<Verb> getVerbQuestionList() {
        return mVerbQuestionList;
    }

    public Verb getCorrectVerb() {
        return mCorrectVerb;
    }

    public void setCorrectVerb(Verb correctVerb) {
        mCorrectVerb = correctVerb;
    }

    public int getCorrectVerbDifficulty() {
        return mCorrectVerbDifficulty;
    }

    public int getCorrectVerbIndex() {
        return mCorrectVerbIndex;
    }

    public String getCorrectVerbMood() {
        return mCorrectVerbMood;
    }

    public void setCorrectVerbMood(String correctVerbMood) {
        mCorrectVerbMood = correctVerbMood;
    }

    public String getCorrectVerbVoice() {
        return mCorrectVerbVoice;
    }

    public void setCorrectVerbVoice(String correctVerbVoice) {
        mCorrectVerbVoice = correctVerbVoice;
    }

// Inner Class
    // -----------
    /**
     * RESULT - Inner Class
     * --------------------
     * A Container Class that contains the Results for a Question
     * id - Verb ID
     * answer - Correct 1, Incorrect 0
     * difficulty -  RSI Question Difficulty Classification
     *
     */
    public class Answer {
        // Fields
        // ------
        public int id;
        public int correct;
        public int difficulty;

        // Constructor
        // -----------
        public Answer(int id, int correct, int difficulty){
            this.id = id;
            this.correct = correct;
            this.difficulty = difficulty;
        }

    }


}
