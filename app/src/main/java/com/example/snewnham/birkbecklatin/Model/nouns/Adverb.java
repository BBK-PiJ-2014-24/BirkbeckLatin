package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ADVERB;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_MALE;

/**
 * Created by snewnham on 16/11/2016.
 */

public class Adverb implements NounEtc {

    // Constants
    // ---------
    //  protected final static String ADVERB = "Adverb";



    // Fields
    // ------
    protected int mId;
    protected DatabaseAccess mDatabaseAccess;
    protected String mType;
    protected String mGender;
    protected int mDeclension;
    protected String mNounCase;
    protected String mLatinAdverbStem;
    protected String mLatinAdverb;
    protected String mEnglishAdverb;
    protected String mEnglishAdverbComparative;
    protected String mEnglishAdverbSuperlative;

    protected String mLatinWordEnding;
    protected String mLatinWord;
    protected String mEnglishWord;


    // Constructor
    // -----------
    public Adverb(int id){
        mId = id;
        mGender = GENDER_MALE;   // default
        mType = ADVERB;
    }

    public Adverb(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
        mGender = GENDER_MALE;   // default
        mType = ADVERB;
    }

    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {
        mGender = gender;  // Set Gender
        mNounCase = ""; // Set noun case
        mLatinWord = mLatinAdverb;
        return mLatinWord;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishAdverb;
        return mEnglishAdverb;
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
    public String getCase(){ return  mNounCase; }

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
        return mLatinAdverbStem;
    }

    @Override
    public void setLatinWordStem(String latinStem) {
        mLatinAdverbStem = latinStem;
    }

    @Override
    public String getLatinWordEnding() {
        return mLatinWordEnding;
    }

    @Override
    public void setLatinWordEnding(String latinWordEnding) {
        mLatinWordEnding = latinWordEnding;
    }

    @Override
    public String getLatinWord() {
        return mLatinWord;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatinWord = latinWord;
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
        return mEnglishWord;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
        mEnglishWord = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishWord;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishWord = englishWordPlural;
    }


    public String getLatinAdverbStem() {
        return mLatinAdverbStem;
    }

    public void setLatinAdverbStem(String latinAdverbStem) {
        mLatinAdverbStem = latinAdverbStem;
    }

    public String getLatinAdverb() {
        return mLatinAdverb;
    }

    public void setLatinAdverb(String latinAdverb) {
        mLatinAdverb = latinAdverb;
    }

    public String getEnglishAdverb() {
        return mEnglishAdverb;
    }

    public void setEnglishAdverb(String englishAdverb) {
        mEnglishAdverb = englishAdverb;
    }

    public String getEnglishAdverbComparative() {
        return mEnglishAdverbComparative;
    }

    public void setEnglishAdverbComparative(String englishAdverbComparative) {
        mEnglishAdverbComparative = englishAdverbComparative;
    }

    public String getEnglishAdverbSuperlative() {
        return mEnglishAdverbSuperlative;
    }

    public void setEnglishAdverbSuperlative(String englishAdverbSuperlative) {
        mEnglishAdverbSuperlative = englishAdverbSuperlative;
    }

}
