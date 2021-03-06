package com.newnham.app.GCSE_Latin.Model.nouns;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.*;

/**
 * Created by snewnham on 05/11/2016.
 */

public class NounRegular implements NounEtc {


    // Fields
    // ------
    protected DatabaseAccess mDatabaseAccess;
    protected int mId;
    protected String mType;
    protected int mDeclension;
    protected String mNounCase;
    protected String mGender;
    protected String mNominative;
    protected String mGenitive;
    protected String mGenitive_Plural;
    protected String mLatin_Noun_Stem;
    protected String mLatin_Noun_Ending;
    protected String mLatinNoun;
    protected String mEnglishWord;
    protected String mEnglishNounSingular;
    protected String mEnglishNounPlural;


    // Constructor
    // -----------
    public NounRegular(int id){
        mId = id;
        mDatabaseAccess = null;
    }

    public NounRegular(int id, DatabaseAccess databaseAccess){
        mId = id;
        mDatabaseAccess = databaseAccess;
    }


    /**
     * makeLatinWord()
     * ---------------
     * sql query for making the Latin NounEtc From the stem and ending, given the case, number and declension
     * @param databaseAccess
     * @param number
     * @param noun_Case
     * @return
     */
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {

        mNounCase = noun_Case; // Set Noun Case

        // Check if Noun only has a Plural (e.g. troops)
        if(mEnglishNounSingular == null){
            number = NUMBER_PLURAL;
        }
        // Check if Noun only has a Single (e.g. Jupiter)
        if(mEnglishNounPlural == null){
            number = NUMBER_SINGULAR;
        }

        // Check Genders Are Congruent with Declension
        if(mDeclension == DECLENSION1)
            mGender = GENDER_FEMALE; // Ensure All 1st Declensions are FEMALE
        else if(mDeclension == DECLENSION2 && mGender.equals(GENDER_FEMALE))
            mGender = GENDER_MALE;
        else if(mDeclension == DECLENSION4 && !mGender.equals(GENDER_FEMALE))
            mGender = GENDER_FEMALE;
        else if(mDeclension == DECLENSION5 && mGender.equals(GENDER_NEUTER))
            mGender = GENDER_MALE;


        // Override for 2nd Declension Nominative and Singular
        if( mDeclension == DECLENSION2 && noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR) ) {
                mLatin_Noun_Ending = databaseAccess.sqlNounEndingQuery( Integer.toString(mDeclension), number, mGender, noun_Case);;
                mLatinNoun = mNominative;
                return mLatinNoun;
            } else if( mDeclension == CONJNUM3 || mDeclension == CONJNUM31 ) { // Override for 3rd Declension Nominative and Singular (Singular) && Genitive Plural

                if( (noun_Case.equals(NOMINATIVE) || noun_Case.equals(VOCATIVE)) && number.equals(SINGULAR) ) {
                    mLatin_Noun_Ending = "";  // Endings are too irregular
                    mLatinNoun = mNominative;
                    return mLatinNoun;
                } else if( noun_Case.equals(ACCUSATIVE) && mGender.equals(GENDER_NEUTER) && number.equals(SINGULAR) ){
                    mLatin_Noun_Ending = "";  // Endings are too irregular
                    mLatinNoun = mNominative;
                    return mLatinNoun;
                } else if (noun_Case.equals(GENITIVE) && number.equals(PLURAL) && mGenitive_Plural != null) {
                    mLatin_Noun_Ending = "";   // Endings are too irregular
                    mLatinNoun = mGenitive_Plural;
                    return mLatinNoun;
                }
            }

            mLatin_Noun_Ending = databaseAccess.sqlNounEndingQuery( Integer.toString(mDeclension), number, mGender, noun_Case);
            mLatinNoun = mLatin_Noun_Stem + mLatin_Noun_Ending;
            return mLatinNoun;
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {
        return makeLatinWord(databaseAccess,number, noun_Case);
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {

        // Check if Noun only has a Plural (e.g. troops)
        if(mEnglishNounSingular == null){
            number = NUMBER_PLURAL;
        }
        // Check if Noun only has a Single (e.g. Jupiter)
        if(mEnglishNounPlural == null){
            number = NUMBER_SINGULAR;
        }


        if(number.equals(SINGULAR)){
            mEnglishWord = mEnglishNounSingular;
        } else {
            mEnglishWord = mEnglishNounPlural;
        }

        return mEnglishWord;
    }



    // Getter/Setters
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

    @Override
    public int getDeclension() {
        return mDeclension;
    }

    @Override
    public String getCase(){ return mNounCase;}

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
    public void setNominative(String nominative) { mNominative = nominative; }


    public String getGenitive() {
        return mGenitive;
    }


    public void setGenitive(String genitive) {
        mGenitive = genitive;
    }


    public String getGenitivePlural() {
        return mGenitive_Plural;
    }


    public void setGenitivePlural(String genitivePlural) {
        mGenitive_Plural = genitivePlural;
    }

    @Override
    public String getLatinWordStem() {
        return mLatin_Noun_Stem;
    }

    @Override
    public void setLatinWordStem(String latinNounStem) {
        mLatin_Noun_Stem = latinNounStem;
    }

    @Override
    public String getLatinWordEnding() { return mLatin_Noun_Ending; }

    @Override
    public void setLatinWordEnding(String latinNounEnding) { mLatin_Noun_Ending = latinNounEnding; }


    @Override
    public String getLatinWord() { return mLatinNoun; }

    @Override
    public void setLatinWord(String latinNoun) { mLatinNoun = latinNoun; }

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
        return mEnglishNounSingular;
    }

    @Override
    public void setEnglishWordSingular(String englishNounSingular) {
        mEnglishNounSingular = englishNounSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishNounPlural;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishNounPlural = englishWordPlural;
    }

}
