package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.R;

public class VerbGameActivity extends SingleFragmentActivity {

    // newIntent() - STATIC call of the VerbGameActivity's Intent  ( MAIN_ACTIVITY -> )
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, VerbGameActivity.class);
        return intent;
    }

    // Override for Abstract Method in SingleFragmentActivity
    // ------------------------------------------------------
    @Override
    protected Fragment createFragment() {
        return VerbGameFragment.newInstance();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   // Call the SUPER SingleFragmentActivity

        setContentView(R.layout.generic_fragment_holder);
    }





}
