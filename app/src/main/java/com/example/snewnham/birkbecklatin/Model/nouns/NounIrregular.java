package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_MALE;

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
        mGender = GENDER_MALE;  // default
    }

    public NounIrregular(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
        mGender = GENDER_MALE;   // default
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender){

        mGender = gender;  // Set Gender
        mLatin_Noun_Stem = null;
        mLatin_Noun_Ending = null;
        mNounCase = noun_Case;

        String nounColumnName = mNominative.substring(0,1).toUpperCase()+mNominative.substring(1); // Convert to Upper Case
        mLatinNoun = databaseAccess.sqlNounIrregularQuery(nounColumnName, number, noun_Case, mGender);

        return mLatinNoun;
    }




}
