package com.newnham.app.GCSE_Latin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newnham.app.GCSE_Latin.R;

import java.util.HashMap;
import java.util.Map;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ABLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ABLATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ACCUSATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ACCUSATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_COMPARATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_COMPARATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_SUPERLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE_SUPERLATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_COMPARATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_COMPARATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_SUPERLATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_SUPERLATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL1;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL1_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL2;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL2_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL3;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL3_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL4;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECL4_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENITIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.GENITIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOMINATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOMINATIVE_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PREPOSITION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PREPOSITION_HIST_PERC;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOCATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOCATIVE_HIST_PERC;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounStatisticsFragment extends Fragment {

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

//    private final static String NOUN_HIST_PERC = "Noun_Hist%";
//    private final static String NOUN_REGULAR_HIST_PERC = "NounRegular_Hist%";
//    private final static String NOUN_IRREGULAR_HIST_PERC = "NounIrregular_Hist%";
//    private final static String PREPOSITION_HIST_PERC = "Preposition_Hist%";
//    private final static String CONJUNCTION_HIST_PERC = "Conjunction_Hist%";
//    private final static String ADJECTIVE_HIST_PERC = "Adjective_Hist%";
//    private final static String ADJECTIVE_COMPARATIVE_HIST_PERC = "AdjectiveComparative_Hist%";
//    private final static String ADJECTIVE_SUPERLATIVE_HIST_PERC = "AdjectiveSuperlative_Hist%";
//    private final static String ADVERB_HIST_PERC = "Adverb_Hist%";
//    private final static String ADVERB_COMPARATIVE_HIST_PERC = "AdverbComparative_Hist%";
//    private final static String ADVERB_SUPERLATIVE_HIST_PERC = "AdverbSuperlative_Hist%";


//    private final static String DECL1 = "decl1";
//    private final static String DECL2 = "decl2";
//    private final static String DECL3 = "decl3";
//    private final static String DECL4 = "decl4";

//    private final String DECL1_HIST_PERC = "Decl1_Hist%";  // % of Correctly Answered Conj# Questions
//    private final String DECL2_HIST_PERC = "Decl2_Hist%";  // Key For statisticsMap
//    private final String DECL3_HIST_PERC = "Decl3_Hist%";
//    private final String DECL4_HIST_PERC = "Decl4_Hist%";

//    private final static String NOMINATIVE = "Nominative";
//    private final static String ACUSTATIVE = "Accusative";
//    private final static String GENITIVE = "Genitive";
//    private final static String DATIVE = "Dative";
//    private final static String ABLATIVE = "Ablative";
//    private final static String VOCATIVE = "Vocative";

//    private final static String NOMINATIVE_HIST_PERC = "Nominative_Hist%";
//    private final static String ACUSTATIVE_HIST_PERC = "Accusative_Hist%";
//    private final static String GENITIVE_HIST_PERC = "Genitive_Hist%";
//    private final static String DATIVE_HIST_PERC = "Dative_Hist%";
//    private final static String ABLATIVE_HIST_PERC = "Ablative_Hist%";
//    private final static String VOCATIVE_HIST_PERC = "Vocative_Hist%";

    private final static String TOTAL = "NounTotal";  // Historical Score of ALL Correct Questions
    private final static String TOTAL_HIST_PERC = "NounTotal_Hist%";  // Key For statisticsMap

    public final static String STATMAP = "statMap";
    public final static String PCT = "%";

    // Fields
    // ------

    Map<String, Integer> statMap;

    TextView mNoun;
    TextView mPreposition;
    TextView mConjunction;
    TextView mAdjective;
    TextView mAdjectiveComparative;
    TextView mAdjectiveSuperlative;
    TextView mAdverb;
    TextView mAdverbComparative;
    TextView mAdverbSuperlative;

    TextView mNounHist;
    TextView mPrepositionHist;
    TextView mConjunctionHist;
    TextView mAdjectiveHist;
    TextView mAdjectiveComparativeHist;
    TextView mAdjectiveSuperlativeHist;
    TextView mAdverbHist;
    TextView mAdverbComparativeHist;
    TextView mAdverbSuperlativeHist;

    TextView mDecl1;
    TextView mDecl2;
    TextView mDecl3;
    TextView mDecl4;

    TextView mDecl1Hist;
    TextView mDecl2Hist;
    TextView mDecl3Hist;
    TextView mDecl4Hist;

    TextView mNominative;
    TextView mAccusative;
    TextView mGenitive;
    TextView mDative;
    TextView mAblative;
    TextView mVocative;

    TextView mNominativeHist;
    TextView mAccusativeHist;
    TextView mGenitiveHist;
    TextView mDativeHist;
    TextView mAblativeHist;
    TextView mVocativeHist;


    TextView mTotal;
    TextView mTotalHist;


    // Constructor
    // -----------
    public NounStatisticsFragment() {
        // Required empty public constructor
    }

    // newInstance()  - NounStatisticsActivity -> NounStatisticsFragment
    // -------------
    public static NounStatisticsFragment newInstance(HashMap<String, Integer> map){
        Bundle args = new Bundle();
        args.putSerializable(STATMAP, map);
        NounStatisticsFragment nounStatFragment = new NounStatisticsFragment();
        nounStatFragment.setArguments(args);
        return nounStatFragment;
    }

    // onCreate
    // --------

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        statMap = (Map<String, Integer>) getArguments().getSerializable(STATMAP);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noun_statistics, container, false);

        // Wire TextViews to Java Variables
        // --------------------------------

        mNoun = (TextView) view.findViewById(R.id.noun);
        mPreposition = (TextView) view.findViewById(R.id.preposition);
        mConjunction = (TextView) view.findViewById(R.id.conjunction);
        mAdjective = (TextView) view.findViewById(R.id.adjective);
        mAdjectiveComparative = (TextView) view.findViewById(R.id.adjectiveComparative);
        mAdjectiveSuperlative = (TextView) view.findViewById(R.id.adjectiveSuperlative);
        mAdverb = (TextView) view.findViewById(R.id.adverb);
        mAdverbComparative = (TextView) view.findViewById(R.id.adverbComparative);
        mAdverbSuperlative = (TextView) view.findViewById(R.id.adverbSuperlative);

        mNounHist = (TextView) view.findViewById(R.id.nounHist);
        mPrepositionHist = (TextView) view.findViewById(R.id.prepositionHist);
        mConjunctionHist = (TextView) view.findViewById(R.id.conjunctionHist);
        mAdjectiveHist = (TextView) view.findViewById(R.id.adjectiveHist);
        mAdjectiveComparativeHist = (TextView) view.findViewById(R.id.adjectiveComparativeHist);
        mAdjectiveSuperlativeHist = (TextView) view.findViewById(R.id.adjectiveSuperlativeHist);
        mAdverbHist = (TextView) view.findViewById(R.id.adverbHist);
        mAdverbComparativeHist = (TextView) view.findViewById(R.id.adverbComparativeHist);
        mAdverbSuperlativeHist = (TextView) view.findViewById(R.id.adverbSuperlativeHist);

        mDecl1 = (TextView) view.findViewById(R.id.decl1);
        mDecl2 = (TextView) view.findViewById(R.id.decl2);
        mDecl3 = (TextView) view.findViewById(R.id.decl3);
        mDecl4 = (TextView) view.findViewById(R.id.decl4);

        mDecl1Hist = (TextView) view.findViewById(R.id.decl1Hist);
        mDecl2Hist = (TextView) view.findViewById(R.id.decl2Hist);
        mDecl3Hist = (TextView) view.findViewById(R.id.decl3Hist);
        mDecl4Hist = (TextView) view.findViewById(R.id.decl4Hist);

        mNominative = (TextView) view.findViewById(R.id.nominative);
        mAccusative = (TextView) view.findViewById(R.id.accusative);
        mGenitive = (TextView) view.findViewById(R.id.genitive);
        mDative = (TextView) view.findViewById(R.id.dative);
        mAblative = (TextView) view.findViewById(R.id.ablative);
        mVocative = (TextView) view.findViewById(R.id.vocative);

        mNominativeHist = (TextView) view.findViewById(R.id.nominativeHist);
        mAccusativeHist = (TextView) view.findViewById(R.id.accusativeHist);
        mGenitiveHist = (TextView) view.findViewById(R.id.genitiveHist);
        mDativeHist = (TextView) view.findViewById(R.id.dativeHist);
        mAblativeHist = (TextView) view.findViewById(R.id.ablativeHist);
        mVocativeHist = (TextView) view.findViewById(R.id.vocativeHist);

        mTotal = (TextView) view.findViewById(R.id.total);
        mTotalHist = (TextView) view.findViewById(R.id.totalHist);

        // Set TextViews From StatMaps
        // ---------------------------

        mNoun.setText(Integer.toString(statMap.get(NOUN))+PCT);
        mPreposition.setText(Integer.toString(statMap.get(PREPOSITION))+PCT);
        mConjunction.setText(Integer.toString(statMap.get(CONJUNCTION))+PCT);
        mAdjective.setText(Integer.toString(statMap.get(ADJECTIVE))+PCT);
        mAdjectiveComparative.setText(Integer.toString(statMap.get(ADJECTIVE_COMPARATIVE))+PCT);
        mAdjectiveSuperlative.setText(Integer.toString(statMap.get(ADJECTIVE_SUPERLATIVE))+PCT);
        mAdverb.setText(Integer.toString(statMap.get(ADVERB))+PCT);
        mAdverbComparative.setText(Integer.toString(statMap.get(ADVERB_COMPARATIVE))+PCT);
        mAdverbSuperlative.setText(Integer.toString(statMap.get(ADVERB_SUPERLATIVE))+PCT);

        mNounHist.setText(Integer.toString(statMap.get(NOUN_HIST_PERC))+PCT);
        mPrepositionHist.setText(Integer.toString(statMap.get(PREPOSITION_HIST_PERC))+PCT);
        mConjunctionHist.setText(Integer.toString(statMap.get(CONJUNCTION_HIST_PERC))+PCT);
        mAdjectiveHist.setText(Integer.toString(statMap.get(ADJECTIVE_HIST_PERC))+PCT);
        mAdjectiveComparativeHist.setText(Integer.toString(statMap.get(ADJECTIVE_COMPARATIVE_HIST_PERC))+PCT);
        mAdjectiveSuperlativeHist.setText(Integer.toString(statMap.get(ADJECTIVE_SUPERLATIVE_HIST_PERC))+PCT);
        mAdverbHist.setText(Integer.toString(statMap.get(ADVERB_HIST_PERC))+PCT);
        mAdverbComparativeHist.setText(Integer.toString(statMap.get(ADVERB_COMPARATIVE_HIST_PERC))+PCT);
        mAdverbSuperlativeHist.setText(Integer.toString(statMap.get(ADVERB_SUPERLATIVE_HIST_PERC))+PCT);

        mDecl1.setText(Integer.toString(statMap.get(DECL1))+PCT);
        mDecl2.setText(Integer.toString(statMap.get(DECL2))+PCT);
        mDecl3.setText(Integer.toString(statMap.get(DECL3))+PCT);
        mDecl4.setText(Integer.toString(statMap.get(DECL4))+PCT);

        mDecl1Hist.setText(Integer.toString(statMap.get(DECL1_HIST_PERC))+PCT);
        mDecl2Hist.setText(Integer.toString(statMap.get(DECL2_HIST_PERC))+PCT);
        mDecl3Hist.setText(Integer.toString(statMap.get(DECL3_HIST_PERC))+PCT);
        mDecl4Hist.setText(Integer.toString(statMap.get(DECL4_HIST_PERC))+PCT);

        mNominative.setText(Integer.toString(statMap.get(NOMINATIVE))+PCT);
        mAccusative.setText(Integer.toString(statMap.get(ACCUSATIVE))+PCT);
        mGenitive.setText(Integer.toString(statMap.get(GENITIVE))+PCT);
        mDative.setText(Integer.toString(statMap.get(DATIVE))+PCT);
        mAblative.setText(Integer.toString(statMap.get(ABLATIVE))+PCT);
        mVocative.setText(Integer.toString(statMap.get(VOCATIVE))+PCT);

        mNominativeHist.setText(Integer.toString(statMap.get(NOMINATIVE_HIST_PERC))+PCT);
        mAccusativeHist.setText(Integer.toString(statMap.get(ACCUSATIVE_HIST_PERC))+PCT);
        mGenitiveHist.setText(Integer.toString(statMap.get(GENITIVE_HIST_PERC))+PCT);
        mDativeHist.setText(Integer.toString(statMap.get(DATIVE_HIST_PERC))+PCT);
        mAblativeHist.setText(Integer.toString(statMap.get(ABLATIVE_HIST_PERC))+PCT);
        mVocativeHist.setText(Integer.toString(statMap.get(VOCATIVE_HIST_PERC))+PCT);

        mTotal.setText(Integer.toString(statMap.get(TOTAL))+PCT);
        mTotalHist.setText(Integer.toString(statMap.get(TOTAL_HIST_PERC))+PCT);

        return view;
    }

}
