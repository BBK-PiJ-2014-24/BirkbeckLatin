package com.example.snewnham.birkbecklatin.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.R;

import java.util.List;
import java.util.UUID;


/**
 * VerbPagerActivity
 * =================
 * A View Pager That Scrolls Verb Principal Parts from Left to Right.
 */
public class VerbPagerActivity extends AppCompatActivity {

    // Fields
    // ------
    private DatabaseAccess databaseAccess;
    private ViewPager mViewPager;
    private List<Verb> mVerbList;
    private static final String EXTRA_CONJ_ID = "com.example.snewnham.criminalintent.crime_id";

    // STATIC call on the Intent
    // -------------------------
    public static Intent newIntent(Context packageContext, int theVerbID){
        Intent intent = new Intent(packageContext, VerbPagerActivity.class);
        intent.putExtra(EXTRA_CONJ_ID, theVerbID);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb_pager);


        int verbConj =  (int) getIntent().getSerializableExtra(EXTRA_CONJ_ID);  // Pull the Extra from the Intent
        // serializable from activity to Fragment


        mViewPager = (ViewPager) findViewById(R.id.activity_verb_pager); // wire View Pager to XML
        databaseAccess = DatabaseAccess.getInstance(this);
        mVerbList = databaseAccess.getVerbList(verbConj);
        int x = 5;

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) { // Adapter between ViewPager and frag manager
            @Override                                                          // FM chooses correct Frag
            public Fragment getItem(int position) {
                Verb verb = mVerbList.get(position);
                return VerbPagerFragment.newInstance(verb.getId());
            }

            @Override
            public int getCount() {
                return mVerbList.size();
            }
        });

    }
}













