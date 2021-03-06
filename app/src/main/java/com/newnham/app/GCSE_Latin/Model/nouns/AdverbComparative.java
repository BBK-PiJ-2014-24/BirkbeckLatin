package com.newnham.app.GCSE_Latin.Model.nouns;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.ADVERB_COMPARATIVE;

/**
 * Created by snewnham on 16/11/2016.
 */

public class AdverbComparative extends Adverb {

    // Constants
    // ----------
    private final String ADVERB_COMPARATIVE_ENDING = "ius";
    // private final static String ADVERB_COMPARATIVE = "AdverbComparative";


    // Constructor
    // -----------
    public AdverbComparative(int id){
        super(id);
        mType = ADVERB_COMPARATIVE;
        mEnglishWord = mEnglishAdverbComparative;
        mNounCase = "";
    }

    public AdverbComparative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
        mType = ADVERB_COMPARATIVE;
        mEnglishWord = mEnglishAdverbComparative;
        mNounCase = "";
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
        mType = ADVERB_COMPARATIVE;

        if(mLatinAdverbStem != null) {
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
