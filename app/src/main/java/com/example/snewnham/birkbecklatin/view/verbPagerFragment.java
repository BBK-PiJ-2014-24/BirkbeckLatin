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

        // Verb's Principle Parts
        String verbConj = Integer.toString(mVerb.getLatin_ConjNum());
        String presentCase = mVerb.getLatin_Present();
        String infinitive = mVerb.getLatin_Infinitive();
        String perfect = (mVerb.getLatin_Perfect() != null) ? mVerb.getLatin_Perfect() : " - ";
        String participle = (mVerb.getLatin_Participle()!= null) ? mVerb.getLatin_Participle() : " - ";
        String engVerb = TO + mVerb.getEnglish_Infinitive();

        if (perfect != null) {
            princParts1 = presentCase + ", " + infinitive + ", " + perfect;
            princParts2 = participle;
        } else {
            princParts1 = presentCase + ", " + infinitive + ", " + participle;   // AMEND FOR DEPONENT VERBS
            princParts2 = "";
        }

        // Wire to XML
        TextView verbConjNumText = (TextView) view.findViewById(R.id.verbConjNum);
        verbConjNumText.setText(verbConj);

        TextView principlePart1Text = (TextView) view.findViewById(R.id.principal_parts1);
        principlePart1Text.setText(princParts1);

        TextView principlePart2Text = (TextView) view.findViewById(R.id.principal_parts2);
        principlePart2Text.setText(princParts2);

        TextView englishVerbText = (TextView) view.findViewById(R.id.englishVerb);
        englishVerbText.setText(engVerb);

        return view;
        //return inflater.inflate(R.layout.fragment_verb_pager, container, false);
    }






}