package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class Adverb implements NounEtc {


    // Fields
    // ------
    protected int mId;
    protected DatabaseAccess mDatabaseAccess;
    protected String mGender;
    protected int mDeclension;
    protected String mLatinAdverbStem;
    protected String mLatinAdverb;
    protected String mEnglishAdverb;
    protected String mEnglishAdverbComparative;
    protected String mEnglishAdverbSuperlative;



    // Constructor
    // -----------
    public Adverb(int id){
        mId = id;
        mGender = "m";   // default
    }

    public Adverb(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
        mGender = "m";   // default
    }

    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String Declension) {
        return null;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        return null;
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
        return null;
    }

    @Override
    public void setType(String type) {

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
        return null;
    }

    @Override
    public void setLatinWord(String latinWord) {

    }

    @Override
    public String getEnglishWordSingular() {
        return null;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {

    }

    @Override
    public String getEnglishWordPlural() {
        return null;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {

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
