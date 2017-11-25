package com.newnham.app.GCSE_Latin.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.newnham.app.GCSE_Latin.Control.randomGenerator.Games.NounEtcGame;
import com.newnham.app.GCSE_Latin.Control.randomGenerator.Games.NounEtcGameImpl;
import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import com.newnham.app.GCSE_Latin.Model.nouns.NounEtc;
import com.newnham.app.GCSE_Latin.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ENGLISH_TO_LATIN;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.LATIN_TO_ENGLISH;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TRANSLATION_DIRECTION;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounGameFragment extends Fragment {

    // Fields
    // ------
    private static final int NUM_QUIZ_QUESTIONS = 20;
    private static final int NUM_MULTIPLE_CHOICES = 6;
    private static final String COUNTER = "counter";

    private DatabaseAccess mDatabaseAccess;
    private NounEtcGame mNounEtcGame;
    private NounEtc mCorrectNounEtc;
    private int mCorrectNounEtcIndex;
    private TextView mQuestionText;
    private List<NounEtc> mQuestionList;
    private List<Button> mButtonList;
    private int mCounter;
    private TextView mQuestionNumber;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button buttonNext;

    private String mTranslationDirection;

    private VerbGameFragment.RefreshListener mRefreshListener;

    // Constructor
    // -----------
    public NounGameFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static NounGameFragment newInstance(){
        return new NounGameFragment();
    }


    // onSaveInstanceState()
    // --------------------
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(COUNTER, mCounter);  // Key -> Value
    }

    // onAttach
    // --------
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
//        mRefreshListener = (RefreshListener) context;   // Store the Refresh Listener into the
    }

    // OnCreate
    // --------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseAccess = DatabaseAccess.getInstance(getContext());  // Connect Database
        int mTranslationCode = mDatabaseAccess.sqlMetaQuery(TRANSLATION_DIRECTION); // Get Translation Direction
        mTranslationDirection = (mTranslationCode == 0) ? ENGLISH_TO_LATIN : LATIN_TO_ENGLISH ;
        mNounEtcGame = new NounEtcGameImpl(mDatabaseAccess);                   // Instantiate Noun Game
        mCounter = 1;
        mButtonList = new ArrayList<>();   // Add Buttons to List
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mCounter = savedInstanceState.getInt(COUNTER);
        }

        View view = inflater.inflate(R.layout.fragment_verb_game, container, false);  // Inflate the layout for this mFragment

        mQuestionText = (TextView) view.findViewById(R.id.questionText); // Wire the Question

        button0 = (Button) view.findViewById(R.id.button0);// Wire Buttons to View
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);

        mButtonList.add(button0);
        mButtonList.add(button1);
        mButtonList.add(button2);
        mButtonList.add(button3);
        mButtonList.add(button4);
        mButtonList.add(button5);

        mQuestionNumber = (TextView) view.findViewById(R.id.questionNumber);  // Wire Question Number Counter
        displayTextQuestionNumber();  // set Counter

        buttonNext = (Button) view.findViewById(R.id.buttonNext);  // Wire next Button and it's onClick()
        buttonNext.setOnClickListener(new ButtonNextClickListener());

        setUpQuestion(); // set up a Multiple Choice Question

        return view;
    }

    /**
     * setUpQuestion() -
     * ---------------
     * Generates a Question List of 6 Nouns, selects a correctNoun, shuffles the order of the list.
     * Place the Question in the TextView; Set Latin Text on each Button.
     *
     */
    public void setUpQuestion(){
        mNounEtcGame.runNounGame();  // Generates a Question List of 6 Nouns, selects a correctNoun, shuffles the order of the list.

        mQuestionList = mNounEtcGame.getNounQuestionList();   // Get Question List
        mCorrectNounEtc = mNounEtcGame.getCorrectNounEtc();   // get Correct Noun
        mCorrectNounEtcIndex = mNounEtcGame.getCorrectNounEtcIndex(); // get the index of the Correct Noun in the Question List.
//        mQuestionText.setText(mCorrectNounEtc.getEnglishWord()); // Place the Question in the TextView
        String questionWord = (mTranslationDirection.equals(ENGLISH_TO_LATIN)) ? mCorrectNounEtc.getEnglishWord() : mCorrectNounEtc.getLatinWord();
        mQuestionText.setText(questionWord); // Place the Question in the TextView


        for(int i = 0; i< NUM_MULTIPLE_CHOICES; i++) {  // set Up Buttons
            NounEtc noun = mQuestionList.get(i);
            String word = (mTranslationDirection.equals(LATIN_TO_ENGLISH)) ? noun.getEnglishWord() : noun.getLatinWord();
            mButtonList.get(i).setText(word);    // Set Latin Text on each Button
            mButtonList.get(i).setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
            gd.setStroke(3, ContextCompat.getColor(getContext(), R.color.colorAccent));
            gd.setCornerRadius(15);
            mButtonList.get(i).setBackground(gd);

            if(i== mCorrectNounEtcIndex)
                mButtonList.get(i).setOnClickListener(new NounGameFragment.ButtonCorrectClickListener());  // Wire onClicks to Buttons
            else
                mButtonList.get(i).setOnClickListener(new NounGameFragment.ButtonIncorrectClickListener());

            mButtonList.get(i).setTag(1);  // Set Button Tag Flags
        }
        buttonNext.setTag(1);  // Set Next Button Tag Live
    }

    /**
     * setTextQuestionNumber()
     * -----------------------
     * Sets the Counter for the Number of Questions Taken So Far
     */
    public void displayTextQuestionNumber(){
        String questionOutOfMaxQuestions = Integer.toString(mCounter) + "/" + NUM_QUIZ_QUESTIONS;
        mQuestionNumber.setText(questionOutOfMaxQuestions);
    }


    /**
     * makeAnswerToast()
     * -----------------
     * Forms the Toast for a Correct or Incorrect Answer
     * @param answer Correct Answer(1), Incorrect Answer(0)
     */
    public void makeAnswerToast(int answer){
        if(answer == 1)
            Toast.makeText(getContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        else {
            Resources res = getResources();
            String inCorrectString = String.format(res.getString(R.string.incorrect_toast), mCorrectNounEtc.getLatinWord());
            Toast.makeText(getContext(), inCorrectString, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * setButtonsNull()
     * ----------------
     * Inactivate the Button onClicks()
     */
    public void setButtonsNull(){
        for(int i=0; i<NUM_MULTIPLE_CHOICES; i++){
            mButtonList.get(i).setTag(0);
        }
    }

    /**
     * setButtonsLive()
     * ----------------
     * Activate the Button onClicks()
     */
    public void setButtonsLive(){
        for(int i=0; i<NUM_MULTIPLE_CHOICES; i++){
            mButtonList.get(i).setTag(1);
        }
    }

    /**
     * moveToStatisticsActivity()
     * --------------------------
     * Collects the Map including statistics and opens NounStatisticsActivity with an
     * intent. The map passed as an argument.
     *
     */
    public void moveToStatisticsActivity(){
        HashMap<String, Integer> map = (HashMap<String, Integer>) mNounEtcGame.getStatMap();
        Activity activity = getActivity();
        Intent intent = NounStatisticsActivity.newIntent(activity, map);
        startActivity(intent);
    }


    // ------------------------------ INNER CLASSES -------------------------------------------


    // Inner Class
    // -----------
    class ButtonCorrectClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int status = (Integer) mButtonList.get(0).getTag();  // Check If Buttons are Live
            if(status==1) {
                String table = mNounEtcGame.getTableName(mCorrectNounEtc.getType());
                mNounEtcGame.storeAnswer(table, 1); // record the correct answer
                Button clickedButton = (Button) view;
                clickedButton.setBackgroundColor(Color.GREEN);
                clickedButton.setTextColor(Color.DKGRAY);
                //makeAnswerToast(1);
                setButtonsNull();   // Turn Off the Button onClick()
            }

        }
    }

    // Inner Class
    // -----------
    class ButtonIncorrectClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int status = (Integer) mButtonList.get(0).getTag();  // Check If Buttons are Live
            if(status==1) {
                String table = mNounEtcGame.getTableName(mCorrectNounEtc.getType());
                mNounEtcGame.storeAnswer(table, 0);    // record the incorrect answer
                Button clickedButton = (Button) view; // Find the Clicked Button
                clickedButton.setTextColor(Color.WHITE);
                GradientDrawable gdClicked = new GradientDrawable();
                gdClicked.setColor(Color.RED);
                gdClicked.setStroke(3, ContextCompat.getColor(getContext(), R.color.colorAccent));
                gdClicked.setCornerRadius(15);
                clickedButton.setBackground(gdClicked);


                Button correctButton = mButtonList.get(mCorrectNounEtcIndex);  // Find the Correct Button
                correctButton.setTextColor(Color.DKGRAY);
                GradientDrawable gdCorrect = new GradientDrawable();
                gdCorrect.setColor(Color.GREEN);
                gdCorrect.setStroke(3, ContextCompat.getColor(getContext(), R.color.colorAccent));
                gdCorrect.setCornerRadius(15);
                correctButton.setBackground(gdCorrect);
                setButtonsNull();   // Turn Off the Button onClick()
            }
        }
    }

    // Inner Class
    // -----------
    class ButtonNextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if((Integer) buttonNext.getTag() == 1) {
                int status = (Integer) mButtonList.get(0).getTag(); // Temp Neutralize Button Clicks
                if (status == 1) {   // Check if Question Was Skipped -> MAKE AUTO ANSWER FAIL
                    String table = mNounEtcGame.getTableName(mCorrectNounEtc.getType());
                    mNounEtcGame.storeAnswer(table,0);    // record the answer as incorrect
                   // makeAnswerToast(0); // Set up Toasts
                }

                if (mCounter >= NUM_QUIZ_QUESTIONS) {   // Check if end of the game
                    buttonNext.setTag(0);  // Deactivate NextButton after End of Game
                    Toast.makeText(getContext(), R.string.game_over, Toast.LENGTH_SHORT).show();  // End Game Toast
                    mNounEtcGame.endGame();   // Run The End of the Game Method
                    moveToStatisticsActivity(); // Move to Statistics Activity Page
                } else {
                    mCounter++;
                    displayTextQuestionNumber(); // update next question number
                    setUpQuestion();  // Set Up Next Question
                }
            }

            //  mRefreshListener.refresh();   // Trigger the Listener in the Activity to REFRESH SCREEN
            // For Next Question
        }
    }



}
