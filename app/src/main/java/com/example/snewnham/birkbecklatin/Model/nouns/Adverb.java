package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class Adverb implements NounEtc {

    // Fields
    // ------
    protected int mId;
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


}
