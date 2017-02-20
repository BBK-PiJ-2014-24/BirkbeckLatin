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
public class NounPagerSelectionFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_noun_pager_selection, container, false);
    }

}
