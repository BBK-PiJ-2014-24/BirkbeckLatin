package com.example.snewnham.birkbecklatin.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.snewnham.birkbecklatin.R;

/**
 * Abstract Class that Forms the Generic Code To Add a Single Fragment within an Activity.
 *
 * Created by snewnham on 27/12/2016.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();  // subclasses will create diff fragments


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_fragment_holder);


        FragmentManager fm  = getSupportFragmentManager();  // Set Fragment Manager
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);  // bind fragment to xml fragment container (framelayout)

        if (fragment == null) {     // if fragment does not exist, Create a new transaction
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}