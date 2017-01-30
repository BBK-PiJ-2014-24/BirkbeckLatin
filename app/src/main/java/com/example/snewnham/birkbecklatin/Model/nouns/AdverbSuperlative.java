package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class AdverbSuperlative extends Adverb {

    // Fields
    // ------
    private final String ADVERB_SUPERLATIVE_ENDING = "issime";
    private final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";



    // Constructor
    // -----------
    public AdverbSuperlative(int id){
        super(id);
        mType = ADVERB_SUPERLATIVE;
    }

    public AdverbSuperlative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
        mType = ADVERB_SUPERLATIVE;
    }

    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {

        mType = ADVERB_SUPERLATIVE;

        mGender = gender;  // Set Gender
        if(mLatinAdverbStem != null) {
            mLatinWordEnding = ADVERB_SUPERLATIVE_ENDING;
            mLatinWord = mLatinAdverbStem + mLatinWordEnding;
        } else {
            mLatinWordEnding = null;
            mLatinWord = null;
        }
        return mLatinWord;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishAdverbSuperlative;
        return mEnglishWord;
    }




}
