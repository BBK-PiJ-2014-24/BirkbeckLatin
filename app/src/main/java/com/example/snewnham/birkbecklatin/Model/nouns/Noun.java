package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Interface for the Noun Object
 *
 * Created by snewnham on 05/11/2016.
 */

public interface Noun {

    String makeLatinNoun(DatabaseAccess databaseAccess, String number, String Declension);

    String makeEnglishNoun(DatabaseAccess databaseAccess, String number);



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

    String getGenitive();
    void setGenitive(String genitive);

    String getGenitivePlural();
    void setGenitivePlural(String genitivePlural);

    String getLatinNounStem();
    void setLatinNounStem(String latinNounStem);

    String getLatinNounEnding();
    void setLatinNounEnding(String latinNounStem);

    String getLatin_Preposition();
    void setLatin_Preposition(String preposition);

    String getLatinNoun();
    void setLatinNoun(String latinNoun);

    String getEnglishNounSingular();
    void setEnglishNounSingular(String englishNounSingular);

    String getEnglishNounPlural();
    void setEnglishNounPlural(String englishNounPlural);

    String getLatin_Nominative_Adjective();
    void setLatin_Nominative_Adjective(String latin_Nominative_Adjective);

}
