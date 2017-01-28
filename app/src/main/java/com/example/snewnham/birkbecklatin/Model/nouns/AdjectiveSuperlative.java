package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Adjective Superlative Class - Builds an Adjective Superlative Element. N.b., that gender needs to be set. default = m
 */

public class AdjectiveSuperlative extends Adjective {

    // Fields
    // ------
    private String mLatinSuperlativeEnding;
    private String mLatinSuperlative;
    private final static String DECLENSION1 = "1";
    private final static String DECLENSION2 = "2";



    // Constructor
    // -----------
    public AdjectiveSuperlative(int id){
        super(id);
    }

    public AdjectiveSuperlative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

    /**
     * makeLatinWord()
     * ---------------
     * Superlative Adjectives
     *
     * Note that we use sqlNounEndingQuery() as we are using the standard 212 Declension Noun Endings
     * @param databaseAccess
     * @param number
     * @param noun_Case
     * @return
     */
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {

        if(mGender.equals("m") || mGender.equals("n") ) {
            mLatinSuperlativeEnding = databaseAccess.sqlNounEndingQuery(DECLENSION2, number, mGender, noun_Case);
        } else if(mGender.equals("f")) {
            mLatinSuperlativeEnding = databaseAccess.sqlNounEndingQuery(DECLENSION1, number, mGender, noun_Case);
        }
        mLatinSuperlative = mLatinSuperlativeStem + mLatinSuperlativeEnding;
        return mLatinSuperlative;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        return mEnglishSuperlative;
    }

    // GETTER/SETTER
    // -------------


    @Override
    public String getLatinWordStem() {
        return mLatinSuperlativeStem;
    }

    @Override
    public void setLatinWordStem(String latinStem) {
        mLatinSuperlativeStem = latinStem;
    }

    @Override
    public String getLatinWordEnding() {
        return mLatinSuperlativeEnding;
    }

    @Override
    public void setLatinWordEnding(String latinWordEnding) {
        mLatinSuperlativeEnding = latinWordEnding;
    }

    @Override
    public String getLatinWord() {
        return mLatinSuperlative;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatinSuperlative = latinWord;
    }

    @Override
    public String getEnglishWordSingular() {
        return mEnglishSuperlative;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
        mEnglishSuperlative = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishSuperlative;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishSuperlative = englishWordPlural;
    }


    public String getLatinSuperlativeEnding() {
        return mLatinSuperlativeEnding;
    }

    public void setLatinSuperlativeEnding(String latinSuperlativeEnding) {
        mLatinSuperlativeEnding = latinSuperlativeEnding;
    }

    public String getLatinSuperlative() {
        return mLatinSuperlative;
    }

    public void setLatinSuperlative(String latinSuperlative) {
        mLatinSuperlative = latinSuperlative;
    }



}
