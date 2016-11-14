package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Adjective Class - Builds an Adjective Element. N.b., that gender needs to be set. default = m
 */

public class AdjectiveComparative extends Adjective {

    // Fields
    // ------
    private String mLatinComparativeEnding;
    private String mLatinComparative;
    private final static String DECLENSION3 = "3";  // Al comparatives use 333 Endings
    private final static String NEUTER_INFIX = "ius";

    // Constructor
    // -----------
    public AdjectiveComparative(int id){
        super(id);
    }

    public AdjectiveComparative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

    /**
     * makeLatinWord()
     * ---------------
     * Comparative Adjectives add -ior- to Adjective Stem, except for Neuter which uses
     * -ius- for Nom, Acc and Voc.
     * Note that we use sqlNounEndingQuery() as we are using the standard 3rd Declension Noun Endings
     * @param databaseAccess
     * @param number
     * @param latin_case
     * @return
     */
    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String latin_case) {

            if(mGender.equals("m") || mGender.equals("f")) {
                if (latin_case.equals("Nominative") && number.equals("Singular")) {
                    mLatinComparativeEnding = null;  // Set to Null
                    mLatinComparative = mLatinComparativeStem;
                } else if (latin_case.equals("Vocative") && number.equals("Singular")) {
                    mLatinComparativeEnding = null;  // Calc ending
                    mLatinComparative = mLatinComparativeStem;
                } else {
                    mLatinComparativeEnding = databaseAccess.sqlNounEndingQuery(DECLENSION3, number, mGender, latin_case);
                    mLatinComparative = mLatinComparativeStem + mLatinComparativeEnding;
                }
            } else { // Neuter
                if (latin_case.equals("Nominative") && number.equals("Singular")) {  // Adjective 333 Nominatives can be Irregular
                    mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                    mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
                } else if (latin_case.equals("Accusative") && number.equals("Singular")) {
                    mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                    mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
                } else if (latin_case.equals("Vocative") && number.equals("Singular")) {
                    mLatinComparativeEnding = NEUTER_INFIX;  // Set to Null
                    mLatinComparative = mLatinAdjectiveStem + NEUTER_INFIX;
                } else {
                    mLatinComparativeEnding = databaseAccess.sqlNounEndingQuery(DECLENSION3, number, mGender, latin_case);
                    mLatinComparative = mLatinComparativeStem + mLatinComparativeEnding;
                }
            }
        return mLatinComparative;

    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
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
