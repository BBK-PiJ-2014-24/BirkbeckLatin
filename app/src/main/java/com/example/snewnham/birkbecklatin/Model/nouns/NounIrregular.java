package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 11/11/2016.
 */

/**
 * NounIrregular is for Pronouns, Personal Pronouns, Possessives etc.
 * N.b. that these Irregulars can be both m,f,n genders, which means that the Gender needs to be set
 * that fully completed. Defaut is m.
 */

public class NounIrregular extends NounRegular {

    // CONSTRUCTOR
    // -----------
    public NounIrregular(int id) {
        super(id);
        mGender = "m";  // default
    }

    public NounIrregular(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
        mGender = "m";   // default
    }

    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String declension){

        mLatin_Noun_Stem = null;
        mLatin_Noun_Ending = null;
        mLatinNoun = databaseAccess.sqlNounIrregularQuery(mNominative, mGender, number, declension);

        return mLatinNoun;
    }




}