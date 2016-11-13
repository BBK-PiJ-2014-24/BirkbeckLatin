package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Adjective Class - Builds an Adjective Element. N.b., that gender needs to be set. default = m
 */

public class Adjective implements NounEtc {

    // Fields
    // ------

    DatabaseAccess mDatabaseAccess;
    int mId;
    String mType;
    int mDeclension;
    String mNominative;
    String mNominative_Neuter;
    String mLatinAdjectiveStem;
    String mEnglishAdjective;
    String mLatinComparative;
    String mEnglishComparative;
    String mLatinSuperlative;
    String mEnglishSuperlative;

    String mGender;
    String mLatin_Adjective_Ending;
    String mLatinAdjective;






    // Constructor
    // -----------
    public Adjective(int id){
        mGender = "m";   // default
    }

    public Adjective(int id, DatabaseAccess databaseAccess){
        mDatabaseAccess = databaseAccess;
        mGender = "m";   // default
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String latin_case) {

        if(mDeclension == 333) { // M or F 333
            if(mGender.equals("m") || mGender.equals("f")) {
                if (latin_case.equals("Nominative") && number.equals("Singular")) {  // Adjective 333 Nominatives can be Irregular
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative;
                } else if (latin_case.equals("Vocative") && number.equals("Singular")) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative;
                } else {
                    mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, latin_case);
                    mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
                }
            } else { // Neuter 333
                if (latin_case.equals("Nominative") && number.equals("Singular")) {  // Adjective 333 Nominatives can be Irregular
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else if (latin_case.equals("Accusative") && number.equals("Singular")) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else if (latin_case.equals("Vocative") && number.equals("Singular")) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else {
                    mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, latin_case);
                    mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
                }
            }
        } else { // 212
            if(latin_case.equals("Nominative") && number.equals("Singular") && mGender.equals("m")){
                int stemLength = mLatinAdjectiveStem.length();
                mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                mLatinAdjective = mNominative;
            } else {
                mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, latin_case);
                mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
            }
        }

        return mLatinAdjective;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        return mEnglishAdjective;
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
    public void setType(String type) {
        mType = type;
    }


    public int getDeclension() {
        return mDeclension;
    }

    public void setDeclension(int declension) {
        mDeclension = declension;
    }


    public String getNominative() {
        return mNominative;
    }


    public void setNominative(String nominative) {
        mNominative = nominative;
    }

    @Override
    public String getLatinWordStem() {
        return mLatinAdjectiveStem;
    }

    @Override
    public void setLatinWordStem(String latinStem) {
        mLatinAdjectiveStem = latinStem;
    }

    @Override
    public String getLatinWordEnding() {
        return mLatin_Adjective_Ending;
    }

    @Override
    public void setLatinWordEnding(String latinWordEnding) {
        mLatin_Adjective_Ending = latinWordEnding;
    }

    @Override
    public String getLatinWord() {
        return mLatinAdjective;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatinAdjective = latinWord;
    }

    @Override
    public String getEnglishWordSingular() {
        return mEnglishAdjective;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
        mEnglishAdjective = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishAdjective;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishAdjective = englishWordPlural;
    }

    public String getNominative_Neuter() {
        return mNominative_Neuter;
    }

    public void setNominative_Neuter(String nominative_Neuter) {
        mNominative_Neuter = nominative_Neuter;
    }

    public String getLatinAdjectiveStem() {
        return mLatinAdjectiveStem;
    }

    public void setLatinAdjectiveStem(String latinAdjectiveStem) {
        mLatinAdjectiveStem = latinAdjectiveStem;
    }

    public String getEnglishAdjective() {
        return mEnglishAdjective;
    }

    public void setEnglishAdjective(String englishAdjective) {
        mEnglishAdjective = englishAdjective;
    }

    public String getLatinComparative() {
        return mLatinComparative;
    }

    public void setLatinComparative(String latinComparative) {
        mLatinComparative = latinComparative;
    }

    public String getEnglishComparative() {
        return mEnglishComparative;
    }

    public void setEnglishComparative(String englishComparative) {
        mEnglishComparative = englishComparative;
    }

    public String getLatinSuperlative() {
        return mLatinSuperlative;
    }

    public void setLatinSuperlative(String latinSuperlative) {
        mLatinSuperlative = latinSuperlative;
    }

    public String getEnglishSuperlative() {
        return mEnglishSuperlative;
    }

    public void setEnglishSuperlative(String englishSuperlative) {
        mEnglishSuperlative = englishSuperlative;
    }

    @Override
    public String getGender() {
        return mGender;
    }

    @Override
    public void setGender(String gender) {
        mGender = gender;
    }


}
