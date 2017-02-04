package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGame;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGameImpl;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.VerbGame;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.R;
import com.example.snewnham.birkbecklatin.view.VerbGameFragment;

import java.util.ArrayList;
import java.util.List;

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
    private int mCorrectVerbIndex;
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
        mNounEtcGame = new NounEtcGameImpl(mDatabaseAccess);                   // Instantiate Verb Game
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
     * setUpQuestion()
     * ---------------
     * Generates a Question List of 6 Nouns, selects a correctNoun, shuffles the order of the list.
     * Place the Question in the TextView; Set Latin Text on each Button.
     *
     */
    public void setUpQuestion(){
        mNounEtcGame.runNounGame();  // Generates a Question List of 6 Verbs, selects a correctVerb, shuffles the order of the list.

        mQuestionList = mNounEtcGame.getNounQuestionList();   // Get Question List
        mCorrectNounEtc = mNounEtcGame.getCorrectNounEtc();   // get Correct Verb
        mCorrectVerbIndex = mNounEtcGame.getCorrectNounEtcIndex(); // get the index of the Correct Verb in the Question List.
        mQuestionText.setText(mCorrectNounEtc.getEnglishWord()); // Place the Question in the TextView

        for(int i = 0; i< NUM_MULTIPLE_CHOICES; i++) {  // set Up Buttons
            Verb verb = mQuestionList.get(i);
            String latinWord = verb.getLatinVerb();
            mButtonList.get(i).setText(latinWord);    // Set Latin Text on each Button

            if(i==mCorrectVerbIndex)
                mButtonList.get(i).setOnClickListener(new VerbGameFragment.ButtonCorrectClickListener());  // Wire onClicks to Buttons
            else
                mButtonList.get(i).setOnClickListener(new VerbGameFragment.ButtonIncorrectClickListener());

            mButtonList.get(i).setTag(1);  // Set Button Tag Flags
        }
        buttonNext.setTag(1);  // Set Next Button Tag Live
    }


}
