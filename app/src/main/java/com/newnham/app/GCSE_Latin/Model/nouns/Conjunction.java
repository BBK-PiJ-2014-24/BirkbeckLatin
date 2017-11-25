package com.newnham.app.GCSE_Latin.Model.nouns;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.CONJUNCTION;

/**
 * Preposition - Forms the Latin Preposition and English Translation.
 *
 * Created by snewnham on 07/11/2016.
 */

public class Conjunction implements NounEtc {

    // Constant
    // --------
    // protected final static String CONJUNCTION = "Conjunction";


    // Fields
    // ------

    private int mId;
    private DatabaseAccess mDatabaseAccess;
    private String mType;
    private String mNounCase;
    private String mLatinConjuction;
    private String mEnglishWord;
    private String mEnglishConjunction;



    // Constructor
    // -----------
    public Conjunction(int id){
        mId = id;
        mType = CONJUNCTION;
        mNounCase = "";
    }

    public Conjunction(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
        mType = CONJUNCTION;
        mNounCase = "";
    }


    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return mLatinConjuction;
    }
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {
        return mLatinConjuction;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishConjunction;
        return mEnglishConjunction;
    }

    // GETTER/SETTERS
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
    public void setType(String type) {}

    @Override
    public int getDeclension() {
        return 0;
    }

    @Override
    public void setDeclension(int declension) {
    }

    @Override
    public String getCase(){ return mNounCase;}

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
    public void setNominative(String nominative) {}

    @Override
    public String getGenitive(){
        return null;
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
    public String getEnglishWord() {
        return mEnglishWord;
    }
    @Override
    public void setEnglishWord(String englishWord) {
        mEnglishWord = englishWord;
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
