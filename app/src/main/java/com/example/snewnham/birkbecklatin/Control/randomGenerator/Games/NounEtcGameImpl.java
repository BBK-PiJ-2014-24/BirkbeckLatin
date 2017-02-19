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
import com.example.snewnham.birkbecklatin.Model.nouns.Answer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    private final static String NOUN_SCORE = "NounScore";
    private final static String NOUN_REGULAR_SCORE= "NounRegularScore";
    private final static String NOUN_IRREGULAR_SCORE = "NounIrregularScore";
    private final static String PREPOSITION_SCORE = "PrepositionScore";
    private final static String CONJUNCTION_SCORE = "ConjunctionScore";
    private final static String ADJECTIVE_SCORE = "AdjectiveScore";
    private final static String ADJECTIVE_COMPARATIVE_SCORE = "AdjectiveComparativeScore";
    private final static String ADJECTIVE_SUPERLATIVE_SCORE = "AdjectiveSuperlativeScore";
    private final static String ADVERB_SCORE = "AdverbScore";
    private final static String ADVERB_COMPARATIVE_SCORE = "AdverbComparativeScore";
    private final static String ADVERB_SUPERLATIVE_SCORE = "AdverbSuperlativeScore";

    private final static String NOUN_TALLY = "NounTally";
    private final static String NOUN_REGULAR_TALLY = "NounRegularTally";
    private final static String NOUN_IRREGULAR_TALLY = "NounIrregularTally";
    private final static String PREPOSITION_TALLY = "PrepositionTally";
    private final static String CONJUNCTION_TALLY = "ConjunctionTally";
    private final static String ADJECTIVE_TALLY = "AdjectiveTally";
    private final static String ADJECTIVE_COMPARATIVE_TALLY = "AdjectiveComparativeTally";
    private final static String ADJECTIVE_SUPERLATIVE_TALLY = "AdjectiveSuperlativeTally";
    private final static String ADVERB_TALLY = "AdverbTally";
    private final static String ADVERB_COMPARATIVE_TALLY = "AdverbComparativeTally";
    private final static String ADVERB_SUPERLATIVE_TALLY = "AdverbSuperlativeTally";

    private final static String NOUN_HIST_PERC = "Noun_Hist%";
    private final static String NOUN_REGULAR_HIST_PERC = "NounRegular_Hist%";
    private final static String NOUN_IRREGULAR_HIST_PERC = "NounIrregular_Hist%";
    private final static String PREPOSITION_HIST_PERC = "Preposition_Hist%";
    private final static String CONJUNCTION_HIST_PERC = "Conjunction_Hist%";
    private final static String ADJECTIVE_HIST_PERC = "Adjective_Hist%";
    private final static String ADJECTIVE_COMPARATIVE_HIST_PERC = "AdjectiveComparative_Hist%";
    private final static String ADJECTIVE_SUPERLATIVE_HIST_PERC = "AdjectiveSuperlative_Hist%";
    private final static String ADVERB_HIST_PERC = "Adverb_Hist%";
    private final static String ADVERB_COMPARATIVE_HIST_PERC = "AdverbComparative_Hist%";
    private final static String ADVERB_SUPERLATIVE_HIST_PERC = "AdverbSuperlative_Hist%";

    private final static int DECLENSION3 = 3;

    private final static String DECLNUM1 = "decl1";
    private final static String DECLNUM2 = "decl2";
    private final static String DECLNUM3 = "decl3";
    private final static String DECLNUM4 = "decl4";

    private final static String DECLNUM1_SCORE = "decl1Score";
    private final static String DECLNUM2_SCORE = "decl2Score";
    private final static String DECLNUM3_SCORE = "decl3Score";
    private final static String DECLNUM4_SCORE = "decl4Score";

    private final String DECL1_TALLY = "DeclTally1";  // Tally of All Conj# Questions Asked
    private final String DECL2_TALLY = "DeclTally2";  // Key for Meta Table in DB
    private final String DECL3_TALLY = "DeclTally3";
    private final String DECL4_TALLY = "DeclTally4";

    private final String DECLNUM1_HIST_PERC = "Decl1_Hist%";  // % of Correctly Answered Conj# Questions
    private final String DECLNUM2_HIST_PERC = "Decl2_Hist%";  // Key For statisticsMap
    private final String DECLNUM3_HIST_PERC = "Decl3_Hist%";
    private final String DECLNUM4_HIST_PERC = "Decl4_Hist%";


    private final static String NOMINATIVE = "Nominative";
    private final static String ACUSTATIVE = "Accusative";
    private final static String GENITIVE = "Genitive";
    private final static String DATIVE = "Dative";
    private final static String ABLATIVE = "Ablative";
    private final static String VOCATIVE = "Vocative";

    private final static String NOMINATIVE_SCORE = "NominativeScore";
    private final static String ACUSTATIVE_SCORE = "AccusativeScore";
    private final static String GENITIVE_SCORE = "GenitiveScore";
    private final static String DATIVE_SCORE = "DativeScore";
    private final static String ABLATIVE_SCORE = "AblativeScore";
    private final static String VOCATIVE_SCORE = "VocativeScore";

    private final static String NOMINATIVE_TALLY = "NominativeTally";
    private final static String ACUSTATIVE_TALLY = "AccusativeTally";
    private final static String GENITIVE_TALLY = "GenitiveTally";
    private final static String DATIVE_TALLY = "DativeTally";
    private final static String ABLATIVE_TALLY = "AblativeTally";
    private final static String VOCATIVE_TALLY = "VocativeTally";

    private final static String NOMINATIVE_HIST_PERC = "Nominative_Hist%";
    private final static String ACUSTATIVE_HIST_PERC = "Accusative_Hist%";
    private final static String GENITIVE_HIST_PERC = "Genitive_Hist%";
    private final static String DATIVE_HIST_PERC = "Dative_Hist%";
    private final static String ABLATIVE_HIST_PERC = "Ablative_Hist%";
    private final static String VOCATIVE_HIST_PERC = "Vocative_Hist%";


    private final static String TOTAL = "NounTotal";  // Historical Score of ALL Correct Questions
    private final static String TOTAL_SCORE = "NounTotalScore";  // Historical Score of ALL Correct Questions
    private final static String TOTAL_TALLY = "NounTotalTally";  // Tally of All Correct Questions Asked
    private final static String TOTAL_HIST_PERC = "NounTotal_Hist%";  // Key For statisticsMap

    private final static int CORRECT = 1;
    private final static int INCORRECT = 0;
    private final static int ASKED = 1;
    private final static int NOT_ASKED = 0;


    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<NounEtc> mNounQuestionList;  // List of 6 Verbs for a Multiple Choice Questions
    private List<Answer> mAnswerList;
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


    /**
     * calcStatistics()
     * ----------------
     *
     * Calcs the Statistics for the % of Correct Answers in the Current Quiz and Running (Historical) Score
     * @param list - List of Answers from the Quiz
     * @return map storing statistics of Current Game and and of all games.
     */
    public Map<String, Integer> calcStatistics(List<Answer> list){

        int noun = 0;
        int preposition = 0;
        int conjunction = 0;
        int adjective = 0;
        int adjectiveComparative = 0;
        int adjectiveSuperlative = 0;
        int adverb = 0;
        int adverbComparative = 0;
        int adverbSuperlative = 0;

        int decl1 = 0;
        int decl2 = 0;
        int decl3 = 0;
        int decl4 = 0;

        int nominative = 0;
        int accusative = 0;
        int genitive = 0;
        int dative = 0;
        int ablative = 0;
        int vocative = 0;

        int total = 0;


        int nounTally = 0;
        int prepositionTally = 0;
        int conjunctionTally = 0;
        int adjectiveTally = 0;
        int adjectiveComparativeTally = 0;
        int adjectiveSuperlativeTally = 0;
        int adverbTally = 0;
        int adverbComparativeTally = 0;
        int adverbSuperlativeTally = 0;

        int decl1Tally = 0;
        int decl2Tally = 0;
        int decl3Tally = 0;
        int decl4Tally = 0;

        int nominativeTally = 0;
        int accusativeTally = 0;
        int genitiveTally = 0;
        int dativeTally = 0;
        int ablativeTally = 0;
        int vocativeTally = 0;

        int numQuizQuestions = list.size();


        int nounPerc;
        int prepositionPerc;
        int conjunctionPerc;
        int adjectivePerc;
        int adjectiveComparativePerc;
        int adjectiveSuperlativePerc;
        int adverbPerc;
        int adverbComparativePerc;
        int adverbSuperlativePerc;

        int decl1perc;
        int decl2perc;
        int decl3perc;
        int decl4perc;

        int nominativePerc;
        int accusativePerc;
        int genitivePerc;
        int dativePerc;
        int ablativePerc;
        int vocativePerc;

        int totalPerc;

        int nounPercHist;
        int prepositionPercHist;
        int conjunctionPercHist;
        int adjectivePercHist;
        int adjectiveComparativePercHist;
        int adjectiveSuperlativePercHist;
        int adverbPercHist;
        int adverbComparativePercHist;
        int adverbSuperlativePercHist;

        int decl1percHist;
        int decl2percHist;
        int decl3percHist;
        int decl4percHist;

        int nominativePercHist;
        int accusativePercHist;
        int genitivePercHist;
        int dativePercHist;
        int ablativePercHist;
        int vocativePercHist;


        int totalPercHist;

        Map<String, Integer> mapStatistics = new HashMap<>();


        // Tally Data
        // ----------
        for(Answer ans : list){
            NounEtc nounEtc = ans.noun;
            if(ans.correct == 1)
                total++;  //  total Correct

            switch (nounEtc.getType()) {
                case NOUN_REGULAR:
                    if(ans.correct == 1)
                        noun++;
                    nounTally++;
                    break;
                case NOUN_IRREGULAR:
                    if(ans.correct == 1)
                        noun++;
                    nounTally++;
                    break;
                case PREPOSITION:
                    if(ans.correct == 1)
                        preposition++;
                    prepositionTally++;
                    break;
                case CONJUNCTION:
                    if(ans.correct == 1)
                        conjunction++;
                    conjunctionTally++;
                    break;
                case ADJECTIVE:
                    if(ans.correct == 1)
                        adjective++;
                    adjectiveTally++;
                    break;
                case ADJECTIVE_COMPARATIVE:
                    if(ans.correct == 1)
                        adjectiveComparative++;
                    adjectiveComparativeTally++;
                    break;
                case ADJECTIVE_SUPERLATIVE:
                    if(ans.correct == 1)
                        adjectiveSuperlative++;
                    adjectiveSuperlative++;
                    break;
                case ADVERB:
                    if(ans.correct == 1)
                        adverb++;
                    adverbTally++;
                    break;
                case ADVERB_COMPARATIVE:
                    if(ans.correct == 1)
                        adverbComparative++;
                    adverbComparativeTally++;
                    break;
                case ADVERB_SUPERLATIVE:
                    if(ans.correct == 1)
                        adverbSuperlative++;
                    adverbSuperlative++;
                    break;
            }

            switch(nounEtc.getDeclension()) {
                case 1:
                    if(ans.correct == 1)
                        decl1++;
                    decl1Tally++;
                    break;
                case 2:
                    if(ans.correct == 1)
                        decl2++;
                    decl2Tally++;
                    break;
                case 3:
                    if(ans.correct == 1)
                        decl3++;
                    decl3Tally++;
                    break;
                case 4:
                    if(ans.correct == 1)
                        decl4++;
                    decl4Tally++;
                    break;
                default:
                    if(ans.correct == 1)
                        decl4++;  // For 4th and 5th
                    decl4Tally++;
                    break;
            }

            switch (nounEtc.getCase()) {
                case NOMINATIVE:
                    if(ans.correct == 1)
                        nominative++;
                    nominativeTally++;
                    break;
                case ACUSTATIVE:
                    if(ans.correct == 1)
                        accusative++;
                    accusativeTally++;
                    break;
                case GENITIVE:
                    if(ans.correct == 1)
                        genitive++;
                    genitiveTally++;
                    break;
                case DATIVE:
                    if(ans.correct == 1)
                        dative++;
                    dativeTally++;
                    break;
                case ABLATIVE:
                    if(ans.correct == 1)
                        ablative++;
                    ablativeTally++;
                    break;
                case VOCATIVE:
                    if(ans.correct == 1)
                        vocative++;
                    vocativeTally++;
                    break;
            }
        }


        // Calc Current Quiz Results
        // -------------------------

        nounPerc = (nounTally>0) ? noun*100/nounTally : 0;
        prepositionPerc = (prepositionTally>0) ? preposition*100/prepositionTally : 0;
        conjunctionPerc = (conjunctionTally>0) ? conjunction*100/conjunctionTally: 0;
        adjectivePerc = (adjectiveTally>0) ? adjective*100/adjectiveTally : 0;
        adjectiveComparativePerc = (adjectiveComparativeTally>0) ? adjectiveComparative*100/adjectiveComparativeTally : 0;
        adjectiveSuperlativePerc = (adjectiveSuperlativeTally>0) ? adjectiveSuperlative*100/adjectiveSuperlative : 0;
        adverbPerc = (adverbTally>0) ? adverb*100/adverbTally : 0;
        adverbComparativePerc = (adverbComparativeTally>0) ? adverbComparative*100/adverbComparativeTally : 0;
        adverbSuperlativePerc = (adverbSuperlativeTally>0) ? adverbSuperlative*100/adverbSuperlative : 0;

        decl1perc = (decl1Tally>0) ? decl1*100/decl1Tally : 0;
        decl2perc = (decl2Tally>0) ? decl2*100/decl2Tally : 0;
        decl3perc = (decl3Tally>0) ? decl3*100/decl3Tally : 0;
        decl4perc = (decl4Tally>0) ? decl4*100/decl4Tally : 0;

        nominativePerc = (nominativeTally>0) ? nominative*100/nominativeTally : 0;
        accusativePerc = (accusativeTally>0) ? accusative*100/accusativeTally : 0;
        genitivePerc = (genitiveTally>0) ? genitive*100/genitiveTally : 0;
        dativePerc = (dativeTally>0) ? dative*100/dativeTally : 0;
        ablativePerc = (ablativeTally>0) ? ablative*100/ablativeTally : 0;
        vocativePerc = (vocativeTally>0) ? vocative*100/vocativeTally : 0;

        totalPerc = total*100/numQuizQuestions;


        // Insert Current Quiz Scores Into Map
        // -----------------------------------

        mapStatistics.put( NOUN, nounPerc );
        mapStatistics.put( PREPOSITION, prepositionPerc );
        mapStatistics.put( CONJUNCTION, conjunctionPerc );
        mapStatistics.put( ADJECTIVE, adjectivePerc );
        mapStatistics.put( ADJECTIVE_COMPARATIVE, adjectiveComparativePerc );
        mapStatistics.put( ADJECTIVE_SUPERLATIVE, adjectiveSuperlativePerc  );
        mapStatistics.put( ADVERB, adverbPerc );
        mapStatistics.put( ADVERB_COMPARATIVE, adverbComparativePerc );
        mapStatistics.put( ADVERB_SUPERLATIVE, adverbSuperlativePerc  );

        mapStatistics.put( DECLNUM1, decl1perc );
        mapStatistics.put( DECLNUM2, decl2perc );
        mapStatistics.put( DECLNUM3, decl3perc );
        mapStatistics.put( DECLNUM4, decl4perc );


        mapStatistics.put( NOMINATIVE, nominativePerc );
        mapStatistics.put( ACUSTATIVE, accusativePerc );
        mapStatistics.put( GENITIVE, genitivePerc );
        mapStatistics.put( DATIVE, dativePerc );
        mapStatistics.put( ABLATIVE, ablativePerc );
        mapStatistics.put( VOCATIVE, vocativePerc );


        mapStatistics.put( TOTAL, totalPerc);

        // Calc Total Historical Scores and Update in Map
        // ----------------------------------------------

        nounPercHist = calcHistoryStatistics(NOUN_SCORE, NOUN_TALLY, noun, nounTally);
        mapStatistics.put(NOUN_HIST_PERC, nounPercHist);

        prepositionPercHist = calcHistoryStatistics(PREPOSITION_SCORE, PREPOSITION_TALLY, preposition, prepositionTally);
        mapStatistics.put(PREPOSITION_HIST_PERC, prepositionPercHist);

        conjunctionPercHist = calcHistoryStatistics(CONJUNCTION_SCORE, CONJUNCTION_TALLY, conjunction, conjunctionTally);
        mapStatistics.put(CONJUNCTION_HIST_PERC, conjunctionPercHist);

        adjectivePercHist = calcHistoryStatistics(ADJECTIVE_SCORE, ADJECTIVE_TALLY, adjective, adjectiveTally);
        mapStatistics.put(ADJECTIVE_HIST_PERC, adjectivePercHist);

        adjectiveComparativePercHist = calcHistoryStatistics(ADJECTIVE_COMPARATIVE_SCORE, ADJECTIVE_COMPARATIVE_TALLY, adjectiveComparative, adjectiveComparativeTally);
        mapStatistics.put(ADJECTIVE_COMPARATIVE_HIST_PERC, adjectiveComparativePercHist);

        adjectiveSuperlativePercHist = calcHistoryStatistics(ADJECTIVE_SUPERLATIVE_SCORE, ADJECTIVE_SUPERLATIVE_TALLY, adjectiveSuperlative, adjectiveSuperlativeTally);
        mapStatistics.put(ADJECTIVE_SUPERLATIVE_HIST_PERC, adjectiveSuperlativePercHist);

        adverbPercHist = calcHistoryStatistics(ADVERB_SCORE, ADVERB_TALLY, adverb, adverbTally);
        mapStatistics.put(ADVERB_HIST_PERC, adverbPercHist);

        adverbComparativePercHist = calcHistoryStatistics(ADVERB_COMPARATIVE_SCORE, ADVERB_COMPARATIVE_TALLY, adverbComparative, adverbComparativeTally);
        mapStatistics.put(ADVERB_COMPARATIVE_HIST_PERC, adverbComparativePercHist);

        adverbSuperlativePercHist = calcHistoryStatistics(ADVERB_SUPERLATIVE_SCORE, ADVERB_SUPERLATIVE_TALLY, adverbSuperlative, adverbSuperlativeTally);
        mapStatistics.put(ADVERB_COMPARATIVE_HIST_PERC, adverbSuperlativePercHist);

        decl1percHist = calcHistoryStatistics(DECLNUM1_SCORE, DECL1_TALLY, decl1, decl1Tally);
        mapStatistics.put(DECLNUM1_HIST_PERC, decl1percHist);

        decl2percHist = calcHistoryStatistics(DECLNUM2_SCORE, DECL2_TALLY, decl2, decl2Tally);
        mapStatistics.put(DECLNUM2_HIST_PERC, decl2percHist);

        decl3percHist = calcHistoryStatistics(DECLNUM3_SCORE, DECL3_TALLY, decl3, decl3Tally);
        mapStatistics.put(DECLNUM3_HIST_PERC, decl3percHist);

        decl4percHist = calcHistoryStatistics(DECLNUM4_SCORE, DECL4_TALLY, decl4, decl4Tally);
        mapStatistics.put(DECLNUM4_HIST_PERC, decl4percHist);


        nominativePercHist = calcHistoryStatistics(NOMINATIVE_SCORE, NOMINATIVE_TALLY, nominative, nominativeTally);
        mapStatistics.put(NOMINATIVE_HIST_PERC, nominativePercHist);

        accusativePercHist = calcHistoryStatistics(ACUSTATIVE_SCORE, ACUSTATIVE_TALLY, accusative, accusativeTally);
        mapStatistics.put(ACUSTATIVE_HIST_PERC, accusativePercHist);

        genitivePercHist = calcHistoryStatistics(GENITIVE_SCORE, GENITIVE_TALLY, genitive, genitiveTally);
        mapStatistics.put(GENITIVE_HIST_PERC, genitivePercHist);

        dativePercHist = calcHistoryStatistics(DATIVE_SCORE, DATIVE_TALLY, dative, dativeTally);
        mapStatistics.put(DATIVE_HIST_PERC, dativePercHist);

        ablativePercHist = calcHistoryStatistics(ABLATIVE_SCORE, ABLATIVE_TALLY, ablative, ablativeTally);
        mapStatistics.put(ABLATIVE_HIST_PERC, ablativePercHist);

        vocativePercHist = calcHistoryStatistics(VOCATIVE_SCORE, VOCATIVE_TALLY, vocative, vocativeTally);
        mapStatistics.put(VOCATIVE_HIST_PERC, vocativePercHist);


        totalPercHist = calcHistoryStatistics(TOTAL_SCORE, TOTAL_TALLY, total, numQuizQuestions);
        mapStatistics.put(TOTAL_HIST_PERC, totalPercHist);

        return mapStatistics;
    }


    /**
     * calcHistoryStatistics()
     * -----------------------
     * Helper method for calcStatistics.
     * 1) Retrieves Historical Score and Tally from Meta Table
     * 2) Updates MetaTable with Updated Score and Tally
     *
     * @param dbHistScore - KEY for Score
     * @param dbHistTally - KEY for Tally
     * @param currentScore - The Score of The Current Game for this type of verb
     * @param numQuizQuestions - Number of Quiz Questions.
     */

    public int calcHistoryStatistics(String dbHistScore, String dbHistTally, int currentScore, int numQuizQuestions){

        int totalScore = mDatabaseAccess.sqlMetaQuery(dbHistScore);  // Get Historical Score
        int tally = mDatabaseAccess.sqlMetaQuery(dbHistTally); // Get Histortical Tally of Questions

        mDatabaseAccess.sqlMeta_Insertion(dbHistScore, totalScore + currentScore);  // Update Database of Historical Score
        mDatabaseAccess.sqlMeta_Insertion(dbHistTally, tally + numQuizQuestions); // Update Database of Historical Tally
        return (tally + numQuizQuestions > 0) ? ((totalScore + currentScore)*100)/(tally + numQuizQuestions) : 0 ;  // Calc New Historical %
    }

}
