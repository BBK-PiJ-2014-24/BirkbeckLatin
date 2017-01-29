package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;
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

    private RandomGenerator mRandomGenerator;
    private DatabaseAccess mDatabaseAccess;
    private int mSkillLevel; // skillLevel of Game
    private double mTheta;  // IRT skill level
    private List<NounEtc> mNounQuestionList;  // List of 6 Verbs for a Multiple Choice Questions
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
     * getNounEtcQuestions()
     * ---------------------
     * Generates a list of 6 verb questions given the Table and Ids and skillLevel
     * @param idList - Pair of IDs
     * @return  a list of six NounEtc objects
     */
    @Override
    public List<NounEtc> getNounEtcQuestions(String nounType, List<Integer> idList){

        String number1 = mRandomGenerator.getNounNumber();
        String number2 = mRandomGenerator.getNounNumber();
        String number3 = mRandomGenerator.getNounNumber();
        String noun_Case1 = mRandomGenerator.getNounCase();
        String noun_Case2 = mRandomGenerator.getNounCase();
        String noun_Case3 = mRandomGenerator.getNounCase();
        String gender1 = mRandomGenerator.getAdjectiveGender();
        String gender2 = mRandomGenerator.getAdjectiveGender();
        String gender3 = mRandomGenerator.getAdjectiveGender();

        if(mSkillLevel == 5) {
            if (nounType.equals(ADJECTIVE))
                nounType = mRandomGenerator.getAdjectiveType();
            else if (nounType.equals(ADVERB)) {
                nounType = mRandomGenerator.getAdverbType();
            }
        }

        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(0), number1, noun_Case1, gender1));
        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(1), number2, noun_Case2, gender2));
        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(2), number3, noun_Case3, gender3));
        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(3), number1, noun_Case1, gender1));
        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(4), number2, noun_Case2, gender2));
        mNounQuestionList.add(makeGameNounEtc(nounType, idList.get(5), number3, noun_Case3, gender3));

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



    // TODO storeAnswer()

    // TODO endGame()

    // TODO determineQuestionDifficulty()


    // TODO updateSkillLevel()

}
