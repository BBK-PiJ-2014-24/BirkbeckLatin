package com.example.snewnham.birkbecklatin.view;


import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbPagerFragment extends Fragment {

    // Constants
    // ---------
    private final static String TO = "To ";

    // Fields
    // ------
    private DatabaseAccess databaseAccess;
    private final static String VERB_ID = "verbID";
    private Verb mVerb;


    // Constructor
    // -----------
    public VerbPagerFragment() {
        // Required empty public constructor
    }


    /**
     * newInstance()  - Static Call for Instantiation
     * -------------
     * @param verbId
     * @return
     */
    public static VerbPagerFragment newInstance(int verbId) {
        Bundle args = new Bundle();  // pass the verbId in the activity Intent to the mFragment
        args.putSerializable(VERB_ID, verbId);

        VerbPagerFragment fragment = new VerbPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }



    // OnCreate
    // --------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int verbId = (int) getArguments().getSerializable(VERB_ID);  // call frags arguments
        databaseAccess = DatabaseAccess.getInstance(getContext());
        mVerb = databaseAccess.sqlVerbListQuery(verbId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this mFragment
        View view = inflater.inflate(R.layout.fragment_verb_pager, container, false);

        String princParts1;
        String princParts2;
        String princParts3;
        String princParts4;

        int maxFirstLineLength = 20; // max word length in order to avoid overrun
        int superMaxWordLength = 10; // word requires 3 lines

        // Verb's Principle Parts
        String verbConj = Integer.toString(mVerb.getLatin_ConjNum());
        String presentCase = mVerb.getLatin_Present();
        String infinitive = mVerb.getLatin_Infinitive();
        String perfect = (mVerb.getLatin_Perfect() != null) ? mVerb.getLatin_Perfect() : " - ";
        String participle = (mVerb.getLatin_Participle()!= null) ? mVerb.getLatin_Participle() : " - ";
        String engVerb = TO + mVerb.getEnglish_Infinitive();

        int firstLineLength = presentCase.length() + infinitive.length() + perfect.length();

        if(firstLineLength <= maxFirstLineLength) { // small words
            princParts1 = presentCase + ", " + infinitive + ", " + perfect;
            princParts2 = participle;
            princParts3 = " ";
            princParts4 = " ";
        } else if(infinitive.length() <= superMaxWordLength) { // medium words
            princParts1 = presentCase + ", " + infinitive;
            princParts2 = perfect + ", " + participle;
            princParts3 = " ";
            princParts4 = " ";
        } else {  // large words
            princParts1 = presentCase + ",";
            princParts2 = infinitive + ",";
            princParts3 = perfect + ",";
            princParts4 = participle;
        }

        // Wire to XML
        TextView verbConjNumText = (TextView) view.findViewById(R.id.verbConjNum);
        verbConjNumText.setText(verbConj);

        TextView principlePart1Text = (TextView) view.findViewById(R.id.principal_parts1);
        principlePart1Text.setText(princParts1);

        TextView principlePart2Text = (TextView) view.findViewById(R.id.principal_parts2);
        principlePart2Text.setText(princParts2);

        TextView principlePart3Text = (TextView) view.findViewById(R.id.principal_parts3);
        principlePart3Text.setText(princParts3);

        TextView principlePart4Text = (TextView) view.findViewById(R.id.principal_parts4);
        principlePart4Text.setText(princParts4);


        TextView englishVerbText = (TextView) view.findViewById(R.id.englishVerb);
        englishVerbText.setText(engVerb);

        return view;

    }






}