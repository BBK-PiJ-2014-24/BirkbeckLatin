package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class AdverbSuperlative extends Adverb {

    // Fields
    // ------
    private final String ADVERB_SUPERLATIVE_ENDING = "issime";

    // Constructor
    // -----------
    public AdverbSuperlative(int id){
        super(id);
    }

    public AdverbSuperlative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String Declension) {
        mLatinWordEnding = ADVERB_SUPERLATIVE_ENDING;
        mLatinWord = mLatinAdverbStem + mLatinWordEnding;
        return mLatinWord;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishAdverbSuperlative;
        return mEnglishWord;
    }




}
