package com.example.snewnham.birkbecklatin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounPagerFragment extends Fragment {

    // Constants
    // ---------
    private static final String EXTRA_DECL_NUM = "Decl_Number";
    private static final String TABLE = "table";
    private final static String NOUN = "Noun";
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

    // Fields
    // ------
    NounEtc mNounEtc;


    // Constructor
    // -----------
    public NounPagerFragment() {
        // Required empty public constructor
    }



    // newInstance()  - Static Call for Instantiation
    // -------------
    public static NounPagerFragment newInstance(String table, int nounDeclNum) {
        Bundle args = new Bundle();
        args.putSerializable(TABLE, table);
        args.putSerializable(EXTRA_DECL_NUM, nounDeclNum);

        NounPagerFragment fragment = new NounPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noun_pager, container, false);

        String princParts1;
        String princParts2;


        // Noun's Principle Parts
        String nounDecl = Integer.toString(mNounEtc.getDeclension());
        String nominative = mNounEtc.getNominative();
        String genitive = null; //mNounEtc.getGenitive();
        String gender = mNounEtc.getGender();


        switch(mNounEtc.getType()) {
            case NOUN:
                princParts1 = nominative + ", " + genitive;
                princParts2 = gender;
                break;
            case NOUN_IRREGULAR:
                princParts1 = nominative + ", " + genitive;
                princParts2 = gender;
                break;
            case PREPOSITION:
                princParts1 = null;
                break;
            case CONJUNCTION:
                break;
            case ADJECTIVE:
                break;
            case ADVERB:
                break;
        }



        // Wire to XML
//        TextView verbConjNumText = (TextView) view.findViewById(R.id.verbConjNum);
//        verbConjNumText.setText(verbConj);
//
//        TextView principlePart1Text = (TextView) view.findViewById(R.id.principal_parts1);
//        principlePart1Text.setText(princParts1);
//
//        TextView principlePart2Text = (TextView) view.findViewById(R.id.principal_parts2);
//        principlePart2Text.setText(princParts2);
//
//        TextView englishVerbText = (TextView) view.findViewById(R.id.englishVerb);
//        englishVerbText.setText(engVerb);

        return view;
    }

}
