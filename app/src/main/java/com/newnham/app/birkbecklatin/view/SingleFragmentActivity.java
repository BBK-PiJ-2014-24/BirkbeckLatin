package com.newnham.app.birkbecklatin.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.newnham.app.birkbecklatin.R;

/**
 * Abstract Class that Forms the Generic Code To Add a Single Fragment within an Activity.
 *
 * Created by snewnham on 27/12/2016.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected Fragment mFragment;

    // Boiler Plate Code to Add a Fragment to An Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_fragment_holder);


        FragmentManager fm  = getSupportFragmentManager();  // Set Fragment Manager
        mFragment = fm.findFragmentById(R.id.generic_fragment_holder);  // bind mFragment to xml mFragment container (framelayout)

        if (mFragment == null) {     // if mFragment does not exist, Create a new transaction
            mFragment = createFragment();   // ABSTRACT METHOD
            fm.beginTransaction()
                    .add(R.id.generic_fragment_holder, mFragment)  // drop the mFragment into the holder
                    .commit();
        }
    }

    // Abstract Method to Create Different Fragments
    protected abstract Fragment createFragment();

}