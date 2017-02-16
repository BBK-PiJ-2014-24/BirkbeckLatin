package com.example.snewnham.birkbecklatin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.R;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.id;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbStatisticsFragment extends Fragment {


    // Constants
    // ---------

    private static final String CONJNUM1 = "ConjNum1";
    private static final String CONJNUM2 = "ConjNum2";
    private static final String CONJNUM3 = "ConjNum3";
    private static final String CONJNUM31 = "ConjNum31";
    private static final String CONJNUM4 = "ConjNum4";

    private final static String TENSE_PRESENT = "Present";
    private final static String TENSE_IMPERFECT = "Imperfect";
    private final static String TENSE_FUTURE = "Future";
    private final static String TENSE_PERFECT = "Perfect";
    private final static String TENSE_PLUPERFECT = "Pluperfect";
    private final static String TENSE_FUTURE_PERFECT = "Future Perfect";

    private final static String MOOD_INDICATIVE = "Indicative";
    private final static String MOOD_IMPERATIVE = "Imperative";
    private final static String MOOD_SUBJUNCTIVE = "Subjunctive";

    private final static String VOICE_ACTIVE = "Active";
    private final static String VOICE_PASSIVE = "Passive";

    private final String CONJNUM1_HIST_PERC = "Conj1_Hist%";  // % of Correctly Answered Conj# Questions
    private final String CONJNUM2_HIST_PERC = "Conj2_Hist%";  // Key For statisticsMap
    private final String CONJNUM3_HIST_PERC = "Conj3_Hist%";
    private final String CONJNUM4_HIST_PERC = "Conj4_Hist%";

    private final static String TENSE_PRESENT_HIST = "Present_Hist%";    // % of Correctly Answered Tense Questions
    private final static String TENSE_IMPERFECT_HIST = "Imperfect_Hist%";  // Key For statisticsMap
    private final static String TENSE_FUTURE_HIST = "Future_Hist%";
    private final static String TENSE_PERFECT_HIST = "Perfect_Hist%";
    private final static String TENSE_PLUPERFECT_HIST = "Pluperfect_Hist%";
    private final static String TENSE_FUTURE_PERFECT_HIST = "Future Perfect_Hist%";

    private final static String MOOD_INDICATIVE_HIST = "Indicative_Hist%";   // % of Correctly Answered Mood Questions
    private final static String MOOD_IMPERATIVE_HIST = "Imperative_Hist%";   // Key For statisticsMap
    private final static String MOOD_SUBJUNCTIVE_HIST = "Subjunctive_Hist%";

    private final static String VOICE_ACTIVE_HIST = "Active_Hist%";   // % of Correctly Answered Voice Questions
    private final static String VOICE_PASSIVE_HIST = "Passive_Hist%";  // Key For statisticsMap

    private final static String TOTAL = "Total";  // Historical Score of ALL Correct Questions
    private final static String TOTAL_HIST = "Total_Hist%";  // Key For statisticsMap

    public final static String STATMAP = "statMap";
    public final static String PCT = " %";


    // Fields
    // ------

    Map<String, Integer> statMap;

    TextView mConj1;
    TextView mConj2;
    TextView mConj3;
    TextView mConj4;
    TextView mConj1Hist;
    TextView mConj2Hist;
    TextView mConj3Hist;
    TextView mConj4Hist;

    TextView mPresent;
    TextView mImperfect;
    TextView mFuture;
    TextView mPerfect;
    TextView mPluperfect;
    TextView mFutPerfect;

    TextView mPresentHist;
    TextView mImperfectHist;
    TextView mFutureHist;
    TextView mPerfectHist;
    TextView mPluperfectHist;
    TextView mFutPerfectHist;

    TextView mIndicative;
    TextView mSubjunctive;
    TextView mImperative;
    TextView mIndicativeHist;
    TextView mSubjunctiveHist;
    TextView mImperativeHist;

    TextView mActive;
    TextView mPassive;
    TextView mActiveHist;
    TextView mPassiveHist;

    TextView mTotal;
    TextView mTotalHist;


    // Constructor
    // -----------
    public VerbStatisticsFragment() {
        // Required empty public constructor
    }

    // newInstance()  - VerbStatisticsActivity -> VerbStatisticsFragment
    // -------------
   //public static VerbStatisticsFragment newInstance(){
   public static VerbStatisticsFragment newInstance(HashMap<String, Integer> map){
       Bundle args = new Bundle();
       args.putSerializable(STATMAP, map);
       VerbStatisticsFragment verbStatFragment = new VerbStatisticsFragment();
       verbStatFragment.setArguments(args);
       return verbStatFragment;
    }


    // onCreate
    // --------

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        statMap = (Map<String, Integer>) getArguments().getSerializable(STATMAP);
    }

    // OnCreateView
    // ------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verb_statistics, container, false);

        // Wire TextViews to Java Variables
        // --------------------------------
        mConj1 = (TextView) view.findViewById(R.id.conj1);
        mConj2 = (TextView) view.findViewById(R.id.conj2);
        mConj3 = (TextView) view.findViewById(R.id.conj3);
        mConj4 = (TextView) view.findViewById(R.id.conj4);

        mConj1Hist = (TextView) view.findViewById(R.id.conj1Hist);
        mConj2Hist = (TextView) view.findViewById(R.id.conj2Hist);
        mConj3Hist = (TextView) view.findViewById(R.id.conj3Hist);
        mConj4Hist = (TextView) view.findViewById(R.id.conj4Hist);

        mPresent = (TextView) view.findViewById(R.id.present);
        mImperfect = (TextView) view.findViewById(R.id.imperfect);
        mFuture = (TextView) view.findViewById(R.id.future);
        mPerfect = (TextView) view.findViewById(R.id.perfect);
        mPluperfect = (TextView) view.findViewById(R.id.pluperfect);
        mFutPerfect = (TextView) view.findViewById(R.id.futPerfect);

        mPresentHist = (TextView) view.findViewById(R.id.presentHist);
        mImperfectHist = (TextView) view.findViewById(R.id.imperfectHist);
        mFutureHist = (TextView) view.findViewById(R.id.futureHist);
        mPerfectHist = (TextView) view.findViewById(R.id.perfectHist);
        mPluperfectHist = (TextView) view.findViewById(R.id.pluperfectHist);
        mFutPerfectHist = (TextView) view.findViewById(R.id.futPerfectHist);

        mIndicative = (TextView) view.findViewById(R.id.indicative);
        mSubjunctive = (TextView) view.findViewById(R.id.subjunctive);
        mImperative = (TextView) view.findViewById(R.id.imperative);
        mIndicativeHist = (TextView) view.findViewById(R.id.indicativeHist);
        mSubjunctiveHist = (TextView) view.findViewById(R.id.subjunctiveHist);
        mImperativeHist = (TextView) view.findViewById(R.id.imperativeHist);
        mActive = (TextView) view.findViewById(R.id.active);

        mPassive = (TextView) view.findViewById(R.id.passive);
        mActiveHist = (TextView) view.findViewById(R.id.activeHist);
        mPassiveHist = (TextView) view.findViewById(R.id.passiveHist);

        mTotal = (TextView) view.findViewById(R.id.total);
        mTotalHist = (TextView) view.findViewById(R.id.totalHist);


        // Set TextViews From StatMaps
        // ---------------------------
        mConj1.setText(Integer.toString(statMap.get(CONJNUM1))+PCT);
        mConj2.setText(Integer.toString(statMap.get(CONJNUM2))+PCT);
        mConj3.setText(Integer.toString(statMap.get(CONJNUM3))+PCT);
        mConj4.setText(Integer.toString(statMap.get(CONJNUM4))+PCT);

        mConj1Hist.setText(Integer.toString(statMap.get(CONJNUM1_HIST_PERC))+PCT);
        mConj2Hist.setText(Integer.toString(statMap.get(CONJNUM2_HIST_PERC))+PCT);
        mConj3Hist.setText(Integer.toString(statMap.get(CONJNUM3_HIST_PERC))+PCT);
        mConj4Hist.setText(Integer.toString(statMap.get(CONJNUM4_HIST_PERC))+PCT);

        mPresent.setText(Integer.toString(statMap.get(TENSE_PRESENT))+PCT);
        mImperfect.setText(Integer.toString(statMap.get(TENSE_IMPERFECT))+PCT);
        mFuture.setText(Integer.toString(statMap.get(TENSE_FUTURE))+PCT);
        mPerfect.setText(Integer.toString(statMap.get(TENSE_PERFECT))+PCT);
        mPluperfect.setText(Integer.toString(statMap.get(TENSE_PLUPERFECT))+PCT);
        mFutPerfect.setText(Integer.toString(statMap.get(TENSE_FUTURE_PERFECT))+PCT);

        mPresentHist.setText(Integer.toString(statMap.get(TENSE_PRESENT_HIST))+PCT);
        mImperfectHist.setText(Integer.toString(statMap.get(TENSE_IMPERFECT_HIST))+PCT);
        mFutureHist.setText(Integer.toString(statMap.get(TENSE_FUTURE_HIST))+PCT);
        mPerfectHist.setText(Integer.toString(statMap.get(TENSE_PERFECT_HIST))+PCT);
        mPluperfectHist.setText(Integer.toString(statMap.get(TENSE_PLUPERFECT_HIST))+PCT);
        mFutPerfectHist.setText(Integer.toString(statMap.get(TENSE_FUTURE_PERFECT_HIST))+PCT);

        mIndicative.setText(Integer.toString(statMap.get(MOOD_INDICATIVE))+PCT);
        mSubjunctive.setText(Integer.toString(statMap.get(MOOD_SUBJUNCTIVE))+PCT);
        mImperative.setText(Integer.toString(statMap.get(MOOD_IMPERATIVE))+PCT);

        mIndicativeHist.setText(Integer.toString(statMap.get(MOOD_INDICATIVE_HIST))+PCT);
        mSubjunctiveHist.setText(Integer.toString(statMap.get(MOOD_SUBJUNCTIVE_HIST))+PCT);
        mImperativeHist.setText(Integer.toString(statMap.get(MOOD_IMPERATIVE_HIST))+PCT);

        mActive.setText(Integer.toString(statMap.get(VOICE_ACTIVE))+PCT);
        mPassive.setText(Integer.toString(statMap.get(VOICE_PASSIVE))+PCT);

        mPassiveHist.setText(Integer.toString(statMap.get(VOICE_PASSIVE_HIST))+PCT);
        mPassiveHist.setText(Integer.toString(statMap.get(VOICE_PASSIVE_HIST))+PCT);

        mTotal.setText(Integer.toString(statMap.get(TOTAL))+PCT);
        mTotalHist.setText(Integer.toString(statMap.get(TOTAL_HIST))+PCT);

        return view;
    }

}
