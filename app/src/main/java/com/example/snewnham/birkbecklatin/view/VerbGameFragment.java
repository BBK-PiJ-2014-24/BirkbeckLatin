package com.example.snewnham.birkbecklatin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snewnham.birkbecklatin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbGameFragment extends Fragment {


    // Constructor
    // -----------
    public VerbGameFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static VerbGameFragment newInstance(){
        return new VerbGameFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verb_game, container, false);



        return view;
    }




}
