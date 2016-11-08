package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Preposition - Forms the Latin Preposition and English Translation.
 *
 * Created by snewnham on 07/11/2016.
 */

public class Conjunction extends Preposition {

    // Constructor
    // -----------
    public Conjunction(int id){
        super(id);
    }

    public Conjunction(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }

}
