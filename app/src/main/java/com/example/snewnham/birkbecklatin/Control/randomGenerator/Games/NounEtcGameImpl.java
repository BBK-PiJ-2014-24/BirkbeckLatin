package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Item;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.ItemResponseTheory;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;

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

    private final static String NOMINATIVE = "Nominative";

    private final static String NOUN_REGULAR = "NounRegular";
    private final static String NOUN_IRREGULAR = "NounIrregular";
    private final static String PREPOSITION = "Preposition";
    private final static String CONJUNCTION = "Conjunction";
    private final static String ADJECTIVE = "Adjective";
    private final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    private final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";
    private final static String ADVERB = "Adverb";
    private final static String ADVERB_COMPARATIVE = "AdverbComparative";
    private final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";

    private final static String GENDER_MALE = "m";
    private final static int DECLENSION3 = 3;

    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<NounEtc> mNounQuestionList;  // List of 6 Verbs for a Multiple Choice Questions
    private List<NounEtcGameImpl.Answer> mAnswerList;
    private int mQuestionNumber;
    private NounEtc mCorrectNounEtc;
    private int mCorrectNounEtcIndex;
    private int mCorrectNounEtcDifficulty;



    // Constructor
    // -----------
    public NounEtcGameImpl(DatabaseAccess databaseAccess, int skillLevel){
        mDatabaseAccess = databaseAccess;
        mRandomGenerator = new RandomGenerator(mDatabaseAccess);
        mSkillLevel = skillLevel;
        mTheta = skillLevel - 3.0;
        mNounQuestionList = new ArrayList<>();
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
        mNounQuestionList = new ArrayList<>();
        mAnswerList = new ArrayList<>();
        mQuestionNumber = 0;
        mCorrectNounEtc = null;
        mCorrectNounEtcIndex = 100;
        mCorrectNounEtcDifficulty = 100;
    }

    /**
     * getNounEtcQuestionSet()
     * ---------------------
     * Generates a list of 6 verb questions given the Table and Ids and skillLevel.
     * Note that Adverb SubClasses need special screening as not all Adverbs can be
     * converted into Comparatives or Superlatives.
     * @param idList - Pair of IDs
     * @return  a list of six NounEtc objects
     */
    @Override
    public List<NounEtc> getNounEtcQuestionSet(String nounType, List<Integer> idList){

        String number1 = mRandomGenerator.getNounNumber();
        String number2 = mRandomGenerator.getNounNumber();
        String number3 = mRandomGenerator.getNounNumber();
        String noun_Case1 = mRandomGenerator.getNounCase();
        String noun_Case2 = mRandomGenerator.getNounCase();
        String noun_Case3 = mRandomGenerator.getNounCase();
        String gender1 = mRandomGenerator.getAdjectiveGender();
        String gender2 = mRandomGenerator.getAdjectiveGender();
        String gender3 = mRandomGenerator.getAdjectiveGender();

        if(mSkillLevel < 4){
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(0), number1, noun_Case1, gender1));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(1), number2, noun_Case2, gender2));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(2), number3, noun_Case3, gender3));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(3), number1, noun_Case1, gender1));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(4), number2, noun_Case2, gender2));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(5), number3, noun_Case3, gender3));
        } else if (mSkillLevel == 4){
            if (nounType.equals(ADJECTIVE))  // If Adjective -> Select Type - Adjective, Comparative, Superlative
                nounType = mRandomGenerator.getAdjectiveType();
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(0), number1, noun_Case1, gender1));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(1), number2, noun_Case2, gender2));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(2), number3, noun_Case3, gender3));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(3), number1, noun_Case1, gender1));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(4), number2, noun_Case2, gender2));
            mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(5), number3, noun_Case3, gender3));
        } else { // mSkillLevel == 5
            if (nounType.equals(ADVERB)) // If Adverb Select Type - Adverb, Comparative, Superlative
                nounType = mRandomGenerator.getAdverbType();
            for(Integer i : idList){
                boolean hasStem = mDatabaseAccess.sqlAdverbCheckStem(idList.get(i));  // Check if Adverb has Stem to build Comparative, Superlative
                if(hasStem)
                    mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(0), number1, noun_Case1, gender1));
                else
                    mNounQuestionList.add(makeGameNounEtc(ADVERB, idList.get(0), number1, noun_Case1, gender1));
            }
        }
        return mNounQuestionList;
    }



    /**
     * makeGameNounEtc()
     * -----------------
     * Make a generic NounEtc for the game, given the Noun Type, Table id, and declension
     * @param type - Type of NounEtc - Regular, Adjective, etc.
     * @param id - id number within Table
     * @param number - "Singular" or "Plural"
     * @param noun_Case -
     * @return - generic NounEtc object.
     */
    @Override
    public NounEtc makeGameNounEtc(String type, int id, String number, String noun_Case, String gender ){

        NounEtc gameNounEtc = null;

        switch(type){
            case NOUN_REGULAR:
                NounRegular nounRegular =  mDatabaseAccess.sqlNounListQuery(NOUN_REGULAR, id);
                nounRegular.makeLatinWord(mDatabaseAccess, number, noun_Case);
                nounRegular.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = nounRegular;
                break;
            case NOUN_IRREGULAR:
                NounRegular nounIrregular = mDatabaseAccess.sqlNounListQuery(NOUN_IRREGULAR, id);
                nounIrregular.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                nounIrregular.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = nounIrregular;
                break;
            case CONJUNCTION:
                Conjunction conjunction = mDatabaseAccess.sqlConjunctionListQuery(id);
                conjunction.makeLatinWord(mDatabaseAccess, number, noun_Case);
                conjunction.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = conjunction;
                break;
            case PREPOSITION:
                Preposition preposition = mDatabaseAccess.sqlPrepositionListQuery(id);
                preposition.makeLatinWord(mDatabaseAccess, number, noun_Case);
                preposition.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = preposition;
                break;
            case ADJECTIVE:
                Adjective adjective = mDatabaseAccess.sqlAdjectiveListQuery(id);
                adjective.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adjective.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adjective;
                break;
            case ADJECTIVE_COMPARATIVE:
                Adjective adjectiveComparative =  mDatabaseAccess.sqlAdjectiveSubClassListQuery(ADJECTIVE_COMPARATIVE, id);
                adjectiveComparative.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adjectiveComparative.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adjectiveComparative;
                break;
            case ADJECTIVE_SUPERLATIVE:
                Adjective adjectiveSuperlative = mDatabaseAccess.sqlAdjectiveSubClassListQuery(ADJECTIVE_SUPERLATIVE, id);
                adjectiveSuperlative.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adjectiveSuperlative.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adjectiveSuperlative;
                break;
            case ADVERB:
                Adverb adverb = mDatabaseAccess.sqlAdverbListQuery(id);
                adverb.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adverb.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adverb;
                break;
            case ADVERB_COMPARATIVE:
                Adverb adverbComparative = mDatabaseAccess.sqlAdverbSubClassListQuery(ADVERB_COMPARATIVE, id);
                adverbComparative.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adverbComparative.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adverbComparative;
                break;
            case ADVERB_SUPERLATIVE:
                Adverb adverbSuperlative =  mDatabaseAccess.sqlAdverbSubClassListQuery(ADVERB_SUPERLATIVE, id);
                adverbSuperlative.makeLatinWord(mDatabaseAccess, number, noun_Case, gender);
                adverbSuperlative.makeEnglishWord(mDatabaseAccess, number);
                gameNounEtc = adverbSuperlative;
                break;
        }
        return gameNounEtc;
    }

    /**
     * determineQuestionDifficulty()
     * -----------------------------
     * Level 1: Nouns 1,2,3 Decl.
     * Level 2: Nouns including Irregular.
     * Level 3: Nouns or Prepositions or Conjunctions
     * Level 4: Nouns or Prepositions or Conjunctions or Adjectives
     * Level 5: Nouns or Prepositions or Conjunctions or Adjectives or
     *          Adverbs (incl. Comparatives, Superlatives)
     *
     * @return skillLevel of question
     */
    @Override
    public int determineQuestionDifficulty(){

        if(mCorrectNounEtc.getType().equals(NOUN_REGULAR) && mCorrectNounEtc.getDeclension() <= DECLENSION3)
            return 1;
        else if(mCorrectNounEtc.getType().equals(NOUN_REGULAR) || mCorrectNounEtc.getType().equals(NOUN_IRREGULAR))
            return 2;
        else if(mCorrectNounEtc.getType().equals(CONJUNCTION) || mCorrectNounEtc.getType().equals(PREPOSITION))
            return 3;
        else if(mCorrectNounEtc.getType().equals(ADJECTIVE))
            return 4;
        else
            return 5;
    }


    // 4. TODO endGame() - UpdateSkillLevel(); MetaInsertion - SkillLevel, VerbTheta
    // 3. TODO storeAnswer() - Update Database for CORRECT or INCORRECT; determineQuestionDifficulty(); Form Answer Object and Add to Lists

    /**
     * storeAnswer()
     * -------------
     * 1) Updates the Correct NounEtc Table, updating CORRECT Field
     * 2) Creates an Answer object to contain data for the question and adds to Answer List.
     * @param ans answer flag - correct/incorrect (1 or 0)
     * @return If answer is correct/incorrect (1 or 0)
     */
    @Override
    public int storeAnswer(String table, int ans){

        // Update Database
        mDatabaseAccess.sqlNounEtcTable_Insert(table, mCorrectNounEtc.getId(), DbSchema.NounListTable.Cols.CORRECT, ans);

        // Form Answer Object and Add to Lists
        mCorrectNounEtcDifficulty = determineQuestionDifficulty(); // determine Difficulty of Question
        Answer answer = new Answer(mCorrectNounEtc.getType(), mCorrectNounEtc.getId(), ans, mCorrectNounEtcDifficulty);  // Set Answer Object
        mAnswerList.add(answer); // Add to buffer mAsked List

        return answer.correct;  // Return if answer is correct/incorrect
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
    @Override
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

    // Getter/Setters
    // --------------

    @Override
    public NounEtc getCorrectNounEtc() {
        return mCorrectNounEtc;
    }

    @Override
    public void setCorrectNounEtc(NounEtc correctNounEtc) {
        mCorrectNounEtc = correctNounEtc;
    }

    @Override
    public List<Answer> getAnswerList() {
        return mAnswerList;
    }

// Inner Class
    // -----------
    /**
     * RESULT - Inner Class
     * --------------------
     * A Container Class that contains the Results for a Question
     * table - NounEtc Table
     * id - NounEtc ID
     * answer - Correct 1, Incorrect 0
     * difficulty -  RSI Question Difficulty Classification
     *
     */
    public class Answer {
        // Fields
        // ------
        public String type;
        public int id;
        public int correct;
        public int difficulty;

        // Constructor
        // -----------
        public Answer(String type, int id, int correct, int difficulty){
            this.type = type;
            this.id = id;
            this.correct = correct;
            this.difficulty = difficulty;
        }
    }
}
