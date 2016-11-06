package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 05/11/2016.
 */

public class NounRegular implements Noun {

    // Fields
    // ------
    DatabaseAccess mDatabaseAccess;
    int mId;
    String mType;
    int mDeclension;
    String mGender;
    String mNominative;
    String mGenitive;
    String mGenitive_Plural;
    String mLatin_Noun_Stem;
    String mLatin_Noun_Ending;
    String mLatinNoun;
    String mEnglishNoun;


    // Constructor
    // -----------
    public NounRegular(int id){
        mId = id;
        mDatabaseAccess = null;
    }

    public NounRegular(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
    }


    /**
     * makeLatinNoun()
     * ---------------
     * sql query for making the Latin Noun From the stem and ending, given the case, number and declension
     * @param databaseAccess
     * @param number
     * @param declension
     * @return
     */
    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String declension) {

        if( mType.equals("Noun") ){
            mLatin_Noun_Ending = databaseAccess.sqlNounEndingQuery( Integer.toString(mDeclension), number, mGender, declension );
        } else {
            mLatin_Noun_Ending = "";
        }

        mLatinNoun = mLatin_Noun_Stem + mLatin_Noun_Ending;

        return mLatin_Noun_Stem;
    }

    @Override
    public String makeEnglishNoun(DatabaseAccess databaseAccess) {
        return mEnglishNoun;
    }



    // Getter/Setters
    // --------------
    @Override
    public int getId() {
        return mId;
    }

    @Override
    public void setId(int id) {
        mId = id;
    }

    @Override
    public String getType() {
        return mType;
    }

    @Override
    public void setType(String type) {
        mType = type;
    }

    @Override
    public int getDeclension() {
        return mDeclension;
    }

    @Override
    public void setDeclension(int declension) {
        mDeclension = declension;
    }

    @Override
    public String getGender() {
        return mGender;
    }

    @Override
    public void setGender(String gender) {
        mGender = gender;
    }

    @Override
    public String getNominative() {
        return mNominative;
    }

    @Override
    public void setNominative(String nominative) { mNominative = nominative; }

    @Override
    public String getGenitive() {
        return mGenitive;
    }

    @Override
    public void setGenitive(String genitive) {
        mGenitive = genitive;
    }

    @Override
    public String getGenitivePlural() {
        return mGenitive_Plural;
    }

    @Override
    public void setGenitivePlural(String genitivePlural) {
        mGenitive_Plural = genitivePlural;
    }

    @Override
    public String getLatinNounStem() {
        return mLatin_Noun_Stem;
    }

    @Override
    public void setLatinNounStem(String latinNounStem) {
        mLatin_Noun_Stem = latinNounStem;
    }

    @Override
    public String getLatinNounEnding() { return mLatin_Noun_Ending; }

    @Override
    public void setLatinNounEnding(String latinNounEnding) { mLatin_Noun_Ending = latinNounEnding; }

    @Override
    public String getEnglishNoun() {
        return mEnglishNoun;
    }

    @Override
    public void setEnglishNoun(String englishNoun) {
        mEnglishNoun = englishNoun;
    }


    @Override
    public String getLatinNoun() { return mLatinNoun; }

    @Override
    public void setLatinNoun(String latinNoun) { mLatinNoun = latinNoun; }



}
