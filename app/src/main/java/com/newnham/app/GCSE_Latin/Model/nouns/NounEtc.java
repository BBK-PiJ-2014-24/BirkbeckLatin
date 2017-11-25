package com.newnham.app.GCSE_Latin.Model.nouns;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

/**
 * Interface for the NounEtc Objects
 *
 * Created by snewnham on 05/11/2016.
 */

public interface NounEtc {

//    final static String NOMINATIVE = "Nominative";
//    final static String ACCUSATIVE = "Accusative";
//    final static String GENITIVE = "Genitive";
//    final static String DATIVE = "Dative";
//    final static String ABLATIVE = "Ablative";
//    final static String VOCATIVE = "Vocative";
//
//    final static String SINGULAR = "Singular";
//    final static String PLURAL = "Plural";
//
//    final static String GENDER_MALE = "m";
//    final static String GENDER_FEMALE = "f";
//    final static String GENDER_NEUTER = "n";
//
//    final static int DECLENSION1 = 1;
//    final static int DECLENSION2 = 2;
//    final static int DECLENSION3 = 3;
//    final static int DECLENSION4 = 4;
//    final static int DECLENSION5 = 5;
//    final static int DECLENSION212 = 212;
//    final static int DECLENSION333 = 333;




    /**
     * makeLatinWord()
     * ---------------
     * Create the latin word from the stem and ending
     * @param databaseAccess
     * @param number
     * @param noun_Case
     * @return
     */
    String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case);

    /**
     * makeLatinWord()
     * ---------------
     * Create the latin word from the stem and ending and gender (For Adjectives, Adverbs etc.)
     * @param databaseAccess
     * @param number
     * @param noun_Case
     * @param gender
     * @return
     */
    String makeLatinWord(DatabaseAccess databaseAccess, String number, String noun_Case, String gender);

    /**
     * makeEnglishWord()
     * -----------------
     * Create the english word from the stem and ending
     * @param databaseAccess
     * @param number
     * @return
     */
    String makeEnglishWord(DatabaseAccess databaseAccess, String number);

    // getter/setters
    // --------------
    int getId();
    void setId(int id);

    String getType();
    void setType(String type);

    int getDeclension();
    void setDeclension(int declension);

    String getCase();

    String getGender();
    void setGender(String gender);

    String getNominative();
    void setNominative(String nominative);

    String getGenitive();

    String getLatinWordStem();
    void setLatinWordStem(String latinStem);

    String getLatinWordEnding();
    void setLatinWordEnding(String latinWordEnding);

    String getLatinWord();
    void setLatinWord(String latinWord);

    String getEnglishWord();
    void setEnglishWord(String englishWord);

    String getEnglishWordSingular();
    void setEnglishWordSingular(String englishWordSingular);

    String getEnglishWordPlural();
    void setEnglishWordPlural(String englishWordPlural);

}
