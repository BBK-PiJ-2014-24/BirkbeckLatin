package com.example.snewnham.birkbecklatin.view;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGame;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbGameFragment extends Fragment {

    // Fields
    // ------
    private static final int NUM_QUIZ_QUESTIONS = 20;
    private static final int NUM_MULTIPLE_CHOICES = 6;
    private static final String COUNTER = "counter";


    private DatabaseAccess mDatabaseAccess;
    private  VerbGame mVerbGame;
    private  Verb mCorrectVerb;
    private int mCorrectVerbIndex;
    private TextView mQuestionText;
    private List<Verb> mQuestionList;
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

    private RefreshListener mRefreshListener;



    // Constructor
    // -----------
    public VerbGameFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static VerbGameFragment newInstance(){
        return new VerbGameFragment();
    }


    /**
     * RefreshListener
     * ---------------
     * Implements the RefreshListener Interface, which allows the VerbGame Fragment to
     * request the VerbGameActivity to Refresh the Fragment screen.
     */

    public interface RefreshListener{
        void refresh();
    }


    // onSaveInstanceState()
    // --------------------
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(COUNTER, mCounter);  // Key -> Value
    }

    // onAttach
    // --------
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mRefreshListener = (RefreshListener) context;   // Store the Refresh Listener into the
    }

    // OnCreate
    // --------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseAccess = DatabaseAccess.getInstance(getContext());  // Connect Database
        mVerbGame = new VerbGame(mDatabaseAccess);                   // Instantiate Verb Game
        mCounter = 1;
        mButtonList = new ArrayList<>();   // Add Buttons to List
    }


    // On CreateView
    // -------------
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

        setUpQuestion(); // set up a Multiple Choice Question

        buttonNext = (Button) view.findViewById(R.id.buttonNext);  // Wire next Button and it's onClick()
        buttonNext.setOnClickListener(new ButtonNextClickListener());

        return view;
    }

    /**
     * setUpQuestion()
     * ---------------
     * Generates a Question List of 6 Verbs, selects a correctVerb, shuffles the order of the list.
     * Place the Question in the TextView; Set Latin Text on each Button
     */
    public void setUpQuestion(){
        mVerbGame.runVerbQuestion();  // Generates a Question List of 6 Verbs, selects a correctVerb, shuffles the order of the list.

        mQuestionList = mVerbGame.getVerbQuestionList();   // Get Question List
        mCorrectVerb = mVerbGame.getCorrectVerb();   // get Correct Verb
        mCorrectVerbIndex = mVerbGame.getCorrectVerbIndex(); // get the index of the Correct Verb in the Question List.
        mQuestionText.setText(mCorrectVerb.getEnglishVerb()); // Place the Question in the TextView

        for(int i = 0; i< NUM_MULTIPLE_CHOICES; i++) {  // set Up Buttons
            Verb verb = mQuestionList.get(i);
            String latinWord = verb.getLatinVerb();
            mButtonList.get(i).setText(latinWord);    // Set Latin Text on each Button

            if(i==mCorrectVerbIndex)
                mButtonList.get(i).setOnClickListener(new ButtonCorrectClickListener());  // Wire onClicks to Buttons
            else
                mButtonList.get(i).setOnClickListener(new ButtonIncorrectClickListener());

            mButtonList.get(i).setTag(1);  // Set Tag Flags
        }
    }

    /**
     * displayTextQuestionNumber()
     * -----------------------
     * Sets the Counter on the Screen for the Number of Questions Taken So Far
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

        String incorrectString = null;
        if(answer == 1)
            Toast.makeText(getContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        else {
            Resources res = getResources();  // Set Up A Resouces Object, then use it help format string
            incorrectString = String.format(res.getString(R.string.incorrect_toast), mCorrectVerb.getLatinVerb());
            Toast.makeText(getContext(), incorrectString, Toast.LENGTH_SHORT).show();
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



    // ------------------------------ INNER CLASSES -------------------------------------------


    // Inner Class
    // -----------
    class ButtonCorrectClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int status = (Integer) mButtonList.get(0).getTag();  // Check If Buttons are Live
            if(status==1) {
                mVerbGame.storeAnswer(1); // record the answer as correct
                makeAnswerToast(1);
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
                mVerbGame.storeAnswer(0);    // record the answer as incorrect
                makeAnswerToast(0);
                setButtonsNull();   // Turn Off the Button onClick()
            }
        }
    }

    // Inner Class
    // -----------
    class ButtonNextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(mCounter == NUM_QUIZ_QUESTIONS){   // Check if end of the game
                mVerbGame.endGame();   // Run The End of the Game
                Toast.makeText(getContext(),R.string.game_over, Toast.LENGTH_SHORT).show();
            } else {
                int status = (Integer) mButtonList.get(0).getTag(); // Temp Neutralize Button Clicks
                if (status == 1) {   // i.e. if Question Was Skipped MAKE ANSWER FAIL
                    mVerbGame.storeAnswer(0);    // record the answer as incorrect
                    makeAnswerToast(0); // Set up Toasts
                }
                mCounter++;
                displayTextQuestionNumber(); // update next question number
                setUpQuestion();  // Set Up Next Question
            }
          //  mRefreshListener.refresh();   // Trigger the Listener in the Activity to REFRESH SCREEN
                                          // For Next Question
        }
    }



}
