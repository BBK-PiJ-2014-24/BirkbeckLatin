package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Adjective Superlative Class - Builds an Adjective Superlative Element. N.b., that gender needs to be set. default = m
 */

public class AdjectiveSuperlative extends Adjective {

    private final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";


    // Fields
    // ------

    private String mLatinSuperlativeEnding;
    private String mLatinSuperlative;




    // Constructor
    // -----------
    public AdjectiveSuperlative(int id){
        super(id);
        mType = ADJECTIVE_SUPERLATIVE;
    }

    public AdjectiveSuperlative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
        mType = ADJECTIVE_SUPERLATIVE;
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
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {

        mGender = gender;  // Set Gender
        mNounCase = noun_Case; // Set noun case
        mType = ADJECTIVE_SUPERLATIVE;

        if(mGender.equals(GENDER_MALE) || mGender.equals(GENDER_NEUTER) ) {
            mLatinSuperlativeEnding = databaseAccess.sqlNounEndingQuery(Integer.toString(DECLENSION2), number, mGender, noun_Case);
        } else if(mGender.equals(GENDER_FEMALE)) {
            mLatinSuperlativeEnding = databaseAccess.sqlNounEndingQuery(Integer.toString(DECLENSION1), number, mGender, noun_Case);
        }
        mLatinSuperlative = mLatinSuperlativeStem + mLatinSuperlativeEnding;
        return mLatinSuperlative;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishSuperlative;
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
