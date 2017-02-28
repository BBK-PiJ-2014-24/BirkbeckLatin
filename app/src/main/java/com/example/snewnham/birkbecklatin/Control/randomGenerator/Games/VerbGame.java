package com.example.snewnham.birkbecklatin.Control.randomGenerator.Games;

import com.example.snewnham.birkbecklatin.Model.verbs.Answer;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import java.util.List;
import java.util.Map;

/**
 * Created by snewnham on 28/02/2017.
 */
public interface VerbGame {

    /**
     * runVerbGame()
     * -------------
     * Generates:
     * 1) a pair of Verb IDs, restricted according to skillLevel and either from Correct or Incorrect Lists
     *    (If the game counter signals a scheduled Incorrect Verb or Not)
     * 2) Updates the VerbList Table, updating the ASKED FIELD == 1
     * 3) Forms a Question List of 6 Verbs from the pair of Verb IDs
     * 4) Randomly selects a correctVerb
     * 5) Shuffles the order of the list.
     *
     */
    void runVerbGame();


    /**
     * storeAnswer()
     * -------------
     * 1) Updates ViewList Table, updating CORRECT Field
     * 2) Creates Answer object to contain data for the question and adds to Answer List.
     * @param ans answer flag - correct/incorrect (1 or 0)
     * @return If answer is correct/incorrect (1 or 0)
     */
    int storeAnswer(int ans);


    /**
     * endGame()
     * ---------
     * Run at the end of the game:
     * 1) updates the students IRT Theta and game skill level.
     * 2) Stores Theta and SkillLevel in the Meta Table.
     * 3) Run CalcStatics()
     *
     */
    void endGame();


    /**
     * determineQuestionDifficulty()
     * -----------------------------
     * Determines the skillLevel difficulty of the Correct Verb
     * @return difficulty 1- 5
     */
    int determineQuestionDifficulty();


    /**
     * getVerbQuestionSet()
     * --------------------
     *
     * Generates a list of 6 verb questions given the skill level of the student.
     * @param idList - Pair of IDs
     * @return  a list of six Verb objects
     */
    List<Verb> getVerbQuestionSet(List<Integer> idList);


    /**
     * makeImperativeQuestionList()
     * ----------------------------
     * A Separate Helper Method to Create a Question List for IMPERATIVES, given that there
     * are only 4 Imperatives for each Verb. So Need to have a special list to ensure full
     * population of 6 questions.
     * Note that Persons (1,2,3) and tenses are set to Null as they are not required
     * ALSO note that we have to add 2 Infinitive questions to the list as VERB_DEPONENT verbs do not
     * have passive IMPERATIVES.
     * @param idList - List of IDs
     * @return - List of Imperative Questions
     */
    List<Verb> makeImperativeQuestionList(List<Integer> idList);


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
    Verb makeGameVerb(int id, String person, String number,
                             String tense, String mood, String voice);


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
     * calcStatistics()
     * ----------------
     *
     * Calcs the Statistics for the % of Correct Answers in the Current Quiz and Running (Historical) Score
     * @param list - List of Answers from the Quiz
     * @return map storing statistics of Current Game and and of all games.
     */
    public Map<String, Integer> calcStatistics(List<Answer> list);


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

     int calcHistoryStatistics(String dbHistScore, String dbHistTally, int currentScore, int numQuizQuestions);


    // Getters/Setters
    // ---------------

    List<Verb> getVerbQuestionList();

    Verb getCorrectVerb();

    void setCorrectVerb(Verb correctVerb);

    int getCorrectVerbDifficulty();

    int getCorrectVerbIndex();

    String getCorrectVerbMood();

    void setCorrectVerbMood(String correctVerbMood);

    String getCorrectVerbVoice();

    void setCorrectVerbVoice(String correctVerbVoice);

    int getQuestionNumber();

    void setQuestionNumber(int questionNumber);

    Map<String, Integer> getStatMap();


}
