package com.example.snewnham.birkbecklatin.view;


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

    DatabaseAccess mDatabaseAccess;
    VerbGame mVerbGame;
    Verb mCorrectVerb;
    int mCorrectVerbIndex;
    TextView mQuestionText;
    List<Verb> mQuestionList;
    List<Button> mButtonList;


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_verb_game, container, false);  // Inflate the layout for this fragment

        mDatabaseAccess = DatabaseAccess.getInstance(getContext());  // Connect Database
        mVerbGame = new VerbGame(mDatabaseAccess);                   // Instantiate Verb Game

        mQuestionText = (TextView) view.findViewById(R.id.questionText); // Wire the Question

        Button button1 = (Button) view.findViewById(R.id.button1);  // Wire Buttons to View
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);
        Button button5 = (Button) view.findViewById(R.id.button5);
        Button button6 = (Button) view.findViewById(R.id.button6);

        mButtonList = new ArrayList<>();   // Add Buttons to List
        mButtonList.add(button1);
        mButtonList.add(button2);
        mButtonList.add(button3);
        mButtonList.add(button4);
        mButtonList.add(button5);
        mButtonList.add(button6);

        setUpQuestion(); // set up a Multiple Choice Question

        for(int i=0; i<NUM_MULTIPLE_CHOICES; i++){
            if(i==mCorrectVerbIndex)
                mButtonList.get(i).setOnClickListener(new ButtonCorrectClickListener());
            else
                mButtonList.get(i).setOnClickListener(new ButtonIncorrectClickListener());
        }

        Button buttonNext = (Button) view.findViewById(R.id.buttonNext);

 //       mVerbGame.endGame();

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

        for(int i = 0; i< NUM_MULTIPLE_CHOICES; i++) {  // Set Latin Text on each Button
            Verb verb = mQuestionList.get(i);
            String latinWord = verb.getLatinVerb();
            mButtonList.get(i).setText(latinWord);
            mButtonList.get(i).setTag(1);  // Set Tag Flags
        }

    }

    public void makeAnswerToast(int answer){
        if(answer == 1)
            Toast.makeText(getContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
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


    // Inner Class
    // -----------
    class ButtonCorrectClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int status = (Integer) mButtonList.get(0).getTag();  // Check If Buttons are Live
            if(status==1) {
                //mVerbGame.checkAnswer(mCorrectVerbIndex); // record the answer
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
                int otherIndex = (mCorrectVerbIndex == 0) ? 1 : 0; // make up dummy index as cannot pass to anom function
                //mVerbGame.checkAnswer(otherIndex);    // record the answer
                makeAnswerToast(0);
                setButtonsNull();   // Turn Off the Button onClick()
            }
        }
    }

    // Inner Class
    // -----------
    class ButtonNullClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }


    }



}
