package com.newnham.app.birkbecklatin.model.gameTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.newnham.app.birkbecklatin.Control.randomGenerator.Games.NounEtcGame;
import com.newnham.app.birkbecklatin.Control.randomGenerator.Games.NounEtcGameImpl;
import com.newnham.app.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.database.DbSchema;
import com.newnham.app.birkbecklatin.Model.nouns.Answer;
import com.newnham.app.birkbecklatin.Model.nouns.NounEtc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.newnham.app.birkbecklatin.Model.LatinConstants.ABLATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ACCUSATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADJECTIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADJECTIVE_COMPARATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADJECTIVE_SUPERLATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADVERB;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADVERB_COMPARATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADVERB_SUPERLATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.CONJUNCTION;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DECL1;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DECL2;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DECL3;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DECL4;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.GENDER_MALE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.GENITIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NOMINATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NOUN;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NOUN_IRREGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NOUN_REGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.PREPOSITION;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOCATIVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * TESTS FOR CREATING LATIN NounEtc FOR ALL TYPES, PERSONS, DECLENSIONS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class GameNounEtcTests {

    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;
    RandomGenerator randomGenerator;

    int id_Regular;
    int id_Irregular;
    int id_Conjunction;
    int id_Preposition;
    int id_Adjective;
    int id_Adverb;

    NounEtcGame nounGame1;
    NounEtcGame nounGame2;
    NounEtcGame nounGame3;
    NounEtcGame nounGame4;
    NounEtcGame nounGame5;
    NounEtcGameImpl nounGameSkill;



    int skillLevel1;
    int skillLevel2;
    int skillLevel3;
    int skillLevel4;
    int skillLevel5;

    String numberSingular;
    String numberPlural;


    private static final int CONJNUM1_2 = 2;
    private static final int CONJNUM1_4 = 40;

    int correct;
    boolean restricted;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE

        databaseAccess.sqlNounEtcTable_Reset(DbSchema.NounListTable.NOUN_LIST_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.NounListTable.NOUN_LIST_TABLE, DbSchema.NounListTable.Cols.ASKED);  // Reset ASKED = 0
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.ConjunctionListTable.CONJUNCTION_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.ConjunctionListTable.CONJUNCTION_TABLE, DbSchema.NounListTable.Cols.ASKED);  // Reset ASKED = 0
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.PrepositionListTable.PREPOSITION_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.PrepositionListTable.PREPOSITION_TABLE, DbSchema.NounListTable.Cols.ASKED);  // Reset ASKED = 0
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset ASKED = 0
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.AdverbListTable.ADVERB_TABLE, DbSchema.NounListTable.Cols.CORRECT);  // Reset CORRECT = 1
        databaseAccess.sqlNounEtcTable_Reset(DbSchema.AdverbListTable.ADVERB_TABLE, DbSchema.NounListTable.Cols.ASKED);  // Reset ASKED = 0

        randomGenerator = new RandomGenerator(databaseAccess);

        nounGame1 = new NounEtcGameImpl(databaseAccess, 1); // Verb Skill 1
        nounGame2 = new NounEtcGameImpl(databaseAccess, 2); // Verb Skill 2
        nounGame3 = new NounEtcGameImpl(databaseAccess, 3); // Verb Skill 3
        nounGame4 = new NounEtcGameImpl(databaseAccess, 4); // Verb Skill 4
        nounGame5 = new NounEtcGameImpl(databaseAccess, 5); // Verb Skill 5
        nounGameSkill =  new NounEtcGameImpl(databaseAccess, 5);

        id_Regular = 1;
        id_Irregular = 14;
        id_Conjunction = 17;
        id_Preposition = 6;
        id_Adjective = 5;
        id_Adverb = 40;

        skillLevel1 = 1;
        skillLevel2 = 2;
        skillLevel3 = 3;
        skillLevel4 = 4;

        numberSingular = "Singular";
        numberPlural = "Plural";

        correct = 1;
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }


    /**
     * testMakeGameVerb_Regular()
     * ==========================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Regular.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Regular() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(NOUN_REGULAR, id_Regular, numberSingular, NOMINATIVE, GENDER_MALE);

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Regular Noun LatinWord ", "ager", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Regular Noun EnglishWord", "field", englishWord );
    }

    /**
     * testMakeGameVerb_Regular()
     * ==========================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Regular.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Irregular() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(NOUN_IRREGULAR, id_Irregular, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Regular Noun LatinWord ", "hic", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Regular Noun EnglishWord", "this", englishWord );
    }


    /**
     * testMakeGameNoun_Conjunction()
     * ===============================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Conjunction.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Conjunction() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(CONJUNCTION, id_Conjunction, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Conjunction LatinWord ", "sed", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Conjunction EnglishWord", "but", englishWord );

    }
    /**
     * testMakeGameNoun_Preposition()
     * ===============================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Preposition.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Preposition() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(PREPOSITION, id_Preposition, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Preposition LatinWord ", "circum", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Preposition EnglishWord", "around", englishWord );
    }
    /**
     * testMakeGameNoun_Adjective()
     * ============================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Adjective.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Adjective() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADJECTIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adjective LatinWord ", "bonus", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adjective EnglishWord", "good", englishWord );
    }

    /**
     * testMakeGameNoun_Adjective_Comparative()
     * ========================================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Adjective_Comparative.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Adjective_Comparative() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADJECTIVE_COMPARATIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adjective_Comparative LatinWord ", "melior", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adjective_Comparative EnglishWord", "better", englishWord );
    }


    /**
     * testMakeGameNoun_Adjective_Comparative()
     * ========================================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Adjective_Comparative.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Adjective_Superlative() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADJECTIVE_SUPERLATIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adjective_Superlative LatinWord ", "optimus", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adjective_Superlative EnglishWord", "best", englishWord );
    }

    /**
     * testMakeGameNoun_Adverb()
     * ============================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - Adverb.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_Adverb() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADVERB, id_Adverb, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adverb LatinWord ", "laete", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adverb EnglishWord", "happily", englishWord );
    }

    /**
     * testMakeGameNoun_AdverbComparative()
     * ====================================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - AdverbComparative.
     * @throws Exception
     */

    @Test
    public void testMakeGameNoun_AdverbComparative() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADVERB_COMPARATIVE, id_Adverb, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adverb Comparative LatinWord ", "laetius", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adverb Comparative EnglishWord ", "more happily", englishWord );
    }


    /**
     * testMakeGameNoun_AdverbSuperlative()
     * ====================================
     * test if makeGameNounEtc() Can Make The Right Type of Noun - AdverbComparative.
     * @throws Exception
     */
    @Test
    public void testMakeGameNoun_AdverbSuperlative() throws Exception {

        NounEtc nounEtc = nounGame1.makeGameNounEtc(ADVERB_SUPERLATIVE, id_Adverb, numberSingular, NOMINATIVE, GENDER_MALE );

        String latinWord = nounEtc.getLatinWord();
        assertEquals("Adverb Superlative LatinWord ", "laetissime", latinWord );

        String englishWord = nounEtc.getEnglishWordSingular();
        assertEquals("Adverb Superlative EnglishWord ", "very happily", englishWord );
    }

    /**
     * testGetNounEtcQuestions() - LEVEL 1
     * -------------------------
     * Test that getNounEtcQuestions() can generate 6 NounEtc Objects of the correct Type
     * @throws Exception
     */
    @Test
    public void testGetNounEtcQuestions_Level1() throws Exception {

        List<Integer> idList = randomGenerator.getRandomNounEtcIDlist(DbSchema.NounListTable.NOUN_LIST_TABLE, 1, 1);

        List<NounEtc> questionList = nounGame1.getNounEtcQuestionSet(NOUN_REGULAR, idList);

        for(NounEtc n : questionList){
            int id = n.getId();
            if(id != 14) {
                String nounType = n.getType();
                assertEquals(NOUN_REGULAR, nounType);
            }
        }
    }

    /**
     * Test whether can Form A AdverbComparative
     * @throws Exception
     */
    @Test
    public void testAdverbComparative() throws Exception {


    }



    /**
     * testGetNounEtcQuestions() - LEVEL 5
     * -------------------------
     * Test that getNounEtcQuestions() can generate 6 NounEtc Objects of the correct Type
     * @throws Exception
     */
    @Test
    public void testGetNounEtcQuestions_Level5() throws Exception {

        List<Integer> idList = randomGenerator.getRandomNounEtcIDlist(DbSchema.AdverbListTable.ADVERB_TABLE, 5, 1);

        List<NounEtc> questionList = nounGame1.getNounEtcQuestionSet(ADVERB, idList);

        for(NounEtc n : questionList){
                String nounType = n.getType();
                assertEquals(ADVERB, nounType);
        }
    }


    /**
     * testDetermineQuestionDifficulty()
     * =================================
     * testing determineQuestionDifficulty() to determine question difficulty
     */
    @Test
    public void testDetermineQuestionDifficulty() {

        NounEtc nounEtc1 = nounGame1.makeGameNounEtc(NOUN_REGULAR, id_Regular, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame1.setCorrectNounEtc(nounEtc1);
        int ansDiff1 = nounGame1.determineQuestionDifficulty();
        assertEquals("Question Difficulty 1: ", 1, ansDiff1);

        NounEtc nounEtc2 = nounGame2.makeGameNounEtc(NOUN_IRREGULAR, id_Irregular, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame2.setCorrectNounEtc(nounEtc2);
        int ansDiff2 = nounGame2.determineQuestionDifficulty();
        assertEquals("Question Difficulty 2: ", 2, ansDiff2);

        NounEtc nounEtc3 = nounGame3.makeGameNounEtc(CONJUNCTION, id_Conjunction, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame3.setCorrectNounEtc(nounEtc3);
        int ansDiff3 = nounGame3.determineQuestionDifficulty();
        assertEquals("Question Difficulty 3: ", 3, ansDiff3);

        NounEtc nounEtc4 = nounGame4.makeGameNounEtc(ADJECTIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame4.setCorrectNounEtc(nounEtc4);
        int ansDiff4 = nounGame4.determineQuestionDifficulty();
        assertEquals("Question Difficulty 4: ", 4, ansDiff4);

        NounEtc nounEtc5a = nounGame5.makeGameNounEtc(ADVERB, id_Adverb, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame5.setCorrectNounEtc(nounEtc5a);
        int ansDiff5a = nounGame5.determineQuestionDifficulty();
        assertEquals("Question Difficulty 5: ", 5, ansDiff5a);

        NounEtc nounEtc5b = nounGame5.makeGameNounEtc(ADJECTIVE_COMPARATIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame5.setCorrectNounEtc(nounEtc5b);
        int ansDiff5b = nounGame5.determineQuestionDifficulty();
        assertEquals("Question Difficulty 5: ", 5, ansDiff5b);
    }

    /**
     * testStoreAnswer()
     * -----------------
     * Tests storeAnswer() to see if the Answer object is correctly instantiated and
     * added to the List.
     *
     * @throws Exception
     */
    @Test
    public void testStoreAnswer() throws Exception {
        int ans = 0;
        NounEtc nounEtc5 = nounGame5.makeGameNounEtc(ADJECTIVE_COMPARATIVE, id_Adjective, numberSingular, NOMINATIVE, GENDER_MALE );
        nounGame5.setCorrectNounEtc(nounEtc5);
        int testAns = nounGame5.storeAnswer(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE, ans);
        assertEquals(ans, testAns);

        List<Answer> list = nounGame5.getAnswerList();
        Answer answer = list.get(0);


        assertEquals("Answer.TABLE", ADJECTIVE_COMPARATIVE, answer.type);
        assertEquals("Answer.ID", id_Adjective, answer.id);
        assertEquals("Answer.CORRECT", 0, answer.correct);
        assertEquals("Answer.DIFFICULTY", 5, answer.difficulty);

    }

    /**
     * testUpdateSkillLevel()
     * ----------------------
     * Test that skill level can be changed after IRT update
     */
    @Test
    public void testUpdateSkillLevel(){

        List<Answer> answerList = new ArrayList<>();

        Answer ans1 = new Answer(NOUN_REGULAR, 1,1,1);
        Answer ans2 = new Answer(NOUN_REGULAR, 2,1,1);
        Answer ans3 = new Answer(NOUN_REGULAR, 3,1,1);
        Answer ans4 = new Answer(NOUN_REGULAR, 4,1,1);
        Answer ans5 = new Answer(NOUN_REGULAR, 5,1,1);
        Answer ans6 = new Answer(NOUN_REGULAR, 6,1,1);
        Answer ans7 = new Answer(NOUN_REGULAR, 7,1,1);
        Answer ans8 = new Answer(NOUN_REGULAR, 8,1,1);
        Answer ans9 = new Answer(NOUN_REGULAR, 9,1,1);
        Answer ans10 = new Answer(NOUN_REGULAR, 10,1,1);
        Answer ans11 = new Answer(NOUN_REGULAR, 11,1,1);
        Answer ans12 = new Answer(NOUN_REGULAR, 12,1,1);
        Answer ans13 = new Answer(ADJECTIVE, 1,1,1);
        Answer ans14 = new Answer(ADJECTIVE, 2,1,1);
        Answer ans15 = new Answer(ADJECTIVE, 3,1,1);
        Answer ans16 = new Answer(ADJECTIVE, 4,1,1);
        Answer ans17 = new Answer(ADJECTIVE, 5,1,1);
        Answer ans18 = new Answer(CONJUNCTION, 1,1,1);
        Answer ans19 = new Answer(CONJUNCTION, 2,1,1);
        Answer ans20 = new Answer(CONJUNCTION, 3,1,1);

        answerList.add(ans1);
        answerList.add(ans2);
        answerList.add(ans3);
        answerList.add(ans4);
        answerList.add(ans5);
        answerList.add(ans6);
        answerList.add(ans7);
        answerList.add(ans8);
        answerList.add(ans9);
        answerList.add(ans10);
        answerList.add(ans11);
        answerList.add(ans12);
        answerList.add(ans13);
        answerList.add(ans14);
        answerList.add(ans15);
        answerList.add(ans16);
        answerList.add(ans17);
        answerList.add(ans18);
        answerList.add(ans19);
        answerList.add(ans20);

        // Full Marks -> SKillLevel Up!
        int newSkillLevel = nounGameSkill.updateSkillLevel(answerList);
        assertEquals(5, newSkillLevel);

        // ALL WRONG -> SKillLevel Down!
        for(Answer ans : answerList){  // Change to All Wrong Marks
            ans.correct = 0;
        }
        newSkillLevel = nounGameSkill.updateSkillLevel(answerList);
        assertEquals(4, newSkillLevel);

        int x=5;
        // 75% Correct
        for(int i=0; i<15; i++){
            Answer ans = answerList.get(i);
            ans.correct = 1;
        }
        newSkillLevel = nounGameSkill.updateSkillLevel(answerList);


        ans16.correct = 1;
        ans17.correct = 1;

        newSkillLevel = nounGameSkill.updateSkillLevel(answerList);

        ans18.correct = 1;

        newSkillLevel = nounGameSkill.updateSkillLevel(answerList);

        ans19.correct = 1;
        ans20.correct = 1;

        newSkillLevel = nounGameSkill.updateSkillLevel(answerList);

        assertEquals(5, newSkillLevel); // 75% Correct -> SKillLevel Up!

    }

    /**
     * testCalcStatistics()
     * --------------------
     * Test calcStatistics() so that it can correctly supply all statistics
     * both latest Quiz and Running Total;
     * @throws Exception
     */
    @Test
    public void testCalcStatistics() throws Exception {

        databaseAccess.sqlMeta_Reset(); // RESET

        List<Answer> ansList = new ArrayList<>();

        NounEtc noun1 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans1 = new Answer( noun1.getType(), noun1.getId(), 0, 1, noun1);

        NounEtc noun2 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 2, numberSingular, ACCUSATIVE, GENDER_MALE);
        Answer ans2 = new Answer( noun2.getType(), noun2.getId(), 1, 1, noun2);

        NounEtc noun3 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 3, numberSingular, GENITIVE, GENDER_MALE);
        Answer ans3 = new Answer( noun3.getType(), noun3.getId(), 0, 1, noun3);

        NounEtc noun4 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 4, numberSingular, DATIVE, GENDER_MALE);
        Answer ans4 = new Answer( noun4.getType(), noun4.getId(), 1, 1, noun4);

        NounEtc noun5 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 5, numberSingular, ABLATIVE, GENDER_MALE);
        Answer ans5 = new Answer( noun5.getType(), noun5.getId(), 0, 1, noun5);

        NounEtc noun6 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 6, numberSingular, VOCATIVE, GENDER_MALE);
        Answer ans6 = new Answer( noun6.getType(), noun6.getId(), 1, 1, noun6);

        NounEtc noun7 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 7, numberSingular, ACCUSATIVE, GENDER_MALE);
        Answer ans7 = new Answer( noun7.getType(), noun7.getId(), 0, 1, noun7);

        NounEtc noun8 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 8, numberSingular, GENITIVE, GENDER_MALE);
        Answer ans8 = new Answer( noun8.getType(), noun8.getId(), 1, 1, noun8);

        NounEtc noun9 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 9, numberSingular, DATIVE, GENDER_MALE);
        Answer ans9 = new Answer( noun9.getType(), noun9.getId(), 0, 1, noun9);

        NounEtc noun10 = nounGame1.makeGameNounEtc(NOUN_REGULAR, 10, numberSingular, ABLATIVE, GENDER_MALE);
        Answer ans10 = new Answer( noun10.getType(), noun10.getId(), 1, 1, noun10);

        NounEtc noun11 = nounGame1.makeGameNounEtc(ADJECTIVE, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans11 = new Answer( noun11.getType(), noun11.getId(), 1, 1, noun11);

        NounEtc noun12 = nounGame1.makeGameNounEtc(ADJECTIVE, 2, numberSingular, ACCUSATIVE, GENDER_MALE);
        Answer ans12 = new Answer( noun12.getType(), noun12.getId(), 0, 1, noun12);

        NounEtc noun13 = nounGame1.makeGameNounEtc(ADJECTIVE_COMPARATIVE, 1, numberSingular, ABLATIVE, GENDER_MALE);
        Answer ans13 = new Answer( noun13.getType(), noun13.getId(), 1, 1, noun13);

        NounEtc noun14 = nounGame1.makeGameNounEtc(ADJECTIVE_SUPERLATIVE, 1, numberSingular, GENITIVE, GENDER_MALE);
        Answer ans14 = new Answer( noun14.getType(), noun14.getId(), 0, 1, noun14);

        NounEtc noun15 = nounGame1.makeGameNounEtc(PREPOSITION, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans15 = new Answer( noun15.getType(), noun15.getId(), 1, 1, noun15);

        NounEtc noun16 = nounGame1.makeGameNounEtc(CONJUNCTION, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans16 = new Answer( noun16.getType(), noun16.getId(), 0, 1, noun16);

        NounEtc noun17 = nounGame1.makeGameNounEtc(ADVERB, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans17 = new Answer( noun17.getType(), noun17.getId(), 1, 1, noun17);

        NounEtc noun18 = nounGame1.makeGameNounEtc(ADVERB_SUPERLATIVE, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans18 = new Answer( noun18.getType(), noun18.getId(), 0, 1, noun18);

        NounEtc noun19 = nounGame1.makeGameNounEtc(ADVERB_COMPARATIVE, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans19 = new Answer( noun19.getType(), noun19.getId(), 1, 1, noun19);

        NounEtc noun20 = nounGame1.makeGameNounEtc(ADVERB_COMPARATIVE, 1, numberSingular, NOMINATIVE, GENDER_MALE);
        Answer ans20 = new Answer( noun20.getType(), noun20.getId(), 0, 1, noun20);


        ansList.add(ans1);
        ansList.add(ans2);
        ansList.add(ans3);
        ansList.add(ans4);
        ansList.add(ans5);
        ansList.add(ans6);
        ansList.add(ans7);
        ansList.add(ans8);
        ansList.add(ans9);
        ansList.add(ans10);
        ansList.add(ans11);
        ansList.add(ans12);
        ansList.add(ans13);
        ansList.add(ans14);
        ansList.add(ans15);
        ansList.add(ans16);
        ansList.add(ans17);
        ansList.add(ans18);
        ansList.add(ans19);
        ansList.add(ans20);

        Map<String, Integer> map = nounGame5.calcStatistics(ansList);

        assertEquals((int)map.get(NOUN), 50);
        assertEquals((int)map.get(PREPOSITION), 100 );
        assertEquals((int)map.get(CONJUNCTION), 0 );
        assertEquals((int)map.get(ADJECTIVE), 50 );
        assertEquals((int)map.get(ADJECTIVE_COMPARATIVE), 100 );
        assertEquals((int)map.get(ADJECTIVE_SUPERLATIVE), 0 );
        assertEquals((int)map.get(ADVERB), 100 );
        assertEquals((int)map.get(ADVERB_COMPARATIVE), 50 );
        assertEquals((int)map.get(ADVERB_SUPERLATIVE), 0 );

        assertEquals((int)map.get(DECL1), 100 );
        assertEquals((int)map.get(DECL2), 33 );
        assertEquals((int)map.get(DECL3), 50 );
        assertEquals((int)map.get(DECL4), 50 );

        assertEquals((int)map.get(NOMINATIVE), 50 );
        assertEquals((int)map.get(ACCUSATIVE), 33 );
        assertEquals((int)map.get(GENITIVE), 33 );
        assertEquals((int)map.get(DATIVE), 50 );
        assertEquals((int)map.get(ABLATIVE), 66 );
        assertEquals((int)map.get(VOCATIVE), 100 );

    }


        /**
         * testRunNounGame()
         * -----------------
         * Tests Multiple Runs of runNounGame
         *
         * @throws Exception
         */
    @Test
    public void testRunNounGame() throws Exception{

        for(int i=0; i<10; i++) {

            // 1
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 2
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 3
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 4
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 5
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 6
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 7
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 8
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 9
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 10
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 11
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 12
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 13
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 14
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 15
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 16
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 17
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 18
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 19
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);
            // 20
            nounGame1.runNounGame();
            nounGame1.storeAnswer(DbSchema.NounListTable.NOUN_LIST_TABLE, 0);

            databaseAccess.sqlVerbList_Reset(DbSchema.NounListTable.Cols.CORRECT);
            databaseAccess.sqlVerbList_Reset(DbSchema.NounListTable.Cols.CORRECT);
            nounGame1.setQuestionNumber(0);
        }

    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }

}
