package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 16/11/2016.
 */

public class AdverbComparative extends Adverb {


    // Constructor
    // -----------
    public AdverbComparative(int id){
        super(id);
    }

    public AdverbComparative(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

    // GETTER/SETTERS
    // --------------

    @Override
    public String makeLatinWord(DatabaseAccess databaseAccess, String number, String Declension) {
        return null;
    }

    @Override
    public String makeEnglishWord(DatabaseAccess databaseAccess, String number) {
        return null;
    }








}
