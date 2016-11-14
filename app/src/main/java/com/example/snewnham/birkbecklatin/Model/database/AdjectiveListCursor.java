package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;

/**
 * AdjectiveListCursor
 * --------------
 * Takes a DB query on the Adjective_List table, which is in the form of a cursor, and converts
 * that data into a Adjective Object. A mini internal 'factory' is used to create the correct NounEtc class(i.e.,
 * NounRegular, Pronoun etc.)
 *
 *
 * Created by snewnham on 05/11/2016.
 */

public class AdjectiveListCursor extends CursorWrapper{

    // Constructor
    // -----------
    public AdjectiveListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * makeAdjectiveObject()
     * ================
     * Converts a Cursor into a NounEtc Object
     * @return
     */
    public Adjective makeAdjectiveObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.AdjectiveListTable.Cols._id));
        String type = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.TYPE));
        int declension = getInt(getColumnIndex(DbSchema.AdjectiveListTable.Cols.DECLENSION));
        String nominative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.NOMINATIVE));
        String nominativeNeuter = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.NOMINATIVE_NEUTER));
        String latinAdjStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_ADJECTIVE_STEM));
        String englishAdjective = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_ADJECTIVE));
        String latinComparativeStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_COMPARATIVE_STEM));
        String englishComparative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_COMPARATIVE));
        String latinSuplerlativeStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_SUPERLATIVE_STEM));
        String englishSuperlative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_SUPERLATIVE));


        Adjective adjective = new Adjective(id);



        // Transfer db data to a Adjective object
        // --------------------------------------
        adjective.setId(id);
        adjective.setType(type);
        adjective.setDeclension(declension);
        adjective.setNominative(nominative);
        adjective.setNominative_Neuter(nominativeNeuter);
        adjective.setLatinAdjectiveStem(latinAdjStem);
        adjective.setEnglishAdjective(englishAdjective);
        adjective.setLatinComparativeStem(latinComparativeStem);
        adjective.setEnglishComparative(englishComparative);
        adjective.setLatinSuperlativeStem(latinSuplerlativeStem);
        adjective.setEnglishSuperlative(englishSuperlative);
        return adjective;
    }
}
