package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Preposition - Forms the Latin Preposition and English Translation.
 *
 * Created by snewnham on 07/11/2016.
 */

public class Preposition implements Noun {


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
    String mLatin_Preposition;
    String mEnglishNounSingular;
    String mEnglishNounPlural;


    // Constructor
    // -----------
    public Preposition(int id){
        mId = id;
        mDatabaseAccess = null;
    }

    public Preposition(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
    }


    /**
     * Simply returns the preposition in the Latin_Other attribute of the Noun_list Table
     * @param databaseAccess
     * @param number = null
     * @param Declension = null
     * @return
     */
    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String Declension) {
        mLatinNoun = mLatin_Preposition;
        return mLatin_Preposition;
    }

    @Override
    public String makeEnglishNoun(DatabaseAccess databaseAccess, String number) {

        if(number.equals("Singular")) {
            return mEnglishNounSingular;
        } else {
            return mEnglishNounPlural;
        }
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

    public String getLatin_Preposition() {return mLatin_Preposition;}

    @Override
    public void setLatin_Preposition(String latin_Preposition) { mLatin_Preposition = latin_Preposition;}

    @Override
    public String getLatinNoun() { return mLatinNoun; }

    @Override
    public void setLatinNoun(String latinNoun) { mLatinNoun = latinNoun; }

    @Override
    public String getEnglishNounSingular() {
        return mEnglishNounSingular;
    }

    @Override
    public void setEnglishNounSingular(String englishNounSingular) {
        mEnglishNounSingular = englishNounSingular;
    }

    @Override
    public String getEnglishNounPlural() {
        return mEnglishNounPlural;
    }

    @Override
    public void setEnglishNounPlural(String englishNounPlural) {
        mEnglishNounPlural = englishNounPlural;
    }




}
