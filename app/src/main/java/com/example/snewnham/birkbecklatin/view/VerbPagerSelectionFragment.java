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

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJNUM1;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJNUM2;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJNUM3;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.CONJNUM4;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbPagerSelectionFragment extends Fragment {

//    private static final int CONJNUM1 = 1;
//    private static final int CONJNUM2 = 2;
//    private static final int CONJNUM3 = 3;
//    private static final int CONJNUM4 = 4;


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
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJNUM1);
                startActivity(intent);
            }
        });

        mButton2 = (Button) view.findViewById(R.id.buttonVerb2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJNUM2);
                startActivity(intent);
            }
        });

        mButton3 = (Button) view.findViewById(R.id.buttonVerb3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJNUM3);
                startActivity(intent);
            }
        });

        mButton4 = (Button) view.findViewById(R.id.buttonVerb4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = VerbPagerActivity.newIntent(getActivity(), CONJNUM4);
                startActivity(intent);
            }
        });


        return view;
    }



}
