package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Adjective Class - Builds an Adjective Element. N.b., that gender needs to be set. default = m
 */

public class Adjective extends NounRegular {

    // Constructor
    // -----------
    public Adjective(int id){
        super(id);
        mGender = "m";   // default
    }

    public Adjective(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
        mGender = "m";   // default
    }

    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String latin_case) {

        mLatin_Noun_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, latin_case);
        mLatinNoun = mLatin_Noun_Stem + mLatin_Noun_Ending;
        return mLatinNoun;
    }




}
