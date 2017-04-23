package com.example.snewnham.birkbecklatin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGame;
import com.example.snewnham.birkbecklatin.Control.randomGenerator.Games.NounEtcGameImpl;
import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.AdjectiveComparative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdjectiveSuperlative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbComparative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbSuperlative;
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.R;

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADJECTIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADJECTIVE_COMPARATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADJECTIVE_SUPERLATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADVERB;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADVERB_COMPARATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADVERB_SUPERLATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJUNCTION;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_FEMALE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_MALE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_NEUTER;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NOMINATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NOUN_IRREGULAR;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NOUN_REGULAR;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NUMBER_SINGULAR;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.PREPOSITION;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounPagerFragment extends Fragment {

    // Constants
    // ---------
    private static final String TYPE = "Type";
    private static final String NOUN_ID = "nounId";

    private final static String DECL1 = "1";


    // Fields
    // ------
    DatabaseAccess mDatabaseAccess;
    NounEtcGame mNounEtcGame;

    String mType;
    int mNounID;

    NounEtc mNounEtc;
    String mEnglishSingular;


    // Constructor
    // -----------
    public NounPagerFragment() {
        // Required empty public constructor
    }


    // newInstance()  - Static Call for Instantiation
    // -------------
    public static NounPagerFragment newInstance(String type, int nounID) {
        Bundle args = new Bundle();
        args.putSerializable(TYPE, type);
        args.putSerializable(NOUN_ID, nounID);

        NounPagerFragment fragment = new NounPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    // OnCreate
    // --------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseAccess = DatabaseAccess.getInstance(getContext());
        mNounEtcGame = new NounEtcGameImpl(mDatabaseAccess, 5);
        mType = (String) getArguments().getSerializable(TYPE);
        mNounID = (int) getArguments().getSerializable(NOUN_ID);  // call frags arguments
        mNounEtc = mNounEtcGame.makeGameNounEtc(mType, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_MALE );
        mEnglishSingular = mNounEtc.getEnglishWord();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noun_pager, container, false);

        String princParts1 = "";
        String princParts2 = "";
        String genitive = "";
        String nominativeMale="";
        String nominativeFemale="";
        String nominativeNeuter="";

        // Noun's Principle Parts
        // ----------------------
        String nounDecl = Integer.toString(mNounEtc.getDeclension());
        String nominative = mNounEtc.getNominative();

        String gender = "(" + mNounEtc.getGender() + ")";
        String description = mNounEtc.getType();

        if(mType.equals(NOUN_REGULAR))
            genitive = mNounEtc.getGenitive();

        if(mType.equals(NOUN_IRREGULAR)){
            nominativeMale = mNounEtc.getLatinWord();
            mNounEtc = mNounEtcGame.makeGameNounEtc(mType, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_FEMALE );
            nominativeFemale = mNounEtc.getLatinWord();
            mNounEtc = mNounEtcGame.makeGameNounEtc(mType, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_NEUTER );
            nominativeNeuter = mNounEtc.getLatinWord();
        }

        switch(mNounEtc.getType()) {
            case NOUN_REGULAR:  // Nominative, Genitive, Gender
                description = description + " " + nounDecl;
                princParts1 = nominative + ", " + genitive;
                princParts2 = gender;
                break;
            case NOUN_IRREGULAR: // Nominative, Genitive, Gender
                description = "PRONOUN/POSSESSIVE";
                princParts1 = nominativeMale + ", " + nominativeFemale;
                princParts2 = nominativeNeuter;
                break;
            case PREPOSITION:
                princParts1 = mNounEtc.getLatinWord();
                princParts2 = " ";
                break;
            case CONJUNCTION:
                princParts1 = mNounEtc.getLatinWord();
                princParts2 = " ";
                break;
            case ADJECTIVE:  // Nominative(m, f, n), Comparative, Superlative
                Adjective latinF = (Adjective) mNounEtcGame.makeGameNounEtc(mType, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_FEMALE );
                Adjective latinN = (Adjective) mNounEtcGame.makeGameNounEtc(mType, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_NEUTER );
                princParts1 = nominative + ", " + latinF.getLatinWord() + ", " + latinN.getLatinWord();
                AdjectiveComparative adjectiveComparative = (AdjectiveComparative) mNounEtcGame.makeGameNounEtc(ADJECTIVE_COMPARATIVE, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_MALE );
                AdjectiveSuperlative adjectiveSuperlative = (AdjectiveSuperlative) mNounEtcGame.makeGameNounEtc(ADJECTIVE_SUPERLATIVE, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_MALE );
                princParts2 = adjectiveComparative.getLatinWord() + ", " + adjectiveSuperlative.getLatinWord();
                break;
            case ADVERB:
                princParts1 = mNounEtc.getLatinWord(); // Adverb, Comparative, Superlative
                AdverbComparative adverbComparative = (AdverbComparative) mNounEtcGame.makeGameNounEtc(ADVERB_COMPARATIVE, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_FEMALE);
                AdverbSuperlative adverbSuperlative = (AdverbSuperlative) mNounEtcGame.makeGameNounEtc(ADVERB_SUPERLATIVE, mNounID, NUMBER_SINGULAR, NOMINATIVE, GENDER_FEMALE);
                if(adverbComparative.getLatinWord() != null)
                    princParts2 = adverbComparative.getLatinWord() + ", " + adverbSuperlative.getLatinWord();
                else
                    princParts2 = "";
                break;
        }

        // Wire to XML
        // -----------
        TextView nounDescriptionText = (TextView) view.findViewById(R.id.nounDescription);
        nounDescriptionText.setText(description);

        TextView principlePart1Text = (TextView) view.findViewById(R.id.noun_principal_parts1);
        principlePart1Text.setText(princParts1);

        TextView principlePart2Text = (TextView) view.findViewById(R.id.noun_principal_parts2);
        principlePart2Text.setText(princParts2);

        TextView englishNounText = (TextView) view.findViewById(R.id.englishNoun);
        englishNounText.setText(mEnglishSingular);

        return view;
    }




}
