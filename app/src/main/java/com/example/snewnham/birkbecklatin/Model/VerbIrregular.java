package com.example.snewnham.birkbecklatin.Model;

/**
 * Created by snewnham on 29/10/2016.
 */

public class VerbIrregular extends VerbRegular {

    // Constructor
    // -----------
    public VerbIrregular(int id) {
        super(id);
    }

    public VerbIrregular(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
    }

    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        if(mDatabaseAccess == null) {
            this.mDatabaseAccess = databaseAccess;
        }

        




        return null;
    }



}
