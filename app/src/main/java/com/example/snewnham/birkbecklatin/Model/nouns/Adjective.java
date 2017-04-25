package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

import static com.example.snewnham.birkbecklatin.Model.LatinConstants.ACCUSATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.DECLENSION333;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_FEMALE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.GENDER_MALE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NOMINATIVE;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.NUMBER_PLURAL;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.SINGULAR;
import static com.example.snewnham.birkbecklatin.Model.LatinConstants.VOCATIVE;

/**
 * Adjective Class - Builds an Adjective Element. N.b., that gender needs to be set. default = m
 */

public class Adjective implements NounEtc {

    // Fields
    // ------
    protected DatabaseAccess mDatabaseAccess;
    protected int mId;
    protected String mType;
    protected int mDeclension;
    protected String mNounCase;
    protected String mNominative;
    protected String mNominative_Neuter;
    protected String mLatinAdjectiveStem;
    protected String mEnglishWord;
    protected String mEnglishAdjective;
    protected String mLatinComparativeStem;
    protected String mEnglishComparative;
    protected String mLatinSuperlativeStem;
    protected String mEnglishSuperlative;

    protected String mGender;
    protected String mLatin_Adjective_Ending;
    protected String mLatinAdjective;


    // Constructor
    // -----------
    public Adjective(int id){
        mId = id;
        mGender = GENDER_MALE;   // default
    }

    public Adjective(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
        mGender = GENDER_MALE;   // default
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {

        int wordLength = mNominative.length();
        if( mDeclension == 0){
            mLatinAdjective = mNominative;
            return mNominative;
        }
        // Check if only Plural meaning
        if( mDeclension == 212 && mNominative.charAt(wordLength - 1) == 'i')
            number = NUMBER_PLURAL;
        if( mDeclension == 333 && mNominative.substring(wordLength - 2).equals("es"))
            number = NUMBER_PLURAL;

        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {

        mGender = gender;  // Set Gender
        mNounCase = noun_Case; // noun Case
        int wordLength = mNominative.length();

        if( mDeclension == 0){
            mLatinAdjective = mNominative;
            return mNominative;
        }

        if(mDeclension == DECLENSION333) { // M or F 333
            // Check if only Plural meaning
            if( mNominative.substring(wordLength - 2).equals("es"))
                number = NUMBER_PLURAL;
            if(mGender.equals(GENDER_MALE) || mGender.equals(GENDER_FEMALE)) {
                if (noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR)) {  // Adjective 333 Nominatives can be Irregular
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative;
                } else if (noun_Case.equals(VOCATIVE) && number.equals(SINGULAR)) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative;
                } else {
                    mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, noun_Case);
                    mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
                }
            } else { // Neuter 333
                if (noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR)) {  // Adjective 333 Nominatives can be Irregular
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else if (noun_Case.equals(ACCUSATIVE) && number.equals(SINGULAR)) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else if (noun_Case.equals(VOCATIVE) && number.equals(SINGULAR)) {
                    int stemLength = mLatinAdjectiveStem.length();
                    mLatin_Adjective_Ending = mNominative_Neuter.substring(stemLength);  // Calc ending
                    mLatinAdjective = mNominative_Neuter;
                } else {
                    mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, noun_Case);
                    mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
                }
            }
        } else { // 212
            if( mNominative.charAt(wordLength - 1) == 'i')
                number = NUMBER_PLURAL;
            if(noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR) && mGender.equals(GENDER_MALE)){
                int stemLength = mLatinAdjectiveStem.length();
                mLatin_Adjective_Ending = mNominative.substring(stemLength);  // Calc ending
                mLatinAdjective = mNominative;
            } else {
                DatabaseAccess da = databaseAccess;
                mLatin_Adjective_Ending = databaseAccess.sqlAdjectiveEnding(Integer.toString(mDeclension), mGender, number, noun_Case);
                mLatinAdjective = mLatinAdjectiveStem + mLatin_Adjective_Ending;
            }
        }
        return mLatinAdjective;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishAdjective;
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

    @Override
    public String getCase(){return mNounCase;}

    public void setDeclension(int declension) {
        mDeclension = declension;
    }


    public String getNominative() {
        return mNominative;
    }


    public void setNominative(String nominative) {
        mNominative = nominative;
    }

    public String getGenitive(){
        return "";   // Obtain Genitive Through Make Word
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
    public String getEnglishWord() {
        return mEnglishWord;
    }
    @Override
    public void setEnglishWord(String englishWord) {
        mEnglishWord = englishWord;
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

    public String getLatinComparativeStem() {
        return mLatinComparativeStem;
    }

    public void setLatinComparativeStem(String latinComparativeStem) {
        mLatinComparativeStem = latinComparativeStem;
    }

    public String getEnglishComparative() {
        return mEnglishComparative;
    }

    public void setEnglishComparative(String englishComparative) {
        mEnglishComparative = englishComparative;
    }

    public String getLatinSuperlativeStem() {
        return mLatinSuperlativeStem;
    }

    public void setLatinSuperlativeStem(String latinSuperlativeStem) {
        mLatinSuperlativeStem = latinSuperlativeStem;
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
