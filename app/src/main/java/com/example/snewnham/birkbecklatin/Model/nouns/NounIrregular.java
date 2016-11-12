package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 11/11/2016.
 */



public class NounIrregular extends NounRegular {

    // CONSTRUCTOR
    // -----------
    public NounIrregular(int id) {
        super(id);
        mGender = "m";
    }

    public NounIrregular(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
        mGender = "m";
    }

    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String declension){

        String nounIrregular = mNominative.substring(0,1).toUpperCase() + mNominative.substring(1); // make First Letter Upper Case.
        mLatinNoun = databaseAccess.sqlLatinIrregularNoun(nounIrregular, mGender, number, declension);

        return mLatinNoun;
    }



}
