package com.newnham.app.GCSE_Latin.Control.randomGenerator.Games;

import com.newnham.app.GCSE_Latin.Model.nouns.Answer;
import com.newnham.app.GCSE_Latin.Model.nouns.NounEtc;

import java.util.List;
import java.util.Map;

/**
 * Created by snewnham on 20/01/2017.
 */

public interface NounEtcGame {


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
    void runNounGame();


    /**
     * makeGameNounEtc()
     * -----------------
     * Make a generic NounEtc for the game, given the Noun Type, Table id, and declension
     *
     * @param type       - Type of NounEtc - Regular, Adjective, etc.
     * @param id         - id number within Table
     * @param number     - "Singular" or "Plural"
     * @param declension -
     * @return - generic NounEtc object.
     */
    NounEtc makeGameNounEtc(String type, int id, String number, String declension, String gender);


    /**
     * getNounEtcQuestions()
     * ---------------------
     * Generates a list of 6 verb questions given the Table and Ids and skillLevel.
     *
     * @param idList - Pair of IDs
     * @return a list of six NounEtc objects
     */

    List<NounEtc> getNounEtcQuestionSet(String nounType, List<Integer> idList);

    /**
     * determineQuestionDifficulty()
     * -----------------------------
     * Level 1: Nouns 1,2,3 Decl.
     * Level 2: Nouns including Irregular.
     * Level 3: Nouns or Prepositions or Conjunctions
     * Level 4: Nouns or Prepositions or Conjunctions or Adjectives
     * Level 5: Nouns or Prepositions or Conjunctions or Adjectives or
     *          Adverbs (inc. Comparatives, Superlatives)
     *
     * @return skillLevel of question
     */

    int determineQuestionDifficulty();


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
    int updateSkillLevel(List<Answer> answerList);



    /**
     * storeAnswer()
     * -------------
     * 1) Updates the Correct NounEtc Table, updating CORRECT Field
     * 2) Creates an Answer object to contain data for the question and adds to Answer List.
     * @param ans answer flag - correct/incorrect (1 or 0)
     * @return If answer is correct/incorrect (1 or 0)
     */
    int storeAnswer(String table, int ans);


    /**
     * getTableName()
     * --------------
     * Maps the Database Table Name to a given NounEtc Type
     * @param type - NounEtc Type
     * @return  -  Name of Database Table
     */
     String getTableName(String type);


    /**
     * endGame()
     * ---------
     * Run at the end of the game:
     * 1) updates the students IRT Theta and game skill level.
     * 2) Stores Theta and SkillLevel in the Meta Table.
     *
     */
    void endGame();


    /**
     * calcStatistics()
     * ----------------
     * Test calcStatistics() so that it can correctly supply all statistics
     * both latest Quiz and Running Total;
     *
     * @param ansList - List of Answers
     * @return Map of Statistics
     */
    Map<String, Integer> calcStatistics(List<Answer> ansList);

    // GETTER/SETTERS
    // --------------

    NounEtc getCorrectNounEtc();

    int getCorrectNounEtcIndex();

    void setCorrectNounEtc(NounEtc correctNounEtc);

    List<NounEtc> getNounQuestionList();

    List<Answer> getAnswerList();

    void setQuestionNumber(int questionNumber);

    Map<String, Integer> getStatMap();


}