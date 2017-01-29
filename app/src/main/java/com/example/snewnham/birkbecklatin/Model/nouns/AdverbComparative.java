package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class AdverbComparative extends Adverb {

    // Fields
    // ------
    private final String ADVERB_COMPARATIVE_ENDING = "ius";

    // Constructor
    // -----------
    public AdverbComparative(int id){
        super(id);
    }

    public AdverbComparative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

    // GETTER/SETTERS
    // --------------
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {

        mGender = gender;  // Set Gender

        if(mDeclension != 0) {
            mLatinWordEnding = ADVERB_COMPARATIVE_ENDING;
            mLatinWord = mLatinAdverbStem + mLatinWordEnding;
        } else {
            mLatinWordEnding = null;
            mLatinWord = null;
        }
        return mLatinWord;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishAdverbComparative;
        return mEnglishWord;
    }


}
