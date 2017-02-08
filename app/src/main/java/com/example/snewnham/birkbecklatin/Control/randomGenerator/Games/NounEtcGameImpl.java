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
import java.util.Random;

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

    private final static String NOUN = "Noun";
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

    private final static int CORRECT = 1;
    private final static int INCORRECT = 0;
    private final static int ASKED = 1;
    private final static int NOT_ASKED = 0;


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
    private int mNumChoicesInQuestion;



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
        mNumChoicesInQuestion = 6;
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
        mNumChoicesInQuestion = 6;
    }


    /**
     * runNounGame()
     * -------------
     * Generates:
     * 1) Generate Random NounType given skillLevel.
     * 2) Generate set of NounEtc IDs, updating the ASKED FIELD == 1
     * 3) Forms a Question List of 6 NounEtc
     * 4) Randomly selects a correctNoun
     * 5) Shuffles the order of the Noun QuestionSet.
     *
     */
    @Override
    public void runNounGame(){

        // Pre-Game Preparations
        mQuestionNumber++; // Increase Counter
        List<NounEtc> newNounList = new ArrayList<>(6);
        mNounQuestionList = newNounList; // Hack to Reset The Verb Question List
        boolean restricted = (mSkillLevel == 1) ? true : false; // restriction Noun Declensions


        // Generate Random NounType given skillLevel and its Database Table Name
        String nounType = mRandomGenerator.getNounEtcType(mSkillLevel);
        String table = getTableName(nounType);


        // defence check to see if there is enough UNASKED, CORRECT Nouns Left.
        List<Integer> listCorrectNounIDs = mDatabaseAccess.getNounEtcIDlist(table, CORRECT, restricted );
        int correctTableSize = listCorrectNounIDs.size();
        if(correctTableSize < mNumChoicesInQuestion){ // If less than 6 CORRECT VerbIDs have not been asked  ...
            mDatabaseAccess.sqlNounEtcTable_AskedReset(table, CORRECT); // ...then Reset all ASKED Fields = 0 for CORRECT VERBS;
            listCorrectNounIDs = mDatabaseAccess.getNounEtcIDlist(table, CORRECT, restricted );
            correctTableSize = listCorrectNounIDs.size();
            if(correctTableSize < mNumChoicesInQuestion){  // If still small table -> Then ALL verbs have been answered INCORRECT
                mDatabaseAccess.sqlNounEtcTable_Reset(table, DbSchema.NounListTable.Cols.CORRECT);
                mDatabaseAccess.sqlNounEtcTable_Reset(table, DbSchema.NounListTable.Cols.ASKED);
            }
        }

        // Check if time for Incorrect Question ...
        // But first preparation for a defence check to see how many (Unasked) INCORRECT Verbs left
        List<Integer> listIncorrectNounIDs = mDatabaseAccess.getNounEtcIDlist(table, INCORRECT, restricted );
        int incorrectTableSize = listIncorrectNounIDs.size(); // must have than 1 for a pair

        int correctValue;
        if(mQuestionNumber % TIME_FOR_INCORRECT_QUESTION == 0  && incorrectTableSize  > mNumChoicesInQuestion )
            correctValue = INCORRECT;                              // Yes. Not All Verbs in Correct Table been tested
        else
            correctValue = CORRECT;


        // generate set of NounEtc IDs
        List<Integer> idList = mRandomGenerator.getRandomNounEtcIDlist(table, mSkillLevel, correctValue);


        // Updates the Database that the NounEtc IDs have been used
        for(Integer i : idList){
            mDatabaseAccess.sqlNounEtcTable_Insert(table, i, DbSchema.NounListTable.Cols.ASKED, ASKED);
        }

        // Generate question set
        mNounQuestionList = getNounEtcQuestionSet(nounType, idList);

        // Select a correctVerb NounEtc randomly
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(mNumChoicesInQuestion);
        mCorrectNounEtc = mNounQuestionList.get(rndIndex);

        mNounQuestionList = mRandomGenerator.shuffleNounList(mNounQuestionList); // shuffle Question List

        mCorrectNounEtcIndex = mNounQuestionList.indexOf(mCorrectNounEtc); // find the index of the Correct Verb
                                                                           // in the shuffle list.
    }

    /**
     * getTableName()
     * --------------
     * Maps the Database Table Name to a given NounEtc Type
     * @param type - NounEtc Type
     * @return  -  Name of Database Table
     */
    public String getTableName(String type){
        switch(type){
            case(NOUN_REGULAR):
                return DbSchema.NounListTable.NOUN_LIST_TABLE;
            case(NOUN_IRREGULAR):
                return DbSchema.NounListTable.NOUN_LIST_TABLE;
            case(PREPOSITION):
                return DbSchema.PrepositionListTable.PREPOSITION_TABLE;
            case(CONJUNCTION):
                return DbSchema.ConjunctionListTable.CONJUNCTION_TABLE;
            case(ADJECTIVE):
                return DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE;
            case(ADVERB):
                return DbSchema.AdverbListTable.ADVERB_TABLE;
        }
        return null;
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

    /**
     * endGame()
     * ---------
     * Run at the end of the game:
     * 1) updates the students IRT Theta and game skill level.
     * 2) Stores Theta and SkillLevel in the Meta Table.
     *
     */
    @Override
    public void endGame(){
        updateSkillLevel(mAnswerList); // update the Skill Level after the Test
        mDatabaseAccess.sqlMeta_Insertion(NOUN_SKILL_LEVEL, mSkillLevel*1.0); // Add skill, Theta to meta table
        mDatabaseAccess.sqlMeta_Insertion(NOUN_THETA, mTheta);
        mDatabaseAccess.close();
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
    public int getCorrectNounEtcIndex() {
        return mCorrectNounEtcIndex;
    }

    @Override
    public List<NounEtc> getNounQuestionList() {
        return mNounQuestionList;
    }

    @Override
    public List<Answer> getAnswerList() {
        return mAnswerList;
    }


    @Override
    public void setQuestionNumber(int questionNumber) {
        mQuestionNumber = questionNumber;
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
        NounEtc noun;

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
}
