package com.newnham.app.GCSE_Latin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.newnham.app.GCSE_Latin.R;

public class NounEndingActivity extends AppCompatActivity {

    // newIntent() - STATIC call of the NounGameActivity's Intent  ( MAIN_ACTIVITY -> )
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, NounEndingActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun_ending);
    }
}
