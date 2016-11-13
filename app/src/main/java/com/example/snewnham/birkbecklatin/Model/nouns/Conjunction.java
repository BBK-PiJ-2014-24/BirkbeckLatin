package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Preposition - Forms the Latin Preposition and English Translation.
 *
 * Created by snewnham on 07/11/2016.
 */

public class Conjunction implements NounEtc {

    // Fields
    // ------

    private int mId;
    private DatabaseAccess mDatabaseAccess;
    private String mLatinConjuction;
    private String mEnglishConjunction;


    // Constructor
    // -----------
    public Conjunction(int id){
        mId = id;
    }

    public Conjunction(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
    }


    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String Declension) {
        return mLatinConjuction;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        return mEnglishConjunction;
    }

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
        return "Conjunction";
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public int getDeclension() {
        return 0;
    }

    @Override
    public void setDeclension(int declension) {

    }

    @Override
    public String getGender() {
        return null;
    }

    @Override
    public void setGender(String gender) {

    }

    @Override
    public String getNominative() {
        return null;
    }

    @Override
    public void setNominative(String nominative) {

    }

    @Override
    public String getLatinWordStem() {
        return null;
    }

    @Override
    public void setLatinWordStem(String latinStem) {

    }

    @Override
    public String getLatinWordEnding() {
        return null;
    }

    @Override
    public void setLatinWordEnding(String latinWordEnding) {

    }

    @Override
    public String getLatinWord() {
        return mLatinConjuction;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatinConjuction = latinWord;
    }

    @Override
    public String getEnglishWordSingular() {
        return mEnglishConjunction;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
            mEnglishConjunction = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishConjunction;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishConjunction = englishWordPlural;
    }
}
