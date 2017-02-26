package com.example.snewnham.birkbecklatin.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.snewnham.birkbecklatin.R;

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADJECTIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADVERB;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJUNCTION;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLNUM1;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLNUM2;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLNUM3;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLNUM4;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLNUM5;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NOUN_REGULAR;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.PREPOSITION;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounPagerSelectionFragment extends Fragment {


    // Constants
    // ---------
//    private final static String NOUN = "Noun";
//    private final static String NOUN_REGULAR = "NounRegular";
//    private final static String NOUN_IRREGULAR = "NounIrregular";
//    private final static String PREPOSITION = "Preposition";
//    private final static String CONJUNCTION = "Conjunction";
//    private final static String ADJECTIVE = "Adjective";
//    private final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
//    private final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";
//    private final static String ADVERB = "Adverb";
//    private final static String ADVERB_COMPARATIVE = "AdverbComparative";
//    private final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";


//    private static final int DECLNUM1 = 1;
//    private static final int DECLNUM2 = 2;
//    private static final int DECLNUM3 = 3;
//    private static final int DECLNUM4 = 4;
//    private static final int DECLNUM5 = 5;


    // Fields
    // ------
    Button mButtonNoun1;
    Button mButtonNoun2;
    Button mButtonNoun3;
    Button mButtonNoun4;
    Button mButtonNoun5;
    Button mButtonConjunction;
    Button mButtonPreposition;
    Button mButtonAdjective;
    Button mButtonAdverb;




    // Constructor
    // -----------

    // Constructor
    // -----------
    public NounPagerSelectionFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static NounPagerSelectionFragment newInstance() {
        return new NounPagerSelectionFragment();
    }

    // onCreateView()
    // --------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_noun_pager_selection, container, false);

        mButtonNoun1 = (Button) view.findViewById(R.id.buttonNoun1);
        Activity activity = getActivity();
        mButtonNoun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM1);
                startActivity(intent);
            }
        });

        mButtonNoun2 = (Button) view.findViewById(R.id.buttonNoun2);
        activity = getActivity();
        mButtonNoun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM2);
                startActivity(intent);
            }
        });

        mButtonNoun3 = (Button) view.findViewById(R.id.buttonNoun3);
        activity = getActivity();
        mButtonNoun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM3);
                startActivity(intent);
            }
        });

        mButtonNoun4 = (Button) view.findViewById(R.id.buttonNoun4);
        activity = getActivity();
        mButtonNoun4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM4);
                startActivity(intent);
            }
        });

        mButtonNoun5 = (Button) view.findViewById(R.id.buttonNoun5);
        activity = getActivity();
        mButtonNoun5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM5);
                startActivity(intent);
            }
        });

        mButtonConjunction = (Button) view.findViewById(R.id.buttonConjunction);
        activity = getActivity();
        mButtonConjunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), CONJUNCTION, 0);
                startActivity(intent);
            }
        });

        mButtonPreposition = (Button) view.findViewById(R.id.buttonPreposition);
        activity = getActivity();
        mButtonPreposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), PREPOSITION, 0);
                startActivity(intent);
            }
        });

        mButtonAdjective = (Button) view.findViewById(R.id.buttonAdjective);
        activity = getActivity();
        mButtonAdjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), ADJECTIVE, 0);
                startActivity(intent);
            }
        });

        mButtonAdverb = (Button) view.findViewById(R.id.buttonAdverb);
        activity = getActivity();
        mButtonAdverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), ADVERB, 0);
                startActivity(intent);
            }
        });

        return view;
    }

}
