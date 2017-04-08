package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.R;

public class NounGameActivity extends SingleFragmentActivity {


    // newIntent() - STATIC call of the NounGameActivity's Intent  ( MAIN_ACTIVITY -> )
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, NounGameActivity.class);
        return intent;
    }

    // Override for Abstract Method in SingleFragmentActivity
    // ------------------------------------------------------
    @Override
    protected Fragment createFragment() {
        return NounGameFragment.newInstance();
    }


    // OnCreate
    // --------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_noun_game);
        setContentView(R.layout.generic_fragment_holder);
    }

}
