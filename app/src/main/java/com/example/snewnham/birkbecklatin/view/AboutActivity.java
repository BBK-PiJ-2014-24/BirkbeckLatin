package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.R;

public class AboutActivity extends AppCompatActivity {

    // newIntent() - STATIC call of the AboutActivity's Intent  ( MAIN_ACTIVITY -> )
    // -----------
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, AboutActivity.class);
        return intent;
    }


    // onCreate()
    // ----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    // onBackPressed()
    //----------------
    @Override
    public void onBackPressed() {
        this.startActivity(new Intent(this, MainActivity.class));
    }
}
