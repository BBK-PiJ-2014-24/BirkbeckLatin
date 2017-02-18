package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Preposition - Forms the Latin Preposition and English Translation.
 *
 * Created by snewnham on 07/11/2016.
 */

public class Preposition implements NounEtc {



    // Fields
    // ------
    private DatabaseAccess mDatabaseAccess;
    private int mId;
    private String mType;
    private String mLatin_Preposition;
    private String mEnglish_Preposition;
    private String mEnglishWord;
    private String mNounCase;


    protected final static String PREPOSITION= "Preposition";



    // Constructor
    // -----------
    public Preposition(int id){
        mId = id;
        mDatabaseAccess = null;
        mType = PREPOSITION;
        mNounCase = NOMINATIVE;
    }

    public Preposition(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
        mType = PREPOSITION;
        mNounCase = NOMINATIVE;
    }


    /**
     * Simply returns the preposition in the Latin_Other attribute of the Noun_list Table
     * @param databaseAccess
     * @param number = null
     * @param noun_Case = null
     * @return
     */

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return mLatin_Preposition;
    }
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender ) {
        return mLatin_Preposition;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglish_Preposition;
        return mEnglish_Preposition;
    }


    // GETTER/SETTERS
    // --------------
    @Override
    public int getId() {
        return mId;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getType() {
        return mType;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public int getDeclension() {
        return 0;
    }

    @Override
    public void setDeclension(int declension) {}

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
        return mLatin_Preposition;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatin_Preposition = latinWord;
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
        return mEnglish_Preposition;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
        mEnglish_Preposition = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglish_Preposition;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglish_Preposition = englishWordPlural;
    }


}
