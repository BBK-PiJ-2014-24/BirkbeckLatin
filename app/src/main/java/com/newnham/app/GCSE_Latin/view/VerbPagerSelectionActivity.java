package com.newnham.app.GCSE_Latin.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.newnham.app.GCSE_Latin.R;

public class VerbPagerSelectionActivity extends SingleFragmentActivity {


    // newIntent() - STATIC call of the VerbPagerSelectionActivity Intent  ( MAIN_ACTIVITY ->  VerbPagerSelectionActivity)
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, VerbPagerSelectionActivity.class);
        return intent;
    }


    // Override for Abstract Method in SingleFragmentActivity
    // ------------------------------------------------------
    @Override
    protected VerbPagerSelectionFragment createFragment() {
        return VerbPagerSelectionFragment.newInstance();
    }

    // onCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_fragment_holder);
    }

}
