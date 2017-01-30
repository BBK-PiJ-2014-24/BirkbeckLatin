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



    // GETTER/SETTERS
    // --------------

    public NounEtc getCorrectNounEtc();

    public void setCorrectNounEtc(NounEtc correctNounEtc);


}