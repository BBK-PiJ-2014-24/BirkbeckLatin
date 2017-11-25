package com.newnham.app.GCSE_Latin.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newnham.app.GCSE_Latin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounEndingMenuFragment extends Fragment {


    // newInstance - Static Call for instantiation
    // -----------
    public static NounEndingMenuFragment newInstance(){
        NounEndingMenuFragment fragment = new NounEndingMenuFragment();
        return fragment;
    }

    // Constructor
    // -----------
    public NounEndingMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noun_ending_menu, container, false);
        return view;
    }

}
