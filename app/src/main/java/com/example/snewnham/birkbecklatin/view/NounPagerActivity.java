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
    private static final String EXTRA_DECL_NUM = "Decl_Number";
    private static final String TABLE = "table";

    // STATIC call on the Intent (NounPagerSelectionActivity -> NounPagerActivity)
    // -------------------------
    public static Intent newIntent(Context packageContext, String table, int nounDeclNum){
        Intent intent = new Intent(packageContext, NounPagerActivity.class);
        intent.putExtra(TABLE, table);
        intent.putExtra(EXTRA_DECL_NUM, nounDeclNum);
        return intent;
    }

    // OnCreate
    // --------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun_pager);

        String table =  (String) getIntent().getSerializableExtra(TABLE);  // Pull the Extra TABLE from the Intent
        int declNum =  (int) getIntent().getSerializableExtra(EXTRA_DECL_NUM);  // Pull the Extra from the Intent

        mViewPager = (ViewPager) findViewById(R.id.activity_noun_pager); // wire View Pager to XML
        databaseAccess = DatabaseAccess.getInstance(this);
       //+++++++++ mNounEtcList = databaseAccess.getVerbConjugationList(verbConj);
        int x = 5;

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




