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

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbPagerSelectionFragment extends Fragment {

    private static final int CONJ1 = 1;
    private static final int CONJ2 = 2;
    private static final int CONJ3 = 3;
    private static final int CONJ4 = 4;


    // Fields
    // ------
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;


    // Constructor
    // -----------
    public VerbPagerSelectionFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static VerbPagerSelectionFragment newInstance() {
        return new VerbPagerSelectionFragment();
    }

    // onCreate()
    // ----------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // onCreateView()
    // --------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verb_pager_selection, container, false);

        mButton1 = (Button) view.findViewById(R.id.buttonVerb1);
        Activity activity = getActivity();
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJ1);
                startActivity(intent);
            }
        });

        mButton2 = (Button) view.findViewById(R.id.buttonVerb2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJ2);
                startActivity(intent);
            }
        });

        mButton3 = (Button) view.findViewById(R.id.buttonVerb3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJ3);
                startActivity(intent);
            }
        });

        mButton4 = (Button) view.findViewById(R.id.buttonVerb4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJ4);
                startActivity(intent);
            }
        });


        return view;
    }



}
