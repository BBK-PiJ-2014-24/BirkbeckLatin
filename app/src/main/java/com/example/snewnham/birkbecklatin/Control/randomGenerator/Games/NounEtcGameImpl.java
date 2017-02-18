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
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

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

    private final static String NOMINATIVE = "Nominative";
    private final static String ACCUSTATIVE = "Accusative";
    private final static String GENITIVE = "Genitive";
    private final static String DATIVE = "Dative";
    private final static String ABLATIVE = "Ablative";
    private final static String VOCATIVE = "Vocative";

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


    /**
     * calcStatistics()
     * ----------------
     *
     * Calcs the Statistics for the % of Correct Answers in the Current Quiz and Running (Historical) Score
     * @param list - List of Answers from the Quiz
     * @return map storing statistics of Current Game and and of all games.
     */
    public Map<String, Integer> calcStatistics(List<com.example.snewnham.birkbecklatin.Model.verbs.Answer> list){

        int conj1 = 0;
        int conj2 = 0;
        int conj3 = 0;
        int conj4 = 0;

        int present = 0;
        int imperfect = 0;
        int future = 0;
        int perfect = 0;
        int pluperfect = 0;
        int futurePerfect = 0;

        int indicative = 0;
        int subjunctive = 0;
        int imperative = 0;

        int active = 0;
        int passive = 0;

        int total = 0;

        int conj1Tally = 0;
        int conj2Tally = 0;
        int conj3Tally = 0;
        int conj4Tally = 0;

        int presentTally = 0;
        int imperfectTally = 0;
        int futureTally = 0;
        int perfectTally = 0;
        int pluperfectTally = 0;
        int futurePerfectTally = 0;

        int indicativeTally = 0;
        int subjunctiveTally = 0;
        int imperativeTally = 0;

        int activeTally = 0;
        int passiveTally = 0;

        int numQuizQuestions = list.size();
        int conj1perc;
        int conj2perc;
        int conj3perc;
        int conj4perc;

        int presentPerc;
        int imperfectPerc;
        int futurePerc;
        int perfectPerc;
        int pluperfectPerc;
        int futPerfectPerc;

        int indicativePerc;
        int imperativePerc;
        int subjunctivePerc;

        int totalPerc;

        int activerPerc;
        int passivePerc;

        int conj1percHist;
        int conj2percHist;
        int conj3percHist;
        int conj4percHist;

        int presentPercHist;
        int imperfectPercHist;
        int futurePercHist;
        int perfectPercHist;
        int pluperfectPercHist;
        int futPerfectPercHist;

        int indicativePercHist;
        int imperativePercHist;
        int subjunctivePercHist;

        int activePercHist;
        int passivePercHist;

        int totalPercHist;

        Map<String, Integer> mapStatistics = new HashMap<>();


        // Tally Data
        // ----------
        for(com.example.snewnham.birkbecklatin.Model.verbs.Answer ans : list){
            Verb verb = ans.verb;
            if(ans.correct == 1)
                total++;  //  total Correct
            switch(verb.getLatin_ConjNum()) {
                case 1:
                    if(ans.correct == 1)
                        conj1++;
                    conj1Tally++;
                    break;
                case 2:
                    if(ans.correct == 1)
                        conj2++;
                    conj2Tally++;
                    break;
                case 3:
                    if(ans.correct == 1)
                        conj3++;
                    conj3Tally++;
                    break;
                case 4:
                    if(ans.correct == 1)
                        conj4++;
                    conj4Tally++;
                    break;
                default:
                    if(ans.correct == 1)
                        conj3++;  // For Alternatives of the Conj 3rd
                    conj3Tally++;
                    break;
            }

            switch (verb.getTense()) {
                case TENSE_PRESENT:
                    if(ans.correct == 1)
                        present++;
                    presentTally++;
                    break;
                case TENSE_IMPERFECT:
                    if(ans.correct == 1)
                        imperfect++;
                    imperfectTally++;
                    break;
                case TENSE_FUTURE:
                    if(ans.correct == 1)
                        future++;
                    futureTally++;
                    break;
                case TENSE_PERFECT:
                    if(ans.correct == 1)
                        perfect++;
                    perfectTally++;
                    break;
                case TENSE_PLUPERFECT:
                    if(ans.correct == 1)
                        pluperfect++;
                    pluperfectTally++;
                    break;
                case TENSE_FUTURE_PERFECT:
                    if(ans.correct == 1)
                        futurePerfect++;
                    futurePerfectTally++;
                    break;
            }

            switch (verb.getMood()) {
                case MOOD_INDICATIVE:
                    if(ans.correct == 1)
                        indicative++;
                    indicativeTally++;
                    break;
                case MOOD_IMPERATIVE:
                    if(ans.correct == 1)
                        imperative++;
                    imperativeTally++;
                    break;
                case MOOD_SUBJUNCTIVE:
                    if(ans.correct == 1)
                        subjunctive++;
                    subjunctiveTally++;
                    break;
            }

            switch (verb.getVoice()) {
                case VOICE_ACTIVE:
                    if(ans.correct == 1)
                        active++;
                    activeTally++;
                    break;
                case VOICE_PASSIVE:
                    if(ans.correct == 1)
                        passive++;
                    passiveTally++;
                    break;
            }
        }


        // Calc Current Quiz Results
        // -------------------------
        conj1perc = (conj1Tally>0) ? conj1/conj1Tally*100 : 0;
        conj2perc = (conj2Tally>0) ? conj2/conj2Tally*100 : 0;
        conj3perc = (conj3Tally>0) ? conj3/conj3Tally*100 : 0;
        conj4perc = (conj4Tally>0) ? conj4/conj4Tally*100 : 0;

        presentPerc = (presentTally>0) ? present*100/presentTally : 0;
        imperfectPerc = (imperfectTally>0) ? imperfect*100/imperfectTally : 0;
        futurePerc = (futureTally>0) ? future*100/futureTally: 0;
        perfectPerc = (perfectTally>0) ? perfect*100/perfectTally : 0;
        pluperfectPerc = (pluperfectTally>0) ? pluperfect*100/pluperfectTally : 0;
        futPerfectPerc = (futureTally>0) ? futurePerfect*100/futureTally : 0;

        indicativePerc = (indicativeTally>0) ? indicative*100/indicativeTally : 0;
        subjunctivePerc = (subjunctiveTally>0) ? subjunctive*100/subjunctiveTally : 0;
        imperativePerc = (imperativeTally>0) ? imperative*100/imperativeTally : 0;

        activerPerc = (activeTally>0) ? active*100/activeTally : 0;
        passivePerc = (passiveTally>0) ? passive*100/passiveTally : 0;

        totalPerc = total*100/numQuizQuestions;


        // Insert Current Quiz Scores Into Map
        // -----------------------------------
        mapStatistics.put( CONJNUM1, conj1perc );
        mapStatistics.put( CONJNUM2, conj2perc );
        mapStatistics.put( CONJNUM3, conj3perc );
        mapStatistics.put( CONJNUM4, conj4perc );

        mapStatistics.put( TENSE_PRESENT, presentPerc );
        mapStatistics.put( TENSE_IMPERFECT, imperfectPerc );
        mapStatistics.put( TENSE_FUTURE, futurePerc );
        mapStatistics.put( TENSE_PERFECT, perfectPerc );
        mapStatistics.put( TENSE_PLUPERFECT, pluperfectPerc );
        mapStatistics.put( TENSE_FUTURE_PERFECT, futPerfectPerc );

        mapStatistics.put( MOOD_INDICATIVE, indicativePerc );
        mapStatistics.put( MOOD_SUBJUNCTIVE, subjunctivePerc );
        mapStatistics.put( MOOD_IMPERATIVE, imperativePerc );

        mapStatistics.put( VOICE_ACTIVE, activerPerc );
        mapStatistics.put( VOICE_PASSIVE, passivePerc );

        mapStatistics.put( TOTAL, totalPerc);

        // Calc Total Historical Scores and Update in Map
        // ----------------------------------------------
        conj1percHist = calcHistoryStatistics(CONJNUM1_SCORE, CONJ1_TALLY, conj1, conj1Tally);
        mapStatistics.put(CONJNUM1_HIST_PERC, conj1percHist);

        conj2percHist = calcHistoryStatistics(CONJNUM2_SCORE, CONJ2_TALLY, conj2, conj2Tally);
        mapStatistics.put(CONJNUM2_HIST_PERC, conj2percHist);

        conj3percHist = calcHistoryStatistics(CONJNUM3_SCORE, CONJ3_TALLY, conj3, conj3Tally);
        mapStatistics.put(CONJNUM3_HIST_PERC, conj3percHist);

        conj4percHist = calcHistoryStatistics(CONJNUM4_SCORE, CONJ4_TALLY, conj4, conj4Tally);
        mapStatistics.put(CONJNUM4_HIST_PERC, conj4percHist);

        presentPercHist = calcHistoryStatistics(PRESENT_SCORE, PRESENT_TALLY, present, presentTally);
        mapStatistics.put(TENSE_PRESENT_HIST, presentPercHist);

        imperfectPercHist = calcHistoryStatistics(IMPERFECT_SCORE, IMPERFECT_TALLY, imperfect, imperfectTally);
        mapStatistics.put(TENSE_IMPERFECT_HIST, imperfectPercHist);

        futurePercHist = calcHistoryStatistics(FUTURE_SCORE, FUTURE_TALLY, future, futureTally);
        mapStatistics.put(TENSE_FUTURE_HIST, futurePercHist);

        perfectPercHist = calcHistoryStatistics(PERFECT_SCORE, PERFECT_TALLY, perfect, perfectTally);
        mapStatistics.put(TENSE_PERFECT_HIST, perfectPercHist);

        pluperfectPercHist = calcHistoryStatistics(PLUPERFECT_SCORE, PLUPERFECT_TALLY, pluperfect, pluperfectTally);
        mapStatistics.put(TENSE_PLUPERFECT_HIST, pluperfectPercHist);

        futPerfectPercHist = calcHistoryStatistics(FUT_PERFECT_SCORE, FUT_PERFECT_TALLY, futurePerfect, futurePerfectTally);
        mapStatistics.put(TENSE_FUTURE_PERFECT_HIST, futPerfectPercHist);

        indicativePercHist = calcHistoryStatistics(INDICATIVE_SCORE, INDICATIVE_TALLY, indicative, indicativeTally);
        mapStatistics.put(MOOD_INDICATIVE_HIST, indicativePercHist);

        subjunctivePercHist = calcHistoryStatistics(SUBJUNCTIVE_SCORE, SUBJUNCTIVE_TALLY, subjunctive, subjunctiveTally);
        mapStatistics.put(MOOD_SUBJUNCTIVE_HIST, subjunctivePercHist);

        imperativePercHist = calcHistoryStatistics(IMPERATIVE_SCORE, IMPERATIVE_TALLY, imperative, imperativeTally);
        mapStatistics.put(MOOD_IMPERATIVE_HIST, imperativePercHist);

        activePercHist = calcHistoryStatistics(ACTIVE_SCORE, ACTIVE_TALLY, active, activeTally);
        mapStatistics.put(VOICE_ACTIVE_HIST, activePercHist);

        passivePercHist = calcHistoryStatistics(PASSIVE_SCORE, PASSIVE_TALLY, passive, passiveTally);
        mapStatistics.put(VOICE_PASSIVE_HIST, passivePercHist);

        totalPercHist = calcHistoryStatistics(TOTAL_SCORE, TOTAL_TALLY, total, numQuizQuestions);
        mapStatistics.put(TOTAL_HIST, totalPercHist);

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
