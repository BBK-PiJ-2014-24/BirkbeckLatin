package com.newnham.app.GCSE_Latin.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.newnham.app.GCSE_Latin.R;

public class NounPagerSelectionActivity extends SingleFragmentActivity {


    // newIntent() - STATIC call of the VerbPagerSelectionActivity Intent  ( MAIN_ACTIVITY ->  NounPagerSelectionActivity)
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, NounPagerSelectionActivity.class);
        return intent;
    }


    // Override for Abstract Method in SingleFragmentActivity
    // ------------------------------------------------------
    @Override
    protected NounPagerSelectionFragment createFragment() {
        return NounPagerSelectionFragment.newInstance();
    }

    // onCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_fragment_holder);
    }
}
