package com.example.snewnham.birkbecklatin.Model.nouns;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 05/11/2016.
 */

public class Adjective extends NounRegular {

    // Constructor
    // -----------
    public Adjective(int id){
        super(id);
    }

    public Adjective(int id, DatabaseAccess databaseAccess){
        super(id, databaseAccess);
    }




}
