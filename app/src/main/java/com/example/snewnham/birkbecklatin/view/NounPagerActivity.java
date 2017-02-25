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
import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.R;

import java.util.List;

public class NounPagerActivity extends AppCompatActivity {



    // Fields
    // ------
    private DatabaseAccess databaseAccess;
    private ViewPager mViewPager;
    private List<NounEtc> mNounEtcList;
    private static final String TYPE = "Type";
    private static final String EXTRA_DECL_NUM = "Decl_Number";


    // STATIC call on the Intent (NounPagerSelectionActivity -> NounPagerActivity)
    // -------------------------
    public static Intent newIntent(Context packageContext, String type, int nounDeclNum){
        Intent intent = new Intent(packageContext, NounPagerActivity.class);
        intent.putExtra(TYPE, type);
        intent.putExtra(EXTRA_DECL_NUM, nounDeclNum);
        return intent;
    }

    // OnCreate
    // --------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun_pager);

        String type =  (String) getIntent().getSerializableExtra(TYPE);  // Pull the Extra TABLE from the Intent
        int declNum =  (int) getIntent().getSerializableExtra(EXTRA_DECL_NUM);  // Pull the Extra from the Intent

        mViewPager = (ViewPager) findViewById(R.id.activity_noun_pager); // wire View Pager to XML
        databaseAccess = DatabaseAccess.getInstance(this);
        mNounEtcList = databaseAccess.getNounDeclensionList(type, declNum); // Gets List of NounEtc Given Type and Decl

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) { // Adapter between ViewPager and frag manager
            @Override                                                          // FM chooses correct Frag
            public Fragment getItem(int position) {
                NounEtc nounEtc = mNounEtcList.get(position);
                return NounPagerFragment.newInstance( nounEtc.getType(), nounEtc.getId() );
            }

            @Override
            public int getCount() {
                return mNounEtcList.size();
            }
        });

    }
}




