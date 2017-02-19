package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.R;

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
