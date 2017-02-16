package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.R;

import java.util.HashMap;
import java.util.Map;



public class VerbStatisticsActivity extends SingleFragmentActivity {


    public final static String STATMAP = "statMap";

    HashMap<String, Integer> hashMap;

    // Override for Abstract Method in SingleFragmentActivity
    // ------------------------------------------------------
    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        hashMap = (HashMap<String, Integer>) intent.getSerializableExtra(STATMAP);
        VerbStatisticsFragment vb = VerbStatisticsFragment.newInstance(hashMap);
        return vb;
        //return VerbStatisticsFragment.newInstance(hashMap);
    }


    // newIntent() - STATIC call of the VerbGameActivity's Intent  ( VerbGameFragment -> VerbStatisticsActivity)
    // -----------
    public static Intent newIntent(Context packageContext, HashMap<String,Integer> map){
        Intent intent = new Intent(packageContext, VerbStatisticsActivity.class);
        intent.putExtra(STATMAP, map);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }



}
