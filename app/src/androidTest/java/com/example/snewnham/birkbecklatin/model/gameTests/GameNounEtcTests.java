package com.example.snewnham.birkbecklatin.model.gameTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGame;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGameImpl;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.RandomGenerator;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

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


    int skillLevel1;
    int skillLevel2;
    int skillLevel3;
    int skillLevel4;
    int skillLevel5;


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

    private final static String NOMINATIVE = "Nominative";
    private final static String ACCUSATIVE = "Accusative";
    private final static String DATIVE = "Dative";
    private final static String GENITIVE = "Genitive";
    private final static String ABLATIVE = "Ablative";

    private final static String GENDER_MALE = "m";

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
        nounGame2 = new NounEtcGameImpl(databaseAccess, 2); // Verb Skill 1
        nounGame3 = new NounEtcGameImpl(databaseAccess, 3); // Verb Skill 1
        nounGame4 = new NounEtcGameImpl(databaseAccess, 4); // Verb Skill 1
        nounGame5 = new NounEtcGameImpl(databaseAccess, 5); // Verb Skill 1

        id_Regular = 1;
        id_Irregular = 14;
        id_Conjunction = 2;
        id_Preposition = 3;
        id_Adjective = 1;
        id_Adverb = 1;

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

        List<NounEtcGameImpl.Answer> list = nounGame5.getAnswerList();
        NounEtcGameImpl.Answer answer = list.get(0);


        assertEquals("Answer.TABLE", ADJECTIVE_COMPARATIVE, answer.type);
        assertEquals("Answer.ID", id_Adjective, answer.id);
        assertEquals("Answer.CORRECT", 0, answer.correct);
        assertEquals("Answer.DIFFICULTY", 5, answer.difficulty);

    }
//
//
//    // ---------------------------------VERB CORRECT ---------------------------------------------
//
//    /**
//     * testRandomVerbCorrectTable()
//     * ------------------------------
//     * Test for random selection of a verb_id from the IncorrectVerb Table.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testRandomVerbIncorrectTable() throws Exception {
//
//        int skillLevel = 5;
//        int id1 = 1;
//        Verb verb1 = databaseAccess.sqlVerbListQuery(id1);
//        int id2 = 2;
//        Verb verb2 = databaseAccess.sqlVerbListQuery(id2);
//        int id3 = 8;
//        Verb verb3 = databaseAccess.sqlVerbListQuery(id3);
//        int id4 = 10;
//        Verb verb4 = databaseAccess.sqlVerbListQuery(id4);
//
//        int randomSims = 800;
//
//        // Reset the table
//        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.ASKED);
//        databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
//
//        // load the table
//        databaseAccess.sqlVerbList_Insert(id1, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id2, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id3, DbSchema.VerbListTable.Cols.CORRECT, 0);
//        databaseAccess.sqlVerbList_Insert(id4, DbSchema.VerbListTable.Cols.CORRECT, 0);
//
//        List<Integer> inCorrectList = databaseAccess.getVerbIDList(CONJNUM1_4, 0, false);
//        int numVerbs = inCorrectList.size();
//
//        int sample = randomSims / numVerbs;
//        float toleranceFactor = 0.2f;
//        int toleranceForSample = (int) (sample * toleranceFactor);
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0; i<randomSims; i++) {
//            List<Integer> list = randomGenerator.getRandomVerbIDpair(CONJNUM1_4, 0, false);
//            int ans = list.get(0);
//            if (!map.containsKey(ans))
//                map.put(ans, 1);
//            else
//                map.put(ans, map.get(ans) + 1);
//        }
//
//        int x = 5;
//        assertThat("Num verbId_1 Simulations", map.get(id1), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_1 Simulations", map.get(id1), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_2 Simulations", map.get(id2), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_2 Simulations", map.get(id2), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_3 Simulations", map.get(id3), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_3 Simulations", map.get(id3), lessThan(sample + toleranceForSample));
//
//        assertThat("Num verbId_4 Simulations", map.get(id4), greaterThan(sample - toleranceForSample));
//        assertThat("Num verbId_4 Simulations", map.get(id4), lessThan(sample + toleranceForSample));
//    }
//
//
//
//    /**
//     * testUpdateSkillLevel()
//     * ----------------------
//     * Test that skill level can be changed after IRT update
//     */
//    @Test
//    public void testUpdateSkillLevel(){
//
//        List<VerbGame.Answer> answerList = new ArrayList<>();
//
//        VerbGame.Answer ans1 = verbGameSkill.new Answer(1,1,1);
//        VerbGame.Answer ans2 = verbGameSkill.new Answer(2,1,1);
//        VerbGame.Answer ans3 = verbGameSkill.new Answer(3,1,1);
//        VerbGame.Answer ans4 = verbGameSkill.new Answer(4,1,1);
//        VerbGame.Answer ans5 = verbGameSkill.new Answer(5,1,1);
//        VerbGame.Answer ans6 = verbGameSkill.new Answer(6,1,1);
//        VerbGame.Answer ans7 = verbGameSkill.new Answer(7,1,1);
//        VerbGame.Answer ans8 = verbGameSkill.new Answer(8,1,1);
//        VerbGame.Answer ans9 = verbGameSkill.new Answer(9,1,1);
//        VerbGame.Answer ans10 = verbGameSkill.new Answer(10,1,1);
//        VerbGame.Answer ans11 = verbGameSkill.new Answer(11,1,1);
//        VerbGame.Answer ans12 = verbGameSkill.new Answer(12,1,1);
//        VerbGame.Answer ans13 = verbGameSkill.new Answer(13,1,1);
//        VerbGame.Answer ans14 = verbGameSkill.new Answer(14,1,1);
//        VerbGame.Answer ans15 = verbGameSkill.new Answer(15,1,1);
//        VerbGame.Answer ans16 = verbGameSkill.new Answer(16,1,1);
//        VerbGame.Answer ans17 = verbGameSkill.new Answer(17,1,1);
//        VerbGame.Answer ans18 = verbGameSkill.new Answer(18,1,1);
//        VerbGame.Answer ans19 = verbGameSkill.new Answer(19,1,1);
//        VerbGame.Answer ans20 = verbGameSkill.new Answer(20,1,1);
//
//        answerList.add(ans1);
//        answerList.add(ans2);
//        answerList.add(ans3);
//        answerList.add(ans4);
//        answerList.add(ans5);
//        answerList.add(ans6);
//        answerList.add(ans7);
//        answerList.add(ans8);
//        answerList.add(ans9);
//        answerList.add(ans10);
//        answerList.add(ans11);
//        answerList.add(ans12);
//        answerList.add(ans13);
//        answerList.add(ans14);
//        answerList.add(ans15);
//        answerList.add(ans16);
//        answerList.add(ans17);
//        answerList.add(ans18);
//        answerList.add(ans19);
//        answerList.add(ans20);
//
//        int newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        assertEquals(2, newSkillLevel);  // Full Marks -> SKillLevel Up!
//
//        for(VerbGame.Answer ans : answerList){  // Change to All Wrong Marks
//            ans.correct = 0;
//        }
//
//        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        assertEquals(1, newSkillLevel);  // ALL WRONG -> SKillLevel Down!
//
//        for(int i=0; i<15; i++){    // 75% Correct
//            VerbGame.Answer ans = answerList.get(i);
//            ans.correct = 1;
//        }
//
//        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        ans16.correct = 1;
//        ans17.correct = 1;
//
//        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        ans18.correct = 1;
//
//        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        ans19.correct = 1;
//        ans20.correct = 1;
//
//        newSkillLevel = verbGameSkill.updateSkillLevel(answerList);
//
//        assertEquals(3, newSkillLevel); // 75% Correct -> SKillLevel Up!
//
//    }
//
//    @Test
//    public void testRunVerbQuestion() throws Exception{
//
//        for(int i=0; i<10; i++) {
//
//            // 1
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 2
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 3
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 4
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 5
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 6
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 7
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 8
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 9
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 10
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 11
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 12
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 13
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 14
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 15
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 16
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 17
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 18
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 19
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//            // 20
//            verbGame1.runVerbQuestion();
//            verbGame1.storeAnswer(0);
//
//            databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
//            databaseAccess.sqlVerbList_Reset(DbSchema.VerbListTable.Cols.CORRECT);
//            verbGame1.setQuestionNumber(0);
//        }
//
//    }

    @After
    public void breakDown() {
        databaseAccess.close();
    }

}
