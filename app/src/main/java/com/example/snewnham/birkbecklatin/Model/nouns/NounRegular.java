package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 05/11/2016.
 */

public class NounRegular implements Noun {

    // Fields
    // ------
    int mid;
    String mType;
    int  mDeclension;
    String mGender;
    String mNominative;
    String mGeninitive;
    String mGeninitive_Plural;
    String mLatin_Noun_Stem;
    String mEnglish_Noun;


    // Constructor
    // -----------
    public NounRegular(int id){

    }

    @Override
    public String makeLatinNoun(DatabaseAccess databaseAccess, String number, String Declension) {
        return null;
    }

    @Override
    public String makeEnglishNoun(DatabaseAccess databaseAccess) {
        return null;
    }



    // Getter/Setters
    // --------------
    @Override
    public int getId() {
        return mid;
    }

    @Override
    public void setId(int id) {
        mid = id;
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
    public void setNominative(String nominative) {
        mNominative = nominative;
    }

    @Override
    public String getGenitive() {
        return mGeninitive;
    }

    @Override
    public void setGenitive(String genitive) {
        mGeninitive = genitive;
    }

    @Override
    public String getGenitivePlural() {
        return mGeninitive_Plural;
    }

    @Override
    public void setGenitivePlural(String genitivePlural) {
        mGeninitive_Plural = genitivePlural;
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
    public String getEnglishNoun() {
        return mEnglish_Noun;
    }

    @Override
    public void setEnglishNoun(String englishNoun) {
        mEnglish_Noun = englishNoun;
    }
}
