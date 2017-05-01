package com.newnham.app.birkbecklatin.Model.nouns;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;

import static com.newnham.app.birkbecklatin.Model.LatinConstants.ACCUSATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.ADJECTIVE_COMPARATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.DECLENSION3;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.GENDER_FEMALE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.GENDER_MALE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NOMINATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.SINGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOCATIVE;

/**
 * Adjective Comparative - Builds an Comparative Element. N.b., that gender needs to be set. default = m
 */

public class AdjectiveComparative extends Adjective {


    // Constants
    // ---------
    private final static String NEUTER_INFIX = "ius";
    //private final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";


    // Fields
    // ------
    private String mLatinComparativeEnding;
    private String mLatinComparative;


    // Constructor
    // -----------
    public AdjectiveComparative(int id){
        super(id);
        mType = ADJECTIVE_COMPARATIVE;
    }

    public AdjectiveComparative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
        mType = ADJECTIVE_COMPARATIVE;
    }

    /**
     * makeLatinWord()
     * ---------------
     * Comparative Adjectives add -ior- to Adjective Stem, except for Neuter which uses
     * -ius- for Nom, Acc and Voc.
     * Note that we use sqlNounEndingQuery() as we are using the standard 3rd Declension Noun Endings
     * @param databaseAccess
     * @param number
     * @param noun_Case
     * @return
     */

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case) {
        return makeLatinWord(databaseAccess, number, noun_Case, mGender);
    }

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender) {

        mGender = gender;  // Set Gender
        mNounCase = noun_Case; // Set noun case
        mType = ADJECTIVE_COMPARATIVE;

        if(mGender.equals(GENDER_MALE) || mGender.equals(GENDER_FEMALE)) {
            if (noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR)) {
                mLatinComparativeEnding = null;  // Set to Null
                mLatinComparative = mLatinComparativeStem;
            } else if (noun_Case.equals(VOCATIVE) && number.equals(SINGULAR)) {
                mLatinComparativeEnding = null;  // Calc ending
                mLatinComparative = mLatinComparativeStem;
            } else {
                mLatinComparativeEnding = databaseAccess.sqlNounEndingQuery(Integer.toString(DECLENSION3), number, mGender, noun_Case);
                mLatinComparative = mLatinComparativeStem + mLatinComparativeEnding;
            }
        } else { // Neuter
            if (noun_Case.equals(NOMINATIVE) && number.equals(SINGULAR)) {  // Adjective 333 Nominatives can be Irregular
                mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
            } else if (noun_Case.equals(ACCUSATIVE) && number.equals(SINGULAR)) {
                mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
            } else if (noun_Case.equals(VOCATIVE) && number.equals(SINGULAR)) {
                mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
            } else {
                mLatinComparativeEnding = databaseAccess.sqlNounEndingQuery(Integer.toString(DECLENSION3), number, mGender, noun_Case);
                mLatinComparative = mLatinComparativeStem + mLatinComparativeEnding;
            }
        }
        return mLatinComparative;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        mEnglishWord = mEnglishComparative;
        return mEnglishComparative;
    }

    // GETTER/SETTER
    // -------------


    @Override
    public String getLatinWordStem() {
        return mLatinComparativeStem;
    }

    @Override
    public void setLatinWordStem(String latinStem) {
        mLatinComparativeStem = latinStem;
    }

    @Override
    public String getLatinWordEnding() {
        return mLatinComparativeEnding;
    }

    @Override
    public void setLatinWordEnding(String latinWordEnding) {
        mLatinComparativeEnding = latinWordEnding;
    }

    @Override
    public String getLatinWord() {
        return mLatinComparative;
    }

    @Override
    public void setLatinWord(String latinWord) {
        mLatinComparative = latinWord;
    }

    @Override
    public String getEnglishWordSingular() {
        return mEnglishComparative;
    }

    @Override
    public void setEnglishWordSingular(String englishWordSingular) {
        mEnglishComparative = englishWordSingular;
    }

    @Override
    public String getEnglishWordPlural() {
        return mEnglishComparative;
    }

    @Override
    public void setEnglishWordPlural(String englishWordPlural) {
        mEnglishComparative = englishWordPlural;
    }


    public String getLatinComparativeEnding() {
        return mLatinComparativeEnding;
    }

    public void setLatinComparativeEnding(String latinComparativeEnding) {
        mLatinComparativeEnding = latinComparativeEnding;
    }

    public String getLatinComparative() {
        return mLatinComparative;
    }

    public void setLatinComparative(String latinComparative) {
        mLatinComparative = latinComparative;
    }
}
