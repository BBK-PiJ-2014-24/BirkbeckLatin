package com.example.snewnham.birkbecklatin.Model;

/**
 * VERB is the class for verb. It contains the same data as that held in the database's 'VerbList' table
 * Created by snewnham on 05/10/2016.
 */

public class Verb {

    // Fields
    // ------
    private int mId;
    private String mLatin_Type;
    private int mLatin_ConjNum;
    private String mLatin_Present;
    private String mLatin_Infinitive;
    private String mLatin_Perfect;
    private String mLatin_Participle;
    private String mLatin_Present_Stem;
    private String mLatin_Infinitive_Stem;
    private String mLatin_Infinitive_StemMod;
    private String mLatin_Perfect_Stem;
    private String mLatin_Participle_Stem;
    private String mEnglish_Infinitive;
    private String mEnglish_Present_3rdPerson;
    private String mEnglish_Perfect;
    private String mEnglish_Participle;



    // Constructor
    // -----------
    public Verb(int id) {
        this.mId = id;
    }


    // Getter/Setters
    // --------------

    public int getId() {return mId;}


    public String getLatin_Type() {
        return mLatin_Type;
    }

    public void setLatin_Type(String latin_Type) {
        mLatin_Type = latin_Type;
    }


    public int getLatin_ConjNum() {
        return mLatin_ConjNum;
    }

    public void setLatin_ConjName(int latin_ConjNum) {
        mLatin_ConjNum = latin_ConjNum;
    }


    public String getLatin_Present() {
        return mLatin_Present;
    }

    public void setLatin_Present(String latin_Present) {
        mLatin_Present = latin_Present;
    }


    public String getLatin_Infinitive() {
        return mLatin_Infinitive;
    }

    public void setLatin_Infinitive(String latin_Infinitive) {
        mLatin_Infinitive = latin_Infinitive;
    }


    public String getLatin_Perfect() {
        return mLatin_Perfect;
    }

    public void setLatin_Perfect(String latin_Perfect) {
        mLatin_Perfect = latin_Perfect;
    }


    public String getLatin_Participle() {
        return mLatin_Participle;
    }

    public void setLatin_Participle(String latin_Participle) {
        mLatin_Participle = latin_Participle;
    }


    public String getLatin_Present_Stem() {
        return mLatin_Present_Stem;
    }

    public void setLatin_Present_Stem(String latin_Present_Stem) {
        mLatin_Present_Stem = latin_Present_Stem;
    }


    public String getLatin_Infinitive_Stem() {
        return mLatin_Infinitive_Stem;
    }

    public void setLatin_Infinitive_Stem(String latin_Infinitive_Stem) {
        mLatin_Infinitive_Stem = latin_Infinitive_Stem;
    }


    public String getLatin_Infinitive_StemMod() {
        return mLatin_Infinitive_StemMod;
    }

    public void setLatin_Infinitive_StemMod(String latin_Infinitive_StemMod) {
        mLatin_Infinitive_StemMod = latin_Infinitive_StemMod;
    }


    public String getLatin_Perfect_Stem() {
        return mLatin_Perfect_Stem;
    }

    public void setLatin_Perfect_Stem(String latin_Perfect_Stem) {
        mLatin_Perfect_Stem = latin_Perfect_Stem;
    }


    public String getLatin_Participle_Stem() {
        return mLatin_Participle_Stem;
    }

    public void setLatin_Participle_Stem(String latin_Participle_Stem) {
        mLatin_Participle_Stem = latin_Participle_Stem;
    }


    public String getEnglish_Infinitive() {
        return mEnglish_Infinitive;
    }

    public void setEnglish_Infinitive(String english_Infinitive) {
        mEnglish_Infinitive = english_Infinitive;
    }


    public String getEnglish_Present_3rdPerson() {
        return mEnglish_Present_3rdPerson;
    }

    public void setEnglish_Present_3rdPerson(String english_Present_3rdPerson) {
        mEnglish_Present_3rdPerson = english_Present_3rdPerson;
    }


    public String getEnglish_Perfect() {
        return mEnglish_Perfect;
    }

    public void setEnglish_Perfect(String english_Perfect) {
        mEnglish_Perfect = english_Perfect;
    }


    public String getEnglish_Participle() {
        return mEnglish_Participle;
    }

    public void setEnglish_Participle(String english_Participle) {
        mEnglish_Participle = english_Participle;
    }
}