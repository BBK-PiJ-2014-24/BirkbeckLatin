package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Interface for the NounEtc Objects
 *
 * Created by snewnham on 05/11/2016.
 */

public interface NounEtc {

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

    String getGender();
    void setGender(String gender);

    String getNominative();
    void setNominative(String nominative);

    String getLatinWordStem();
    void setLatinWordStem(String latinStem);

    String getLatinWordEnding();
    void setLatinWordEnding(String latinWordEnding);

    String getLatinWord();
    void setLatinWord(String latinWord);

    String getEnglishWordSingular();
    void setEnglishWordSingular(String englishWordSingular);

    String getEnglishWordPlural();
    void setEnglishWordPlural(String englishWordPlural);

}
