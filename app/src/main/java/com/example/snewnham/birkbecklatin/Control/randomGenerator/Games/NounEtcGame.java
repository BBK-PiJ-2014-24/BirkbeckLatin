package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;

import java.util.List;

/**
 * Created by snewnham on 20/01/2017.
 */

public interface NounEtcGame {


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
    int updateSkillLevel(List<NounEtcGameImpl.Answer> answerList);



    /**
     * storeAnswer()
     * -------------
     * 1) Updates the Correct NounEtc Table, updating CORRECT Field
     * 2) Creates an Answer object to contain data for the question and adds to Answer List.
     * @param ans answer flag - correct/incorrect (1 or 0)
     * @return If answer is correct/incorrect (1 or 0)
     */
    int storeAnswer(String table, int ans);

    // GETTER/SETTERS
    // --------------

    NounEtc getCorrectNounEtc();

    void setCorrectNounEtc(NounEtc correctNounEtc);

    List<NounEtcGameImpl.Answer> getAnswerList();


}