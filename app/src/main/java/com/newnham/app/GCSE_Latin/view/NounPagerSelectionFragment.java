package com.newnham.app.GCSE_Latin.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.newnham.app.GCSE_Latin.R;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADJECTIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLNUM1;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLNUM2;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLNUM3;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLNUM4;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.DECLNUM5;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_IRREGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.NOUN_REGULAR;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.PREPOSITION;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounPagerSelectionFragment extends Fragment {


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
    Button mButtonPronouns;




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
        mButtonNoun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM1);
                startActivity(intent);
            }
        });

        mButtonNoun2 = (Button) view.findViewById(R.id.buttonNoun2);
        mButtonNoun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM2);
                startActivity(intent);
            }
        });

        mButtonNoun3 = (Button) view.findViewById(R.id.buttonNoun3);
        mButtonNoun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM3);
                startActivity(intent);
            }
        });

        mButtonNoun4 = (Button) view.findViewById(R.id.buttonNoun4);
        mButtonNoun4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM4);
                startActivity(intent);
            }
        });

        mButtonNoun5 = (Button) view.findViewById(R.id.buttonNoun5);
        mButtonNoun5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_REGULAR, DECLNUM5);
                startActivity(intent);
            }
        });

        mButtonConjunction = (Button) view.findViewById(R.id.buttonConjunction);
        mButtonConjunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), CONJUNCTION, 0);
                startActivity(intent);
            }
        });

        mButtonPreposition = (Button) view.findViewById(R.id.buttonPreposition);
        mButtonPreposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), PREPOSITION, 0);
                startActivity(intent);
            }
        });

        mButtonAdjective = (Button) view.findViewById(R.id.buttonAdjective);
        mButtonAdjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), ADJECTIVE, 0);
                startActivity(intent);
            }
        });

        mButtonAdverb = (Button) view.findViewById(R.id.buttonAdverb);
        mButtonAdverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), ADVERB, 0);
                startActivity(intent);
            }
        });

        mButtonPronouns = (Button) view.findViewById(R.id.buttonPronoun);
        mButtonPronouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NounPagerActivity.newIntent(getActivity(), NOUN_IRREGULAR, 0);
                startActivity(intent);
            }
        });

        return view;
    }

}
